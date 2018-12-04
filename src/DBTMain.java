import java.sql.SQLException;

public class DBTMain {
    public static void main(String[] args) throws SQLException {

        DbConnection db = new DbConnection();

        System.out.println(db.receive());
    }

}
