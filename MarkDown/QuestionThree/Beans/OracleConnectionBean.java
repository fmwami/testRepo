package Beans;



import Tasks.DataBaseType;
import Tasks.DatabaseOperations;
import models.Utility;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import static Tasks.DataBaseType.Type.ORACLE;

/**
 * Created by faima on 3/27/17.
 */
@Stateless(name = "Connection")
@DataBaseType(ORACLE)
@TransactionManagement(TransactionManagementType.BEAN)
public class OracleConnectionBean implements DatabaseOperations {
    private Connection cn=null;
    private Statement st = null;
    @Override
    public Connection connection() {
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:jboss/datasources/clinic");
            cn = dataSource.getConnection();
            if (cn != null) {
                Utility.printLn("Connection Successful to ORACLE");

            } else {
                Utility.printLn("Connection FAILED to ORACLE");
            }
        } catch (NamingException ne) {
            Utility.printLn("NamingException " + ne.getMessage());

        } catch (SQLException se) {
            Utility.printLn("SQLException " + se.getMessage());

        }
return cn;
    }

    @Override
    public ResultSet read(String read) {
        ResultSet rs = null;
        try {

            st=cn.createStatement();
            rs=st.executeQuery(read);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;


    }

    @Override
    public boolean update(String update) {
        try {
            st=cn.createStatement();
            st.executeUpdate(update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean writeDb(String write) {
        try {
            st=cn.createStatement();
            st.execute(write);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public boolean writeMany(String [] sql) {
        try {
            cn.setAutoCommit(false);
            st=cn.createStatement();
            for (int i = 0; i< sql.length; i++){
                st.execute(sql[i]);
            }
            cn.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                cn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return false;

        }
    }

    @Override
    public boolean delete() {
     return  true;
    }
}
