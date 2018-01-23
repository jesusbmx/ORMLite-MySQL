package ormlite.mysql.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.TableUtils;
import ormlite.mysql.model.Nota;

import ormlite.mysql.model.dao.MySQL;

public class NotaDao extends MySQL {
  
    private Dao<Nota, Integer> dao;
    
    public Dao<Nota, Integer> getDao() throws SQLException {
        initialize(); // abre la base de datos si no esta abierta.
        if (dao == null) {
            // crea un dao para el recurso 'nota'.
            dao = DaoManager.createDao(this, Nota.class);
            // si la tabla 'nota' no existe se crea.
            TableUtils.createTableIfNotExists(this, Nota.class);
        }
        return dao;
    }
    
    // obtiene todas las notas.
    public List<Nota> findAll() throws SQLException {
        // Consulta todos los elementos en la tabla de objetos y devuelve una 
        // lista de ellos. Para tablas de tamaño mediano o grande, esto puede 
        // cargar muchos objetos en la memoria, por lo que debería considerar 
        // usar el método 'iterator()' en su lugar.
        return getDao().queryForAll();
    }
    
    // busca la 'nota' por su campo de identificación (id)
    public Nota findById(int id) throws SQLException {
        // Busca la identificación en la base de datos y recupera un objeto 
        // asociado a ella.
        return getDao().queryForId(id);
    }
    
    // guarda el objeto 'nota' a la base de datos
    public boolean save(Nota nota) throws SQLException {
        // Este es un método conveniente para crear un elemento en la base de 
        // datos si no existe. El ID se extrae del argumento de datos y se 
        // realiza una consulta por ID en la base de datos. Si existe una fila 
        // en la base de datos con el mismo ID, entonces todas las columnas en 
        // la base de datos se actualizarán desde los campos en el parámetro de 
        // datos. Si el ID es null (o 0 o algún otro valor predeterminado) o no
        // existe en la base de datos, entonces el objeto se creará en la base 
        // de datos. Esto también significa que su elemento de datos debe tener 
        // un campo de identificación definido.
        Dao.CreateOrUpdateStatus status = getDao().createOrUpdate(nota);
        return status.isCreated() || status.isUpdated();
    }
    
    // borra la 'nota' por su campo de identificación (id)
    public boolean delete(int id) throws SQLException {
        // Elimina un objeto de la base de datos si tienes su id. Esto debería 
        // devolver 1 dado que se eliminó 1 fila.
        return getDao().deleteById(id) == 1;
    }
}