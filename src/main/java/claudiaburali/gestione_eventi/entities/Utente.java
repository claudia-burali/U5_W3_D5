package claudiaburali.gestione_eventi.entities;

import claudiaburali.gestione_eventi.enums.RuoloUtente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Utente {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private RuoloUtente ruoloUtente;

    public Utente(String name, String surname, String email, String password, RuoloUtente ruoloUtente) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.ruoloUtente = ruoloUtente;
    }
}
