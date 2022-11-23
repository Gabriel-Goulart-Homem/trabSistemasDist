/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicasttotord;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author gabri
 */

public class Servidor implements Runnable {

    int porta;

    public Servidor(int p) {
        porta = p;
    }

    @Override
    public void run() {
        String texto = "";
        Scanner scanner = new Scanner(System.in);
        try {
            ServerSocket servidor = new ServerSocket(porta);
            Socket socketServido = servidor.accept();

            ObjectOutputStream saida = new ObjectOutputStream(socketServido.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(socketServido.getInputStream());

            do {
                System.out.print("..: ");
                texto = scanner.nextLine();
                saida.writeObject(texto);
                saida.flush();
                //lendo a mensagem enviada pelo servidor
                texto = (String) entrada.readObject();
                System.out.println("Servidor>> " + texto);
            } while (!texto.equals("FIM"));

            saida.close();
            entrada.close();
            socketServido.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
}

