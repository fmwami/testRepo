package Tasks;


import javax.ejb.Local;
import java.util.List;

/**
 * Created by faima on 4/20/17.
 */
@Local
public interface HouseTask {

    List<Character> viewDetails();



}
