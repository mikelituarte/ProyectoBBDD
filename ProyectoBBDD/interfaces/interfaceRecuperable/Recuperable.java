package interfaceRecuperable;

import java.sql.SQLException;

public interface Recuperable {
	Object leerEmpleado(int id)throws ClassNotFoundException, SQLException;
}
