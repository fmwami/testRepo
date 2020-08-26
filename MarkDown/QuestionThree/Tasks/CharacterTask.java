package Tasks;




import models.Characters;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by faima on 4/7/17.
 */
@Local
public interface CharacterTask {

    List<Characters> viewDetails();


}
