package com.db.grad.javaapi.service;
import com.db.grad.javaapi.repository.BookRepository;
//import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.db.grad.javaapi.model.Book;
//import sun.tools.jconsole.JConsole;



import java.util.List;
import java.util.Objects;
import java.util.Optional;

//the point of the service is to take the query supplied by the repo and
//make it readable for the controller
//uses the interface to have a model of abstract methods
//controller will call the service to execute functions
@Service
public class BookService implements IBooksService {
    //implements this interface to say here is what this class can do all the moveable abstract methods
    private BookRepository itsBooksRepo;
    //creates a book repo for this service
    @Autowired
    public BookService( BookRepository bRepo )
    {
        itsBooksRepo = bRepo;
        //makes the repo in this service the one from the query
    }

    @Override
    public List<Book> getAllBooks()
    {
        return itsBooksRepo.findAll();
    }

    @Override
    public Book addBook(Book theBook)
    {
        return itsBooksRepo.save( theBook );
    }

    @Override
    public long getNoOfBooks()
    {
        return itsBooksRepo.count();
    }

    @Override
    public boolean removeBook(int uniqueId)
    {
        boolean result = false;

        Optional<Book> theBook = itsBooksRepo.findById(uniqueId);
        //may have a null value

        if(theBook.isPresent()) //iof the book isnt null
        {
            itsBooksRepo.delete(theBook.get());
            result = true;
        }

        return  result;
    }

    @Override
    public Book getBookById(int uniqueId)
    {
        return itsBooksRepo.findById(uniqueId).get();
    }

    @Override
    public Book getBookByName(String BooksName)
    {
        List<Book> books = itsBooksRepo.findAll();
        int count = 0;
        for (Book bb : books) {
            if (Objects.equals(bb.getName(),BooksName)){
                return books.get(count);
            }
            count += 1;
        }
        return null;
    }

    @Override
    public Book updateBookDetails(Book BookToUpdate)
    {
        return itsBooksRepo.save( BookToUpdate );
    }
}


