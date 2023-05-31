package rentacar.reto_3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "car") //Recordar que esto es una tabla de base de datos
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCar; //Es importante trabajar con el tipo integer
//Es importante conservar el orden de los atributos y sus nombres según la tabla
    private String name;
    private String brand;
    private Integer year;
    private String description;
    //Contraparte de la relación con gama
    @ManyToOne
    @JoinColumn(name = "idGama")
    @JsonIgnoreProperties("cars") //Al igual que en gama, ignoramos cars que está creado en gama.
    private Gama gama;

    //Relación Mensajes
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "car")
    @JsonIgnoreProperties({"car","client"})
    private List<Message> messages;

    //Relación Reservas
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "car")
    @JsonIgnoreProperties({"car","client"})
    private List<Reservation> reservations;

    public Integer getIdCar() {
        return idCar;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Gama getGama() {
        return gama;
    }

    public void setGama(Gama gama) {
        this.gama = gama;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
