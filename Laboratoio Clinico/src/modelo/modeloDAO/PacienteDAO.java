package modelo.modeloDAO;
import java.sql.*;
import java.util.ArrayList;
import modelo.Paciente;
import services.Servicio;

public class PacienteDAO {

    public PacienteDAO() {
    }
    
    public int insert(Paciente p){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Servicio.getConnection();
            String sql = "INSERT INTO Paciente VALUES (?,?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, p.getCedula());
            pstm.setString(2, p.getNombre());
            pstm.setString(3,p.getApellido());
            pstm.setDate(4, java.sql.Date.valueOf(p.getFechaNacimiento()) );
            pstm.setString(5,p.getPOS());
            pstm.setString(6,p.getTelefonoContacto());
            pstm.setString(7,p.getCedulaContacto());                                 
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            System.out.println("Error: "+ex.getLocalizedMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                System.out.println("Error: "+ex.getLocalizedMessage()+" "+ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public ArrayList<Paciente> getAllPacientes(){
        ArrayList<Paciente> todos = null;
        Connection conn=null;
        PreparedStatement psmt;
        try {
            todos = new ArrayList<>();
            conn = Servicio.getConnection();
            String consulta = "SELECT * FROM Pacientes";
            psmt=conn.prepareStatement(consulta);
            todos = (ArrayList<Paciente>) psmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error: "+e.getLocalizedMessage());
        }
        return todos;
    }
}
