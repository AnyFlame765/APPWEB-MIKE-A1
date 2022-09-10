package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
//Delgado Pérez José Miguel
public class RPCValor {
    public static void main(String[] args) throws XmlRpcException, MalformedURLException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el valor inferior");
        int v1 = sc.nextInt();
        System.out.println("Ingresa el valor limite");
        int v2 = sc.nextInt();
        Object[] operation = {v1, v2};
        int response = (int)
                client.execute("Methods.suma", operation);
        System.out.println("Result ---> " + response);
    }
}
