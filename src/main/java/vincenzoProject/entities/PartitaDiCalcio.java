package vincenzoProject.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue("PartitaDiCalcio")
public class PartitaDiCalcio extends  Evento{
    private String squadraDiCasa;
    private String squadraOspite;
    private String squadravincente = null;
    private int puntiCasa, puntiOspiti;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, Integer numeroMassimoPartecipanti, String squadraDiCasa, String squadraOspite, String squadravincente, int puntiCasa, int puntiOspiti) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadravincente = squadravincente;
        this.puntiCasa = puntiCasa;
        this.puntiOspiti = puntiOspiti;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadravincente() {
        return squadravincente;
    }

    public void setSquadravincente(String squadravincente) {
        this.squadravincente = squadravincente;
    }

    public int getPuntiCasa() {
        return puntiCasa;
    }

    public void setPuntiCasa(int puntiCasa) {
        this.puntiCasa = puntiCasa;
    }

    public int getPuntiOspiti() {
        return puntiOspiti;
    }

    public void setPuntiOspiti(int puntiOspiti) {
        this.puntiOspiti = puntiOspiti;
    }
}
