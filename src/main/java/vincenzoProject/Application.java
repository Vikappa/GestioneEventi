package vincenzoProject;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vincenzoProject.entities.Evento;
import vincenzoProject.entities.EventoDAO;
import vincenzoProject.exceptions.NotFoundException;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Application {
    static Faker faker = new Faker();
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        EventoDAO evDAO = new EventoDAO(em);

        // Creo un nuovo Evento
        Evento evento = new Evento("Rock show", faker.date().future(12, TimeUnit.DAYS),"Descrizione", Evento.TipoEvento.PUBBLICO,200 );
        Evento evento2 = new Evento("Pop show", faker.date().future(15, TimeUnit.DAYS),"Descrizione 2", Evento.TipoEvento.PUBBLICO,200 );
        Evento evento3 = new Evento("Jaxx show", faker.date().future(10, TimeUnit.DAYS),"Descrizione 3", Evento.TipoEvento.PRIVATO,200 );

//        evDAO.save(evento);
//        evDAO.save(evento2);
//        evDAO.save(evento3);


        try {
            Evento ev = evDAO.findById(1);
            System.out.println(ev);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        evDAO.findByIdAndDelete(1);

        try {
            Evento ev = evDAO.findById(1);
            System.out.println(ev);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        // Chiusura dell'EntityManager e dell'EntityManagerFactory
        em.close();
        emf.close();
    }
}
