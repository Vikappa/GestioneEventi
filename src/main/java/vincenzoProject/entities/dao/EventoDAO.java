package vincenzoProject.entities.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vincenzoProject.entities.Evento;

public class EventoDAO{
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento event){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();
        System.out.println("Evento " + event.getDescrizione() + " salvato correttamente!");
    }

    public Evento findById(long studentId){
        Evento event = em.find(Evento.class, studentId);
        if(event == null){
            System.out.println("Evento con id " + studentId + " non trovato!");
            return null;
        }
        return event;
    }
    public void findByIdAndDelete(long studentId){
        Evento found = this.findById(studentId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Studente con id " + found.getId() + " eliminato correttamente!");
    }
}