package rentacar.reto_3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rentacar.reto_3.Model.Gama;
import rentacar.reto_3.Service.GamaService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods ={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Gama")
public class GamaController {
    @Autowired
    private GamaService gamaService;
    @GetMapping("/all") // Al ser una petición Get utilizamos el GetMapping, la ruta sería localhost.../api/Gama/all
    public List<Gama> getAll(){
        return gamaService.getAll();
    }

    @GetMapping("/{id}") //Para poder enviar el id a la hora de realizar la petición ej. /api/Gama/12
    public Optional<Gama> getGama (@PathVariable int id){ //PathVariable especifica que el valor del {id} sea el que
        return gamaService.getGama(id);        //Entra por parametro desde la url.
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    //Necesitamos especificar el cuerpo de la petición
    public Gama save (@RequestBody Gama gama){
        return gamaService.save(gama);
    }
}
