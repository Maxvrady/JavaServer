package main;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.OwnServlet;

public class Main {

    public static void main(String[] args) throws Exception{
        OwnServlet servlet = new OwnServlet();

        ServletContextHandler holder = new ServletContextHandler();
        holder.addServlet(new ServletHolder(servlet), "/");

        Server server = new Server(8080);
        server.setHandler(holder);

        server.start();
        server.join();
    }
}
