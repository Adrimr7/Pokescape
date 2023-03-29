import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Observable;
public class Pokescape extends Observable
{
	private static VentanaInicio frameInicio;
	//private static VentanaJugador frameJugador;
	private static Pokescape miPokescape;
	public Pokescape()
	{

	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				// GUIA (1)
				// GUIA : Bienvenidos a este tour por Pokescape, hoy, comprenderemos las maravillas informaticas que se esconden a plena vista
				// GUIA : Para empezar tenemos el main, como no, el cual llama a crearPantallas(), un metodo que encontramos mas abajo.
				// GUIA : Siganme ...
				crearPantallas();
			}
		});
	}
    private static void crearPantallas() 
    {
    	// GUIA (2)
    	// GUIA : Bien, este metodo es una pequeña "excepcion" del MVC por que en algun lado hay que iniciar la parte de vista
    	try 
    	{	
    		// GUIA : Tratamos de crear la ventana inicial 
    		frameInicio = new VentanaInicio();	//Generamos la pantalla del titulo
    		
    		// GUIA : Y la añadimos como Observer de la clase en la que nos encontramos, esto es importante para el patron MVC y mas adelante veremos su uso, de momento
    		// GUIA : vale con entender que "frameInicio" y "Pokescape" estan unidas en el patron MVC.
    		
    		Pokescape.getMiPokescape().addObserver(frameInicio);
    		frameInicio.setVisible(true);		//Y la hacemos visible
    		System.out.println("VentanaInicio");
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
			System.out.println("ERROR");
		}
    	
    	// GUIA : Ahora vamos a pasar al apartado de Vista, concretamente a "VentanaInicio"
    	// GUIA : Siganme ...
    }
    public void iniciarCombate(int numBots, int numJugs, int numPokes)
    {
    	//TODO ********************* Tiene pinta de que primero tenemos que tener los pokemon hechos para general las pantallas con los pokemon ya puestos *****
    	//Creamos una lista para almacenar todas las ventanas de los jugadores
    	
    	
    	// GUIA (6)  	
      	// GUIA : Bueno bueno, parece ser que empieza la fiesta por que depues del aviso del controlador nos vamos a "iniciarCombate" pero esta vez de ListaCombatientes.
    	// GUIA : Estad atentos por que mas adelante volveremos aqui
    	// GUIA : Seguidme ...
    	
    	ListaCombatientes.getMiListaCombatientes().iniciarCombate(numBots, numJugs, numPokes);
    	
    	
    	
    	
    	
    	// GUIA (10)
    	// GUIA : Bien, teniendo todo bien montadito, (a un euro la unidad), es hora de avisar a VentanaIncio
    	// GUIA : Os acordais del previamente añadido Observer, pues es hora de que entre en juego
    	// GUIA : El Observable y el Observer son una pareja, en este caso Pokescape y VentanaInicio
    	// GUIA : Trabajan juntos pero sin que se vea. El Observable hace una seña, y el Observer la recibe.
    	// GUIA : Es una forma de pasar informacion de forma "indirecta"
    	// GUIA : Con setChanged() Pokespace dice que algo ha cambiado, como que lo deja caer
    	
    	
    	avisarInicio(numBots, numJugs, numPokes);
		
		
		// GUIA (13 xd)
		// GUIA : Una vez esten todas las ventanas de combatientes preparaddas, es hora de llenarlas
		ListaCombatientes.getMiListaCombatientes().daAvisos();
		
		

		// Turnos
		
		ListaCombatientes.getMiListaCombatientes().escogeCombatiente();
		
    }
    
    public void avisarInicio(int numBots, int numJugs, int numPokes) 
    {
    	
   		setChanged();
   		
   		// GUIA : Y luego da cierta informacion, pero no a nadie concteto, simplenete lo suelta al aire
    
		notifyObservers(new Object[] {numBots, numJugs, numPokes});
		
		// GUIA : Eso si, nosotros sabemos quien lo va a recibir, en este caso, VentanaInicio con su metodo "update"
		// GUIA : Siganme ...
    	
    }
    
	public static Pokescape getMiPokescape() 
	{
		if (miPokescape == null)
		{
			miPokescape = new Pokescape();
		}
		return miPokescape;
	}
}