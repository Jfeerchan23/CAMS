/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Controlador.controlador;
import Modelo.manipularCSV;
import Vista.vistaParticipantes;
import Vista.vistaPaseLista;
import java.io.File;

/**
 *
 * @author alber
 */
public class Main {
        
    public static void main(String[] args){           
        manipularCSV archivo = new manipularCSV();              
        String rutaArchivos = archivo.obtenerRutaArchivos();

        // numProblemasExtras
        File ficheroNumProbExtras = new File(rutaArchivos + "\\numProblemasExtras.txt");
        if (ficheroNumProbExtras.exists()) {            
            ficheroNumProbExtras.delete();               
        }
        // IMPRESION_PAREJAS
        File ficheroImpParejas = new File(archivo.obtenerRutaGuardadoArchivos() + "\\IMPRESION_PAREJAS.csv");
 
        // Log
        File ficheroLog = new File(archivo.obtenerRutaGuardadoArchivos() + "\\Log.txt");
        if (ficheroLog.exists()) {            
            ficheroLog.delete();               
        }
        
        // Parejas
        File ficheroParejas = new File(archivo.obtenerRutaGuardadoArchivos() + "\\PAREJAS.csv");   
        
        //////// INICIA FASE DE PASE DE LISTA ////////
        vistaPaseLista frmVistaPase = new vistaPaseLista();         
        vistaParticipantes frmParticipantes = new vistaParticipantes();
        controlador ctrl = new controlador(frmVistaPase,frmParticipantes);
        ctrl.iniciar();
        ctrl.inicializarTablas();
        frmVistaPase.setVisible(true);   
    }
}
