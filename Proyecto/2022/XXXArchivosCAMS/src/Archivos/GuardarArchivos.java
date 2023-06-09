package Archivos;

import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shannon
 */
public class GuardarArchivos {
    
    public void inicializarGuardado(){
        manipularCSV archivo = new manipularCSV();              
        String rutaArchivos = archivo.obtenerRutaArchivos();
        
      // Fase escrita
        File ficheroFaseE = new File(rutaArchivos + "\\Fase escrita.txt");
        if (ficheroFaseE.exists()) {            
            ficheroFaseE.delete();               
        }
        
       // se obtiene el número de archivos 
        int numArchivos = archivo.obtenerNumArchivos();
        
        // creamos el archivo Log.txt
        archivo.validarNumeroArchivos(numArchivos, rutaArchivos);
        
        // se obtiene el número de filas y columnas del archivo base
        int numFilasColumnas []= archivo.contarFilasCols(rutaArchivos+"\\Archivo_base.csv"); 
        int numColArchivoBase = numFilasColumnas[1];
                        
        // se obtiene el tamaño que tendrá la matriz final
        int numFilas = numFilasColumnas[0];
        // se hace el +1 por la columna de asistencia
        int numColumnas = numColArchivoBase + numArchivos +1;      
        String matrizFinal [][] = new String [numFilas][numColumnas]; 
        
        // se almacena la información del archivo base en una matriz
        String matrizArchivoBase [][] = archivo.leerArchivo(rutaArchivos+"\\Archivo_base.csv");
        
        // se copia la matriz base a la matriz final
        for (int i=0;i<matrizArchivoBase.length;i++){      
            for (int j=0;j<matrizArchivoBase[i].length;j++){      
                matrizFinal[i][j] = matrizArchivoBase [i][j];                
            }
        }        
        
        // variable para iterar el número de archivo
        int num = 1;
        int numColArchivoBaseTemp = numColArchivoBase;
        // se copian las calificaciones a la matriz final
        for (int i=0;i<numArchivos;i++){                     
            String matrizReactivo [][] = archivo.leerArchivo(rutaArchivos+ "\\Calificaciones" +"\\P"+num+".csv");                        
            archivo.validarComas(matrizReactivo,rutaArchivos,"P"+num+"");
            for (int x=0;x<matrizFinal.length;x++){
                // el if es para omitir el encabezado
                if (x!=0){
                    if (matrizReactivo[x][3] == null){
                        matrizFinal[x][numColArchivoBase] = "";
                    } else{
                        matrizFinal[x][numColArchivoBase] = matrizReactivo[x][3];
                    }                    
                }
            }
            num++;
            numColArchivoBase++;                                                            
        }                   
        
        // colocamos la asistencia
        matrizFinal = archivo.colocarAsistencia(matrizFinal, numColArchivoBaseTemp);
        
        //escribimos los datos en el archivo de salida con los datos de los alumnos, las calificaciones y las asistencias
        archivo.escribirEnFichero(matrizFinal, rutaArchivos,"Fase escrita","txt");    
    }
    
}
