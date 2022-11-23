/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicasttotord;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author gabri
 */
public class Cliente implements Runnable {

    int porta;

    public Cliente(int p1) {
        porta = p1;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String texto = "";
        try {
            Socket clienteSocket = new Socket("127.0.0.1", porta);

            ObjectOutputStream saida = new ObjectOutputStream(clienteSocket.getOutputStream());
            saida.flush();
            ObjectInputStream entrada = new ObjectInputStream(clienteSocket.getInputStream());

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
            clienteSocket.close();

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
