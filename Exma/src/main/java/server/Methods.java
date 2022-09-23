package server;

import java.util.Random;

public class Methods {

    //Método para generar el rfc
    public String mirfc(String nombre, String apellido1, String apellido2, String año, String mes, String dia){

        String patern = apellido2.toUpperCase();
        String rfc = apellido1.substring(0,2).toUpperCase() + patern.charAt(0) + nombre.charAt(0)
                + año + mes + dia +  numRandom();
        return rfc;
        }

    public static String numRandom(){
        //Variables para Generar el ID de Forma Aleatoria//
        Random aleatorio = new Random();
        String alfa = "ABCDEFGHIJKLMNOPQRSTVWXYZ";
        String cadena = "";  //Aqui se inicializa la cadena
        int numero;
        int forma;
        forma=(int)(aleatorio.nextDouble() * alfa.length()-1+0);
        numero=(int)(aleatorio.nextDouble() * 99+100);
        cadena=cadena+alfa.charAt(forma)+numero;
        return cadena;
    }
}
