/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicasttotord;

import java.util.Scanner;

/**
 *
 * @author gabri
 */
public class MulticastTotOrd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String texto = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a porta do local servidor1:");
        int portas1 = scanner.nextInt();
        
        System.out.println("Informe a porta do local servidor2:");
        int portas2 = scanner.nextInt();
        try {
            Servidor servidor = new Servidor(portas1);
            new Thread(servidor).start();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        try {
            Servidor servidor = new Servidor(portas2);
            new Thread(servidor).start();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        System.out.println("Informe a porta do servidor 1 que deseja conectar:");
        int portac1 = scanner.nextInt();
        
        System.out.println("Informe a porta do servidor 1 que deseja conectar:");
        int portac2 = scanner.nextInt();
        try {
            Cliente cliente = new Cliente(portac1);
            new Thread(cliente).start();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        try {
            Cliente cliente = new Cliente(portac2);
            new Thread(cliente).start();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            Leitor leitor = new Leitor();
            new Thread(leitor).start();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        
    }
}