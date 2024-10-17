/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilostarea;
import java.util.Random;




public class NumeroOculto {
    private final int numeroOculto;
    private boolean encontrado = false;

    public NumeroOculto() {
        Random r = new Random();
        this.numeroOculto = r.nextInt(101); 
        System.out.println("Número oculto generado: " + numeroOculto);
    }

    public synchronized int propuestaNumero(int num) {
        if (encontrado) {
            return -1; 
        }
        if (num == numeroOculto) {
            encontrado = true;
            return 1;
        }
        return 0;
    }
}