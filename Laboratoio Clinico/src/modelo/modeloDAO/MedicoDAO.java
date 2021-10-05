package modelo.modeloDAO;
import java.sql.*;
import java.util.ArrayList;
import modelo.Medico;
import services.Servicio;


public class MedicoDAO {
    
    public MedicoDAO() {
    }
    public int insert(Medico med) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Servicio.getConnection();
            String sql = "INSERT INTO Medico VALUES (?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, med.getCedula());
            pstm.setString(2, med.getNombre());
            pstm.setString(3, med.getApellido());
            pstm.setString(4, med.getTelefono());
            pstm.setString(5, med.getDireccion());
            pstm.setString(6, med.getEspecialidad());
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getLocalizedMessage() + " " + ex.getMessage());
            }
        }
        return rtdo;
    } 
    
    public ArrayList<Medico> getAllPacientes() {
        ArrayList<Medico> todos = null;
        Connection conn = null;
        PreparedStatement psmt;
        try {
            todos = new ArrayList<>();
            conn = Servicio.getConnection();
            String consulta = "SELECT * FROM Medico";
            psmt = conn.prepareStatement(consulta);
            todos = (ArrayList<Medico>) psmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return todos;
    }
}
