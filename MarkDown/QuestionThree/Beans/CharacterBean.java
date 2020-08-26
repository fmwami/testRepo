package Beans;





import Dao.BooksDao;
import Dao.CharacterDao;
import Tasks.CharacterTask;
import models.Characters;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

/**
 * Created by faima on 4/7/17.
 */

@Stateless(name = "Characters")
public  class CharacterBean implements CharacterTask {
    @PersistenceContext(unitName = "GameOfThrones")
private  EntityManager entityManager;





    @Override
    public List<Characters> viewDetails() {
        CharacterDao characterDao = new CharacterDao(entityManager);
        return characterDao.findAll();
    }
}

