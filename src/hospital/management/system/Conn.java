package hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    Connection connection;
    Statement statement;

    public Conn()
    {
        try
        {
            connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hospital_management_system?useSSL=false&serverTimezone=UTC",
                    "root",
                    "*********"
            );
            statement=connection.createStatement();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
