package database.user.service;


import database.user.db.UserRepository;
import database.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    /*
    * 다른 방법은 private UserRepository userRepository 한 다음 위에 어노테이션으로 @Autowired를 달아주게 되면 된다. 여러가지 개체중에서 userRepository를 주입해준다.  */
    public UserEntity save(UserEntity user){

        //save을 위한 레포지토리가 필요하다.
        return userRepository.save(user);
    }
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }
    public void delete(UserEntity id){
         userRepository.delete(id);
    }
    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }
    public List<UserEntity> filterScore(int score){
//        return null;
        return userRepository.findAllByScoreGreaterThanEqual(score);
    }
}
