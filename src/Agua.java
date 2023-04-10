
public class Agua extends Pokemon {

	public Agua(String pNombre, int pVida, int pAtaque, int pDefensa, int pNumEvoluciones, int pNumPoke) {
		super(pNombre, pVida, pAtaque, pDefensa, pNumEvoluciones,pNumPoke);
		
		super.arrayDebilidades = new String[2];
	    super.arrayDebilidades[0] = "Planta";
	    super.arrayDebilidades[1] = "Electrico";
	}
}
