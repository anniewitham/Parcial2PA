package edu.avanzada.parcial2.vista;
/**
 *
 * @author Personal
 */
public class Reproductor extends javax.swing.JFrame {
    public Reproductor() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextNombreCancionRepro = new javax.swing.JLabel();
        botonPlay = new javax.swing.JButton();
        botonPausa = new javax.swing.JButton();
        botonAdelantar = new javax.swing.JButton();
        BotonDevolver = new javax.swing.JButton();
        botonVolverTienda = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(200, 200, 241));

        botonSalir.setBackground(new java.awt.Color(200, 200, 241));
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/avanzada/parcial2/vista/imagenes/salir.png"))); // NOI18N
        botonSalir.setBorder(null);
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Reproductor");

        jLabel2.setBackground(new java.awt.Color(153, 153, 0));
        jLabel2.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("----------------------------------------------------------");

        TextNombreCancionRepro.setBackground(new java.awt.Color(153, 153, 0));
        TextNombreCancionRepro.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        TextNombreCancionRepro.setForeground(new java.awt.Color(51, 51, 51));

        botonPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/avanzada/parcial2/vista/imagenes/tocar.png"))); // NOI18N
        botonPlay.setContentAreaFilled(false);

        botonPausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/avanzada/parcial2/vista/imagenes/pausa.png"))); // NOI18N
        botonPausa.setContentAreaFilled(false);

        botonAdelantar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/avanzada/parcial2/vista/imagenes/tiempo-pasado (1).png"))); // NOI18N
        botonAdelantar.setContentAreaFilled(false);

        BotonDevolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/avanzada/parcial2/vista/imagenes/tiempo-pasado.png"))); // NOI18N
        BotonDevolver.setContentAreaFilled(false);

        botonVolverTienda.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        botonVolverTienda.setForeground(new java.awt.Color(102, 102, 102));
        botonVolverTienda.setText("Volver a la tienda");

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Cancion a reproducir:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(86, 86, 86)
                            .addComponent(botonSalir)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonVolverTienda)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BotonDevolver)
                                .addGap(18, 18, 18)
                                .addComponent(botonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonPausa, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(botonAdelantar)
                        .addGap(81, 81, 81))))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(TextNombreCancionRepro, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(63, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonSalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonAdelantar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonPausa, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonPlay, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(32, 32, 32)
                        .addComponent(botonVolverTienda)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(BotonDevolver)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(92, 92, 92)
                    .addComponent(TextNombreCancionRepro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(170, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>                        

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonSalirActionPerformed
public void actualizarNombreCancion(String nombreCancion) {
       TextNombreCancionRepro.setText(nombreCancion);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BotonDevolver;
    public javax.swing.JLabel TextNombreCancionRepro;
    public javax.swing.JButton botonAdelantar;
    public javax.swing.JButton botonPausa;
    public javax.swing.JButton botonPlay;
    public javax.swing.JButton botonSalir;
    public javax.swing.JButton botonVolverTienda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
