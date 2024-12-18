package edu.avanzada.parcial2.vista;

import javax.swing.ListSelectionModel;

/**
 *
 * @author Personal
 */
public class Canciones extends javax.swing.JFrame {
    public Canciones() {
        initComponents();
        this.setLocationRelativeTo(null);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        TablaCanciones = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        TextCuenta = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TextNombreCliente1 = new javax.swing.JLabel();
        botonDescargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(200, 200, 241));
        jPanel1.setLayout(null);

        botonSalir.setBackground(new java.awt.Color(200, 200, 241));
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/avanzada/parcial2/vista/imagenes/salir.png"))); // NOI18N
        botonSalir.setBorder(null);
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        jPanel1.add(botonSalir);
        botonSalir.setBounds(520, 10, 40, 30);

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Tienda de Canciones ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(159, 7, 280, 33);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Canciones Dsiponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 0, 12), new java.awt.Color(102, 102, 102)))); // NOI18N
        jPanel2.setAutoscrolls(true);

        jTable1.setBackground(new java.awt.Color(242, 242, 242));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Artista"
            }
        ));
        TablaCanciones.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TablaCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TablaCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(25, 97, 533, 161);

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("(Cada cancion tiene un costo de $15k)");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(140, 330, 260, 16);

        TextCuenta.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        TextCuenta.setForeground(new java.awt.Color(0, 102, 0));
        TextCuenta.setText("$");
        TextCuenta.setToolTipText("");
        jPanel1.add(TextCuenta);
        TextCuenta.setBounds(400, 50, 130, 30);

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Cuenta:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(340, 60, 51, 17);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/avanzada/parcial2/vista/imagenes/notas-musicales.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(470, 270, 90, 80);

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Cliente: ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(33, 56, 53, 17);

        TextNombreCliente1.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        TextNombreCliente1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(TextNombreCliente1);
        TextNombreCliente1.setBounds(90, 50, 130, 30);

        botonDescargar.setBackground(new java.awt.Color(172, 165, 255));
        botonDescargar.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        botonDescargar.setForeground(new java.awt.Color(51, 51, 51));
        botonDescargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/avanzada/parcial2/vista/imagenes/32.png"))); // NOI18N
        botonDescargar.setText("Descargar Cancion");
        jPanel1.add(botonDescargar);
        botonDescargar.setBounds(160, 280, 240, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonSalirActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane TablaCanciones;
    public javax.swing.JLabel TextCuenta;
    public javax.swing.JLabel TextNombreCliente1;
    public javax.swing.JButton botonDescargar;
    public javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
