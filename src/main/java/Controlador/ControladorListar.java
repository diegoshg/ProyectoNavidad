/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Alumno
 */
public class ControladorListar {
    
    
    public DefaultTableModel recogerDatos(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Query<Object[]> query = session.createQuery("SELECT j.nombreJuego, j.plataforma, j.precio, c.nombreCliente FROM Juegos j, Clientes c", Object[].class);
            List<Object[]> resultado = query.list();

            // Crear un modelo de datos para la tabla
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Juego");
            model.addColumn("Plataforma");
            model.addColumn("Precio");
            model.addColumn("Cliente");
            // Procesar los resultados y agregarlos al modelo de la tabla
            for (int i = 0; i < resultado.size(); i++) {
                for (Object[] row : resultado) {
                String nombreJuego = (String) row[0];
                String plataforma = (String) row[1];
                Double precio = (Double) row[2];
                String nombreCliente = (String) row[3];

                // Agregar fila al modelo
                model.addRow(new Object[]{nombreJuego, plataforma, precio, nombreCliente});
            }

            }
            
            transaction.commit();
            return model;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close(); // Cerrar la sesión al finalizar
        }

        return null;
    }
}
