
package controller;

import front.Principal;
import modelo.Login;
import modelo.modeloDAO.LoginDAO;
import front.login;
import front.IngresarOrden;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import modelo.Orden;
import modelo.modeloDAO.OrdenDAO;


public class Control {
    protected login vistalogin;
    protected Principal principal;
    protected IngresarOrden ingOrden;
    
    
    
    protected void iniciarLogin(){
        this.vistalogin = new login();
        this.vistalogin.setVisible(true);
        this.vistalogin.addListenerIngresar(new LoginListener());
        this.vistalogin.addListenerCancelar(new LoginListener());
    }

    
    class LoginListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getActionCommand().equalsIgnoreCase("ENTRAR")){
                this.logear();
            }else if(e.getActionCommand().equalsIgnoreCase("CANCELAR")){
                vistalogin.cancelar();
            }
        }    
        protected void logear(){
            Login algo = new Login(vistalogin.getCedulaTF(), vistalogin.getjPassword());
            LoginDAO ldao = new LoginDAO();
            Boolean aux = ldao.verify(algo);
            System.out.println(vistalogin.getCedulaTF() +"\n"+vistalogin.getjPassword());
                if(aux){
                    this.iniciarPrincipal();
                    vistalogin.setVisible(false);
                    System.out.println("autentication: "+aux);
                }else{
                    JOptionPane.showMessageDialog(null, "Cedula/Contraseña incorrecta");
                    vistalogin.limpiar();
                    System.out.println("autentication: "+aux);
                }
        }
        private void iniciarPrincipal(){
            principal = new Principal();
                principal.setVisible(true);
                principal.addListenerIngresarOrden(new PrincipalListener());
                principal.addListenerRegistrarPaciente(new PrincipalListener());
                principal.addListenerReportes(new PrincipalListener());
                principal.addListenerFacturacion(new PrincipalListener());
                principal.addListenerOrdenesPendientes(new PrincipalListener());
                principal.addListenerExamenesPendientes(new PrincipalListener());
        }
        protected void cancelar(){
            vistalogin.cancelar();
        }  
    }
    
    class PrincipalListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getActionCommand().equalsIgnoreCase("Ingresar Orden")){
                this.ingresarOrden();
            }else if(e.getActionCommand().equalsIgnoreCase("Registrar Paciente")){
                
            }else if(e.getActionCommand().equalsIgnoreCase("Reportes")){
                
            }else if(e.getActionCommand().equalsIgnoreCase("Facturacion")){
                
            }else if(e.getActionCommand().equalsIgnoreCase("Ordenes Pendientes")){
                
            }else if(e.getActionCommand().equalsIgnoreCase("Examenes Pendientes")){
                
            }else if(e.getActionCommand().equalsIgnoreCase("X")){
                this.cancelar();
            }
        }
        private void ingresarOrden(){
            ingOrden = new IngresarOrden();
                ingOrden.setVisible(true);
                ingOrden.addListenerAceptar(new IngresarOrdenListener());
                ingOrden.addListenerCancelar(new IngresarOrdenListener());
        }

        protected void cancelar(){
            
        }  
    }
    
    class IngresarOrdenListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getActionCommand().equalsIgnoreCase("Aceptar")){
                this.Aceptar();
            }else if(e.getActionCommand().equalsIgnoreCase("Cancelar")){
                this.cancelar();
            }
        }
        private void Aceptar(){
//            Orden O = new Orden(ingOrden.getTxtConsecutivo().toString(),
//                                Integer.parseInt(ingOrden.getTxtCedula().toString()),
//                                ,
//                                ingOrden.getTxtFechaIngreso().toString(),
//                                Integer.parseInt(ingOrden.getTxtMedicoTratante().toString()),
//                                ingOrden.getTxtNumeroOrden().toString());
//            OrdenDAO odao = new OrdenDAO();
//            odao.insert(O);
                JOptionPane.showMessageDialog(null, "Orden Ingresada");
            ingOrden.dispose();
            
        }

        protected void cancelar(){
            ingOrden.dispose();
        }  
    }
}
