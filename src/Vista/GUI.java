/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import libcomp.Alfabeto;
import libcomp.DTO_Comunicacion;


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
        setResizable(false);
        ArrayList alfabetos = controlador.cargarAlfabetos();
        for(Object alfabeto : alfabetos) {
            Alfabeto a = (Alfabeto) alfabeto;
            cbAlfabeto.addItem((String) a.getNombre());
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
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(2, 71, 71));
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

        modoCodificacion.setFont(new java.awt.Font("Menlo", 0, 18)); // NOI18N
        modoCodificacion.setForeground(new java.awt.Color(255, 255, 255));
        modoCodificacion.setText("Decodificar");
        modoCodificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modoCodificacionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Menlo", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Alfabeto:");

        jLabel2.setFont(new java.awt.Font("Menlo", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Frase:");

        jLabel3.setFont(new java.awt.Font("Menlo", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipos de algoritmo:");

        jLabel4.setFont(new java.awt.Font("Menlo", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tipo de salidas:");

        jLabel5.setFont(new java.awt.Font("Menlo", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Salida:");

        jLabel6.setFont(new java.awt.Font("Phosphate", 1, 24)); // NOI18N

        AceptarButton.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
        AceptarButton.setText("Aceptar");
        AceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarButtonActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(lSalidas1);

        jLabel7.setFont(new java.awt.Font("Menlo", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bitacoras:");

        botonAlfabetos.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
        botonAlfabetos.setText("Alfabetos");
        botonAlfabetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAlfabetosActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/CODIF.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/fondo.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbAlfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vFraseOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modoCodificacion)
                            .addComponent(botonAlfabetos)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(105, 105, 105)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(62, 62, 62))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AceptarButton)
                .addGap(397, 397, 397))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbAlfabeto)
                    .addComponent(botonAlfabetos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(vFraseOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modoCodificacion))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(AceptarButton)
                .addGap(100, 100, 100))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAlfabetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAlfabetosActionPerformed
        new UIAlfabeto(controlador).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonAlfabetosActionPerformed

    private void AceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarButtonActionPerformed
        //Crea un DTO para guardar los datos.
        ArrayList<String> algoritmos = new ArrayList<>();
        for (String i : lAlgoritmos.getSelectedValuesList()) {
            algoritmos.add(i);
        }
        ArrayList<Integer> salidas = new ArrayList<>();
        for (int i : lSalidas1.getSelectedIndices()) {
            salidas.add(i);
        }
        DTO_Comunicacion datos = new DTO_Comunicacion(new ArrayList<Alfabeto>(), null, algoritmos, null);
        datos.setTipos_salida(salidas);
        Alfabeto a = new Alfabeto(0, null, null, null);
        String cod = "23";
        if (algoritmos.indexOf("Vigenere") != -1){
            cod = JOptionPane.showInputDialog("Digite codigo vigenere");
            if (cod.length() != 2){
                JOptionPane.showMessageDialog(this, "Error en el codigo Vigenere");
                return;
            } else {
                datos.setAlg_vigenere(Integer.valueOf(cod));
            }
        }
        if (algoritmos.indexOf("PalabraClave") != -1){
            cod = JOptionPane.showInputDialog("Digite palabra clave");
            if (cod.length() == 0){
                JOptionPane.showMessageDialog(this, "No ha digitado palabra clave");
                return;
            } else {
                datos.setPalabra_clave(cod);
            }
        }
        a.setNombre(cbAlfabeto.getSelectedItem().toString());
        datos.getAlfabetos().add(a);
        datos.setEntrada(vFraseOrigen.getText());
        datos.setCodificacion(!modoCodificacion.isSelected());
        //Toma todos los datos y se les aplica al DTO.
        //       DTOAlgoritmos DTO = new DTOAlgoritmos(cbAlfabeto.getWidth(), vFraseOrigen.getText(),taResultados.getText(), algoritmos,
            //           salidas,modoCodificacion.isSelected());

        //El controlador procesa la petición.
        datos.setSalida(new ArrayList<>());
        datos = controlador.procesarPeticion(datos);
        String salida = "";
        for (String result : datos.getSalida()){
            salida += result + "\n";
        }
        taResultados.setText(salida);
    }//GEN-LAST:event_AceptarButtonActionPerformed

    private void modoCodificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modoCodificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modoCodificacionActionPerformed

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

    private void vFraseOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vFraseOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vFraseOrigenActionPerformed


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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
