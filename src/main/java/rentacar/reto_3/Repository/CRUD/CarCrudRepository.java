package rentacar.reto_3.Repository.CRUD;

import org.springframework.data.repository.CrudRepository;
import rentacar.reto_3.Model.Car;

public interface CarCrudRepository extends CrudRepository<Car, Integer> { //Integer ya que nuestro ID tiene ese tipo de dato
}
