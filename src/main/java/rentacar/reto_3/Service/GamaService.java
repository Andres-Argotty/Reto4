package rentacar.reto_3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rentacar.reto_3.Model.Gama;
import rentacar.reto_3.Repository.GamaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GamaService {

    @Autowired
    GamaRepository gamaRepository;

    public List<Gama> getAll() {
        return gamaRepository.findAll();
    }

    public Optional<Gama> getGama(int id) {
        return gamaRepository.getGama(id);
    }

    public Gama save(Gama gama) {
        //Validaciones:
        if (gama.getIdGama() == null) {
            return gamaRepository.save(gama);
        } else {
            Optional<Gama> gamaFinded = getGama(gama.getIdGama());
            if (gamaFinded.isEmpty()) {
                return gamaRepository.save(gama);
            } else {
                return gama;
            }
        }
    }

    public Gama update(Gama gama) {
        if (gama.getIdGama() != null) {
            Optional<Gama> gamaFinded = getGama(gama.getIdGama());
            if (gamaFinded.isPresent()) {
                if (gama.getDescription() != null) {
                    gamaFinded.get().setDescription(gama.getDescription());
                }
                if (gama.getName() != null) {
                    gamaFinded.get().setName(gama.getName());
                }
                return gamaRepository.save(gamaFinded.get());
            }else {
                return gama;
            }
        }else {
            return gama;
        }
    }

    public boolean deleteGama (int id){
        Boolean respuesta= getGama(id).map(gama -> {
            gamaRepository.delete(gama);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
