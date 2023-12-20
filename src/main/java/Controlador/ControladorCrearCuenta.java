/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import model.Usuarios;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Diego Sanchez Gandara
 */
public class ControladorCrearCuenta {
    
    //metodo para verificar las credenciales, se le pasa el nombre de usuario, email y contraseña
    public boolean verificarCredenciales(String username, String email, String contrasena) {
        boolean credencialesValidas = false;
        //iniciamos la sesion y la transacion
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();
        Transaction tx = sesion.beginTransaction();

        try {
            // Creamos la consulta para recoger los datos
            String hql = "FROM Usuarios WHERE username = :username AND email = :email AND contrasena = :contrasena";
            Query<Usuarios> query = sesion.createQuery(hql, Usuarios.class);
            //le pasamos los parametros a la consulta
            query.setParameter("username", username);
            query.setParameter("email", email);
            query.setParameter("contrasena", contrasena);

            // Obtenemos el resultado de la consulta
            Usuarios usuario = query.uniqueResult();

            // Verificamos su el resultado esta vacio
            if (usuario != null) {
                credencialesValidas = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //guardamos y cerramos la sesion
            tx.commit();
            sesion.close();
        }
        //retornamos el resultado
        return credencialesValidas;
    }
    

    //metodo para introducir usuarios, pasamos los mismos datos
    public void introducirUsuario(String username, String password, String email) {
        // Obtén la sesión de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Comienza una transacción
        Transaction transaction = null;

        try {
            
            transaction = session.beginTransaction();

            // Crea un nuevo usuario y le pasamos los datos
            Usuarios user = new Usuarios();
            user.setUsername(username);
            
            // Encriptamos la contraseña y se la pasamos a la clase
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            user.setContrasena(hashedPassword);
            //pasamos el email
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
            e.printStackTrace();
        } finally {
            // Cierra la sesión de Hibernate
            session.close();
        }
    }
}
