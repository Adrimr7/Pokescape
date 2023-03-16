
public abstract class Pokemon 
{
	private String nombre;
	private int vida;
	private int ataque;
	private int numEvoluciones; // TODO ****************
								// boolean Evoluciona --> Pokemon evolucion (Y cuando llegue a mitad de la vida actual cambia de pokemon)
	
	public Pokemon(String pNombre, int pVida, int pAtaque, int pNumEvoluciones) 
	{
		// TODO ****************** RANDOM ATAQUE VIDA ETC STATS
		nombre = pNombre;
		vida = pVida;
		ataque = pAtaque;
	} 
}
