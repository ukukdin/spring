package database.db;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T,ID> extends Repository<T,ID>{

    // create, updatea
    T save(T data);

    // read 에 해당되는 코드
    Optional<T> findById(ID id);

    List<T> findAll();
    // delete

    void delete(ID id);


}
