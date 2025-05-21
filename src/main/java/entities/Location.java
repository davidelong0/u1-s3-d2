package entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generazione dell'ID
    private Long id;

    private String nome;

    private String citta;

    private String indirizzo;  // Nuovo campo

    // Relazione con Eventi
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Evento> eventi;

    public Location() {}

    public Location(String nome, String citta, String indirizzo) {
        this.nome = nome;
        this.citta = citta;
        this.indirizzo = indirizzo;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCitta() { return citta; }
    public void setCitta(String citta) { this.citta = citta; }

    public String getIndirizzo() { return indirizzo; }
    public void setIndirizzo(String indirizzo) { this.indirizzo = indirizzo; }

    public List<Evento> getEventi() { return eventi; }
    public void setEventi(List<Evento> eventi) { this.eventi = eventi; }
}


