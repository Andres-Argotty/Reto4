package rentacar.reto_3.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rentacar.reto_3.Model.Score;
import rentacar.reto_3.Repository.CRUD.ScoreCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> findAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    public Optional<Score> getScore (int id){
        return scoreCrudRepository.findById(id);
    }
    public Score save (Score score){
        return scoreCrudRepository.save(score);
    }
    public void delete (Score score){
        scoreCrudRepository.delete(score);
    }
}

