package Empleados;

import java.sql.SQLException;

import empleadoHibernateDAO.EmpleadoHibernateDAO;
import interfaceRecuperable.Recuperable;

public class EmployeesServices {

	private Recuperable objetoDao;
	
	public void setRecuperable(Recuperable objetoDao){
		this.objetoDao = objetoDao;
	}
	
	public Object leerEmpleadoServices(int id)throws ClassNotFoundException, SQLException{
		Object empleado = null;
		empleado = this.objetoDao.leerEmpleado(id);
		return empleado;
	}
}
