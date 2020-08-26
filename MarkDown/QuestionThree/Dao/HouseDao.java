package Dao;


import GenericDao.GenericDao;
import models.houses;

import javax.persistence.EntityManager;

/**
 * Created by faima on 4/19/17.
 */
public class HouseDao extends GenericDao<houses,Long> {

    public HouseDao(EntityManager entityManager) {
        super(houses.class, entityManager);
    }
}
