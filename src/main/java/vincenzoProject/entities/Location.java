package vincenzoProject.entities;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Locations")
public class Location {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Nome")
    private String nome;
    @Column(name = "Città")
    private String città;

    @OneToMany(mappedBy = "location")
    private Set<Evento> eventi = new HashSet<>();

    public Set<Evento> getEventi() {
        return eventi;
    }

    public void setEventi(Set<Evento> eventi) {
        this.eventi = eventi;
    }

    public Location() {}

    public Location(Long id, String nome, String città) {
        this.id = id;
        this.nome = nome;
        this.città = città;
    }

    public Location(String nome, String città) {
        this.nome = nome;
        this.città = città;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }
}
