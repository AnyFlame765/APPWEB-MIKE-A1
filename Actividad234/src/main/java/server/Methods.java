package server;

import java.util.Arrays;
//Delgado Pérez José Miguel
public class Methods {
    public String operation(double v1, double v2, double v3, double v4){
        double producto = v1 * v2 *v3*v4;
        double suma = v1+v2+v3+v4;
        double promedio = (v1+v2+v3+v4)/4;
        String message = "\nHola, el producto es: " + producto + "\nLa suma es: " +suma+ "\nEl promedio es: " + promedio;
        return message;
    }

    public int suma (int value1, int value2){
        int suma = 0;
        for (int i = value1+1 ; i < value2; i++ ){
             suma = suma + i;
        }
        return suma;
    }

    public String array(int v1, int v2, int v3, int v4, int v5){
        int[] array = {v1,v2,v3,v4,v5};
        Arrays.sort(array);
        return Arrays.toString(array);
    }
}
