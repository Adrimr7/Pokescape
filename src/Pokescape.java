import java.awt.EventQueue;
import java.util.Observable;

public class Pokescape extends Observable
{
	private static VentanaInicio frameInicio;
	private static Pokescape miPokescape;
	
	// constructora privada característica del patrón singleton
	private Pokescape(){}
	
	public static Pokescape getMiPokescape() 
	{
		// getter característico del patrón singleton
		if (miPokescape == null)
		{
			miPokescape = new Pokescape();
		}
		return miPokescape;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				// el método main llama a crearPantallas, que vemos a continuación
				crearPantallas();
			}
		});
	}
    private static void crearPantallas() 
    {
    	// este metodo es una pequeña "excepcion" del MVC por que en algun lado hay que iniciar la parte de vista
    	try 
    	{	
    		// Tratamos de crear la ventana inicial 
    		frameInicio = new VentanaInicio();	//Generamos la pantalla del titulo
    		
    		// La añadimos como Observer de la clase en la que nos encontramos, esto es importante para el patron MVC y mas adelante veremos su use
    		// Además, "frameInicio" y "Pokescape" estan unidas en el patron MVC.
    		
    		Pokescape.getMiPokescape().addObserver(frameInicio);
    		frameInicio.setVisible(true);		//Y la hacemos visible
    		System.out.println("VentanaInicio");
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
			System.out.println("ERROR");
		}
    	
    	// Ahora pasamos al apartado de Vista, concretamente a "VentanaInicio"
    	
    }
    public void iniciarCombate(int numBots, int numJugs, int numPokes, int nivel)
    {
    	
      	// Despues del aviso del controlador nos vamos a "iniciarCombate" pero esta vez de listaCombatientes.
    	ListaCombatientes.getMilistaCombatientes().iniciarCombate(numBots, numJugs, numPokes, nivel);
    	
    	// Avisamos a VentanaInicio, 
    	// El Observable y el Observer son una pareja, en este caso Pokescape y VentanaInicio
    	// El Observable hace una seña, y el Observer la recibe, es una forma de pasar informacion de forma "indirecta"
    	// Con setChanged() Pokespace dice que algo ha cambiado
    	avisarInicio(numBots, numJugs, numPokes);

		// Una vez esten todas las ventanas de combatientes preparadas, es hora de llenarlas
		ListaCombatientes.getMilistaCombatientes().daAvisos();
		
		
		// Con este metodo le damos turno a un combatiente aleatorio
		ListaCombatientes.getMilistaCombatientes().escogeCombatiente();
		
    }
    
    public void avisarInicio(int numBots, int numJugs, int numPokes) 
    {
    	
   		setChanged();
   		
   		// Luego da cierta informacion 
    
		notifyObservers(new Object[] {numBots, numJugs, numPokes});
		
		// Esto lo recibirá VentanaInicio, y por tanto se podrá actualizar
    	
    }
    


}