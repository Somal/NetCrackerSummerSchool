package com.netcracker.summerschool.classes.class5.TCPServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by somal on 12.07.16.
 * <p>
 * Simple single concurrent echo-server.
 */
public class Server {
    private int port;

    public Server(int port) {
        this.port = port;
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(port);

            System.out.println("ServerSocket is created on " + port);

            while (true) {
                Socket socket = ss.accept();
                System.out.println("Client is found.");

                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                DataInputStream in = new DataInputStream(inputStream);
                DataOutputStream out = new DataOutputStream(outputStream);

                String text = "";
                try {
                    while (true) { // Simple command for closing server
                        text = in.readUTF();
                        out.writeUTF(text);
                        out.flush();
                    }
                } catch (EOFException e1) {
                    socket.close();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getPort() {
        return port;
    }

    public static void main(String[] args) {
        Server server = new Server(9000);
    }


}
