package entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("Gara")
public class GaraDiAtletica extends Evento {

    @ManyToMany
    private Set<Persona> atleti;

    @ManyToOne
    private Persona vincitore;

    public GaraDiAtletica() {}

    public GaraDiAtletica(Long id, String titolo, java.time.LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Set<Persona> atleti, Persona vincitore) {
        super(id, titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() { return atleti; }
    public void setAtleti(Set<Persona> atleti) { this.atleti = atleti; }
    public Persona getVincitore() { return vincitore; }
    public void setVincitore(Persona vincitore) { this.vincitore = vincitore; }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                '}';
    }
}

