package Tasks;

import javax.ejb.Local;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by faima on 3/27/17.
 */
@Local
public interface DatabaseOperations  {
    Connection connection();
    ResultSet read(String read);
    boolean update(String update);
    boolean writeDb(String write);
    boolean writeMany(String[] sql);
    boolean delete();
}
