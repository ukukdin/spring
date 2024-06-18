package database.book.db.repository;

import database.book.db.entity.BookEntity;
import database.db.SimpleDataRepository;
import org.springframework.stereotype.Service;

@Service
public class BookRepository extends SimpleDataRepository<BookEntity, Long> {

}
