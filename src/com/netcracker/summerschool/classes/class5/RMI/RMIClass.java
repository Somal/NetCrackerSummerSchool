package com.netcracker.summerschool.classes.class5.RMI;


import java.rmi.RemoteException;
import java.sql.*;
import java.util.Vector;


/**
 * Created by somal on 12.07.16.
 */
public class RMIClass implements RMIClassInterface {

    @Override
    public String helloWorld() throws RemoteException {
        return "Hello World!";
    }

    @Override
    public Vector getData(String id) throws RemoteException {
        Vector<StringBuilder> vector = new Vector<>(5);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@edu-netcracker.com:1520:xe", "unc16_user16", "unc16_user16");
            PreparedStatement stat = con.prepareStatement("SELECT * from pers WHERE PERS_ID=" + id);
            ResultSet set = stat.executeQuery();
            System.out.println(set.toString());

            while (set.next()) {
                StringBuilder from = new StringBuilder();
                for (int i = 1; i <= set.getMetaData().getColumnCount(); i++) {
                    from.append(set.getObject(i)).append(" ");
                }
                vector.add(from);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vector;
    }
}
