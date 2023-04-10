
public class Fuego extends Pokemon {

	public Fuego(String pNombre, int pVida, int pAtaque, int pDefensa, int pNumEvoluciones, int pNumPoke) {
		super(pNombre, pVida, pAtaque, pDefensa, pNumEvoluciones,pNumPoke);
		super.arrayDebilidades = new String[1];
		super.arrayDebilidades[0] = "Agua";
	}

}
