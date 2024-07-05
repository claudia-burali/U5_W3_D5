package claudiaburali.gestione_eventi.controllers;

import claudiaburali.gestione_eventi.exceptions.BadRequestException;
import claudiaburali.gestione_eventi.payloads.UtenteDTO;
import claudiaburali.gestione_eventi.payloads.UtenteLoginDTO;
import claudiaburali.gestione_eventi.payloads.UtenteLoginResponseDTO;
import claudiaburali.gestione_eventi.payloads.UtenteResponseDTO;
import claudiaburali.gestione_eventi.services.AuthService;
import claudiaburali.gestione_eventi.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UtenteControllerAuth {
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UtenteResponseDTO saveUtente(@RequestBody @Validated UtenteDTO body, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            throw new BadRequestException(validationResult.getAllErrors());
        }
        return new UtenteResponseDTO(this.utenteService.save(body).getId());
    }
    @PostMapping("/login")
    public UtenteLoginResponseDTO login(@RequestBody @Validated UtenteLoginDTO payload, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors());
        }
        return new UtenteLoginResponseDTO(authService.authenticateUserAndGenerateToken(payload));
    }
}
