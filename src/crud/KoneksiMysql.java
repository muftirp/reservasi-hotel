package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class KoneksiMysql {
    private Connection connect;
    private String driverName="com.mysql.cj.jdbc.Driver";
    private String jdbc = "jdbc:mysql://";
    private String host = "localhost:";
    private String port = "3306/";
    private String database ="reservasi_hotel2";
    private String url = jdbc + host + port + database;
    private String username = "root";
    private String password = "";
    
    public Connection getkoneksi() throws SQLException {
        if(connect == null) {
            try {
            Class.forName(driverName);
            System.out.println("Class Driver Ditemukan");
                try {
                connect = DriverManager.getConnection(url, username,password);
                System.out.println("Koneksi data Sukses");
            } catch (SQLException se) {
                System.out.println("Koneksi Database gagal:" + se);
                System.exit(0);
                }
            } catch (ClassNotFoundException cnfe) {
              System.out.println("Class Driver Tidak Ditemukan, Terjadi kesalahan pada " + cnfe);
              System.exit(0);
            }
        }
    return connect;
    }
}

