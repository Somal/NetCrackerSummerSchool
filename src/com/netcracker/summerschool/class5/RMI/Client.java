package com.netcracker.summerschool.class5.RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Vector;

/**
 * Created by somal on 12.07.16.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 12345);
//            RMIClassInterface rmiClass = (RMIClassInterface) registry.lookup("RMIRegistry");
            RMIClassInterface rmiClass = (RMIClassInterface) Naming.lookup("rmi://localhost:12345/RMIRegistry");

            System.out.println(rmiClass.helloWorld());
            System.out.println(rmiClass.getData("100"));

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
