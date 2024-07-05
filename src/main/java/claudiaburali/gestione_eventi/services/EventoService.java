package claudiaburali.gestione_eventi.services;

import claudiaburali.gestione_eventi.entities.Evento;
import claudiaburali.gestione_eventi.entities.Utente;
import claudiaburali.gestione_eventi.exceptions.NotFoundException;
import claudiaburali.gestione_eventi.payloads.EventoDTO;
import claudiaburali.gestione_eventi.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private UtenteService utenteService;
    public Evento save (EventoDTO eventoDTO, Utente utente){
        Evento evento = new Evento(eventoDTO.titolo(), eventoDTO.descrizione(), eventoDTO.data(), eventoDTO.luogo(), eventoDTO.numero_posti(), utenteService.findById(utente.getId()));
        return eventoRepository.save(evento);
    }
    public Evento findById(UUID id){
        return eventoRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }
}
