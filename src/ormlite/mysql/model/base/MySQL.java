package ormlite.mysql.model.base;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import java.io.IOException;
import java.sql.SQLException;

// crea una fuente de conexión a nuestra base de datos
public class MySQL extends JdbcConnectionSource {
    
    public MySQL() {
        // cadena de conexion para MySQL
        this.setUrl("jdbc:mysql://localhost:3306/notas");
        this.setUsername("root");
        this.setPassword("");
    }

    @Override
    public void initialize() throws SQLException {
        if (connection != null && connection.isClosed()) {
            closeConnection();
        }
        super.initialize();
    }

    public void closeConnection() {
        try {
            this.close();
        } catch (IOException e) {
            //
        }
    }
}
