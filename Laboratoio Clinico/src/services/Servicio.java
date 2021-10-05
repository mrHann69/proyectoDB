
package services;
import java.sql.*;
import java.util.ResourceBundle;

public class Servicio {
    
    private static Connection con = null;
    
    public static Connection getConnection(){
        try
        {
            if(con == null){
                //Determina cuando se termina el programa
                Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
                //Recupera los parámetros de conexión del archivo 
                //jdbc.properties
                ResourceBundle rb = ResourceBundle.getBundle("services.jdbc");
                String driver = rb.getString("driver");
                String url = rb.getString("url");
                String pwd = rb.getString("pwd");
                String usr = rb.getString("usr");
                Class.forName(driver);
                con = DriverManager.getConnection(url, usr, pwd);
            }
        }
        catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error get connection: "+ex.getLocalizedMessage());
        }
        return con;
    }
    
    static class MiShDwnHook extends Thread{
        //Justo antes de finaliza el programa la JVM invocará
        //este método donde podemos cerra la conexión
        @Override
        public void run(){
            try{
                Connection con = Servicio.getConnection();
                con.close();                     
            }
            catch (SQLException ex){
                System.out.println("Error Servicio: "+ex.getLocalizedMessage());
            }
        }
    }
}