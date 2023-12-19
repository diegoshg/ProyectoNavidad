/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import model.Usuarios;
import org.hibernate.SessionFactory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Alumno
 */
public class controladorLoggin {
    
    
    public boolean verificarCredenciales(String nombreUsuario, String contrasena) {
        boolean credencialesValidas = false;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Crear la consulta HQL (Hibernate Query Language)
            String hql = "FROM Usuario WHERE nombreUsuario = :nombreUsuario AND contrasena = :contrasena";
            Query<Usuarios> query = session.createQuery(hql, Usuarios.class);
            query.setParameter("nombreUsuario", nombreUsuario);
            query.setParameter("contrasena", contrasena);

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
    
    
    
    public void insertarUsuario(){
        
    }
}
