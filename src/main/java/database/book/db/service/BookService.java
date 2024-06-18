package database.book.db.service;


import database.book.db.entity.BookEntity;
import database.book.db.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class BookService {

    //book 서비스가 생성이 될때 이 생성자 메소드로 생성할 건데 ~ 이때 여기다가 주입을 해주는게 스프링 역할이다.
    //book repository 를 생성자 메소드로 작성하게 되면 스프링은 bin 영역에서 찾게된다. 스프링 컨텍스트에서 찾다 보면은 book repository 가 서비스로 되어 있기 때문에 bin으로 등록이 됐을 것이다.
    //lombok 에 @RequiredArgsConstructor 이 생성자를 만들어 받겟다가 되어서 밑에 주석 처리되어있는 public Bookservice(BookRepository bookREpository)를 생성자로 만들어준다.
    //@RequiredArgsConstructor 도 싫다면 private final 이 아닌 private BookRepository를 만들고 @Autowired를 적어주면 동일하게 스프링이 컨텍스트를 찾아서 주입을 해준다.
    //차이점은 @오토와이드 생성자는 bin 걸로 생성하고 주입을 하게되고 또는 생성자로 받게 되면 나중에 테스트 코드라든지 여러가지 할때 우리가 원하는 book repository를 만들어서 넣어줄수 있다.
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;

    }


    //create, update
    public BookEntity create(BookEntity book){

        return bookRepository.save(book);
    }

    //all
    public List<BookEntity> findAll(){
        return bookRepository.findAll();
    }

    // delete

    //find one
}
