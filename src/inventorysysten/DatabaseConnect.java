package inventorysysten;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Talha Bin Rais
 */
public class DatabaseConnect {

    private Statement st;
    private Connection con;
    ResultSet rs;

    public DatabaseConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ourswingproject", "root", "");
            st = con.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean InsertRegister(String insertQuery) {
        try {
            st.executeUpdate(insertQuery);
            JOptionPane.showMessageDialog(null, "Sucessfully  Registraion ");
              return true;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, " Not Sucessfully  Registraion");
            return  false;
        }
    }

    public  boolean LoginData(String queryLogin, String userName, String password) {

        int flag = 1;
        try {
            rs = st.executeQuery(queryLogin);

            while (rs.next()) {
                String tableName = rs.getString(3);
                String tablePass = rs.getString(5);

                if (userName.equals(tableName) && password.equals(tablePass)) {
                    JOptionPane.showMessageDialog(null, "You are sucessfully  Sign In ");
                    flag = 0;
                  return true;
                }

            }

            if (flag == 1) {
                JOptionPane.showMessageDialog(null, " User Name or Password did not match ");
            }
        } catch (Exception e) {
        }
         return false;
    }
    public  boolean LoginDataForAdmin(String queryLogin, String userName, String password) {

        int flag = 1;
        try {
            rs = st.executeQuery(queryLogin);

            while (rs.next()) {
                String tableName = rs.getString(2);
                String tablePass = rs.getString(3);

                if (userName.equals(tableName) && password.equals(tablePass)) {
                    JOptionPane.showMessageDialog(null, "You are sucessfully  Sign In ");
                    flag = 0;
                    return true;
                    //break;
                }
                

            }

           
            if (flag == 1) {
                JOptionPane.showMessageDialog(null, " User Name or Password did not match ");
                //return false;
            }
        } catch (Exception e) {
        }
        return false;
    }

}
