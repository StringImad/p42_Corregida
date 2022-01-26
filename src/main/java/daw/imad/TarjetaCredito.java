package daw.imad;


import java.time.YearMonth;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author imad
 */
public class TarjetaCredito {

    private final String ENTIDAD_EMISORA;
    private final String NUMERO;//Deben ser 16 numeros
    private final YearMonth FECHA_CADUCIDAD;//formato 12/23
    private final String TITULAR;
    private boolean estadoTarjeta;//true activada
    private double limiteTarjeta; //entre 500 y 3000
    private String pin;

    public TarjetaCredito() {
        this.ENTIDAD_EMISORA = "NBank";
        this.NUMERO = "1234567898765432";
        this.FECHA_CADUCIDAD = YearMonth.now().plusYears(3);
        this.TITULAR = "Al Holder";
        this.estadoTarjeta = false;
        this.limiteTarjeta = 2000;
        this.pin = "1234";
    }

    public TarjetaCredito(String entidadEmisora, String numero, YearMonth fechaCaducidad, String titular, double limiteTarjeta, String pin) {
        this.ENTIDAD_EMISORA = entidadEmisora;
        if (compruebaIntroduccion16Caracteres(numero)) {
            this.NUMERO = numero;

        } else {
            this.NUMERO = "1234567898765432";

        }
        this.FECHA_CADUCIDAD = fechaCaducidad;
        this.TITULAR = titular;
        this.estadoTarjeta = false;
        if (limiteTarjeta <= 3000 && limiteTarjeta >= 500) {
            this.limiteTarjeta = limiteTarjeta;
        } else {
            this.limiteTarjeta = 2000;
        }
        if (compruebaIntroduccion4Caracteres(pin)) {
        this.pin = pin;
        } else {
            this.pin = "1234";
        }
    }

    //método privado de clase para comprobar si un String tiene 16 caracteres
    //Devuelve verdadero en caso de todos los caracteres sean digitos y tengan una extension de 16 caracteres
    private static boolean compruebaIntroduccion16Caracteres(String numero) {
        int contador = 0;
        for (int i = 0; i < numero.length(); i++) {
            if (Character.isDigit(numero.charAt(i))) {
                contador++;
            }
        }
        return contador==16;
    }

    private static boolean compruebaIntroduccion4Caracteres(String numero) {
        int contador = 0;
        for (int i = 0; i < numero.length(); i++) {
            if (Character.isDigit(numero.charAt(i))) {
                contador++;
            }
        }
        return contador==4;
    }
    public void activarTarjeta() {
        this.estadoTarjeta = true;
    }

    public void anularTarjeta() {
        this.estadoTarjeta = false;
    }

    public void pagar() {
        String pinIntroducido;
        double cantidadAPagar;
        int contadorIntentosPin = 0;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("Introduce el pin: ");
            pinIntroducido = teclado.nextLine();

            if (this.pin.equals(pinIntroducido)) {

                System.out.println("Introduce la cantidad a pagar: ");
                cantidadAPagar = teclado.nextDouble();
                teclado.nextLine();

                if (cantidadAPagar <= this.limiteTarjeta) {
                    if (estadoTarjeta) {
                        if ((FECHA_CADUCIDAD.isAfter(YearMonth.now()))) {
                            System.out.println("Compra realizada con  exito");
                            this.limiteTarjeta -= cantidadAPagar;
                        } else {
                            System.out.println("La tarjeta esta caducada");
                            break;
                        }

                    } else {
                        System.out.println("La tarjeta no esta activada");
                        break;
                    }
                } else {
                    System.out.println("Cantidad a pagar excede los limites de su tarjeta");
                    break;
                }

            } else {
                contadorIntentosPin++;
                System.out.println("Error al introducir el pin");
                if (contadorIntentosPin == 3) {
                    anularTarjeta();
                }
            }

        } while (contadorIntentosPin != 3);
    }

//método de clase, llamado copiar, que reciba un objeto de tipo TarjetaCredito a copiar y devuelva un nuevo objeto con la copia del mismo.
    public static TarjetaCredito copiar(TarjetaCredito recibida) {
        TarjetaCredito copia = new TarjetaCredito(recibida.getEntidadEmisora(), recibida.getNumero(),recibida.getFechaCaducidad(), recibida.getTitular(), recibida.getLimiteTarjeta(), recibida.getPin());
        return copia;
    }

    public String getEntidadEmisora() {
        return ENTIDAD_EMISORA;
    }

    public String getNumero() {
        return NUMERO;
    }

    public YearMonth getFechaCaducidad() {
        return FECHA_CADUCIDAD;
    }

    public String getTitular() {
        return TITULAR;
    }

    public boolean isEstadoTarjeta() {
        return estadoTarjeta;
    }

    public double getLimiteTarjeta() {
        return limiteTarjeta;
    }

    public String getPin() {
        return pin;
    }
//Los únicos atributos que permiten el cambio de valor de una tarjeta son:
    //estado (activa/anulada)

    public void setEstadoTarjeta(boolean estadoTarjeta) {
        this.estadoTarjeta = estadoTarjeta;
    }
//el límite de crédito. 

    public void setLimiteTarjeta(double limiteTarjeta) {
        if (limiteTarjeta <= 3000 && limiteTarjeta >= 500) {
            this.limiteTarjeta = limiteTarjeta;
        } else {
            this.limiteTarjeta = 2000;
        }
    }
//el pin de seguridad del usuario (el que piden los datáfonos al pagar)

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "\t" + TITULAR + "\t" + ENTIDAD_EMISORA + "\n"
                + "\t" + FECHA_CADUCIDAD + " caducidad\t " + limiteTarjeta + "\n"
                + "\t" + NUMERO;
    }

}
