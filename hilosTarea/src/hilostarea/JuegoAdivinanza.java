/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilostarea;

/**
 *
 * @author simon
 */
public class JuegoAdivinanza {
    private static final int NUM_HILOS = 10;

    public static void main(String[] args) {
        NumeroOculto numeroOculto = new NumeroOculto();

        Thread[] adivinadores = new Thread[NUM_HILOS];
        for (int i = 0; i < NUM_HILOS; i++) {
            Adivinador adivinador = new Adivinador("Adivinador " + i, numeroOculto);
            adivinadores[i] = new Thread(adivinador);
        }

        for (Thread adivinador : adivinadores) {
            adivinador.start();
        }

        for (Thread adivinador : adivinadores) {
            try {
                adivinador.join();
            } catch (InterruptedException e) {
            }
        }

        System.out.println("El juego ha terminado.");
    }
}