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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

/**
 *
 * @author alber
 */
public class vistaProblemas extends javax.swing.JFrame {

    // matriz para almacenar las parejas, únicamente el nombre 
    String[][] matrizNombreParejas = new String[5][2];
    // matriz para almacenar el archivo orden_rpp
    String[][] matrizOrdenRPP = new String[20][8];
    manipularCSV modelo = new manipularCSV();
    // contador para el numero de fila del orden_rpp.txt
    int numFilaOrdenRPP = 0;
    vistaEscogerProblema viewEscogerProblema = new vistaEscogerProblema();

    // DATOS DE CADA FILA DEL ARCHIVO orden_rpp.txt
    String numRonda;
    String numPareja;
    String numProblema;
    String areaConocimiento;
    String tiempo;
    String numPagPregunta;
    String numPagInicioSol;
    String numPagFinSol;

    // VARIABLES PARA CONTROLAR EL PDF
    SwingController control = new SwingController();
    SwingViewBuilder factry = new SwingViewBuilder(control);
    JPanel veiwerCompntpnl = factry.buildViewerPanel();
    public int numPagina = 0;

    /**
     * Creates new form vistaProblemas
     */
    public vistaProblemas() {
        initComponents();
        this.setLocationRelativeTo(null);
        String[][] matriz = modelo.leerArchivo(modelo.obtenerRutaArchivos() + "\\orden_rpp.txt");
        setMatrizOrdenRPP(matriz);
        setExtendedState(MAXIMIZED_BOTH);
        jLabelParticipante1.setText("Participante A");
        jLabelParticipante2.setText("Participante B");
        jLabelProblema.setHorizontalAlignment(JLabel.CENTER);
        jLabelProblema.setVerticalAlignment(JLabel.CENTER);
        jLabelNumProblema.setHorizontalAlignment(JLabel.CENTER);
        jLabelNumProblema.setVerticalAlignment(JLabel.CENTER);
        //Icono y titulo del frame
        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/logoCAMS.png"));
        this.setIconImage(icono);
        this.setTitle("Concurso Anual de Matemáticas del Sureste");

    }

    public void setMatrizNombreParejas(String[][] matrizNombreParejas) {
        this.matrizNombreParejas = matrizNombreParejas;
    }

    public String[][] getMatrizOrdenRPP() {
        return matrizOrdenRPP;
    }

    public void setMatrizOrdenRPP(String[][] matriz) {
        this.matrizOrdenRPP = matriz;
    }

    public String getNumRonda() {
        return numRonda;
    }

    public void setNumRonda(String numRonda) {
        this.numRonda = numRonda;
    }

    public String getNumPareja() {
        return numPareja;
    }

    public void setNumPareja(String numPareja) {
        this.numPareja = numPareja;
    }

    public String getNumProblema() {
        return numProblema;
    }

    public void setNumProblema(String numProblema) {
        this.numProblema = numProblema;
    }

    public String getAreaConocimiento() {
        return areaConocimiento;
    }

    public void setAreaConocimiento(String areaConocimiento) {
        this.areaConocimiento = areaConocimiento;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
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

    public int getNumFilaOrdenRPP() {
        return numFilaOrdenRPP;
    }

    public void setNumFilaOrdenRPP(int numFilaOrdenRPP) {
        this.numFilaOrdenRPP = numFilaOrdenRPP;
    }

    // funcion para colocar todos los valores necesarios para mostrar en pantalla
    public void colocarInformacion() {
        setNumRonda(matrizOrdenRPP[numFilaOrdenRPP][0]);
        setNumPareja(matrizOrdenRPP[numFilaOrdenRPP][1]);
        setNumProblema(matrizOrdenRPP[numFilaOrdenRPP][2]);
        setAreaConocimiento(matrizOrdenRPP[numFilaOrdenRPP][3]);
        setTiempo(matrizOrdenRPP[numFilaOrdenRPP][4]);
        setNumPagPregunta(matrizOrdenRPP[numFilaOrdenRPP][5]);
        setNumPagInicioSol(matrizOrdenRPP[numFilaOrdenRPP][6]);
        setNumPagFinSol(matrizOrdenRPP[numFilaOrdenRPP][7]);
    }

    // funcion para mostrar valores en pantalla
    public void mostrarDatos() {
        int posicion = Integer.parseInt(getNumPareja());
        String participante1 = matrizNombreParejas[posicion - 1][0];
        String participante2 = matrizNombreParejas[posicion - 1][1];
        jLabelParticipante1.setText(participante1);
        jLabelParticipante2.setText(participante2);
        jLabelNumRonda.setText(getNumRonda());
        jLabelNumProblema.setText(getNumProblema());
        jLabelTimer.setText(getTiempo());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelParticipante2 = new javax.swing.JLabel();
        jLabelParticipante1 = new javax.swing.JLabel();
        jLabelRonda = new javax.swing.JLabel();
        jLabelProblema = new javax.swing.JLabel();
        jLabelNumProblema = new javax.swing.JLabel();
        btnIgual = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnMenos = new javax.swing.JButton();
        btnMas = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        comboBoxNumProblema = new javax.swing.JComboBox();
        jLabelTimer = new javax.swing.JLabel();
        jScrollPanePDF = new javax.swing.JScrollPane();
        jLabelNumRonda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jLabelParticipante2.setFont(new java.awt.Font("Dialog", 1, 26)); // NOI18N
        jLabelParticipante2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelParticipante1.setFont(new java.awt.Font("Dialog", 1, 26)); // NOI18N
        jLabelParticipante1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabelRonda.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabelRonda.setText("Ronda");
        jLabelRonda.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelRonda.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabelProblema.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabelProblema.setText("Problema");
        jLabelProblema.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabelNumProblema.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N

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

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelSign.png"))); // NOI18N
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        comboBoxNumProblema.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        comboBoxNumProblema.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        comboBoxNumProblema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxNumProblemaActionPerformed(evt);
            }
        });

        jLabelTimer.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabelTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTimer.setToolTipText("");
        jLabelTimer.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelTimer.setFocusable(false);
        jLabelTimer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelTimer.setRequestFocusEnabled(false);
        jLabelTimer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabelNumRonda.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIgual)
                .addGap(18, 18, 18)
                .addComponent(comboBoxNumProblema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabelTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(btnMenos)
                .addGap(18, 18, 18)
                .addComponent(btnMas)
                .addGap(18, 18, 18)
                .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPanePDF)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelParticipante1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelRonda)
                                .addGap(69, 69, 69)
                                .addComponent(jLabelNumRonda, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelProblema)
                                .addGap(30, 30, 30)
                                .addComponent(jLabelNumProblema, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelParticipante2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(106, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelRonda)
                            .addComponent(jLabelNumRonda, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelNumProblema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelProblema)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelParticipante1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelParticipante2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPanePDF, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMas, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPlay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnMenos, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(comboBoxNumProblema, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /* boton de play
     - Al presionarlo se deshabilita
     - Visualizamos el problema (PDF)
     - Iniciamos el decremento del cronómetro
     - Habilitamos el botón "X"
     */
    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // desactivamos el boton
        btnPlay.setEnabled(false);
        // desplegamos el PDF                
        openpdf(modelo.obtenerRutaArchivos() + "\\Problemario.pdf");
        // activamos boton de Cancelar
        btnCancelar.setEnabled(true);

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
                countdownStarter--;
                if (countdownStarter < 0) {
                    // deshabilitamos boton de Cancelar ("X")
                    btnCancelar.setEnabled(false);
                    // habilitamos botón de Igual "="
                    btnIgual.setEnabled(true);
                    scheduler.shutdown();
                    reproducirSonido();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
    }//GEN-LAST:event_btnPlayActionPerformed

    /* Boton siguiente
     - Al presionarlo se deshabilita
     - Despliega nombre de los participantes que integran la pareja
     - Despliega numero de ronda
     - Despliega numero de problema
     - Carga cronómetro con el tiempo correspondiente al problema
     - Habilita botón de play
     */
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        desactivarSgtComboBox();
        numFilaOrdenRPP++;
        btnMenos.setEnabled(false);
        btnMas.setEnabled(false);
    }//GEN-LAST:event_btnSiguienteActionPerformed

    // tiene el mismo comportamiento que el Boton siguiente
    private void comboBoxNumProblemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxNumProblemaActionPerformed
        String opcion = this.comboBoxNumProblema.getSelectedItem().toString();
        int opcionProblema = Integer.parseInt(opcion);
        setNumFilaOrdenRPP(opcionProblema - 1);

        desactivarSgtComboBox();
    }//GEN-LAST:event_comboBoxNumProblemaActionPerformed

    // esta función hace las acciones del boton siguiente y el combo box
    private void desactivarSgtComboBox() {
        control.closeDocument();
        btnSiguiente.setEnabled(false);
        comboBoxNumProblema.setEnabled(false);
        // habilitamos el boton de play
        btnPlay.setEnabled(true);
        colocarInformacion();
        mostrarDatos();
    }

    /* boton igual
     - Al presionarlo se deshabilita
     - Despliega la primera página de la solución del problema
     - Si hay más de una hoja de respuestas habilita los botones "-" y "+" para pasar a la hoja siguiente o anterior
     - En la última hoja de la solución habilita el boton de siguiente y el combo box
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
            if (this.comboBoxNumProblema.getSelectedItem().toString().equals("20")) {
                btnSiguiente.setEnabled(false);
            } else {
                btnSiguiente.setEnabled(true);
            }
            comboBoxNumProblema.setEnabled(true);
        }

    }//GEN-LAST:event_btnIgualActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized

    // botón más "+"
    private void btnMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasActionPerformed
        numPagina++;
        control.showPage(numPagina);

        // activamos el botón de menos (página anterior)
        btnMenos.setEnabled(true);

        int numPaginaActiva = numPagina + 1;
        // si la página activa es igual a la página final de la solución desactivamos el botón de más "+"
        if (numPaginaActiva == Integer.parseInt(getNumPagFinSol())) {
            btnMas.setEnabled(false);
            // activamos el botón de siguiente y el combo box
            if (this.comboBoxNumProblema.getSelectedItem().toString().equals("20")) {
                btnSiguiente.setEnabled(false);
            } else {
                btnSiguiente.setEnabled(true);
            }
            comboBoxNumProblema.setEnabled(true);
        }
    }//GEN-LAST:event_btnMasActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //habilitamos la ventana de confirmación para cancelar la pregunta        
        int resultadoCancelacion = JOptionPane.showConfirmDialog(null, "¿Desea cancelar la pregunta?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resultadoCancelacion == 0) {
            //// si es 0, si se cancela la pregunta
            this.dispose();
            // le pasamos los nombres de los 2 alumnos seleccionados
            viewEscogerProblema.setArraySeleccionados(getParejaSeleccionados());
            viewEscogerProblema.generarMatrizNumProblemasExtras();
            viewEscogerProblema.mostrarTabla();
            viewEscogerProblema.setVisible(true);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    // función que devuelve el nombre de los 2 estudiantes 
    public String[] getParejaSeleccionados() {
        String infoAlumnos[] = new String[2];
        infoAlumnos[0] = jLabelParticipante1.getText();
        infoAlumnos[1] = jLabelParticipante2.getText();
        return infoAlumnos;
    }

    // botón menos "-"
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
            //control.zoomIn();
            control.setZoom((float) 0.90);

            // instrucción para ocultar barra de herramientas
            control.setToolBarVisible(false);
            // deshabilitamos la barra de scroll vertical
            jScrollPanePDF.setVerticalScrollBarPolicy(jScrollPanePDF.VERTICAL_SCROLLBAR_NEVER);
            control.setUtilityPaneVisible(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar el archivo PDF, favor de revisar la ruta.");
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
            java.util.logging.Logger.getLogger(vistaProblemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaProblemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaProblemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaProblemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaProblemas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnIgual;
    public javax.swing.JButton btnMas;
    public javax.swing.JButton btnMenos;
    public javax.swing.JButton btnPlay;
    public javax.swing.JButton btnSiguiente;
    public javax.swing.JComboBox comboBoxNumProblema;
    public javax.swing.JLabel jLabelNumProblema;
    private javax.swing.JLabel jLabelNumRonda;
    public javax.swing.JLabel jLabelParticipante1;
    public javax.swing.JLabel jLabelParticipante2;
    public javax.swing.JLabel jLabelProblema;
    public javax.swing.JLabel jLabelRonda;
    public javax.swing.JLabel jLabelTimer;
    private javax.swing.JScrollPane jScrollPanePDF;
    // End of variables declaration//GEN-END:variables
}
