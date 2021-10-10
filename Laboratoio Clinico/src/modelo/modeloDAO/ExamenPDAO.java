
package modelo.modeloDAO;

import java.util.ArrayList;
import modelo.ExamenPendiente;
import java.sql.*;
import java.time.LocalDate;

public class ExamenPDAO {
    
    
    
    
    public ArrayList<ExamenPendiente> getAllPendientes(String fecha){  
        ArrayList<ExamenPendiente> examenes = null;
        String sql = "SELECT * FROM pending_exams(?)";
        PreparedStatement psmt;
        ResultSet rs; 
        Connection conn;
        try {
            conn = services.Servicio.getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setDate(1, java.sql.Date.valueOf(LocalDate.parse(fecha)));
            rs = psmt.executeQuery();
            ExamenPendiente ep = null;
            while(rs.next()){
                ep = new ExamenPendiente(
                            rs.getInt("cedulapaciente"),
                            rs.getString("nombrepaciente"),
                            rs.getString("apellidopaciente"),
                            rs.getString("consecutivo"),
                            rs.getString("examen"),
                            rs.getDate("fechacita").toString());
                examenes.add(ep);
            }
        } catch (SQLException e) {
            System.out.println("Error ep: "+ e.getLocalizedMessage());
        }
        return examenes;
    }
}
