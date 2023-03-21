import java.awt.EventQueue;
import java.util.ArrayList;

public class Pokescape 
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
    	VentanaJugador[] listaVentanaJugador = new VentanaJugador[numJugs];
    	VentanaJugador jug;
    	for (int i = 0; i<numJugs; i++)
    	{
    		jug = new VentanaJugador("Jugador "+ (i+1));
    		listaVentanaJugador[i] = jug;
    		jug.setVisible(true);
    	}
    	
    	//Y otra para los bots
    	VentanaJugador[] listaVentanaBots = new VentanaJugador[numBots];
    	VentanaJugador bot;
    	for (int i = 0; i<numBots; i++)
    	{
    		bot = new VentanaJugador("Bot "+ (i+1));
    		listaVentanaBots[i] = bot;
    		bot.setVisible(true);
    	}
		
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