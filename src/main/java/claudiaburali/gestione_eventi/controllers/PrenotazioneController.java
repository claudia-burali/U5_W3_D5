package claudiaburali.gestione_eventi.controllers;

import claudiaburali.gestione_eventi.exceptions.BadRequestException;
import claudiaburali.gestione_eventi.payloads.PrenotazioneDTO;
import claudiaburali.gestione_eventi.payloads.PrenotazioneResponseDTO;
import claudiaburali.gestione_eventi.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {
    @Autowired
    PrenotazioneService prenotazioneService;
    @PostMapping
    @PreAuthorize("hasAuthority('UTENTE')")
    public PrenotazioneResponseDTO creazioneEvento(@RequestBody @Validated PrenotazioneDTO prenotazioneDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors());
        }
        return new PrenotazioneResponseDTO(prenotazioneService.save(prenotazioneDTO).getId());
    }
}
