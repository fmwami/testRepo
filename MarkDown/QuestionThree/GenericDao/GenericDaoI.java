package GenericDao;



import java.io.Serializable;
import java.util.List;

/**
 * Created by faima on 4/19/17.
 */
public interface GenericDaoI<T, PK extends Serializable>{
    T save(T t);
    T findById(PK id);
    T merge(T t);
    List<Character> findAll();
    boolean remove(T t);
}
