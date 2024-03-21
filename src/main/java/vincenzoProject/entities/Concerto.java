package vincenzoProject.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

enum genereConcerto{
    CLASSICO, ROCK, POP
}

@Entity
@DiscriminatorValue("CONCERTO")
public class Concerto extends Evento {
    private genereConcerto genere;
private boolean liveStreaming;
    public Concerto(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, Integer numeroMassimoPartecipanti, genereConcerto genere, boolean liveStream) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.genere = genere;
        this.liveStreaming = liveStream;
    }

    public Concerto() {
    }

    public boolean isLiveStreaming() {
        return liveStreaming;
    }

    public void setLiveStreaming(boolean liveStreaming) {
        this.liveStreaming = liveStreaming;
    }

    public genereConcerto getGenere() {
        return genere;
    }

    public void setGenere(genereConcerto genere) {
        this.genere = genere;
    }
}
