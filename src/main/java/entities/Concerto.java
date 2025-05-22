package entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Concerto")
public class Concerto extends Evento {
    @Enumerated(EnumType.STRING)
    private GenereConcerto genere;
    private boolean inStreaming;

    public Concerto() {}

    public Concerto(Long id, String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
                    int numeroMassimoPartecipanti, GenereConcerto genere, boolean inStreaming) {
        super(id, titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }


    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
                    int numeroMassimoPartecipanti, GenereConcerto genere, boolean inStreaming) {
        this(null, titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, genere, inStreaming);
    }

    public GenereConcerto getGenere() { return genere; }
    public void setGenere(GenereConcerto genere) { this.genere = genere; }

    public boolean isInStreaming() { return inStreaming; }
    public void setInStreaming(boolean inStreaming) { this.inStreaming = inStreaming; }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
