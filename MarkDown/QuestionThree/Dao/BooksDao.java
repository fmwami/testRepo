package Dao;


import models.Books;

import GenericDao.GenericDao;
import javax.persistence.EntityManager;

/**
 * Created by faima on 4/20/17.
 */
public class BooksDao extends GenericDao {
    public BooksDao( EntityManager entityManager) {
        super(Books.class, entityManager);
    }
}
