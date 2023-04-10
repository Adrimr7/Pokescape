
public class EstadoNormal implements EstadoPokemon {

	public EstadoNormal() {
		
	}
	
	public int getAtaque(int pAtaque) {
		return (pAtaque-100);
	}
	
	public int getDefensa(int pDefensa) {
		return (pDefensa-100);
	}
}
