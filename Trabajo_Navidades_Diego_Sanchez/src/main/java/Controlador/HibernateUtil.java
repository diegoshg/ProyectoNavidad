/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Alumno
 */
public class HibernateUtil {
   private static final SessionFactory sessionFactory = buildSessionFactory();
	public static SessionFactory buildSessionFactory() {
            try {
                return new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
            } catch (Throwable e) {
                // TODO: handle exception
                System.err.println(e);
            }
           return null;
        }
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
