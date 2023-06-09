/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.vistaParticipantes;
import Vista.vistaPaseLista;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alber
 */
public class controlador implements ActionListener {
    private vistaPaseLista frmVistaPaseLista;  
    private vistaParticipantes frmVistaParticipantes;
    
    public controlador(vistaPaseLista frmVistaPaseLista, vistaParticipantes frmVistaParticipantes) {
        this.frmVistaPaseLista = frmVistaPaseLista;        
        this.frmVistaParticipantes = frmVistaParticipantes;
    }
    
    public void iniciar(){
        frmVistaPaseLista.setTitle("Concurso Anual de Matemáticas del Sureste");
        frmVistaPaseLista.setLocationRelativeTo(null);
        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/logoCAMS.png"));
        frmVistaPaseLista.setIconImage(icono);   
        this.frmVistaPaseLista.comboBoxArchivo.addActionListener(this);  
        this.frmVistaParticipantes.btnTerminar.addActionListener(this);
    }
    
    public void inicializarTablas() {
        DefaultTableModel modeloA = new DefaultTableModel();
        modeloA.setColumnCount(0);
        modeloA.setRowCount(0);

        this.frmVistaParticipantes.jTableParticipantes.setModel(modeloA);               
    }
    
    
    
    public void actionPerformed(ActionEvent e){
        
    }
        
}
