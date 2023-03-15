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
		EventQueue.invokeLater(new Runnable() {
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
    		frameInicio = new VentanaInicio();
    		frameInicio.setVisible(true);
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
    	//TODO ****************   ARRAYLIST ----> ARRAY !!!!!!!!!!!!!!!!!!!!!!
    	ArrayList<VentanaJugador> listaVentanaJugador = new ArrayList<VentanaJugador>();
    	VentanaJugador jug;
    	for (int i = 0; i<numJugs; i++)
    	{
    		jug = new VentanaJugador("Jugador "+ (i+1));
    		listaVentanaJugador.add(jug);
    		jug.setVisible(true);
    	}
    	
    	ArrayList<VentanaJugador> listaVentanaBots = new ArrayList<VentanaJugador>();
    	VentanaJugador bot;
    	for (int i = 0; i<numBots; i++)
    	{
    		bot = new VentanaJugador("Bot "+ (i+1));
    		listaVentanaJugador.add(bot);
    		bot.setVisible(true);
    	}
    	
    	ListaPokemon listaPokemon = new ListaPokemon();
    	Pokemon poke;
    	for (int i = 0; i<numPokes; i++)
    	{
    		// TODO LLAMAR A POKEFACTORY
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