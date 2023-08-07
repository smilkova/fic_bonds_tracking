package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.model.Securities;
import com.db.grad.javaapi.service.BookService;
import com.db.grad.javaapi.service.SecurityService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v5")
@CrossOrigin(origins = "http://localhost:3000")
public class SecurityController {
    private SecurityService securityService;

    @Autowired
    public SecurityController(SecurityService sv) {
        securityService = sv;
    }

    @GetMapping("/securitiesByDate/{date}")
    public ResponseEntity <Optional<List<Securities>> >findByRecentAndNearMaturity(@PathVariable(value = "date") String date)
            throws ResourceNotFoundException {
        Optional<List<Securities>> matSecurity = securityService.findByRecentAndNearMaturity(date);
        return ResponseEntity.ok().body(matSecurity);
    }

    @GetMapping("/securitiesMaturingToday/{date}")
    public ResponseEntity <Optional<List<Securities>> >findMaturingToday(@PathVariable(value = "date") String date)
            throws ResourceNotFoundException {
        Optional<List<Securities>> matSecurity = securityService.findMaturingToday(date);
        return ResponseEntity.ok().body(matSecurity);
    }

    @GetMapping("/securitiesExpired/{date}")
    public ResponseEntity <Optional<List<Securities>> >findExpired(@PathVariable(value = "date") String date)
            throws ResourceNotFoundException {
        Optional<List<Securities>> matSecurity = securityService.findExpired(date);
        return ResponseEntity.ok().body(matSecurity);
    }

    @GetMapping("/securitiesBetweenDates/{start_date}/{end_date}")
    public ResponseEntity <Optional<List<Securities>> >findMaturingToday(@PathVariable(value = "start_date") String start_date,
                                                                         @PathVariable(value = "end_date") String end_date)
            throws ResourceNotFoundException {
        Optional<List<Securities>> matSecurity = securityService.findDates(start_date, end_date);
        return ResponseEntity.ok().body(matSecurity);
    }

    @GetMapping("/securities")
    public List<Securities> getAllSecurities() {
        return securityService.getAllSecurities();
    }


    //
    @RequestMapping(value="/securities/{secID}", method=RequestMethod.GET)
    public ResponseEntity < Securities > getSecuritiesById(@PathVariable(value = "secID") int id)
            throws ResourceNotFoundException {
        Securities sec = securityService.getSecuritiesById(id);
        return ResponseEntity.ok().body(sec);
    }


//
//    @GetMapping("/securities/{status}")
//    public ResponseEntity < Securities > getbyStatus(@PathVariable(value = "Status") String status)
//            throws ResourceNotFoundException {
//        Securities sec = securityService.getbyStatus(status);
//        return ResponseEntity.ok().body(sec);
//    }
}
//
//


