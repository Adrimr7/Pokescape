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

				crearPantallas();
			}
		});
	}
    private static void crearPantallas() 
    {
    	try 
    	{	
    		frameInicio = new VentanaInicio();	//Generamos la pantalla del titulo
    		Pokescape.getMiPokescape().addObserver(frameInicio);
    		frameInicio.setVisible(true);		//Y la hacemos visible
    		System.out.println("VentanaInicio");
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
			System.out.println("ERROR");
		}
    }
    public void iniciarCombate(int numBots, int numJugs, int numPokes)
    {
    	//TODO ********************* Tiene pinta de que primero tenemos que tener los pokemon hechos para general las pantallas con los pokemon ya puestos *****
    	//Creamos una lista para almacenar todas las ventanas de los jugadores
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