package Dao;


import GenericDao.GenericDao;

import javax.persistence.EntityManager;

/**
 * Created by faima on 4/20/17.
 */
public class CharacterDao extends GenericDao {
    public CharacterDao( EntityManager entityManager) {
        super(Character.class, entityManager);
    }
}
