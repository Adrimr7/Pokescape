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
    		
    		// GUIA : Y la añadimos como Obverver de la clase en la que nos encontramos, esto es importante para el patron MVC y mas adelante veremos su uso, de momento
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
    	
    	ListaCombatientes.getMiListaCombatientes().iniciarCombate(numBots, numJugs, numPokes);
   		setChanged();
		notifyObservers(new Object[] {numBots, numJugs, numPokes});
    }
	// lista Jugadores, patron observer, mvc, jugador se encarga de generar los pokemon (factory)
    
	public static Pokescape getMiPokescape() 
	{
		if (miPokescape == null)
		{
			miPokescape = new Pokescape();
		}
		return miPokescape;
	}
}