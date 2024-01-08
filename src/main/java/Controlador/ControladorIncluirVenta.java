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
import model.Ventas;
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
    
    
     public int comprobarJuegoExiste(String nombre_juego, String plataforma) {
        int idJuego = -1; // Default value if not found

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            String hql = "SELECT j.idJuego FROM Juegos j WHERE j.nombreJuego = :nombre_juego AND j.plataforma = :plataforma";
            Query<Integer> query = session.createQuery(hql, Integer.class);
            query.setParameter("nombre_juego", nombre_juego);
            query.setParameter("plataforma", plataforma);

             Integer result = query.uniqueResult();

        // Check for null before invoking intValue()
        if (result != null) {
            idJuego = result.intValue();
        }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return idJuego;
    }
    
   public int obtenerIdClientePorNombre(String nombreCliente) {
        int idCliente = -1; // Default value if not found

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            String hql = "SELECT c.idCliente FROM Clientes c WHERE c.nombreCliente = :nombre_cliente";
            Query<Integer> query = session.createQuery(hql, Integer.class);
            query.setParameter("nombre_cliente", nombreCliente);

            Integer result = query.uniqueResult();

        // Check for null before invoking intValue()
        if (result != null) {
            idCliente = result.intValue();
        }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return idCliente;
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
            Ventas v = new Ventas();
            v.setJuegos(j);
           
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
    
    
    public void introducirCliente(String nombre_cliente) {
        // Obtén la sesión de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Comienza una transacción
        Transaction transaction = null;

        try {
            // Comienza la transacción
            transaction = session.beginTransaction(); 
            Clientes c = new Clientes();
            c.setNombreCliente(nombre_cliente);
            
            Ventas v = new Ventas();
            v.setClientes(c);
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
    
    
   
    public void registrarVenta(Juegos j, Clientes c, double precioVenta, Date fechaVenta) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Comienza una transacción
        Transaction transaction = null;

        try {
            // Comienza la transacción
            transaction = session.beginTransaction();

            // Verifica si los IDs de juego y cliente existen antes de proceder
            Juegos juego = session.get(Juegos.class, j.getIdJuego());
            Clientes cliente = session.get(Clientes.class, c.getIdCliente());
            VentasId ventasId = new VentasId();    
            if (juego == null || cliente == null) {
                System.out.println("Error: Juego o cliente no encontrado.");
               
                ventasId.setIdJuego(j.getIdJuego());
                ventasId.setIdCliente(c.getIdCliente());
                ventasId.setPrecioVenta(precioVenta);
                ventasId.setFechaVenta(fechaVenta);

                // Crea una instancia de Ventas y establece su clave primaria compuesta
                

             
            }

            // Crea una instancia de VentasId y establece sus propiedades
            Ventas venta = new Ventas();
                venta.setId(ventasId);
            // Guarda la entidad Ventas en la base de datos
            session.save(venta);

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
