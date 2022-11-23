/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicasttotord;

import java.util.Scanner;

/**
 *
 * @author Gabriel Goulart Homem
 * @ra 771011
 */
public class Leitor implements Runnable {
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(text);
    }
}


