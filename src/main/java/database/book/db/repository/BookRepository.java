package database.book.db.repository;

import database.book.db.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
