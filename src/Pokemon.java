import java.util.Random;
import java.util.Observable;
public abstract class Pokemon extends Observable
{
	protected String nombre;
	protected int vida;
	protected int ataque;
	protected int defensa;
	protected int numEvoluciones; // TODO ****************
								// boolean Evoluciona --> Pokemon evolucion (Y cuando llegue a mitad de la vida actual cambia de pokemon)
	protected String[] arrayDebilidades;
	public Pokemon(String pNombre, int pVida, int pAtaque, int pDefensa, int pNumEvoluciones) 
	{
		nombre = pNombre;
		Random aleatorio = new Random();
		vida = pVida + aleatorio.nextInt(1,20);
		ataque = pAtaque + aleatorio.nextInt(1,7);
		defensa = pDefensa + aleatorio.nextInt(1,4);
	}
	public void notifyObservers()
	{
		  notifyObservers(null);
	}
}
