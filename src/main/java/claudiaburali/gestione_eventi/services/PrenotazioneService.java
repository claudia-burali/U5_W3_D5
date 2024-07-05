package claudiaburali.gestione_eventi.services;

import claudiaburali.gestione_eventi.entities.Evento;
import claudiaburali.gestione_eventi.entities.Prenotazione;
import claudiaburali.gestione_eventi.entities.Utente;
import claudiaburali.gestione_eventi.payloads.PrenotazioneDTO;
import claudiaburali.gestione_eventi.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PrenotazioneService {
    @Autowired
    PrenotazioneRepository prenotazioneRepository;
    @Autowired
    UtenteService utenteService;
    @Autowired
    EventoService eventoService;
    public Prenotazione save(PrenotazioneDTO prenotazioneDTO){
        Evento evento = eventoService.findById(UUID.fromString(prenotazioneDTO.evento()));
        Utente utente = utenteService.findById(UUID.fromString(prenotazioneDTO.utente()));
        Prenotazione prenotazione = new Prenotazione(evento, utente);
        return prenotazioneRepository.save(prenotazione);
    }
}
