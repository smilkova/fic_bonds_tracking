package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.model.Users;
import com.db.grad.javaapi.service.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3")
@CrossOrigin(origins = "http://localhost:3000")
public class BookUserController {
    private BookUserService bookUserService;

    @Autowired
    public BookUserController(BookUserService bus)
    {
        bookUserService = bus;
    }

    @GetMapping("/bookuser")
    public List <BookUser> getAllBookUser() {
        return bookUserService.getAllBookUsers();
    }

    @GetMapping("/bookuser/{book_id}")
    public ResponseEntity < BookUser > findUsersForBook(@PathVariable(value = "book_id") Book book_id)
            throws ResourceNotFoundException {
        BookUser users = bookUserService.findUsersForBook(book_id);
        return ResponseEntity.ok().body(users);
    }
    //    TODO: might have to change the mapping
    @GetMapping("/bookuser/{user_id}")
    public ResponseEntity < BookUser > findBooksForUser(@PathVariable(value = "user_id") Users user_id)
            throws ResourceNotFoundException {
        BookUser users = bookUserService.findBooksForUser(user_id);
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/bookuser")
    public BookUser createBookUser(@Valid @RequestBody BookUser user) {
        return bookUserService.addBookUser(user);
    }

    @PutMapping("/bookuser/{id}")
    public ResponseEntity < BookUser > updateBookUser(@PathVariable(value = "user_id") int id,
                                                @Valid @RequestBody BookUser userDetails) throws ResourceNotFoundException {

        final BookUser updatedBookUser = bookUserService.updateBookUserDetails(userDetails);
        return ResponseEntity.ok(updatedBookUser);
    }

    @DeleteMapping("/bookuser/{id}")
    public Map < String, Boolean > deleteBookUser(@PathVariable(value = "id") int id)
            throws ResourceNotFoundException {
        boolean removed = bookUserService.removeBookUser(id);

        Map < String, Boolean > response = new HashMap <>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}
