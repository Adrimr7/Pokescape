
public class Planta extends Pokemon {

	public Planta(String pNombre, int pVida, int pAtaque, int pDefensa, int pNumEvoluciones ) {
		super(pNombre, pVida, pAtaque, pDefensa, pNumEvoluciones);
		super.arrayDebilidades = new String[1];
		super.arrayDebilidades[0] = "Fuego";
	}


}
