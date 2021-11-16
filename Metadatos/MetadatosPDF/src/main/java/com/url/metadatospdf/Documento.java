/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.url.metadatospdf;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author memej
 */

public class Documento {
    
    
    
    public void nuevoNombre(String nombre){
        byte cont = 0;
        try {
            RandomAccessFile archivo = new RandomAccessFile("nombres.txt","r");
            
            archivo.seek(0);
            cont = archivo.readByte();
            System.out.println("cont:" + ((int)cont));
            //cierra el archivo
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        }
        nuevoNombre(nombre,cont);
    
    }
    
        public void nuevoNombre(String nombre,int cont){
        try {
            RandomAccessFile data = new RandomAccessFile("nombres.txt", "w");
            
            //se posiciona en la primera posicion
            data.seek(0);
            
            //cont
            data.writeByte(cont+1);
            
            //se posiciona en la ultima posicion
            data.seek(data.length());
            
            //nombre
            data.writeBytes(nombre);
            //posicion
            data.writeByte(cont+1);
            
           
            
            //cierra el objeto
            data.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void escrituraDatos(String nombre,long tamanio,String a ){
        try {
            RandomAccessFile data = new RandomAccessFile("datos.txt", "w");
            
            //se posiciona en la ultima posicion
            data.seek(data.length());
            
            while(nombre.length()<25){
                nombre+=" ";
            }
            while(nombre.length()<120){
                a+=" ";
            }
            data.writeBytes(nombre);//25
            data.writeLong(tamanio);//10
            data.writeBytes(a);//120
            //data.writeBytes(programa);//50
            //data.writeLong(creacion);//19
            //data.writeLong(modificacion);//19
            //total:151
            
            //cierra el objeto
            data.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        public void escrituraDatos2(String autor, String programa, long creacion, long modificacion){
        try {
            RandomAccessFile data = new RandomAccessFile("datos.txt", "w");
            
            //se posiciona en la ultima posicion
            data.seek(data.length());

            while(autor.length()<25){
                autor+=" ";
            }
            while(programa.length()<25){
                programa+=" ";
            }
            //data.writeBytes(nombre);//25
            //data.writeLong(tamanio);//10
            data.writeBytes(autor);//25
            data.writeBytes(programa);//50
            data.writeLong(creacion);//19
            data.writeLong(modificacion);//19
            //total:151
            
            //cierra el objeto
            data.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        }
        
        public String lecturaAleatoria(int ubicacion){
        String r="";
        
        try {
            RandomAccessFile archivo = new RandomAccessFile("datos.txt","r");
            
            //lee el nombre
            archivo.seek(151*ubicacion);
            byte nombre[] = new byte[25];
            archivo.read(nombre);
            r="Nombre:" + new String (nombre);
            
            //lee el tamanio
            int tamanio = archivo.readInt();
            r+=("\ntamanio:" + tamanio);
            
            //lee los componenetes en a
            archivo.seek(151*ubicacion);
            byte a[] = new byte[120];
            archivo.read(a);
            r+=("\ndatos varios: " + new String (a));
            
            
            /*//lee las paginas
            byte paginas = archivo.readByte();
            System.out.println("Paginas:" + ((byte)paginas));
            
            //autor
            byte autor[] = new byte[25];
            archivo.read(autor);
            System.out.println("Autor:" + new String (autor));
            
            //programa
            byte programa[] = new byte[25];
            archivo.read(programa);
            System.out.println("Programa:" + new String (autor));
            
            //lee la fecha de creacion
            long creacion = archivo.readLong();
            System.out.println("Creacion:" + creacion);

            long modificacion = archivo.readLong();
            System.out.println("Creacion:" + modificacion);*/
            
            //cierra el archivo
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
        
        public int lecturaIndice(int indice){
         int datos=0;
        try {
            RandomAccessFile archivo = new RandomAccessFile("datos.txt","r");
           
            //lee el nombre
            archivo.seek(indice);
            byte nombre[] = new byte[25];
            archivo.read(nombre);
            
            
            //lee el seek donde estan los datos almacenados 
            archivo.seek(indice+25);
            datos = archivo.readInt();
            
            
            
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
            
        /*private void escrituraAleatoria(){
        
        try {
            RandomAccessFile archivo = new RandomAccessFile("datos.txt", "w");
            
            //se posiciona en la ultima posicion
            archivo.seek(archivo.length());
            
            //escribe nuevos datos
            archivo.writeFloat(35.2f);
            archivo.writeInt(12345678);
            
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }*/

    void escrituraDatos(String name, long size, int i, String a, String Pathvar, int i0, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
