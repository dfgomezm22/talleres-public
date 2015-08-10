
public class Metro {
    
    public static final int "ADYACENCIA"=0;
    public static final int "MATRIZ"=1;
    
    private boolean creado;
    private int representación;
    
    public Metro()
    {
        creado = false;
    }
	
	public String buscarNombreEst(String id)
	{
        if(!creado)
            throw new Exception("El grafo no ha sido creado");
		//TODO: Implemente un método que busque una estación dado su ID y devuelva su nombre. Recuerde que la implementación es diferente para cada tipo de representación de grafos.
        if(representación=ADYACENCIA)
        {
            return "";
        }
        else
        {
            return "";
        }
		
	}


	public boolean buscarEst(String id) {
        if(!creado)
            throw new Exception("El grafo no ha sido creado");
		// TODO: Implemente un método que diga si la estación existe o no dada su ID. Recuerde que la implementación es diferente para cada tipo de representación de grafos.
        if(representación=ADYACENCIA)
        {
            return false;
        }
        else
        {
            return false;
        }

	}
	
	public boolean hayConexion(String idA, String idB) {
        if(!creado)
            throw new Exception("El grafo no ha sido creado");
		// TODO: Implemente un método que diga si la estación A tiene una conexión directa a la conexión B. Recuerde que la implementación es diferente para cada tipo de representación de grafos.
		if(representación=ADYACENCIA)
        {
            return false;
        }
        else
        {
            return false;
        }

	}

	public void construirGrafoAdy() {
        
        representación=ADYACENCIA;
        
		// TODO cree el grafo utilizando el método de listas de adyacencias.

	}

	public void construirGrafoMatriz() {
        
        representación=MATRIZ;
        
		// TODO cree el grafo utilizando el método de matriz de adyacencias.

	}

}
