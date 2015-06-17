package Empleado;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaceRecuperable.Recuperable;

public class EmpleadoJPADao implements Recuperable {

	@Override
	public Object leerEmpleado(int id) throws ClassNotFoundException, SQLException {
		Long l = new Long(id);
		Employee empleadoDTO = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersonas");
        EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			empleadoDTO = em.find(Employee.class, l);
			//System.out.println(empleadoDTO.toString());
			//em.persist(empleadoDTO);
			em.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return empleadoDTO;
	}

}
