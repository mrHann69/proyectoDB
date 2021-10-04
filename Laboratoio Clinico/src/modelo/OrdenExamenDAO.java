package modelo;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.sql.*;

public class OrdenExamenDAO {
    public OrdenExamenDAO() {

    }

    public int insertOrdenExamen(OrdenExamen orden) {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        String sqlStatement;
        LocalDate dateCita = orden.getFechaCita();
        int restInsert = 0;

        try {
            // conexion = ClassConectionDB.startConection();
            sqlStatement = "insert into ordenExamen values (?, ?, ?, ?)";
            instruccion = conexion.prepareStatement(sqlStatement);

            instruccion.setString(1, orden.getConsecutivo());
            instruccion.setString(2, orden.getExamen());
            instruccion.setDate(3, Date.valueOf(dateCita));

            restInsert = instruccion.executeUpdate();
        }catch (SQLException exception) {
            System.out.println(exception.getSQLState());
        }
        return restInsert;
    }
}
