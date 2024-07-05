package claudiaburali.gestione_eventi.controllers;

import claudiaburali.gestione_eventi.entities.Utente;
import claudiaburali.gestione_eventi.exceptions.BadRequestException;
import claudiaburali.gestione_eventi.payloads.EventoDTO;
import claudiaburali.gestione_eventi.payloads.EventoResponseDTO;
import claudiaburali.gestione_eventi.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventi")
public class EventoController {
    @Autowired
    EventoService eventoService;
    @PostMapping
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")
    public EventoResponseDTO creazioneEvento(@RequestBody @Validated EventoDTO eventoDTO, BindingResult bindingResult, @AuthenticationPrincipal Utente utente) {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors());
        }
        return new EventoResponseDTO(eventoService.save(eventoDTO, utente).getId());
    }
}
