package vincenzoProject.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

enum statoPartecipazione {CONFERMATA, DA_CONFERMARE }

@Entity
@Table(name = "Partecipazioni")
public class Partecipazione {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Persona")
    private Persona persona;

    @Column(name = "Stato")
    private String stato;

    @Column(name = "Evento")
    @OneToMany(mappedBy = "event")
    private Set<Evento> event = new HashSet<>();

    @Column(name = "Partecipanti")
    @OneToMany(mappedBy = "partecipanti")
    private Set<Persona> partecipants = new HashSet<>();

    public Partecipazione() {}

    public Partecipazione(Set<Evento> event, Persona persona, String stato) {
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

    public Set<Evento> getEvent() {
        return event;
    }

    public void setEvent(Set<Evento> event) {
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
