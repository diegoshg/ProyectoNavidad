/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.time.LocalDate;
import java.sql.Date;
import model.Clientes;
import model.Juegos;
import model.Usuarios;
import model.VentasId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


/**
 *
 * @author Diego Sanchez Gandara
 */
public class ControladorIncluirVenta {
    
    public boolean comprobarRepetidos(String nombre_juego, String plataforma, double precio, String nombre_cliente) {
        boolean repetido = false;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();
        Transaction tx = sesion.beginTransaction();

        try {
            // Verificar la existencia del usuario
            String hqlUsuario = "FROM Clientes WHERE nombre_cliente = :nombre_cliente";
            Query<Clientes> queryUsuario = sesion.createQuery(hqlUsuario, Clientes.class);
            queryUsuario.setParameter("nombre_cliente", nombre_cliente);

            Clientes clienteExistente = queryUsuario.uniqueResult();

            if (clienteExistente != null) {
                // El usuario existe, ahora puedes verificar la existencia del juego
                String hqlJuegos = "FROM Juegos WHERE nombre_juego = :nombre_juego AND plataforma = :plataforma AND precio = :precio";
                Query<Juegos> queryJuegos = sesion.createQuery(hqlJuegos, Juegos.class);
                queryJuegos.setParameter("nombre_juego", nombre_juego);
                queryJuegos.setParameter("plataforma", plataforma);
                queryJuegos.setParameter("precio", precio);

                Juegos juegoExistente = queryJuegos.uniqueResult();

                // Verificar si se encontró un juego con las credenciales proporcionadas
                if (juegoExistente != null) {
                    repetido = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tx.commit();
            sesion.close();
        }

        return repetido;
    }
    
    
    /* public boolean comprobarRepetidosClientes(String nombre_cliente) {
        boolean repetido = false;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();
        Transaction tx = sesion.beginTransaction();

        try {
            // Crear la consulta HQL
            String hql2 = "FROM Clientes WHERE nombre_cliente = :nombre_cliente";
            Query<Clientes> query1 = sesion.createQuery(hq2, Clientes.class);
            query1.setParameter("nombre_cliente", nombre_cliente);

            // Obtener el resultado de la consulta
           Juegos j = new Juegos();
           Clientes c = new Clientes();
           

            // Verificar si se encontró un usuario con las credenciales proporcionadas
            if (j != null && c != null) {
                repetido = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tx.commit();
            sesion.close();
        }

        return repetido;
    }*/
    
    
    
    public void introducirJuego(String nombre_juego, String plataforma, double precio) {
        // Obtén la sesión de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Comienza una transacción
        Transaction transaction = null;

        try {
            // Comienza la transacción
            transaction = session.beginTransaction();

            // Crea un nuevo usuario y establece sus propiedades
            Juegos j = new Juegos();
            j.setNombreJuego(nombre_juego);
            j.setPlataforma(plataforma);
            j.setPrecio(precio);
            
           
            // Guarda el usuario en la base de datos
            session.save(j);
          

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
    
    
    public void introducirCliente(String mombre_cliente) {
        // Obtén la sesión de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Comienza una transacción
        Transaction transaction = null;

        try {
            // Comienza la transacción
            transaction = session.beginTransaction(); 
            Clientes c = new Clientes();
            c.setNombreCliente(mombre_cliente);
            session.save(c);

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
    
    
    /*public void registarVenta(double precio_venta, Date fecha_venta){
      
    }*/

    public void registrarVenta(double precio_venta, Date fecha_venta) {
          Session session = HibernateUtil.getSessionFactory().openSession();

        // Comienza una transacción
        Transaction transaction = null;

        try {
            // Comienza la transacción
            transaction = session.beginTransaction();

            // Crea un nuevo usuario y establece sus propiedades
            VentasId vi = new VentasId();
            vi.setPrecioVenta(precio_venta);
            vi.setFechaVenta((java.sql.Date)fecha_venta);
            // Guarda el usuario en la base de datos
            session.save(vi);
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
