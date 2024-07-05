package claudiaburali.gestione_eventi.services;

import claudiaburali.gestione_eventi.entities.Utente;
import claudiaburali.gestione_eventi.exceptions.UnauthorizedException;
import claudiaburali.gestione_eventi.payloads.UtenteLoginDTO;
import claudiaburali.gestione_eventi.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PasswordEncoder bcrypt;
    @Autowired
    private JWTTools jwtTools;

    public String authenticateUserAndGenerateToken(UtenteLoginDTO payload){
        Utente utente = this.utenteService.findByEmail(payload.email());
        if(bcrypt.matches(payload.password(), utente.getPassword())){
            return jwtTools.createToken(utente);
        } else {
            throw new UnauthorizedException("Credenziali non corrette!");
        }
    }
}
