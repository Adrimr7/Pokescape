
public class EstadoEuforia implements EstadoPokemon {
		
	public EstadoEuforia()
	{
		
	}
	
	public int getAtaque(int pAtaque) {
		return (pAtaque+100);
	}
	
	public int getDefensa(int pDefensa) {
		return (pDefensa+100);
	}

}
