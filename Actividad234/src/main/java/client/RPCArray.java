package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

//Delgado Pérez José Miguel
public class RPCArray {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el primer valor");
        int v1 = sc.nextInt();
        System.out.println("Ingresa el segundo valor");
        int v2 = sc.nextInt();
        System.out.println("Ingresa el valor 3");
        int v3 = sc.nextInt();
        System.out.println("Ingresa el valor 4");
        int v4 = sc.nextInt();
        System.out.println("Ingresa el valor 4");
        int v5 = sc.nextInt();
        Object[] operation = {v1, v2, v3, v4, v5};
        String response = (String)
                client.execute("Methods.array", operation);
        System.out.println("Result ---> " + response);
    }
}
