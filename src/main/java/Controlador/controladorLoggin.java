/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import model.Usuarios;
import org.hibernate.SessionFactory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Diego Sanchez Gandara
 */
public class controladorLoggin {
    
    //metodo para obtener el username del usuario
      private Usuarios obtenerUsuarioPorUsername(String username) {
          //crea la sesion
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();

        try {
            //pide el username
            String hql = "FROM Usuarios WHERE username = :username";
            Query<Usuarios> query = sesion.createQuery(hql, Usuarios.class);
            query.setParameter("username", username);
            //devuelve el resultado
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //cierra la sesion
            sesion.close();
        }
    }
    
    // Método para obtener la contraseña de un usuario específico
    public String obtenerContrasenaDeUsuario(String username) {
        //crea la sesion
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();

        try {
            //pide la contraseña
            String hql = "SELECT u.contrasena FROM Usuarios u WHERE u.username = :username";
            Query<String> query = sesion.createQuery(hql, String.class);
            query.setParameter("username", username);
            //devuelve el resultado
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //cierra la sesion
            sesion.close();
        }
}
    
    // Método para verificar si la contraseña coincide 
    public boolean verificarContrasena(String contrasenaInput, String contrasenaAlmacenada) {
        return BCrypt.checkpw(contrasenaInput, contrasenaAlmacenada);
    }
}
