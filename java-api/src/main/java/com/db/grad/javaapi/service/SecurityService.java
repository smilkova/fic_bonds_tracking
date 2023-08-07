package com.db.grad.javaapi.service;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.SecuritiesRepository;
//import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.db.grad.javaapi.model.Securities;
//import sun.tools.jconsole.JConsole;


import javax.sound.midi.Sequence;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//the point of the service is to take the query supplied by the repo and
//make it readable for the controller
//uses the interface to have a model of abstract methods
//controller will call the service to execute functions
@Service
public class SecurityService implements ISecurityService {
    //implements this interface to say here is what this class can do all the moveable abstract methods
    private SecuritiesRepository itsSecuritysRepo;

    //creates a Security repo for this service
    @Autowired
    public SecurityService(SecuritiesRepository sRepo) {
        itsSecuritysRepo = sRepo;
        //makes the repo in this service the one from the query
    }

    @Override
    public List<Securities> getAllSecurities() {
        return itsSecuritysRepo.findAll();
    }

    @Override
    public Securities addSecurities(Securities theS) {
        return itsSecuritysRepo.save(theS);
    }


    @Override
    public long getNoOfSecurities() {
        return itsSecuritysRepo.count();
    }

    @Override
    public boolean RemoveSecurity(int uniqueId) {
        boolean result = false;

        Optional<Securities> thes = itsSecuritysRepo.findById(uniqueId);
        //may have a null value

        //unique id is security id

        if (thes.isPresent()) //iof the security isnt null
        {
            itsSecuritysRepo.delete(thes.get());
            result = true;
        }

        return result;
    }


    @Override
    public Securities getSecuritiesById(int uniqueId) {
        return itsSecuritysRepo.findById(uniqueId).get();
    }

    @Override
    public Securities getbyStatus(String stat) {
        return null;
    }


    @Override
    public Securities findByRecentAndNearMaturity(String today_date) {
        String startDay =  today_date.substring(0,2); // prints the day as an int
        //"05/08/2021"
        return null;
    }

    @Override
    public Securities findDates(Securities start, Securities end) {
        return null;
    }
}