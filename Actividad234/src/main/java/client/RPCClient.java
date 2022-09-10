package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
//Delgado Pérez José Miguel
public class RPCClient {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el primer valor");
        double v1 = sc.nextDouble();
        System.out.println("Ingresa el segundo valor");
        double v2 = sc.nextDouble();
        System.out.println("Ingresa el valor 3");
        double v3 = sc.nextDouble();
        System.out.println("Ingresa el valor 4");
        double v4 = sc.nextDouble();

        Object[] operation = {v1, v2, v3, v4};
        String response = (String)
                client.execute("Methods.operation", operation);
        System.out.println(response);
    }
}
