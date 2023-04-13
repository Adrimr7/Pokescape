public class Humano extends Combatiente {
	
	private int numAtaques = 0;
	public Humano(String pNombre, int pId) {
		super(pNombre, pId);
	}

	
	@Override
	public void tuTurno()
	{
		miTurno = true;
		CampoBatalla.getMiCampoBatalla().setTurno(super.getId());
		usados = new boolean[arrayPokemon.length];
		numAtaques = 0;
		System.out.println("Turno Humano : " + super.nombre);
		
		setChanged();
		notifyObservers(new Object[] {1});
	}
	
	@Override
	public void atacaCon(int idPoke)
	{	
		if(arrayPokemon[idPoke] != null && usados[idPoke]==false && miTurno)
		{
			boolean rdo = CampoBatalla.getMiCampoBatalla().anadir(arrayPokemon[idPoke], id);
			
			if (rdo)
			{
				usados[idPoke] = true;
				numAtaques++;
			}
		}
		else if(arrayPokemon[idPoke] != null && !miTurno)
		{
			CampoBatalla.getMiCampoBatalla().anadir(arrayPokemon[idPoke], id);
		}

	}
	@Override
	public void finAtaque()
	{
		System.out.print("El ataque ha acabado");
		if(numAtaques == numeroVivos()) 
		{
			System.out.println(" y paso mi turno");
			miTurno = false;
			pasaDeTurno();
		}
		System.out.println("");
	}
	
	@Override
	public void clickGo()
	{
		miTurno = false;
		pasaDeTurno();
	}
	
}
