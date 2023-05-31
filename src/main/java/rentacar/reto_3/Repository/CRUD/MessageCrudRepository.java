package rentacar.reto_3.Repository.CRUD;

import org.springframework.data.repository.CrudRepository;
import rentacar.reto_3.Model.Message;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
