package Tasks;

import ClinicSystemObjects.LabTech;
import models.Books;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by faima on 4/20/17.
 */
@Local
public interface BooksTask {

    List<Books> viewDetails();


}
