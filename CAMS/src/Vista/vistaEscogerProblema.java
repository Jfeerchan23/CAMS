/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.manipularCSV;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author alber
 */
public class vistaEscogerProblema extends javax.swing.JFrame {

    // almacena la información de los 2 estudiantes seleccionados
    String[] arraySeleccionados = new String[2];
    manipularCSV modelo = new manipularCSV();
    int[] numFilasCols = modelo.contarFilasCols(modelo.obtenerRutaArchivos() + "\\Orden_rpp_extras.txt");
    String ruta = modelo.obtenerRutaArchivos();
    vistaProblemasExtras viewProblemasExtras = new vistaProblemasExtras();

    /**
     * Creates new form vistaEscogerProblema
     */
    public vistaEscogerProblema() {
        initComponents();
        this.setLocationRelativeTo(null);
        //Icono y titulo del frame
        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/logoCAMS.png"));
        this.setIconImage(icono);
        this.setTitle("Concurso Anual de Matemáticas del Sureste");
        jTableProblemaExtra.getTableHeader().setPreferredSize(new Dimension(10, 40));
        jTableProblemaExtra.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 25));
    }

    public String[] getArraySeleccionados() {
        return arraySeleccionados;
    }

    public void setArraySeleccionados(String[] arrayParticipantes) {
        this.arraySeleccionados = arrayParticipantes;
    }

    /* crea una arreglo con el número de problemas en el archivo Orden_rpp_extras
     y lo escribe en un archivo temporal llamado numProblemasExtras
     */
    public void generarMatrizNumProblemasExtras() {
        String[] numProblemas = new String[numFilasCols[0]];
        for (int i = 0; i < numFilasCols[0]; i++) {
            numProblemas[i] = "PROBLEMA EXTRA " + (i + 1);
        }

        File fichero = new File(ruta + "\\numProblemasExtras.txt");
        //Si existe el archivo lo borra
        if (fichero.exists()) {
            fichero.delete();
        }
        // escribimos el arreglo en un archivo para que la función DefaultTable la puede leer
        modelo.escribirArregloEnFichero(numProblemas, ruta, "numProblemasExtras", "txt");
    }

    public void mostrarTabla() {
        DefaultTableModel tablaNumProblemas = modelo.crearTableModelArreglo(ruta + "\\numProblemasExtras.txt");
        this.jTableProblemaExtra.setModel(tablaNumProblemas);
        this.agregarCheckBox(1, this.jTableProblemaExtra);
    }

    // función que devuelve el número de problema seleccionado
    public int getNumProblemaSeleccionado() {
        int numProblemaSeleccionado = 0;
        int k = 0;
        for (int i = 0; i < jTableProblemaExtra.getRowCount(); i++) {
            String seleccion = String.valueOf(jTableProblemaExtra.getValueAt(i, 1));
            if (seleccion.equals("true")) {
                numProblemaSeleccionado = i;
                k++;
            }
            if (k == 1) {
                break;
            }
        }
        return numProblemaSeleccionado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNombres = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProblemaExtra = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLabelNombres.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabelNombres.setText("Seleccionar un problema");

        jTableProblemaExtra.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jTableProblemaExtra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Problema extra", "Seleccionado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProblemaExtra.setRowHeight(40);
        jScrollPane1.setViewportView(jTableProblemaExtra);

        btnAceptar.setBackground(new java.awt.Color(51, 204, 255));
        btnAceptar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(btnAceptar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelNombres)
                        .addGap(187, 187, 187))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabelNombres)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnAceptar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int cantidad = numRegistrosSeleccionados();
        if (cantidad == 1) {
            //generarParejasAleatorias();
            //matrizSeleccionados();
            /*this.setVisible(false);
             confirmacion.setMatrizParticipantes(getMatrizSeleccionados());
             confirmacion.setVisible(true);*/

            this.setVisible(false);
            // le pasamos los nombres de los 2 alumnos seleccionados
            viewProblemasExtras.setArrayNombrePareja(getArraySeleccionados());
            // le pasamos el número de problema seleccionado
            viewProblemasExtras.setNumFilaOrdenRPP(getNumProblemaSeleccionado());
            viewProblemasExtras.setVisible(true);
        } else {
            if (cantidad < 1) {
                JOptionPane.showMessageDialog(null, "Debe de seleccionar un problema");
            } else {
                int resta = cantidad - 1;
                if (resta != 1) {
                    JOptionPane.showMessageDialog(null, "Debe de seleccionar " + resta + " problemas menos");
                } else {
                    JOptionPane.showMessageDialog(null, "Debe de seleccionar " + resta + " problema menos");
                }
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    // funcion que devuelve el número de registros (filas) seleccionados
    public int numRegistrosSeleccionados() {
        int numRegistros = 0;
        for (int i = 0; i < jTableProblemaExtra.getRowCount(); i++) {
            String seleccion = String.valueOf(jTableProblemaExtra.getValueAt(i, 1));
            if (seleccion.equals("true")) {
                numRegistros++;
            }
        }
        return numRegistros;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vistaEscogerProblema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaEscogerProblema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaEscogerProblema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaEscogerProblema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaEscogerProblema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabelNombres;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProblemaExtra;
    // End of variables declaration//GEN-END:variables

    public void agregarCheckBox(int columna, JTable tabla) {
        TableColumn tc = tabla.getColumnModel().getColumn(columna);
        tc.setCellEditor(tabla.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));
    }

    public boolean isSelected(int row, int column, JTable tabla) {
        return tabla.getValueAt(row, column) != null;
    }
}
