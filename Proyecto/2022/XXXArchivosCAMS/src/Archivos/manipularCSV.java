/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alber
 */
public class manipularCSV {
    
    private BufferedReader lector;
    private String linea;
    private String partes[];
    private String rutaArchivoConfi = "C:\\Users\\Shannon\\Documents\\Documentos\\8 Semestre\\Servicio social\\220209_Archivos_CAMS\\Proyecto\\Archivo de configuracion.txt";        
    
    /* funcion que devuelve la ruta en donde están los archivos que consume el
        programa y donde estarán los archivos de salida
    */
    public String obtenerRutaArchivos(){        
        String matrizRuta [][] = leerArchivo(rutaArchivoConfi);
        // se obtiene la ruta donde están los archivos con las calificaciones y donde se generarán los archivos de salida
        String rutaArchivos = matrizRuta[0][1];
        return rutaArchivos;
    }
    
    // funcion que devuelve el número de archivos (numero de reactivos)
    public int obtenerNumArchivos(){        
        String matrizRuta [][] = leerArchivo(rutaArchivoConfi);
        // se obtiene el número de archivos 
        int numArchivos = Integer.parseInt(matrizRuta[0][0]);      
        return numArchivos;
    }
    
    // funcion para contar las filas y columnas que contiene un archivo
    public int[] contarFilasCols(String rutaArchivo){
        int numFilas=0;
        int numColumnas=0;
        int numFilasColumnas[] = new int [2];
        try{            
            lector = new BufferedReader(new FileReader(rutaArchivo));            
            // se hace la lectura del archivo
            while((linea = lector.readLine()) != null){   
                numColumnas=0;
                partes = linea.split(",");
                for (int j=0;j<partes.length;j++){
                    numColumnas++;
                } 
                numFilas++;                
            }    
            numFilasColumnas[0] = numFilas;
            numFilasColumnas[1] = numColumnas;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return numFilasColumnas;
    }
    
    /* funcion para leer un archivo .txt o .csv
        devuelve una matriz con los datos leídos
    */     
    public String[][] leerArchivo(String nombreArchivo){
        int numFilasCols []= contarFilasCols(nombreArchivo);            
        String matriz[][] = new String [numFilasCols[0]][numFilasCols[1]];
            
        try{                   
            lector = new BufferedReader(new FileReader(nombreArchivo));
            int i=0;
            // se hace la lectura del CSV
            while((linea = lector.readLine()) != null){
                partes = linea.split(",");
                for (int j=0;j<partes.length;j++){                    
                    // se almacena la información leída en una matriz
                    matriz[i][j]=partes[j];
                }       
                i++;                               
            }                   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return matriz;
    }
        
    // creamos un DefaultTableModel de una matriz para crear la tabla de la vista
    public DefaultTableModel leerCSV(String nombreArchivo){
        String[] nombresColumnas = {"Nombre","Escuela","Estado","Presente"};        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);        
        
        try{                   
            lector = new BufferedReader(new FileReader(nombreArchivo));            
            // se hace la lectura del CSV
            while((linea = lector.readLine()) != null){
                partes = linea.split(",");   
                String [] linea = {partes[0],partes[1],partes[2]};                
                modelo.addRow(linea);                
            }      
            lector.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return modelo;
    }     
    
    // creamos un DefaultTableModel de un arreglo para crear la tabla de la vista
    public DefaultTableModel crearTableModelArreglo (String nombreArchivo){
        String[] nombresColumnas = {"Problema extra","Seleccionado"};        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);        
        
        try{                   
            lector = new BufferedReader(new FileReader(nombreArchivo));            
            // se hace la lectura del CSV
            while((linea = lector.readLine()) != null){                  
                String [] arreglo = {linea};                
                modelo.addRow(arreglo);                
            }   
            lector.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }        
        return modelo;
    } 
    
    // funcion para escribir una matriz en un archivo, puede ser .txt o .csv
    public void escribirEnFichero(String[][] datos, String ruta,String nombreArchivo, String tipoArchivo){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {            
            fichero = new FileWriter(ruta+"\\"+nombreArchivo+"."+tipoArchivo,true);
            pw = new PrintWriter(fichero);
            //se escribe los datos en el archivo de salida
            for (int i=0;i<datos.length;i++){
                String datoAlumno = "";
                int numVuelta = 1;
                for (int j=0;j<datos[i].length;j++){
                    if (numVuelta != 1){
                        if (datos[i][j] != "null"){
                            datoAlumno = datoAlumno +","+ datos[i][j];
                        }else{
                            break;
                        }                        
                    }else{
                        datoAlumno = datoAlumno + datos[i][j];   
                        numVuelta++;
                    }
                }
                //instrucción para escribir en el archivo
                pw.println(datoAlumno);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            //finally para asegurarnos que se cierra el fichero.           
            fichero.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
         
    // funcion para escribir un arreglo en un archivo, puede ser .txt o .csv
    public void escribirArregloEnFichero(String[] datos, String ruta,String nombreArchivo, String tipoArchivo){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {            
            fichero = new FileWriter(ruta+"\\"+nombreArchivo+"."+tipoArchivo,true);
            pw = new PrintWriter(fichero);
            //se escribe los datos en el archivo de salida
            for (int i=0;i<datos.length;i++){                
                //instrucción para escribir en el archivo
                pw.println(datos[i]);                
            }                        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
        try {
            fichero.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // valida que no haya campos vacíos en la información de los alumnos
    public void validarComas(String[][] matrizValidar,String ruta,String nombreArchivo){
        int numRegistro = 1;
        for (int a=0;a<matrizValidar.length;a++){ 
            // se le resta 1 al número de columnas para no leer la calificación
            int columnas = matrizValidar[a].length-1;            
            for (int b=0;b<columnas;b++){                 
                if (matrizValidar[a][b].equals("")){                    
                    //escribimos el error en el archivo Log
                    String datosError[][] = new String [1][3];
                    // nombre del archivo
                    datosError[0][0]= "- "+nombreArchivo;
                    // fila en donde se encontró el error
                    datosError[0][1] = "Línea "+String.valueOf(numRegistro);
                    // tipo de error
                    datosError[0][2]= "El registro tiene menos datos";
                    escribirEnFichero(datosError,ruta,"Log","txt");
                    break;
                }
            }
            numRegistro++; 
        }
    }
    
    // valida que estén todos los archivos a procesar
    public void validarNumeroArchivos(int numArchivos, String ruta){
        int num = 1;        
        String rutaArchivos = ruta.replaceAll("\\\\", "/");
        for (int i=0;i<numArchivos;i++){    
            String nombreArchivo = "P"+num;
            System.out.println(rutaArchivos);
            File existeArchivo = new File(rutaArchivos+"/Calificaciones"+ "/P"+num+".csv");
            System.out.println(rutaArchivos+"/Calificaciones"+ "/P"+num+".csv");
            if (!existeArchivo.exists()){
                //escribimos el error en el archivo Log
                String datosError[][] = new String [1][1];
                // nombre del archivo
                datosError[0][0]= "- No se encontró el archivo "+nombreArchivo;                                                                               
                escribirEnFichero(datosError,ruta,"Log","txt");
            }         
            num++;
        }
    }
    
    // funcion para colocar asistencia
    public String[][] colocarAsistencia(String[][] matrizFinal,int numColArchivoBase){
        for(int i=1;i<matrizFinal.length;i++){
            int colFinal = matrizFinal[i].length - 1;                        
            // se coloca 0 por default
            matrizFinal[i][colFinal] = String.valueOf(0);            
            for(int j=numColArchivoBase;j<colFinal;j++){                                
                // con que uno sea distinto de vacío se pone asistencia
                if (!matrizFinal[i][j].equals("")){                    
                    matrizFinal[i][colFinal] = String.valueOf(1);
                    break;
                }
            }
        }
        return matrizFinal;
    }
    
    //funcion para crear la matriz de los participantes seleccionados
    public String[][] crearMatrizSeleccionados (String[][] matrizParejas){
        String matrizSeleccionados[][] = new String [10][4];
        
        //copiamos los datos de las parejas a formato de lista
        int m = 0;              
        for (int i=0;i<matrizSeleccionados.length;i++){
            int k = 4;  
            for (int j=0;j<matrizSeleccionados[i].length;j++){
                if (i<5){
                    matrizSeleccionados[i][j]=matrizParejas[i][j];
                } else {
                    matrizSeleccionados[i][j]=matrizParejas[m][k];
                    k++;
                }                                                
            }
            if (i>4){
                m++;
            }
        }                       
        return matrizSeleccionados;
    }
}
