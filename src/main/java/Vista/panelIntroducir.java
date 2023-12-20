/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.ControladorIncluirVenta;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Sanchez Gandara
 */
public class panelIntroducir extends javax.swing.JPanel {
    //Llamamos al controlador de la clase
    private Controlador.ControladorIncluirVenta civ = new ControladorIncluirVenta();
    /**
     * Creates new form panelIntroducir
     */
    public panelIntroducir() {
        initComponents();
        //estilos de fuente
        jLabel1.putClientProperty("FlatLaf.style", "font: $h2.font");
        jLabel2.putClientProperty("FlatLaf.style", "font: $h2.font");
        jLabel3.putClientProperty("FlatLaf.style", "font: $h2.font");
        jLabel4.putClientProperty("FlatLaf.style", "font: $h2.font");
        //redondeos
        nombreJuego.putClientProperty( "JComponent.roundRect", true );
        plataforma.putClientProperty( "JComponent.roundRect", true );
        precio.putClientProperty( "JComponent.roundRect", true );
        cliente.putClientProperty( "JComponent.roundRect", true );
        //placeHolder
        nombreJuego.putClientProperty( "JTextField.placeholderText" , "ingrese el nombre del juego" );
        plataforma.putClientProperty( "JTextField.placeholderText" , "ingrese la plataforma");
        precio.putClientProperty( "JTextField.placeholderText" , "ingrese el precio" );
        cliente.putClientProperty( "JTextField.placeholderText" , "ingrese el cliente" );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nombreJuego = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        plataforma = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        cliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        botonIntroducir = new javax.swing.JButton();

        setBackground(new java.awt.Color(6, 2, 221));

        jLabel1.setText("Titulo:");

        jLabel2.setText("Plataforma:");

        jLabel3.setText("Precio:");

        jLabel4.setText("Cliente:");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/paimon 1.png"))); // NOI18N

        botonIntroducir.setBackground(new java.awt.Color(0, 0, 0));
        botonIntroducir.setForeground(new java.awt.Color(255, 255, 255));
        botonIntroducir.setText("INTRODUCIR");
        botonIntroducir.setToolTipText("meter nueva venta");
        botonIntroducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIntroducirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(nombreJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(plataforma, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(botonIntroducir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nombreJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(plataforma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(botonIntroducir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)))
        );
    }// </editor-fold>//GEN-END:initComponents
    //boton para introducir una nueva venta
    private void botonIntroducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIntroducirActionPerformed
        //pasamos los datos a varibale
        String titulo = nombreJuego.getText();
        String plat = plataforma.getText();
        double perc = Double.parseDouble(precio.getText());
        String client = cliente.getText();
        LocalDate fecha = LocalDate.now();

        // Convertir LocalDate a java.sql.Date
        Date date = java.sql.Date.valueOf(fecha);
        
        //comprobamos si existe ya una venta similar
        boolean com = civ.comprobarRepetidos(titulo, plat, perc, client);
        try {
            //si existe avisamos al usuario
            if (com) {
                JOptionPane.showMessageDialog(null, "La venta ya está registrada", "Error", JOptionPane.INFORMATION_MESSAGE);
                nombreJuego.setText("");
                plataforma.setText("");
                precio.setText("");
                cliente.setText("");
            //sino introducimos los datos en sus respectivas tablas
            } else {
                civ.introducirJuego(titulo, plat, perc);
                civ.introducirCliente(client);
                //civ.registrarVenta(perc, date);
                JOptionPane.showMessageDialog(null, "Venta registrada correctamente");
                //limpiamos los campos tras introducir
                nombreJuego.setText("");
                plataforma.setText("");
                precio.setText("");
                cliente.setText("");
            }
            //manejo de excepciones
        } catch (ClassCastException e) {
           e.printStackTrace();
        }
    }//GEN-LAST:event_botonIntroducirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIntroducir;
    private javax.swing.JTextField cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nombreJuego;
    private javax.swing.JTextField plataforma;
    private javax.swing.JTextField precio;
    // End of variables declaration//GEN-END:variables
}
