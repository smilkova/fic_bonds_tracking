package com.db.grad.javaapi.service;
import com.db.grad.javaapi.model.Securities;

import javax.sound.midi.Sequence;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ISecurityService {
    public List<Securities> getAllSecurities();

    public Securities addSecurities(Securities theS);

    public long getNoOfSecurities();

    public boolean RemoveSecurity(int uniqueId);

    public Securities getSecuritiesById(int uniqueId);

    public Securities getbyStatus(String stat);

    public Optional<List<Securities>> findByRecentAndNearMaturity(String today_date);

    public Optional<List<Securities>> findMaturingToday(String today_date);

    public Optional<List<Securities>> findExpired(String today_date);

    public Optional<List<Securities>> findDates(String start, String end);

//    public Securities updateUserDetails(Securities UserToUpdate);
}
