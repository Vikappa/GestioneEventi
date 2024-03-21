package vincenzoProject.entities;

import jakarta.persistence.*;

enum statoPartecipazione {CONFERMATA, DA_CONFERMARE }

@Entity
@Table(name = "Partecipazioni")
public class Partecipazione {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Evento")
    private Evento event;
    @Column(name = "Persona")
    private Persona persona;

    @Column(name = "Stato")
    private String stato;

    public Partecipazione() {}

    public Partecipazione(Evento event, Persona persona, String stato) {
        this.event = event;
        this.persona = persona;
        this.stato = stato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evento getEvent() {
        return event;
    }

    public void setEvent(Evento event) {
        this.event = event;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }
}
