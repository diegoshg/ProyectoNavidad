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
 * @author Alumno
 */
public class controladorLoggin {
    
    
    public boolean verificarCredenciales(String username, String email, String contrasena) {
        boolean credencialesValidas = false;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();
        Transaction tx = sesion.beginTransaction();
        try{
            // Crear la consulta HQL (Hibernate Query Language)
            String hql = "FROM Usuario WHERE username = :username AND email = :email AND contrasena = :contrasena";
            Query<Usuarios> query = sesion.createQuery(hql, Usuarios.class);
            query.setParameter("username", username);
            query.setParameter("contrasena", contrasena);
            query.setParameter("email", email);

            // Obtener el resultado de la consulta
            Usuarios usuario = query.uniqueResult();

            // Verificar si se encontró un usuario con las credenciales proporcionadas
            if (usuario != null) {
                credencialesValidas = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return credencialesValidas;
    }
    
    
    
    public void introducirUsuario(String username, String password, String email) {
        // Obtén la sesión de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Comienza una transacción
        Transaction transaction = null;

        try {
            // Comienza la transacción
            transaction = session.beginTransaction();

            // Crea un nuevo usuario y establece sus propiedades
            Usuarios user = new Usuarios();
            user.setUsername(username);
            
            // Encripta la contraseña antes de almacenarla
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            user.setContrasena(hashedPassword);

            user.setEmail(email);

            // Guarda el usuario en la base de datos
            session.save(user);

            // Confirma la transacción
            transaction.commit();
        } catch (Exception e) {
            // Si hay algún error, realiza un rollback de la transacción
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Trata el error según tus necesidades
        } finally {
            // Cierra la sesión de Hibernate
            session.close();
        }
    }
}
