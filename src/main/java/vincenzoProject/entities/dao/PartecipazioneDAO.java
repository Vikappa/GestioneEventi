package vincenzoProject.entities.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vincenzoProject.entities.Location;
import vincenzoProject.entities.Partecipazione;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazioneId){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazioneId);
        transaction.commit();
        System.out.println("Evento ID" + partecipazioneId.getId() + " salvato correttamente!");
    }

    public Partecipazione findById(long partecipazioneId){
        Partecipazione event = em.find(Partecipazione.class, partecipazioneId);
        if(event == null){
            System.out.println("Partecipazione con id " + partecipazioneId + " non trovato!");
            return null;
        }
        return event;
    }
    public void findByIdAndDelete(long partecipazioneId){
        Partecipazione found = this.findById(partecipazioneId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Partecipazione con id " + found.getId() + " eliminata correttamente!");
    }
}
