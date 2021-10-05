
package modelo.modeloDAO;

import modelo.Login;
import services.Servicio;
import java.sql.*;

public class LoginDAO {

    public LoginDAO() {
    }
    
    public boolean verify(Login l){
        boolean status=false;
        Connection con;
        PreparedStatement pstm;
        ResultSet rs;
        try {
            con = Servicio.getConnection();
            String sql = "select cedula from trabajadores where cedula= ? and pass= ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, l.getCedula());
            pstm.setString(2, l.getContraseña());
            rs = pstm.executeQuery();
            if(rs.next()){
                if(rs.getString("cedula").equals(l.getCedula())){
                    status=true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error login verification: " + ex.getLocalizedMessage());
        }
        return status;
    }
}
