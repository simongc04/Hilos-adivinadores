/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilostarea;


import java.util.Random;

public class Adivinador implements Runnable {
    private final String nombre;
    private final NumeroOculto numeroOculto;

    public Adivinador(String nombre, NumeroOculto numeroOculto) {
        this.nombre = nombre;
        this.numeroOculto = numeroOculto;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true) {
            int propuesta = r.nextInt(101); 
            int resultado = numeroOculto.propuestaNumero(propuesta);

            if (resultado == -1) {
                break;
            } else if (resultado == 1) {
                System.out.println(nombre + " ha adivinado el número! Era: " + propuesta);
                break;
           } else {
                System.out.println(nombre + " propone el número: " + propuesta);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
