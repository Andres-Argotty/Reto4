package rentacar.reto_3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rentacar.reto_3.Model.Score;
import rentacar.reto_3.Service.ScoreService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods ={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;
    @GetMapping("/all") // Al ser una petición Get utilizamos el GetMapping, la ruta sería localhost.../api/Score/all
    public List<Score> getAll(){
        return scoreService.getAll();
    }

    @GetMapping("/{id}") //Para poder enviar el id a la hora de realizar la petición ej. /api/Score/12
    public Optional<Score> getScore (@PathVariable int id){ //PathVariable especifica que el valor del {id} sea el que
        return scoreService.getScore(id);        //Entra por parametro desde la url.
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    //Necesitamos especificar el cuerpo de la petición
    public Score save (@RequestBody Score score){
        return scoreService.save(score);
    }
}

