package com.netcracker.summerschool.classes.class5.RMI;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Created by somal on 12.07.16.
 */
public interface RMIClassInterface extends Remote {
    public String helloWorld() throws RemoteException;

    public Vector getData(String id) throws RemoteException;
}
