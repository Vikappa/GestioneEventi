package vincenzoProject.entities.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vincenzoProject.entities.Partecipazione;
import vincenzoProject.entities.Persona;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona personId){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(personId);
        transaction.commit();
        System.out.println("Evento ID" + personId.getId() + " salvato correttamente!");
    }

    public Persona findById(long personId){
        Persona event = em.find(Persona.class, personId);
        if(event == null){
            System.out.println("Persona con id " + personId + " non trovato!");
            return null;
        }
        return event;
    }
    public void findByIdAndDelete(long personId){
        Persona found = this.findById(personId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Persona con id " + found.getId() + " eliminata correttamente!");
    }
}
