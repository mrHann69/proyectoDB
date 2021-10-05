
package controller;

import front.Principal;
import modelo.Login;
import modelo.modeloDAO.LoginDAO;
import front.login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Control {
    protected login vistalogin;
//    public static void main(String[] args) {

//    }
    
    protected void iniciarLogin(){
        this.vistalogin = new login();
        this.vistalogin.setVisible(true);
        this.vistalogin.addListenerIngresar(new ProgramaListener());
        this.vistalogin.addListenerCancelar(new ProgramaListener());
    }

    
    class ProgramaListener implements ActionListener{

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
                    new Principal().setVisible(true);
                    vistalogin.setVisible(false);
                    System.out.println("autentication: "+aux);
                }else{
                    System.out.println("autentication: "+aux);
                }
        }
        
        protected void cancelar(){
            vistalogin.cancelar();
        }
        
    }
    
    
}
