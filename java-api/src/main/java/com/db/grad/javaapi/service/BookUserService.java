package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.model.Users;
import com.db.grad.javaapi.repository.BookUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookUserService implements IBookUserService{
    private BookUserRepository itsBookUserRepo;

    @Autowired
    public BookUserService( BookUserRepository buRepo )
    {
        itsBookUserRepo = buRepo;
        //makes the repo in this service the one from the query
    }
    @Override
    public List<BookUser> getAllBookUsers() {
        return itsBookUserRepo.findAll();
    }

    @Override
    public BookUser addBookUser(BookUser theUser) {
        return itsBookUserRepo.save(theUser);
    }

    @Override
    public long getNoOfBookUsers() {
        return itsBookUserRepo.count();
    }

    @Override
    public boolean removeBookUser(int uniqueId) {
        boolean result = false;

        Optional<BookUser> theUser = itsBookUserRepo.findById(uniqueId);
        //may have a null value

        if(theUser.isPresent()) //if the user isnt null
        {
            itsBookUserRepo.delete(theUser.get());
            result = true;
        }

        return  result;
    }

    @Override
    public BookUser findUsersForBook(Book bookId) {
        BookUser UserToFind = new BookUser();
        //creates empty user object and assigns needed name
        UserToFind.setBook_id(bookId);
        List<BookUser> ManyUsers = itsBookUserRepo.findUsersForBook(UserToFind);
        BookUser result = null;

        if( ManyUsers.size() == 1)
            result = ManyUsers.get(0);
        //if there is a user that matches return it if not return nothing
        return result;
    }

    @Override
    public BookUser findBooksForUser(Users userId) {
        BookUser BookToFind = new BookUser();
        //creates empty user object and assigns needed name
        BookToFind.setUser_id(userId);
        List<BookUser> ManyUsers = itsBookUserRepo.findUsersForBook(BookToFind);
        BookUser result = null;

        if( ManyUsers.size() == 1)
            result = ManyUsers.get(0);
        //if there is a user that matches return it if not return nothing
        return result;
    }

    @Override
    public BookUser updateBookUserDetails(BookUser UserToUpdate) {
        return itsBookUserRepo.save( UserToUpdate );
    }
}
