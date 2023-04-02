
public class CampoBatalla 
{
	private static CampoBatalla miCampoBatalla;
	private Pokemon atacante;
	private Pokemon defensor;
	private CampoBatalla(){}
	private int idTurnoActual;
	public static CampoBatalla getMiCampoBatalla()
	{
		if (miCampoBatalla == null)
		{
			miCampoBatalla = new CampoBatalla();
		}
		return miCampoBatalla;
	}
	public boolean anadir(Pokemon poke, int idCombee)
	{
		boolean bool = false;
		//System.out.println("Entramos al campo");
		if (atacante == null && idCombee == idTurnoActual)
		{ 
			System.out.println("Añadimos pokemon de " + idCombee + " como combatiente");
			atacante = poke;
			//System.out.println("Añadimos atacante");
			defensor = null;
			bool = true;
		}
		else if (defensor == null && atacante != null)
		{
			if (poke.getIdPokemon() != atacante.getIdPokemon())
			{
				defensor = poke;
				System.out.println("Añadimos defensor");
				iniciarAtaque();
				bool = true;
			}
		}
		else
		{
			System.out.println("Esta ocupado");
		}
		return bool;
	}
	private void iniciarAtaque()
	{
		System.out.println("Iniciamos ataque");
		boolean vivo = defensor.danar(atacante.getAtaque());
		if (!vivo)
		{
			ListaCombatientes.getMiListaCombatientes().debilitar(defensor.getIdPokemon(), defensor.getIdCombatiente());
		}
		atacante = null;
		defensor = null;
	}
	
	public void setTurno(int idTurno)
	{
		idTurnoActual = idTurno;
	}
	
}