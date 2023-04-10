
public class Electrico extends Pokemon {

	public Electrico(String pNombre, int pVida, int pAtaque, int pDefensa, int pNumEvoluciones, int pNumPoke) {
		super(pNombre, pVida, pAtaque, pDefensa, pNumEvoluciones,pNumPoke);
		super.arrayDebilidades = new String[1];
		super.arrayDebilidades[0] = "Planta";
	}
}
