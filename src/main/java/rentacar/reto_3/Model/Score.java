package rentacar.reto_3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scoreId;
    private String messageText;
    private Integer stars;

    //Relación con reservas
    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;

    public Integer getIdScore() {
        return scoreId;
    }

    public void setIdScore(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
