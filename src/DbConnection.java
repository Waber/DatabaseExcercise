import java.sql.*;

public class DbConnection {

    private Connection connection = null;


    public String receive() throws SQLException {
        String query = "SELECT Nazwisko FROM Pracownicy";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        String returnString = "";

        while(resultSet.next()){
            returnString += resultSet.getString("Nazwisko") + "\n";

        }

        return returnString;
    }

    public DbConnection() {
        try
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
    } catch(
    ClassNotFoundException e)

    {
        System.out.println("Nie znalazł drivera");
        e.printStackTrace();
        return;
    }

        System.out.println("Zarejestrował drivera");

        try

    {
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Sklep", "123");
    } catch(
    SQLException e)

    {
        System.out.println("Błąd połączenia");
        e.printStackTrace();
        return;
    }

        if(connection !=null)

    {
        System.out.println("Działą! :)");
    } else

    {
        System.out.println("Nie działa :(");
    }
}
}
