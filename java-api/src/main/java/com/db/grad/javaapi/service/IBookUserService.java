package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.model.Users;

import java.util.List;

public interface IBookUserService {
    public List<BookUser> getAllBookUsers();

    public BookUser addBookUser(BookUser theUser);

    public long getNoOfBookUsers();

    public boolean removeBookUser(int uniqueId);

    public BookUser findUsersForBook(Book bookId);

    public BookUser findBooksForUser(Users userId);

    public BookUser updateBookUserDetails(BookUser UserToUpdate);
}
