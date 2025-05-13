package database.book.db.controller;

import database.book.db.entity.BookEntity;
import database.book.db.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/db/book")
@RequiredArgsConstructor
public class BookApiController {
    private final BookService bookService;


    @PostMapping("")
    public BookEntity create(@RequestBody BookEntity bookEntity){

       return bookService.create(bookEntity);

    }
    @GetMapping("/all")
    public List<BookEntity> findAll(){

        return bookService.findAll();
    }

}
