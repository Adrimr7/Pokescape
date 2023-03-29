public class Humano extends Combatiente {

	public Humano(String pNombre, int pId) {
		super(pNombre, pId);
	}

	/*
	public void inicializate(int i, int i2, int numPoke) {
		// TODO Auto-generated method stub
		
	}
	*/
	@Override
	public void tuTurno()
	{
		System.out.println("Turno Humano");
	}

}
