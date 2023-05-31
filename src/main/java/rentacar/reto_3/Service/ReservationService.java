package rentacar.reto_3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rentacar.reto_3.Model.Reservation;
import rentacar.reto_3.Repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation) {
        //Validaciones:
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> reservationFinded = getReservation(reservation.getIdReservation());
            if (reservationFinded.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> reservationFinded = getReservation(reservation.getIdReservation());
            if (reservationFinded.isPresent()) {
                if (reservation.getStartDate() != null) {
                    reservationFinded.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    reservationFinded.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    reservationFinded.get().setStatus(reservation.getStatus());
                }
                return reservationRepository.save(reservationFinded.get());
            }else {
                return reservation;
            }
        }else {
            return reservation;
        }
    }

    public boolean deleteReservation (int id){
        Boolean respuesta= getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return respuesta;
    }
    
}
