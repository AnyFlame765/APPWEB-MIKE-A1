package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ClienteRPC {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
       String option = "", num1 ="", num2="";
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

       do {
           System.out.println("1. Suma");
           System.out.println("2. Resta");
           System.out.println("3. Multiplicacion");
           System.out.println("4. Division");
           System.out.println("5. Exponente");
           System.out.println("6. Raiz");
           System.out.println("7. Salir");
           option = sc.next();

               switch (Integer.parseInt(option)){
                   case 1:
                       System.out.println("--SUMA--");
                       do {
                           System.out.println("Ingresa el primer valor");
                           num1 = sc.next();
                           if (isNumber(num1)){
                               System.out.println("Error, ingrese un valor númerico");
                           }
                       }while (isNumber(num1));

                       do {
                           System.out.println("Ingresa el segundo valor");
                           num2 = sc.next();
                           if (isNumber(num2)){
                               System.out.println("Error, ingrese un valor númerico");
                           }
                       }while (isNumber(num2));

                       //Llamada al servicio web
                       Object[] operation = {num1, num2};
                       int response = (int)
                               client.execute("Methods.suma", operation);
                       System.out.println("La suma es :" + response);
                       break;

                   case 2:
                       System.out.println("--Resta--");
                       System.out.println("Ingrese el primer valor");
                       int v1 = sc.nextInt();
                       System.out.println("Ingrese el segundo valor");
                       int v2 = sc.nextInt();

                       //Llamada al servicio
                       Object[] resta = {v1, v2};
                       int ex = (int)
                               client.execute("Methods.resta", resta);
                       System.out.println("La resta es: " + ex);

                       break;


                   case 3:
                       System.out.println("--Multiplicación--");
                       System.out.println("Ingresa el valor 1");
                       int v1m = sc.nextInt();
                       System.out.println("Ingresa el valor 2");
                       int v2m = sc.nextInt();

                       //Llamada al servicio
                       Object[] multi = {v1m, v2m};
                       int mult = (int)
                               client.execute("Methods.multi", multi);
                       System.out.println("La multiplicacion es: " + mult);
                       break;

                   case 4:
                       boolean flag = true;
                       System.out.println("--Division--");
                       System.out.println("Ingresa el valor 1");
                       double div1 = sc.nextInt();
                       System.out.println("Ingresa el valor 2");
                       double div2 = sc.nextInt();
                       while (flag){
                           if (div1>div2){
                               System.out.println("No se puede dividir entre cero");
                               continue;
                           }else {
                               Object[] div = {div1, div2};
                               double divis = (double)
                                       client.execute("Methods.div", div);
                               System.out.println("La multiplicacion es: " + divis);
                           }
                       }


                       break;

                   case 5:
                       System.out.println("--Potencia--");
                       System.out.println("Ingresa el valor");
                       int value = sc.nextInt();
                       System.out.println("A que potencia deseas elevarlo?");
                       int pot = sc.nextInt();
                       Object[] pot1 = {value, pot};
                       int pote = (int)
                               client.execute("Methods.exponente", pot1);
                       System.out.println("La potencia es: " + pote);
                       break;

                   case 6:
                       System.out.println("--Raiz--");
                       System.out.println("Ingresa el valor");
                       int raiz =sc.nextInt();
                       Object[] raiz1 = {raiz};
                       int rar = (int)
                               client.execute("Methods.raiz", raiz1);
                       System.out.println("La potencia es: " + rar);
                       break;

                   default:
                       System.out.println("Ingresa una opción válida");
               }
       }while (!option.equals("7"));
    }

    public static boolean isNumber(String number){
        try {
            int num = Integer.parseInt(number);
                    return false;
        }catch (NumberFormatException e){
            return false;
        }

    }
}
