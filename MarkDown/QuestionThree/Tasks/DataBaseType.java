package Tasks;


import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by faima on 3/27/17.
 */
@Qualifier
@Retention(RUNTIME)
@Target({FIELD,TYPE,METHOD,PARAMETER})
public @interface DataBaseType {
    enum Type{
        ORACLE,MYSQL,MSSQL
    }
    Type value();
}
