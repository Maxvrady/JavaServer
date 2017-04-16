package Core;

import Hibernate.DBService;
import Hibernate.DBServiceImpl;
import Servlet.Index;
import Time.TimeHelper;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {

    public static void main(String[] args) throws Exception{

        DBService dbService = new DBServiceImpl();
        System.out.println(dbService.getUserById(1).getUsername());
        System.out.println(dbService.getUserByUsername("admin").getPassword());

        TimeHelper timeHelper = new TimeHelper();
        System.out.println(timeHelper.getTime());
        System.out.println(timeHelper.getLocalTime());

        Index indexServlet = new Index();

        ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.addServlet(new ServletHolder(indexServlet), "/");

        Server server = new Server(8080);
        server.setHandler(contextHandler);
        server.start();
        server.join();
    }
}
