import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Scanner;


public class MetroCLI {

	private Scanner in;
	private Metro metro;

	public MetroCLI()
	{
		metro = new Metro();
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
			System.out.println("-        Sistema de metro de NYC         -");
			System.out.println("-                                        -");
			System.out.println("------------------------------------------");
			System.out.println("EL sistema para la plantación de árboles binarios\n");

			System.out.println("Menú principal:");
			System.out.println("-----------------");
			System.out.println("1. Construir grafo matriz");
			System.out.println("2. Construir grafo listas de adyacencia");
			System.out.println("3. Buscar estacion");
			System.out.println("4. Dar nombre estación");
			System.out.println("5. Buscar conexión");
			System.out.println("6. Salir");
			System.out.print("\nSeleccione una opción: ");
			int opt1 = in.nextInt();
			switch(opt1)
			{
			case 1:
				metro.construirGrafoMatriz();
				break;
			case 2:
				metro.construirGrafoAdy();
				break;
			case 3:
				mostrarEstacion();
				break;
			case 4:
				mostrarNombreEst();
				break;
			case 5:
				mostrarHayConexion();
			case 6:
				finish=true;
				break;
			default:
				break;
			}
		}
	}

	private void mostrarNombreEst() {
		boolean finish = false;
		String id="";
		long init = System.currentTimeMillis();
		while(!finish)
		{
			Screen.clear();
			System.out.println("Búsqueda de nombres");
			System.out.println("-----------------");
			System.out.println("Introduzca el id de la estación");
			System.out.println("para conocer su nombre:");
			id = in.next();

		
            try{
                String nombre = metro.buscarNombreEst(id);
            
                long total = System.currentTimeMillis() - init;

		
                Screen.clear();
                System.out.println("El nombre de la estación es:");
                System.out.println(nombre);
                System.out.println("Y el tiempo que tardó la operación es:");
                System.out.println(total+" milisegundos");
                System.out.println("-----------------");
                System.out.println("Para volver al menú principal escoja 1:");
                int opt1 = in.nextInt();
                switch(opt1)
                {
                    case 1:
                        mainMenu();
                        break;
                }
            
            }
            catch(Exception e)
            {
                System.out.println(" El grafo no ha sido creado.");
                System.out.println("-----------------");
                System.out.println("Para volver al menú principal escoja 1:");
                int opt1 = in.nextInt();
                switch(opt1)
                {
                    case 1:
                        mainMenu();
                        break;
                }
            }

		}
	}

	private void mostrarEstacion()
	{
		boolean finish = false;
		String id="";
		long init = System.currentTimeMillis();
		while(!finish)
		{
			Screen.clear();
			System.out.println("Búsqueda de estaciones");
			System.out.println("-----------------");
			System.out.println("Introduzca el id de la estación");
			System.out.println("para saber si existe:");
			id = in.next();

		
            try{
                
                boolean existe = metro.buscarEst(id);
                long total = System.currentTimeMillis() - init;

		
                Screen.clear();
                System.out.println("La estación con el id "+id);
                System.out.println((existe?"existe":"no existe"));
                System.out.println("Y el tiempo que tardó la operación fue:");
                System.out.println(total+" milisegundos");
                System.out.println("-----------------");
                System.out.println("Para volver al menú principal escoja 1:");
                int opt1 = in.nextInt();
                switch(opt1)
                {
                    case 1:
                        mainMenu();
                        break;
                }
            }
            catch(Exception e)
            {
                System.out.println(" El grafo no ha sido creado.");
                System.out.println("-----------------");
                System.out.println("Para volver al menú principal escoja 1:");
                int opt1 = in.nextInt();
                switch(opt1)
                {
                    case 1:
                        mainMenu();
                        break;
                }
            }

		}
	}
	
	private void mostrarHayConexion()
	{
		boolean finish = false;
		String idA="";
		String idB="";
		long init = System.currentTimeMillis();
		while(!finish)
		{
			Screen.clear();
			System.out.println("Checkeo de conexiones");
			System.out.println("-----------------");
			System.out.println("Aqui puede saber si existe una conexión directa");
			System.out.println("entre las estaciones A y B");
			System.out.println("Introduzca el id de la estación A:");
			idA = in.next();
			
			System.out.println("Introduzca el id de la estación B:");
			idB = in.next();

		
            try{
                boolean hayConexión = metro.hayConexion(idA, idB);
                long total = System.currentTimeMillis() - init;

		
                Screen.clear();
                System.out.println(hayConexión?"Hay conexión entre A y B":"No hay conexión entre A y B");
                System.out.println("El tiempo que tardó la operación es:");
                System.out.println(total+" milisegundos");
                System.out.println("-----------------");
                System.out.println("Para volver al menú principal escoja 1:");
                int opt1 = in.nextInt();
                switch(opt1)
                {
                    case 1:
                        mainMenu();
                        break;
                }
            }
            catch(Exception e)
            {
                System.out.println(" El grafo no ha sido creado.");
                System.out.println("-----------------");
                System.out.println("Para volver al menú principal escoja 1:");
                int opt1 = in.nextInt();
                switch(opt1)
                {
                    case 1:
                        mainMenu();
                        break;
                }
            }

		}
	}
	


	public static void main(String... args)
	{
		new MetroCLI().mainMenu();
	}

}
