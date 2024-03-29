/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.manipularCSV;
import java.applet.AudioClip;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

/**
 *
 * @author alber
 */
public class vistaProblemasExtras extends javax.swing.JFrame {

    // matriz para almacenar las parejas, únicamente el nombre 
    String[] arrayNombrePareja = new String[2];
    manipularCSV modelo = new manipularCSV();
    // obtenemos el número de filas del archivo orden_rpp_extras
    int[] numFilasCols = modelo.contarFilasCols(modelo.obtenerRutaArchivos() + "\\Orden_rpp_extras.txt");
    // matriz para almacenar el archivo orden_rpp_extras
    String[][] matrizOrdenRppExtra = new String[numFilasCols[0]][5];
    // contador para el numero de fila del orden_rpp.txt
    int numFilaOrdenRPP = 0;

    // DATOS DE CADA FILA DEL ARCHIVO orden_rpp.txt        
    String numProblema;
    String numPagPregunta;
    String numPagInicioSol;
    String numPagFinSol;
    String tiempo;

    // VARIABLES PARA CONTROLAR EL PDF
    SwingController control = new SwingController();
    SwingViewBuilder factry = new SwingViewBuilder(control);
    JPanel veiwerCompntpnl = factry.buildViewerPanel();
    public int numPagina = 0;

    /**
     * Creates new form vistaProblemasExtras
     */
    public vistaProblemasExtras() {
        initComponents();
        this.setLocationRelativeTo(null);
        String[][] matriz = modelo.leerArchivo(modelo.obtenerRutaArchivos() + "\\Orden_rpp_extras.txt");
        setMatrizOrdenRppExtra(matriz);
        setExtendedState(MAXIMIZED_BOTH);
        btnSalir.setEnabled(true);
        //Icono y titulo del frame
        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/logoCAMS.png"));
        this.setIconImage(icono);
        this.setTitle("Concurso Anual de Matemáticas del Sureste");
    }

    public String[][] getMatrizOrdenRppExtra() {
        return matrizOrdenRppExtra;
    }

    public void setMatrizOrdenRppExtra(String[][] matriz) {
        this.matrizOrdenRppExtra = matriz;
    }

    public String getNumProblema() {
        return numProblema;
    }

    public void setNumProblema(String numProblema) {
        this.numProblema = numProblema;
    }

    public String getNumPagPregunta() {
        return numPagPregunta;
    }

    public void setNumPagPregunta(String numPagPregunta) {
        this.numPagPregunta = numPagPregunta;
    }

    public String getNumPagInicioSol() {
        return numPagInicioSol;
    }

    public void setNumPagInicioSol(String numPagInicioSol) {
        this.numPagInicioSol = numPagInicioSol;
    }

    public String getNumPagFinSol() {
        return numPagFinSol;
    }

    public void setNumPagFinSol(String numPagFinSol) {
        this.numPagFinSol = numPagFinSol;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public int getNumFilaOrdenRPP() {
        return numFilaOrdenRPP;
    }

    public void setNumFilaOrdenRPP(int numFilaOrdenRPP) {
        this.numFilaOrdenRPP = numFilaOrdenRPP;
    }

    public String[] getArrayNombrePareja() {
        return arrayNombrePareja;
    }

    public void setArrayNombrePareja(String[] arrayNombrePareja) {
        this.arrayNombrePareja = arrayNombrePareja;
    }

    // funcion para colocar todos los valores necesarios para mostrar en pantalla
    public void colocarInformacion() {
        setNumProblema(matrizOrdenRppExtra[numFilaOrdenRPP][0]);
        setNumPagPregunta(matrizOrdenRppExtra[numFilaOrdenRPP][2]);
        setNumPagInicioSol(matrizOrdenRppExtra[numFilaOrdenRPP][3]);
        setNumPagFinSol(matrizOrdenRppExtra[numFilaOrdenRPP][4]);
        setTiempo(matrizOrdenRppExtra[numFilaOrdenRPP][5]);
    }

    // funcion para mostrar valores en pantalla
    public void mostrarDatos() {
        jLabelTimer.setText(getTiempo());
        jLabelParticipante1.setText(arrayNombrePareja[0]);
        jLabelParticipante2.setText(arrayNombrePareja[1]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPanePDF = new javax.swing.JScrollPane();
        jLabel4 = new javax.swing.JLabel();
        jLabelParticipante1 = new javax.swing.JLabel();
        jLabelParticipante2 = new javax.swing.JLabel();
        btnIgual = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        jLabelTimer = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnMenos = new javax.swing.JButton();
        btnMas = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel4.setText("Desempate");

        jLabelParticipante1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        jLabelParticipante2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelParticipante2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        btnIgual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/equal_32.png"))); // NOI18N
        btnIgual.setEnabled(false);
        btnIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIgualActionPerformed(evt);
            }
        });

        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/next.png"))); // NOI18N
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        jLabelTimer.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnSalir.png"))); // NOI18N
        btnSalir.setEnabled(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnMenos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lessSign.png"))); // NOI18N
        btnMenos.setEnabled(false);
        btnMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosActionPerformed(evt);
            }
        });

        btnMas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/plusSign.png"))); // NOI18N
        btnMas.setEnabled(false);
        btnMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasActionPerformed(evt);
            }
        });

        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/player_play.png"))); // NOI18N
        btnPlay.setEnabled(false);
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(425, 425, 425)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIgual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(btnMenos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelParticipante1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(jLabelParticipante2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPanePDF, javax.swing.GroupLayout.PREFERRED_SIZE, 1007, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelParticipante1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabelParticipante2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 480, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnIgual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnMenos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPlay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabelTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(108, 108, 108)
                    .addComponent(jScrollPanePDF, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                    .addGap(108, 108, 108)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* boton igual
     - Al presionarlo se deshabilita
     - Despliega la primera página de la solución del problema
     - Si hay más de una hoja de respuestas habilita los botones "-" y "+" para pasar a la hoja siguiente o anterior        
     */
    private void btnIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIgualActionPerformed
        // desactivamos este botón
        btnIgual.setEnabled(false);
        numPagina = Integer.parseInt(getNumPagInicioSol()) - 1;
        // desplegamos la primera página de la solución
        control.showPage(numPagina);
        if (existenMasHojas()) {
            // si existe mas de una hoja de solución habilitamos el botón de mas "+"
            btnMas.setEnabled(true);
        } else {
            btnSiguiente.setEnabled(true);
        }
    }//GEN-LAST:event_btnIgualActionPerformed

    /* Boton siguiente
     - Al presionarlo se deshabilita
     - Despliega nombre de los participantes que integran la pareja                
     - Carga cronómetro con el tiempo correspondiente al problema
     - Habilita botón de play
     */
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        btnSiguiente.setEnabled(false);
        // habilitamos el boton de play
        btnPlay.setEnabled(true);
        colocarInformacion();
        mostrarDatos();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int resultadoSalir = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resultadoSalir == 0) {
            control.closeDocument();
            try {
                this.finalize();
            } catch (Throwable ex) {
                Logger.getLogger(vistaProblemas.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosActionPerformed
        numPagina--;
        control.showPage(numPagina);

        // activamos el botón de mas (página siguiente)
        btnMas.setEnabled(true);
        int numPaginaActiva = numPagina + 1;
        // si la página activa es igual a la página inicial de la solución desactivamos el botón de menos "-"
        if (numPaginaActiva == Integer.parseInt(getNumPagInicioSol())) {
            btnMenos.setEnabled(false);
        }
    }//GEN-LAST:event_btnMenosActionPerformed

    private void btnMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasActionPerformed
        numPagina++;
        control.showPage(numPagina);

        // activamos el botón de menos (página anterior)
        btnMenos.setEnabled(true);

        int numPaginaActiva = numPagina + 1;
        // si la página activa es igual a la página final de la solución desactivamos el botón de más "+"
        if (numPaginaActiva == Integer.parseInt(getNumPagFinSol())) {
            btnMas.setEnabled(false);
            // activamos el botón de siguiente 
            btnSiguiente.setEnabled(true);
        }
    }//GEN-LAST:event_btnMasActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // desactivamos el boton
        btnPlay.setEnabled(false);
        // desplegamos el PDF        
        openpdf(modelo.obtenerRutaArchivos() + "\\Problemario.pdf");
        // activamos boton de Cancelar
        //btnSalir.setEnabled(true);

        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        String tiempoMins = getTiempo();
        String[] parts = tiempoMins.split(":");
        int minutos = Integer.parseInt(parts[0]);
        int segundos = 0;
        if (minutos > 0) {
            int minsASegs = minutos * 60;
            segundos = minsASegs + Integer.parseInt(parts[1]);
        } else {
            segundos = Integer.parseInt(parts[1]);
        }
        final int countdownStarter2 = segundos;

        Runnable runnable = new Runnable() {
            int countdownStarter = countdownStarter2;

            public void run() {
                String time = String.format("%02d:%02d", countdownStarter / 60, countdownStarter % 60);
                jLabelTimer.setText(time);
                //System.out.println(time);
                countdownStarter--;
                if (countdownStarter < 0) {
                    // deshabilitamos boton de Cancelar ("X")
                    //btnSalir.setEnabled(false);
                    // habilitamos botón de Igual "="
                    btnIgual.setEnabled(true);
                    scheduler.shutdown();
                    reproducirSonido();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
    }//GEN-LAST:event_btnPlayActionPerformed

    // metodo para reproducir sonido cuando el temporizador llegue a 0
    public void reproducirSonido() {
        AudioClip Sound;
        Sound = java.applet.Applet.newAudioClip(getClass().getResource("/Sonido/SONIDO-TIEMPO.wav"));
        Sound.play();
    }

    // método para comprobar si hay mas hojas de solucion o es únicamente una
    public boolean existenMasHojas() {
        // si son iguales solo hay una hoja
        if (getNumPagInicioSol().equals(getNumPagFinSol())) {
            return false;
        } else {
            // si son diferentes hay más de una hoja
            return true;
        }
    }

    // método para abrir el PDF
    public void openpdf(String file) {
        try {
            ComponentKeyBinding.install(control, veiwerCompntpnl);
            control.openDocument(file);
            jScrollPanePDF.setViewportView(veiwerCompntpnl);
            // mostramos la página del PDF
            numPagina = Integer.parseInt(getNumPagPregunta()) - 1;
            control.showPage(numPagina);
          //  control.zoomIn();
           control.setZoom((float) 0.88);
            // instrucción para ocultar barra de herramientas
            control.setToolBarVisible(false);
            // deshabilitamos la barra de scroll vertical
            jScrollPanePDF.setVerticalScrollBarPolicy(jScrollPanePDF.VERTICAL_SCROLLBAR_NEVER);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
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
            java.util.logging.Logger.getLogger(vistaProblemasExtras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaProblemasExtras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaProblemasExtras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaProblemasExtras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaProblemasExtras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnIgual;
    public javax.swing.JButton btnMas;
    public javax.swing.JButton btnMenos;
    public javax.swing.JButton btnPlay;
    public javax.swing.JButton btnSalir;
    public javax.swing.JButton btnSiguiente;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabelParticipante1;
    public javax.swing.JLabel jLabelParticipante2;
    public javax.swing.JLabel jLabelTimer;
    private javax.swing.JScrollPane jScrollPanePDF;
    // End of variables declaration//GEN-END:variables
}
