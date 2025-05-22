package entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Partita")
@NamedQuery(name = "PartitaDiCalcio.vinteInCasa", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraDiCasa")
@NamedQuery(name = "PartitaDiCalcio.vinteInTrasferta", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite")
public class PartitaDiCalcio extends Evento {
    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int golCasa;
    private int golOspite;

    public PartitaDiCalcio() {}

    public PartitaDiCalcio(Long id, String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
                           int numeroMassimoPartecipanti, String squadraDiCasa, String squadraOspite,
                           String squadraVincente, int golCasa, int golOspite) {
        super(id, titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.golCasa = golCasa;
        this.golOspite = golOspite;
    }

    // Costruttore senza id (per creare nuovi oggetti facilmente)
    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
                           int numeroMassimoPartecipanti, String squadraDiCasa, String squadraOspite,
                           String squadraVincente, int golCasa, int golOspite) {
        this(null, titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti,
                squadraDiCasa, squadraOspite, squadraVincente, golCasa, golOspite);
    }

    public String getSquadraDiCasa() { return squadraDiCasa; }
    public void setSquadraDiCasa(String squadraDiCasa) { this.squadraDiCasa = squadraDiCasa; }

    public String getSquadraOspite() { return squadraOspite; }
    public void setSquadraOspite(String squadraOspite) { this.squadraOspite = squadraOspite; }

    public String getSquadraVincente() { return squadraVincente; }
    public void setSquadraVincente(String squadraVincente) { this.squadraVincente = squadraVincente; }

    public int getGolCasa() { return golCasa; }
    public void setGolCasa(int golCasa) { this.golCasa = golCasa; }

    public int getGolOspite() { return golOspite; }
    public void setGolOspite(int golOspite) { this.golOspite = golOspite; }
}
