package empleadoHibernateDAO;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import sesion.manager.SesionManager;
import tablas_Clases.Employees;

import interfaceRecuperable.Recuperable;



public class EmpleadoHibernateDAO implements Recuperable{

	@Override
	public Object leerEmpleado(int id) {

		//Configuration configuration = new Configuration().configure();;
		//StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());;
		//SessionFactory factory = configuration.buildSessionFactory(builder.build());;		
		
		Session sesion = null;;
		Transaction transaccion = null;
		Employees empleado = null;
		try{
			sesion = SesionManager.getSesion();
			//sesion = factory.openSession();
			transaccion = sesion.beginTransaction();
			empleado = (Employees)sesion.get(Employees.class, id);
		}
		catch(Exception e){
			e.printStackTrace();
			transaccion.rollback();
		}
		finally{
			SesionManager.desconectarSesion();
			SesionManager.cerrarSesion();
			SesionManager.cerrarfactory();
			//sesion.disconnect();
			//sesion.close();
			//factory.close();
		}
		return empleado;
	}



}
