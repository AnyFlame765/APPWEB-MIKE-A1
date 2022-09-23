package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfig;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import server.BeanRFC;
import server.Methods;
import server.Service;
import server.ServiceRFC;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class ClientRPC {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Scanner sc = new Scanner(System.in);

        System.out.println("Hola qué deseas realizar?");
        System.out.println("1. Registar persona");
        System.out.println("2. Consultar persona");
        System.out.println("3. Modificar persona");
        System.out.println("4. Eliminar persona");
        int option = sc.nextInt();

        switch (option){
            case 1:
                System.out.print("Ingresa tu nombre: ");
                String name = sc.next();
                System.out.print("Ingresa tu apellido paterno: ");
                String apellido1 = sc.next();
                System.out.print("Ingresa tu apellido materno: ");
                String apellido2 = sc.next();
                System.out.print("Ingresa tu curp: ");
                String curp = sc.next();
                System.out.print("Ingresa tu año de nacimiento (ultimos dos digitos): ");
                String year = sc.next();
                System.out.print("Ingresa tu mes de nacimiento: ");
                String mes = sc.next();
                System.out.print("Ingresa tu dia de nacimiento: ");
                String dia = sc.next();

                Methods per = new Methods();
                String rfc11 = per.mirfc(name, apellido1, apellido2, year, mes, dia);
                Object[] rfc = {name, apellido1, apellido2, year, mes, dia};
                String response = (String)
                        client.execute("Methods.mirfc", rfc);
                System.out.println(response);

                ServiceRFC serviceRFC = new ServiceRFC();
                BeanRFC person = new BeanRFC();
                person.setRfc(rfc11);
                person.setName(name);
                person.setApellido1(apellido1);
                person.setApellido2(apellido2);
                person.setCurp(curp);
                person.setAnio(year);
                person.setMes(mes);
                person.setDia(dia);

                boolean result = serviceRFC.saveRFC(person);
                break;

            case 2:
                System.out.println("Consultar Persona");
                System.out.println("Ingrese la CURP de la persona");
                String curpS = sc.next();
                Service serviceRFC1;
                serviceRFC1 = new Service();
                List<BeanRFC> listperson = serviceRFC1.listPerson(curpS);
                System.out.println(listperson);
                break;

            case 3:
                System.out.println("Modificar una persona");
                System.out.println("Ingrese el curp de la persona");

                break;

            case 4:
                System.out.println("Eliminar persona");
                System.out.println("Ingrese el curp de la persona");
                String curpdel = sc.next();
                serviceRFC1 = new Service();
                List<BeanRFC> listperson = serviceRFC1.listPerson(curpdel);
                System.out.println(listperson);
                break;
        }

    }
}
