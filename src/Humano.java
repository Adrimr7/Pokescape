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
		CampoBatalla.getMiCampoBatalla().setTurno(super.getId());
		System.out.println("Turno Humano");
		
		setChanged();
		notifyObservers(new Object[] {1});
	}
	


}
