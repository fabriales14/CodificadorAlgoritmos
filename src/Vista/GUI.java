/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Controlador.DTOAlgoritmos;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;


/**
 *
 * @author melissavillalobos
 */
public class GUI extends javax.swing.JFrame {
    //llama a un solo controlador.
     Controlador controlador  =  new Controlador();
    /**
     * Creates new form GUICod
     */
    public GUI() {
        initComponents();
        //cargar alfabeto, lgoritmos y tipos de salidasd
        ArrayList alfabetos = controlador.cargarAlfabetos();
        for(Object alfabeto : alfabetos) {
                cbAlfabeto.addItem((String) alfabeto);
        }
        ///////////////////////////////////////////////////////
       
        DefaultListModel modelo = new DefaultListModel();
        ArrayList salidas = controlador.cargarSalidas();
        for(Object salida : salidas) {
                modelo.addElement(salida);
        }
        lSalidas1.setModel(modelo);
        ///////////////////////////////////////////////////////
        
        DefaultListModel modeloAl = new DefaultListModel();
        ArrayList algoritmos = controlador.cargarAlgoritmos();
        for(Object algoritmo : algoritmos) {
                modeloAl.addElement(algoritmo);
        }
        lAlgoritmos.setModel(modeloAl);
        
        DefaultListModel modeloBitacoras = new DefaultListModel();
        File[] bitacoras = controlador.cargarBitacoras();
        for (File file : bitacoras) {
            if (file.isFile()) {
                modeloBitacoras.addElement(file.getName());
            }
        }
        this.bitacoras.setModel(modeloBitacoras);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbAlfabeto = new javax.swing.JComboBox<>();
        vFraseOrigen = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lAlgoritmos = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        bitacoras = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        taResultados = new javax.swing.JTextArea();
        modoCodificacion = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        AceptarButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        lSalidas1 = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        botonAlfabetos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 204));

        cbAlfabeto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        vFraseOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vFraseOrigenActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lAlgoritmos);

        bitacoras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bitacorasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bitacoras);

        taResultados.setColumns(20);
        taResultados.setRows(5);
        jScrollPane3.setViewportView(taResultados);

        modoCodificacion.setText("Decodificar");
        modoCodificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modoCodificacionActionPerformed(evt);
            }
        });

        jLabel1.setText("Alfabeto:");

        jLabel2.setText("Frase:");

        jLabel3.setText("Tipos de algoritmo:");

        jLabel4.setText("Tipo de salidas:");

        jLabel5.setText("Salida:");

        jLabel6.setFont(new java.awt.Font("Phosphate", 1, 24)); // NOI18N
        jLabel6.setText("Codificación y decodificación de Frases");

        AceptarButton.setText("Aceptar");
        AceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarButtonActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(lSalidas1);

        jLabel7.setText("Bitacoras:");

        botonAlfabetos.setText("Alfabetos");
        botonAlfabetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAlfabetosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbAlfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(modoCodificacion)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(AceptarButton)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vFraseOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(botonAlfabetos))
                        .addGap(142, 142, 142))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbAlfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(vFraseOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(modoCodificacion)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonAlfabetos)
                        .addGap(39, 39, 39)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(AceptarButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarButtonActionPerformed
        //Crea un DTO para guardar los datos.
        ArrayList<Integer> algoritmos = new ArrayList<>();
        for (int i : lAlgoritmos.getSelectedIndices()) {
            algoritmos.add(i);
        }
        ArrayList<Integer> salidas = new ArrayList<>();
        for (int i : lSalidas1.getSelectedIndices()) {
            salidas.add(i);
        }
        //Toma todos los datos y se les aplica al DTO.
        DTOAlgoritmos DTO = new DTOAlgoritmos(cbAlfabeto.getWidth(), vFraseOrigen.getText(),taResultados.getText(), algoritmos,
            salidas,modoCodificacion.isSelected());

        System.out.println("Se crea el DTO con los datos necesarios");

        //El controlador procesa la petición.
        controlador.procesarPeticion(DTO);

        taResultados.setText("Se procesan las salidas");
    }//GEN-LAST:event_AceptarButtonActionPerformed

    private void modoCodificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modoCodificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modoCodificacionActionPerformed

    private void vFraseOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vFraseOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vFraseOrigenActionPerformed

    private void bitacorasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bitacorasMouseClicked
        if (evt.getClickCount() == 2){
            String filename = bitacoras.getSelectedValue();
            File file = new File("Bitacora/" + filename);
            Desktop desktop = Desktop.getDesktop();
            if(file.exists()) try {
                desktop.open(file);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bitacorasMouseClicked

    private void botonAlfabetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAlfabetosActionPerformed
        new UIAlfabeto().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonAlfabetosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarButton;
    private javax.swing.JList<String> bitacoras;
    private javax.swing.JButton botonAlfabetos;
    private javax.swing.JComboBox<String> cbAlfabeto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> lAlgoritmos;
    private javax.swing.JList<String> lSalidas1;
    private javax.swing.JCheckBox modoCodificacion;
    private javax.swing.JTextArea taResultados;
    private javax.swing.JTextField vFraseOrigen;
    // End of variables declaration//GEN-END:variables
}
