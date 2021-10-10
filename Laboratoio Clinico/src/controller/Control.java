
package controller;

import front.ExamenesPendientes;
import front.Facturacion;
import front.Principal;
import modelo.Login;
import modelo.modeloDAO.LoginDAO;
import front.login;
import front.IngresarOrden;
import front.OrdenesPendientes;
import front.RegistrarPaciente;
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
    protected RegistrarPaciente regPaciente;
    protected Facturacion factu;
    protected OrdenesPendientes OPendientes;
    protected ExamenesPendientes EPendientes;
    
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
                principal.addListenerSalir(new PrincipalListener());
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
                this.registrarPaciente();
            }else if(e.getActionCommand().equalsIgnoreCase("Reportes")){
                
            }else if(e.getActionCommand().equalsIgnoreCase("Facturacion")){
                this.Facturacion();
            }else if(e.getActionCommand().equalsIgnoreCase("Ordenes Pendientes")){
                this.OrdenesPendientes();
            }else if(e.getActionCommand().equalsIgnoreCase("Examenes Pendientes")){
                this.ExamenesPendientes();
            }else if(e.getActionCommand().equalsIgnoreCase("Salir")){
                this.Salir();
            }
        }
        private void ingresarOrden(){
            ingOrden = new IngresarOrden();
                ingOrden.setVisible(true);
                ingOrden.addListenerAceptar(new IngresarOrdenListener());
                ingOrden.addListenerCancelar(new IngresarOrdenListener());
        }
        private void registrarPaciente(){
            regPaciente = new RegistrarPaciente();
                regPaciente.setVisible(true);
                regPaciente.addListenerRegistrar(new RegistrarPacienteListener());
                regPaciente.addListenerCancelar(new RegistrarPacienteListener());
        }
        private void Facturacion() {
            factu = new Facturacion();
                factu.setVisible(true);
                factu.addListenerAceptar(new FacturacionListener());
                factu.addListenerCancelar(new FacturacionListener());
        }
        private void OrdenesPendientes(){
            OPendientes = new OrdenesPendientes();
                OPendientes.setVisible(true);
                OPendientes.addListenerSalir(new OPendientesListener());
                
                OrdenDAO oDAO = new OrdenDAO();
                OPendientes.cargarOrdenes(oDAO.getAllOrdenes());
                
                for (Orden orden : oDAO.getAllOrdenes()){
                    System.out.println("consecutivo "+orden.getConsecutivo());
                }        
        }
        private void ExamenesPendientes() {
            EPendientes = new ExamenesPendientes();
                EPendientes.setVisible(true);
                EPendientes.addListenerSalir(new EPendientesListener());
        }
        
        protected void Salir(){
            principal.dispose();
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
            Orden O = new Orden(ingOrden.getTxtConsecutivo().getText(),
                                Integer.parseInt(ingOrden.getTxtCedula().getText()),
                                LocalDate.parse(ingOrden.getTxtFechaSolicitud().getText()),
                                LocalDate.parse(ingOrden.getTxtFechaIngreso().getText()),
                                Integer.parseInt(ingOrden.getTxtMedicoTratante().getText()),
                                ingOrden.getTxtNumeroOrden().getText());
            OrdenDAO odao = new OrdenDAO();
            odao.insert(O);
            System.out.println(LocalDate.parse(ingOrden.getTxtFechaSolicitud().getText()));
            System.out.println(LocalDate.parse(ingOrden.getTxtFechaIngreso().getText()));
                JOptionPane.showMessageDialog(null, "Orden Ingresada");
            ingOrden.dispose();   
        }

        protected void cancelar(){
            ingOrden.dispose();
        }  
    }
    
    class RegistrarPacienteListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getActionCommand().equalsIgnoreCase("Registrar")){
                this.registrar();
            }else if(e.getActionCommand().equalsIgnoreCase("Cancelar")){
                this.cancelar();
            }
        }
        private void registrar(){
            JOptionPane.showMessageDialog(null, "Paciente Registrado");
            regPaciente.dispose();   
        }
        protected void cancelar(){
            ingOrden.dispose();
        }  
    }
    
    class FacturacionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equalsIgnoreCase("Aceptar")){
                this.aceptar();
            }else if(e.getActionCommand().equalsIgnoreCase("Cancelar")){
                this.cancelar();
            }
        }
        private void aceptar(){
            regPaciente.dispose();   
        }
        protected void cancelar(){
            ingOrden.dispose();
        }  
    }
    
    class OPendientesListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equalsIgnoreCase("Salir")){
                this.Salir();
            }
        }
        protected void Salir(){
            OPendientes.dispose();
        }  
    }
    
    class EPendientesListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equalsIgnoreCase("Salir")){
                this.Salir();
            }
        }
        protected void Salir(){
            EPendientes.dispose();
        }  
    }
    
    
    
}
