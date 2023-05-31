package rentacar.reto_3.Repository.CRUD;

import org.springframework.data.repository.CrudRepository;
import rentacar.reto_3.Model.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
