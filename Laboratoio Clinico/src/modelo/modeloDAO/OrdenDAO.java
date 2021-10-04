package modelo.modeloDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Orden;
import services.Servicio;

public class OrdenDAO {

    public OrdenDAO() {
    }
    
    public int insert(Orden om){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Servicio.getConnection();
            String sql = "INSERT INTO ordenMedica VALUES (?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, om.getConsecutivo());
            pstm.setInt(2, om.getCedulaPaciente());
            pstm.setDate(3, om.getFechaSolicitud() );
            pstm.setDate(4, om.getFechaIngreso());
            pstm.setInt(5, om.getCedulaMedico());
            pstm.setString(6, om.getNumOrdenMed());

                                                
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
    
    public ArrayList<Orden> getAllPacientes(){
        ArrayList<Orden> todos = null;
        Connection conn=null;
        PreparedStatement psmt;
        try {
            todos = new ArrayList<>();
            conn = Servicio.getConnection();
            String consulta = "SELECT * FROM Orden";
            psmt=conn.prepareStatement(consulta);
            todos = (ArrayList<Orden>) psmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error: "+e.getLocalizedMessage());
        }
        return todos;
    }
}
