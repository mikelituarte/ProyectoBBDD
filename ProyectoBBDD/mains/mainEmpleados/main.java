package mainEmpleados;


import jDBC_DAO_DTO.EmpleadoJDBDao;

import java.sql.SQLException;

import empleadoHibernateDAO.EmpleadoHibernateDAO;
import interfaceRecuperable.Recuperable;
import Empleado.EmpleadoJPADao;
import Empleados.EmployeesServices;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeesServices es = new EmployeesServices();
		//Recuperable objetoDao = new EmpleadoHibernateDAO();
		//Recuperable objetoDao = new EmpleadoJPADao();
		Recuperable objetoDao = new EmpleadoJDBDao();
		es.setRecuperable(objetoDao);
		System.out.println(es.leerEmpleadoServices(106));
		
		System.out.println("------Fin Programa-------");
	}
}
