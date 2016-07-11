package com.netcracker.summerschool.class6ServletsAndJSP.src.example;

import com.sun.deploy.net.HttpRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by somal on 11.07.16.
 * My servlet which draw image with text from text input field.
 * <p>
 * 1) Run servlet under GlassFish/TomCat server
 * 2) Go to localhost:9000/commands
 * 3) Enter text in the field
 * 4) Press button
 * 5) Go to 3)
 */

@WebServlet("/image")
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        OutputStream out = response.getOutputStream();
        try {
            BufferedImage bi = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
            Graphics g = bi.getGraphics();

            g.setColor(Color.white);
            g.fillRect(1, 1, 300, 300);

            Font f = new Font("Arial", Font.PLAIN, 60);
            g.setFont(f);

            g.drawString(request.getParameter("text"), 100, 100);
            ImageIO.write(bi, "JPEG", out);
        } finally {
            out.close();
        }
    }


}
