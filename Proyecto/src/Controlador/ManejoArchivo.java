package Controlador;

import java.io.*;
import java.util.ArrayList;


public class ManejoArchivo{
    private String Archivo;
    private ArrayList<String> ed;
    
    public ManejoArchivo(String arch){
        this.Archivo=arch;
        this.ed= new ArrayList<String>();
    }
    
    public void LeerArchivo(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
     
 
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
	// hacer una lectura comoda (disponer del metodo readLine()).
            String temp="src\\Archivos-Entidades\\"+Archivo;
            archivo = new File(temp);
	    fr = new FileReader(archivo);
	    br = new BufferedReader(fr);
 	// Lectura del fichero
            String temporal;
           
            temporal=br.readLine();
            
            while(temporal!=null){
	  	ed.add(temporal);
                
                temporal=br.readLine();
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                    
                           
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }   
    }
    
    public boolean compararIdentificadoresString(String arch, String vista){
        boolean bandera=false;
        String[] arreglo=arch.split(",");
        if(arreglo[0].equals(vista)){
            bandera= true;
        }
        return bandera;
    }
    
    public int busquedaDatosEnArchivo(String clave){
        int indice;
        LeerArchivo();
        for(indice=0; indice<ed.size(); indice++){
            if(compararIdentificadoresString(ed.get(indice), clave)){
                break;
            }
        }
        return indice;
    }
    
    public void eliminarDatosEnArchivo(int indice){
        ed.remove(indice);
        EscrituraArchivo(ed, false);
    }
    
    public boolean verificarNoRepeticion(String noRepetir){
        boolean bandera=false;
        int indice;
        LeerArchivo();
        for(indice=0; indice<ed.size(); indice++){
            String temporal=ed.get(indice);
            String[] arreglo= temporal.split(",");
            if(arreglo[1].equals(noRepetir)){
                bandera=true;
                break;
            }
        }
        return bandera;
    }

    
   
    public void EscrituraArchivo(ArrayList<String> Arch, boolean tipoEscritura){
        //System.out.println(Archivo);
        FileWriter fichero = null;
        PrintWriter pw = null;
        //Arch= Arch+"\n";
        String temp="src\\Archivos-Entidades\\"+Archivo;
        try
        {
            fichero = new FileWriter(temp,tipoEscritura);
            //br = new BufferedWriter(fichero);

            pw = new PrintWriter(fichero);
 
            //System.out.println("Escribiendo en el archivo.txt");
            for(int i=0; i<Arch.size(); i++){
                pw.println(Arch.get(i));
            }
            
            //pw.write(Arch);
           // fichero.write(Arch);
         } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
    	 // Nuevamente aprovechamos el finally para 
        // asegurarnos que se cierra el fichero.
            if (null != fichero)
        	fichero.close();
                //pw.close();
                
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    
    
    public int[] obtenerContadoresEntidades(){
        int[] contadores={0,0,0};
        Archivo="Contadores.txt";
        LeerArchivo();
        for(int i=0; i<3; i++){
            String temporal=ed.get(i);
            String[] arreglo= temporal.split(":");
            contadores[i]=Integer.valueOf(arreglo[1]);
        }
        return contadores;
    }
    
    public void modificarContadoresEntidades(int[] contadores){
        Archivo="Contadores.txt";
        ArrayList<String> contadoresEntidades= new ArrayList<String>();
        contadoresEntidades.add("Clientes:"+contadores[0]);
        contadoresEntidades.add("Productos:"+contadores[1]);
        contadoresEntidades.add("Ventas:"+contadores[2]);
        EscrituraArchivo(contadoresEntidades, false);
    }


    public String obtenerLineaArchivo(int indice){
        return ed.get(indice);
    }
    
    public void establecerLineaArchivo(int indice, String nuevaLinea){
        ed.set(indice, nuevaLinea);
        EscrituraArchivo(ed, false);
    }
    
    
    public void agregarLineaArchivo(String datos){
        ArrayList<String> cadena= new ArrayList<String>();
        cadena.add(datos);
        EscrituraArchivo(cadena, true);
    }
    
    
    
    public static void main(String args[]){
        
        ManejoArchivo arch= new ManejoArchivo("archivo.txt");
        arch.LeerArchivo();
        System.out.println(arch.ed);
        System.out.println(arch.Archivo);
        ArrayList<String> ed;
        ed =new ArrayList<String>();
        ed.add("hola");
        ed.add("queso");
        
        //System.out.println(arch.ed.get(2));
        arch.EscrituraArchivo(ed, true);
        
        System.out.println(arch.ed);
    }
    
}