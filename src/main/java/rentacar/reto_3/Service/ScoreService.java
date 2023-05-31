package rentacar.reto_3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rentacar.reto_3.Model.Score;
import rentacar.reto_3.Repository.ScoreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.findAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score score) {
        //Validaciones:
        if (score.getIdScore() == null) {
            return scoreRepository.save(score);
        } else {
            Optional<Score> scoreFinded = getScore(score.getIdScore());
            if (scoreFinded.isEmpty()) {
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }
    }

    public Score update(Score score) {
        if (score.getIdScore() != null) {
            Optional<Score> scoreFinded = getScore(score.getIdScore());
            if (scoreFinded.isPresent()) {
                if (score.getMessageText() != null) {
                    scoreFinded.get().setMessageText(score.getMessageText());
                }
                if (score.getStars() != null) {
                    scoreFinded.get().setStars(score.getStars());
                }
                return scoreRepository.save(scoreFinded.get());
            }else {
                return score;
            }
        }else {
            return score;
        }
    }

    public boolean deleteScore (int id){
        Boolean respuesta= getScore(id).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return respuesta;
    }
    
}
