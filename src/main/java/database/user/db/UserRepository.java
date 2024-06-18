package database.user.db;

import database.db.SimpleDataRepository;
import database.user.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRepository extends SimpleDataRepository<UserEntity, Long> {

    public List<UserEntity> findAllScoreGreaterThen(int score){

        return  this.findAll().stream()
                .filter(
                        it -> {
                            return it.getScore() >= score;
                        }
                ).collect(Collectors.toList());
    }
}
