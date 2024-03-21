package vincenzoProject.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@DiscriminatorValue("Gara_di_atletica")
public class GaraDiAtletica extends Evento{
    Set<Persona> atleti = new HashSet<>();
    Persona vincitore;

    public GaraDiAtletica(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, Integer numeroMassimoPartecipanti, Set<Persona> atleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public GaraDiAtletica() {
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
