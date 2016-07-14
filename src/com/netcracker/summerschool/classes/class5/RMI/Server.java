package com.netcracker.summerschool.classes.class5.RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by somal on 12.07.16.
 */
public class Server {
    public static void main(String[] args) {
        RMIClass rmiClass = new RMIClass();

        try {
            RMIClassInterface rmiClassInterface = (RMIClassInterface) UnicastRemoteObject.exportObject(rmiClass, 0);
            Registry registry = LocateRegistry.createRegistry(12345);
            registry.bind("RMIRegistry", rmiClassInterface);


        } catch (Exception e) {
        }
    }
}
