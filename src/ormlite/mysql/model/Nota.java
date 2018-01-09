package ormlite.mysql.model;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "nota")
public class Nota {
    
    @DatabaseField(generatedId = true)
    public int id;
    
    @DatabaseField
    public String texto;
    
    @DatabaseField(dataType = DataType.DATE)
    public Date fecha;
}
