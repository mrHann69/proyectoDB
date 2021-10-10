package modelo.modeloDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Orden;
import services.Servicio;

public class OrdenDAO {

    public OrdenDAO() {
    }

    public int insert(Orden om) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Servicio.getConnection();
            String sql = "INSERT INTO orden VALUES (?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, om.getConsecutivo());
            pstm.setInt(2, om.getCedulaPaciente());
            pstm.setDate(3, java.sql.Date.valueOf(om.getFechaSolicitud()));
            pstm.setDate(4, java.sql.Date.valueOf(om.getFechaIngreso()));
            pstm.setInt(5, om.getCedulaMedico());
            pstm.setString(6, om.getNumOrdenMed());
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error ODAO: " + ex.getLocalizedMessage());
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

    public ArrayList<Orden> getAllOrdenes() {
        ArrayList<Orden> ordenes = null;
        Connection conn = null;
        PreparedStatement psmt;
        ResultSet rs = null;
        try {
            ordenes = new ArrayList<>();
            conn = Servicio.getConnection();
            String consulta = "SELECT * FROM Orden";
            psmt = conn.prepareStatement(consulta);
            rs = psmt.executeQuery();
            Orden O = null;
            while(rs.next()){
                O = new Orden(rs.getString("consecutivo"),
                                rs.getInt("cedulapaciente"),
                                LocalDate.parse(rs.getString("fechasolicitud")),
                                LocalDate.parse(rs.getString("fechaingreso")),
                                rs.getInt("cedulamedico"),
                                rs.getString("numordenmed"));
                ordenes.add(O);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return ordenes;
    }
}
