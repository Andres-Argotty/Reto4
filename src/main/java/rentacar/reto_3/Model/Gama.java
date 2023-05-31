package rentacar.reto_3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "gama")
public class Gama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGama;
    private String name;
    private String description;
    //Relación con los Carros
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "gama")
    //La relación va a estar dada por la variable gama, la cual está creada en Car.
    @JsonIgnoreProperties("gama") //Al traer todos los atributos de los carros, se traería otra vez una gama,
    //la cual también tiene carros, etc. Entonces así evitamos la recursión
    private List<Car> cars; //Esta variable va representar el atributo.

    public Integer getIdGama() {
        return idGama;
    }

    public void setIdGama(Integer idGama) {
        this.idGama = idGama;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
