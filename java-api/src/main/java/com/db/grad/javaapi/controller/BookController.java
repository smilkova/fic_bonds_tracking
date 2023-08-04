package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bs)
    {
        bookService = bs;
    }

    @GetMapping("/books")
    public List <Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{book_id}")
    public ResponseEntity < Book > getBookById(@PathVariable(value = "book_id") int id)
            throws ResourceNotFoundException {
        Book books = bookService.getBookById(id);
        return ResponseEntity.ok().body(books);
    }
//    TODO: might have to change the mapping
    @GetMapping("/booksbyname/{name}")
    public ResponseEntity < Book > getBookByName(@PathVariable(value = "name") String name)
            throws ResourceNotFoundException {
        Book books = bookService.getBookByName(name);
        return ResponseEntity.ok().body(books);
    }

    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/books/{book_id}")
    public ResponseEntity < Book > updateBook(@PathVariable(value = "book_id") int book_id,
                                            @Valid @RequestBody Book bookDetails) throws ResourceNotFoundException {

        final Book updatedBooks = bookService.updateBookDetails(bookDetails);
        return ResponseEntity.ok(updatedBooks);
    }

    @DeleteMapping("/books/{book_id}")
    public Map < String, Boolean > deleteBook(@PathVariable(value = "book_id") int book_id)
            throws ResourceNotFoundException {
        boolean removed = bookService.removeBook(book_id);

        Map < String, Boolean > response = new HashMap <>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}
