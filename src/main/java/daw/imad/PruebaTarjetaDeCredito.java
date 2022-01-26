/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.imad;

import java.time.Month;
import java.time.YearMonth;

/**
 *
 * @author imad
 */
public class PruebaTarjetaDeCredito {

    public static void main(String[] args) {
        //Crea una tarjeta con el constructor por defecto (t1)
        TarjetaCredito t1 = new TarjetaCredito();
        //con el constructor parametrizado (t2).
        TarjetaCredito t2 = new TarjetaCredito("Santander", "11112222333344a4", YearMonth.of(24, Month.MARCH), "Imad", 2500, "1111");

        TarjetaCredito t3 = TarjetaCredito.copiar(t2);
        System.out.println("-----------t1-------------\n");
        System.out.println(t1);
        System.out.println("--------------------------");
        System.out.println("-----------t2------------\n");
        System.out.println(t2);
        System.out.println("--------------------------");

        System.out.println("-----------t3------------\n");
        System.out.println(t3);
        System.out.println("--------------------------");
        
        System.out.println("-----------tarjeta 2 anulada-------------");
        t2.anularTarjeta();
        t2.pagar();
        System.out.println("-----------tarjeta 2 activada-------------");

        t2.activarTarjeta();
        t2.pagar();
        System.out.println(t2);
        t3.pagar();
        System.out.println(t3);
    }
}
