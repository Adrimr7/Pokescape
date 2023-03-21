import java.util.Random;

public abstract class Pokemon 
{
	private String nombre;
	private int vida;
	private int ataque;
	private int defensa;
	private int numEvoluciones; // TODO ****************
								// boolean Evoluciona --> Pokemon evolucion (Y cuando llegue a mitad de la vida actual cambia de pokemon)
	
	public Pokemon(String pNombre, int pVida, int pAtaque, int pDefensa, int pNumEvoluciones) 
	{
		nombre = pNombre;
		Random aleatorio = new Random();
		vida = pVida + aleatorio.nextInt(1,20);
		ataque = pAtaque + aleatorio.nextInt(1,7);
		defensa = pDefensa + aleatorio.nextInt(1,4);
	} 
}
