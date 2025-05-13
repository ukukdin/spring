package database.user.db;

import database.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Locale;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //Slect * from user where score >= [??]
    public List<UserEntity> findAllByScoreGreaterThanEqual(int sc);

    //mysql query -> select * from user where score >=?? AND <=??

    List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);

    //jpql 형식으로 쿼리문 작성해본거다. jpql 이란 직접 sql을 작성했던 방법
    // param은 바인딩이 귀찮더라도 param바인딩 해줘야한다. 잘 모르겟으면 spring.io 도큐먼트에 query Methods가 있으니 공식 페이지를 확인하면서 보면 될거같습니다. 
    @Query(
        value = "select * from user u where u.score >=:min  AND u.score <= :max",
        nativeQuery = true
    )
    List<UserEntity> score(
            @Param(value ="min") int min,
            @Param(value = "max") int max);

}

