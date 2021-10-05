
package controller;

import modelo.Login;
import modelo.modeloDAO.LoginDAO;

public class Control {
    public static void main(String[] args) {
        Login algo = new Login("102030", "pass1");
        LoginDAO ldao = new LoginDAO();
        System.out.println("res :"+ldao.verify(algo));
    }
}
