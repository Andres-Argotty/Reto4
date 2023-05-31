package rentacar.reto_3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rentacar.reto_3.Model.Message;
import rentacar.reto_3.Service.MessageService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods ={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @GetMapping("/all") // Al ser una petición Get utilizamos el GetMapping, la ruta sería localhost.../api/Message/all
    public List<Message> getAll(){
        return messageService.getAll();
    }

    @GetMapping("/{id}") //Para poder enviar el id a la hora de realizar la petición ej. /api/Message/12
    public Optional<Message> getMessage (@PathVariable int id){ //PathVariable especifica que el valor del {id} sea el que
        return messageService.getMessage(id);        //Entra por parametro desde la url.
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    //Necesitamos especificar el cuerpo de la petición
    public Message save (@RequestBody Message message){
        return messageService.save(message);
    }
}
