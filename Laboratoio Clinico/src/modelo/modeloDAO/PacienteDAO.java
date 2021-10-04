package modelo.modeloDAO;
import java.sql.*;
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
            String sql = "INSERT INTO Paciente values (?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, p.());
            pstm.setString(2, p.getNombre());
            pstm.setString(3,p.getNivel());
            pstm.setInt(4,p.getNum_creditos());
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
}
