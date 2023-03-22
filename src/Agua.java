
public class Agua extends Pokemon {

	public Agua(String pNombre, int pVida, int pAtaque, int pDefensa, int pNumEvoluciones) {
		super(pNombre, pVida, pAtaque, pDefensa, pNumEvoluciones);
		
		super.arrayDebilidades = new String[2];
	    super.arrayDebilidades[0] = "Planta";
	    super.arrayDebilidades[1] = "Electrico";
	}
}
