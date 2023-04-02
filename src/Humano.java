public class Humano extends Combatiente {
	
	private int numTrue=0;
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
		usados = new boolean[arrayPokemon.length];
		numTrue=0;
		System.out.println("Turno Humano");
		
		setChanged();
		notifyObservers(new Object[] {1});
	}
	
	@Override
	public void atacaCon(int idPoke)
	{
		if(arrayPokemon[idPoke] != null && usados[idPoke]==false)
		{
			boolean rdo= CampoBatalla.getMiCampoBatalla().anadir(arrayPokemon[idPoke], id);
			
			if (rdo){
				usados[idPoke]=true;
				numTrue++;
			
				/*if (numTrue==usados.length) {
					ListaCombatientes.getMiListaCombatientes().escogeCombatiente();
				}*/
			}
		}
	}
	


}
