package com.netcracker.summerschool.class5.TCPServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import com.netcracker.summerschool.class2VectorInterface.*;

/**
 * Created by somal on 12.07.16.
 * <p>
 * Simple client for local echo-server
 */
public class Client {
    private DataInputStream in;
    private int port;
    private final String host = "localhost";
    private DataOutputStream out;
    private Socket socket;

    public Client(int port) {
        this.port = port;
        try {
            InetAddress address = InetAddress.getByName(this.host);
            Socket socket = new Socket(address, port);

            this.out = new DataOutputStream(socket.getOutputStream());
            this.in = new DataInputStream(socket.getInputStream());
            this.socket = socket;
        } catch (UnknownHostException e) {
        } catch (IOException e) {
        }
    }


    public void sendMessages(String[] messages) throws UnknownHostException {
        System.out.println("Start message sending");
        if (this.out == null)
            throw new UnknownHostException("Host wasn't found");

        for (String s : messages)
            try {
                this.out.writeUTF(s);
                this.out.flush();
                System.out.println(this.in.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        System.out.println("End message sending");
    }

    public void close() {
        if (socket != null)
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) throws UnknownHostException {
        int port = 9000;

        for (int i = 0; i < 3; i++) {
            Client client = new Client(port);
            client.sendMessages(new String[]{"Hello", "fdf!"});
            client.close();
        }

    }
}
