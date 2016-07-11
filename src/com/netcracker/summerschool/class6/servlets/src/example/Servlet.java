package example;

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
 */

@WebServlet("/image")
public class Servlet extends javax.servlet.http.HttpServlet {

    class ImageCreator {
        public String text = "Test";

        public void writeImageStream(OutputStream out, HttpServletRequest request) throws IOException {
            BufferedImage bi = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
            Graphics g = bi.getGraphics();

            g.setColor(Color.white);
            g.fillRect(1, 1, 300, 300);
            g.setColor(Color.black);

            Font f = new Font("Arial", Font.PLAIN, 60);
            g.setFont(f);

//            System.out.println(request.getAttributeNames());
            g.drawString((String) request.getParameter("text"), 100, 100);


            ImageIO.write(bi, "JPEG", out);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        PrintWriter outpw = response.getWriter();
        OutputStream out = response.getOutputStream();
        try {
//
            ImageCreator ic = new ImageCreator();
            ic.writeImageStream(out, request);
        } finally {
            out.close();
        }
    }


}
