package taller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Scanner;


public class ArbolCLI {
	
    private Scanner in;
    private String preorden;
    private String inorden;

    public ArbolCLI()
    {
        in = new Scanner(System.in);
    }

    public void mainMenu()
    {
        boolean finish = false;
        while(!finish)
        {
           Screen.clear();
           System.out.println("------------------------------------------");
           System.out.println("-                                        -");
           System.out.println("-           Siembra de árboles           -");
           System.out.println("-                                        -");
           System.out.println("------------------------------------------");
           System.out.println("EL sistema para la plantación de árboles binarios\n");
          
           System.out.println("Menú principal:");
           System.out.println("-----------------");
           System.out.println("1. Cargar archivo con semillas");
           System.out.print("\nSeleccione una opción: ");
           int opt1 = in.nextInt();
           switch(opt1)
           {
                case 1:
                  recibirArchivo();
                  break;
                default:
                  break;
           }
        }
    }

    public void recibirArchivo()
    {
         boolean finish = false;
         while(!finish)
         {
              Screen.clear();
              System.out.println("Recuerde que el archivo a cargar");
              System.out.println("debe ser un archivo properties");
              System.out.println("que tenga la propiedad inorden,");
              System.out.println("la propiedad preorden (donde los ");
              System.out.println("elementos esten separados por comas) y");
              System.out.println("que esté guardado en la carpeta data.");
              System.out.println("guardado en la carpeta data.");
              System.out.println("");
              System.out.println("Introduzca el nombre del archivo:");
              String arch = in.next();
              
              try {
				cargarArchivo(arch);
			} catch (Exception e) {
	              System.out.println("Hubo un problema cargando el archivo:");
	              System.out.println(e.getMessage());

			}
         }
    }

    public void cargarArchivo(String nombre) throws IOException
    {
    	File file = new File("./data/"+nombre);
		FileInputStream fileInput = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fileInput);
		fileInput.close();
		
		inorden = properties.getProperty("inorden");
		preorden = properties.getProperty("preorden");
        
        //TODO: implemente el método que reconstruya el árbol, y luego genere un archivo de texto con el árbol utilizando el método de crear archivo.
    }

    
    public void crearArchivo(String info) throws FileNotFoundException, UnsupportedEncodingException
    {
        File file = new File("./data/arbolPlantado.txt");
    	PrintWriter pw = new PrintWriter(file, "UTF-8");
    	pw.println(info); //note que esto escribe todo el texto en una sola línea. Si desea separar líneas en su String, haga uso de /n.
    	pw.close();
    }
    
    public static void main(String... args)
    {
        new ArbolCLI().mainMenu();
    }

}
