package rentacar.reto_3.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rentacar.reto_3.Model.Message;
import rentacar.reto_3.Repository.CRUD.MessageCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository

public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    public List<Message> findAll(){
        return(List<Message>) messageCrudRepository.findAll();
    }
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    public Message save(Message message){
        return messageCrudRepository.save(message);
    }
    public void delete (Message message){
        messageCrudRepository.delete(message);

    }
}
