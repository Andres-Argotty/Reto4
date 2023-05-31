package rentacar.reto_3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rentacar.reto_3.Model.Client;
import rentacar.reto_3.Service.ClientService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods ={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping("/all") // Al ser una petición Get utilizamos el GetMapping, la ruta sería localhost.../api/Client/all
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @GetMapping("/{id}") //Para poder enviar el id a la hora de realizar la petición ej. /api/Client/12
    public Optional<Client> getClient (@PathVariable int id){ //PathVariable especifica que el valor del {id} sea el que
        return clientService.getClient(id);        //Entra por parametro desde la url.
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    //Necesitamos especificar el cuerpo de la petición
    public Client save (@RequestBody Client client){
        return clientService.save(client);
    }
}
