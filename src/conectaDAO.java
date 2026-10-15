import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class conectaDAO {
    public Connection connectDB() throws SQLException {
        String url = System.getProperty("leiloes.db.url", "jdbc:mysql://localhost:3306/uc11");
        String usuario = System.getProperty("leiloes.db.usuario", "root");
        String senha = System.getProperty("leiloes.db.senha", "");
        Properties configuracao = new Properties();
        configuracao.setProperty("user", usuario);
        configuracao.setProperty("password", senha);
        configuracao.setProperty("serverTimezone", "UTC");
        configuracao.setProperty("connectTimeout", "3000");
        configuracao.setProperty("socketTimeout", "5000");
        return DriverManager.getConnection(url, configuracao);
    }
}
