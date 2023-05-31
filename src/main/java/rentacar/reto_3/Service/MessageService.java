package rentacar.reto_3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rentacar.reto_3.Model.Gama;
import rentacar.reto_3.Model.Message;
import rentacar.reto_3.Repository.MessageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message message) {
        //Validaciones:
        if (message.getIdMessage() == null) {
            return messageRepository.save(message);
        } else {
            Optional<Message> messageFinded = getMessage(message.getIdMessage());
            if (messageFinded.isEmpty()) {
                return messageRepository.save(message);
            } else {
                return message;
            }
        }
    }

    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> messageFinded = getMessage(message.getIdMessage());
            if (messageFinded.isPresent()) {
                if (message.getMessageText() != null) {
                    messageFinded.get().setMessageText(message.getMessageText());
                }
                return messageRepository.save(messageFinded.get());
            }else {
                return message;
            }
        }else {
            return message;
        }
    }

    public boolean deleteMessage (int id){
        Boolean respuesta= getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return respuesta;
    }

}
