package vincenzoProject.entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO{
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento event){
        EntityTransaction transaction = em.getTransaction();
        // 1. Inizio la transazione
        transaction.begin();

        // 2. Aggiungo l'event al Persistence Context (in questo momento non l'ho ancora effettivamente salvato nel DB)
        em.persist(event);

        // 3. Concludo la transazione con l'effettivo salvataggio a db
        transaction.commit();
        System.out.println("Evento " + event.getDescrizione() + " salvato correttamente!");
    }

    public Evento findById(long studentId){
        Evento event = em.find(Evento.class, studentId); // Primo parametro è la classe dell'entity, secondo è l'id da cercare
        if(event == null){
            System.out.println("Evento con id " + studentId + " non trovato!");
            return null;
        }
        return event;
    }
    public void findByIdAndDelete(long studentId){
        // 0. Cerco l'Evento nel db
        Evento found = this.findById(studentId);

        // 1. Richiedo all'entity manager una nuova transazione
        EntityTransaction transaction = em.getTransaction();

        // 2. Inizio la transazione
        transaction.begin();

        // 3. Rimuovo lo studente dal Persistence Context (in questo momento non l'ho ancora effettivamente cancellato dal DB)
        em.remove(found);

        // 4. Concludo la transazione con l'effettivo salvataggio a db
        transaction.commit();
        System.out.println("Studente con id " + found.getId() + " eliminato correttamente!");
    }
}