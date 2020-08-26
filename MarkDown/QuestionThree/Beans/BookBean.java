package Beans;

import Dao.BooksDao;
import Tasks.BooksTask;
import models.Books;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BookBean implements BooksTask {
    @PersistenceContext(unitName = "GameOfThrones")
    private EntityManager entityManager;

    @Override
    public List<Books> viewDetails() {
        BooksDao booksDao = new BooksDao(entityManager);
        return booksDao.findAll();
    }
}
