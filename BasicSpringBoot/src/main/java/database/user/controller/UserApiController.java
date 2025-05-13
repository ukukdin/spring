package database.user.controller;

import database.entity.Entity;
import database.user.model.UserEntity;
import database.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;
    @PutMapping("/user")
    public UserEntity create(@RequestBody UserEntity userEntity){

        return userService.save(userEntity);
    }
    @GetMapping("/all")
    public List<UserEntity> findAll(){

        return userService.findAll();
    }

    //delete dma.....
    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id){

//        userService.delete(id);
    }
    @GetMapping("/id/{id}")
    public UserEntity findOne(@PathVariable Long id){
        var response =  userService.findById(id);
        return response.get();
    }

    @GetMapping("/score")
    public List<UserEntity> filterScore(@RequestParam int score){
        return userService.filterScore(score);

    }

    @GetMapping("/min_max")
    public List<UserEntity> filterScore(@RequestParam int min,
                                        @RequestParam int max){
        return userService.filterScore(min,max);

    }
}
