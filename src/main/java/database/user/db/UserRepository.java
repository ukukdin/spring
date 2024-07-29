package database.user.db;

import database.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //Slect * from user where score >= [??]
    public List<UserEntity> findAllByScoreGreaterThanEqual (int sc);

    //mysql query -> select * from user where score >=?? AND <=??
    List<UserEntity> findAllByScoreGreaterThanEqualAndSocreLessThanEqual(int min, int max);
}
