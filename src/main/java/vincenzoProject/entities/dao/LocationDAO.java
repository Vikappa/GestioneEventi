package vincenzoProject.entities.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vincenzoProject.entities.Evento;
import vincenzoProject.entities.Location;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location loc){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(loc);
        transaction.commit();
        System.out.println("Evento ID" + loc.getId() + " salvato correttamente!");
    }

    public Location findById(long locationId){
        Location event = em.find(Location.class, locationId);
        if(event == null){
            System.out.println("Location con id " + locationId + " non trovato!");
            return null;
        }
        return event;
    }
    public void findByIdAndDelete(long locationId){
        Location found = this.findById(locationId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Location con id " + found.getId() + " eliminata correttamente!");
    }
}
