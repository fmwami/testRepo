package Beans;

import Dao.HouseDao;
import Tasks.HouseTask;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class houseBean implements HouseTask {
    @PersistenceContext(unitName = "GameOfThrones")
    private EntityManager entityManager;

    @Override
    public List<Character> viewDetails() {
        HouseDao houseDao = new HouseDao(entityManager);
        return houseDao.findAll();
    }
}
