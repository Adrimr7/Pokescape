public class NPC extends Combatiente {

	public NPC(String pNombre, int pId) {
		super(pNombre, pId);
	}

	/*
	public void inicializate(int i, int pId, int numPoke) {
		// TODO Auto-generated method stub
		
	}
	*/
	
	public void tuTurno()
	{
		CampoBatalla.getMiCampoBatalla().setTurno(super.getId());
		System.out.println("Turno NPC");
		
		for (int i = 0; i < super.arrayPokemon.length; i++)
		{
			CampoBatalla.getMiCampoBatalla().anadir(arrayPokemon[i], super.getId());
			System.out.println("Ataka el poquemon " + i);
			ListaCombatientes.getMiListaCombatientes().escogerObjetivo(super.getId());
		}
		ListaCombatientes.getMiListaCombatientes().escogeCombatiente();
	}
	


}
