
public class EstadoEvol1 implements EstadoPokemon {
		
	public EstadoEvol1() {
		
	}
	
	public int getAtaque(int pAtaque) {
		return (pAtaque+5);
	}
	
	public int getDefensa(int pDefensa) {
		return (pDefensa+3);
	}

}
