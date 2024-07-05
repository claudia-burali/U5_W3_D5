package claudiaburali.gestione_eventi.entities;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("organizzatore_eventi")
@NoArgsConstructor
@Getter
@Setter
public class OrganizzatoreEventi extends UtenteGenerico {
    public OrganizzatoreEventi(String name, String surname, String email, String password) {
        super(name, surname, email, password);
    }
}
