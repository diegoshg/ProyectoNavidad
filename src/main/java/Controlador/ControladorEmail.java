/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.security.SecureRandom;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
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
public class ControladorEmail {
    
    //clase para verificar el email, le pasamos un email
   public boolean verificarEmail(String email) {
        boolean emailExiste = false;
        //creamos la sesion y la transacion
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();
        Transaction tx = sesion.beginTransaction();

        try {
            // Crear la consulta HQL
            String hql = "FROM Usuarios WHERE email = :email";
            Query<Usuarios> query = sesion.createQuery(hql, Usuarios.class);
            query.setParameter("email", email);

            // Obtenemos el resultado de la consulta
            Usuarios usuario = query.uniqueResult();

            // Comprobamos si el resultado esta vacio
            if (usuario != null) {
                emailExiste = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //guardamos y cerramos la sesion
            tx.commit();
            sesion.close();
        }

        return emailExiste;
    }
   
   //metodo para generar una contraseña aleatoria de una longuitud aleatoria
   public String generarContrasena(int longitudMin, int longitudMax){
       //posibles caracteres de la contraseña
        String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        //calcula la longuitud aleatoria
        longitudMin = Math.max(1, longitudMin);
        int longitud = longitudMin + new SecureRandom().nextInt(longitudMax - longitudMin + 1);

        StringBuilder contraseñaGenerada = new StringBuilder();
        SecureRandom aleatorio = new SecureRandom();
        //generamos la contraseña
        for (int i = 0; i < longitud; i++) {
            int indice = aleatorio.nextInt(CARACTERES.length());
            contraseñaGenerada.append(CARACTERES.charAt(indice));
        }
        //la devolvemos
        return contraseñaGenerada.toString();
   }
   
   //metodo para actualizar la contraseña en la base de datos, le pasamos el email y la contraseña
   public void actualizarContrasena(String email, String contrasena){
       //crea la sesion 
       Session session = HibernateUtil.getSessionFactory().openSession();
        // Comienza una transacción
        Transaction transaction = null;

        try {
            
            transaction = session.beginTransaction();

            // Busca el email del usuario
            String hql = "FROM Usuarios WHERE email = :email";
            Query<Usuarios> query = session.createQuery(hql, Usuarios.class);
            query.setParameter("email", email);

            // Obtener el resultado de la consulta
            Usuarios usuario = query.uniqueResult();

            // Verifica si el email existe
            if (usuario != null) {
                // Encripta la nueva contraseña antes de almacenarla
                String hashedPassword = BCrypt.hashpw(contrasena, BCrypt.gensalt());
                usuario.setContrasena(hashedPassword);

                // Actualiza la tabla de la base de datos
                session.update(usuario);

               
                transaction.commit();
            } else {
                System.out.println("Usuario no encontrado.");
            }
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
