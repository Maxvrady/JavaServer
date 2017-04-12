package DataBase;

import java.io.IOException;
import java.sql.*;

public class Connections {

    private Driver drv;
    private Connection conn;

    public Connections() throws Exception{

        this.drv = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
        DriverManager.registerDriver(this.drv);
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaDB?user=fedora&password=Fedora95!");
    }

    public void execUpdate(String command) throws IOException, SQLException{

        Statement statement = conn.createStatement();
        statement.execute(command);
        statement.close();
    }

    public void execQuery(String command, String columnLabel) throws  IOException, SQLException{

        Statement statement = conn.createStatement();
        statement.execute(command);
        ResultSet query = statement.getResultSet();

        while (true) {
            query.next();
            String value = query.getString(columnLabel);
            System.out.println(value);
            if (query.isLast())
                break;
        }

        statement.close();
        query.close();
    }
}
