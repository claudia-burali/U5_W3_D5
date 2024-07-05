package claudiaburali.gestione_eventi.services;

import claudiaburali.gestione_eventi.entities.Utente;
import claudiaburali.gestione_eventi.exceptions.NotFoundException;
import claudiaburali.gestione_eventi.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public Utente findById(UUID id) {
        return this.utenteRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}