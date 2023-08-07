package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.Users;
import com.db.grad.javaapi.service.TradeService;
import com.db.grad.javaapi.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v4")
@CrossOrigin(origins = "http://localhost:3000")
public class TradeController {
    private TradeService tradeService;

    @Autowired
    public TradeController(TradeService ts)
    {
        tradeService = ts;
    }

    @GetMapping("/trade")
    public List <Trade> getAllTrade() {
        return tradeService.getAllTrades();
    }

    @GetMapping("/tradeByBookID/{book_id}")
    public ResponseEntity < Optional<List<Integer>> > findUsersForBook(@PathVariable(value = "book_id") int book_id)
            throws ResourceNotFoundException {
        Optional<List<Integer>> users = bookUserService.findUsersForBook(book_id);
        return ResponseEntity.ok().body(users);
    }
    //    TODO: might have to change the mapping
    @GetMapping("/tradeByUserID/{user_id}")
    public ResponseEntity < Optional<List<Integer>> > findBooksForUser(@PathVariable(value = "user_id") int user_id)
            throws ResourceNotFoundException {
        Optional<List<Integer>> users = bookUserService.findBooksForUser(user_id);
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/trade")
    public Trade createTrade(@Valid @RequestBody Trade user) {
        return tradeService.addTrade(user);
    }
}
