package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Users;
import com.db.grad.javaapi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {
    private UsersService userService;

    @Autowired
    public UsersController(UsersService us)
    {
        userService = us;
    }

    @GetMapping("/users")
    public List <Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity < Users > getUserById(@PathVariable(value = "user_id") int id)
            throws ResourceNotFoundException {
        Users users = userService.getUsersById(id);
        return ResponseEntity.ok().body(users);
    }
    //    TODO: might have to change the mapping
    @GetMapping("/users/{email}")
    public ResponseEntity < Users > getUserByEmail(@PathVariable(value = "email") String email)
            throws ResourceNotFoundException {
        Users users = userService.getUsersByEmail(email);
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/users")
    public Users createUsers(@Valid @RequestBody Users user) {
        return userService.addUser(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity < Users > updateUsers(@PathVariable(value = "user_id") int id,
                                              @Valid @RequestBody Users userDetails) throws ResourceNotFoundException {

        final Users updatedUsers = userService.updateUserDetails(userDetails);
        return ResponseEntity.ok(updatedUsers);
    }

    @DeleteMapping("/users/{id}")
    public Map < String, Boolean > deleteUsers(@PathVariable(value = "id") int id)
            throws ResourceNotFoundException {
        boolean removed = userService.removeUser(id);

        Map < String, Boolean > response = new HashMap <>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}
