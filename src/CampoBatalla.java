
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
	
	public boolean anadir(Pokemon poke, int idAtacante)
	{
		boolean correcto = false;
		
		//System.out.println("Id combatiente atacante : " + idAtacante); //////////////////////////////////////////////////////////////////
		
		if (atacante == null && idAtacante == idTurnoActual && poke != null)
		{ 
			System.out.println("Añadimos pokemon de " + idAtacante + " como atacante"); //////////////////////////////////////////////////////////////////
			atacante = poke;
			defensor = null;
			correcto = true;
		}
		else if (defensor == null && atacante != null && atacante.getIdCombatiente() != idAtacante && poke != null)
		{
				defensor = poke;
				System.out.println("Añadimos defensor"); //////////////////////////////////////////////////////////////////
				iniciarAtaque();
				correcto = true;
		}
		else if(poke == null)
		{
			System.out.println("No puedes añadir un pokemon nulo"); //////////////////////////////////////////////////////////////////
		}
		else if(atacante == null && idAtacante != idTurnoActual)
		{
			System.out.println("No puedes añadir un atacante, no es tu turno"); //////////////////////////////////////////////////////////////////
		}
		else if(atacante!= null && atacante.getIdCombatiente() == idAtacante)
		{
			System.out.println("No puedes atacarte a ti mismo"); //////////////////////////////////////////////////////////////////
		}
		else 
		{
			System.out.println("Esta ocupado"); //////////////////////////////////////////////////////////////////
		}
		return correcto;
	}
	
	private void iniciarAtaque()
	{
		System.out.println("Iniciamos ataque"); //////////////////////////////////////////////////////////////////
		
		// Danamos al defensor con el ataque del atacante
		boolean vivo = defensor.danar(atacante.getAtaque(), atacante.getClass().getSimpleName());
		
		if (!vivo)
		{
			// Si no ha sobrevivido al ataque, lo debilitamos (Se pone a null en su respectiva lista)
			ListaCombatientes.getMiListaCombatientes().debilitar(defensor.getIdPokemon(), defensor.getIdCombatiente());
		}
		atacante = null;
		defensor = null;
		
		ListaCombatientes.getMiListaCombatientes().avisaFinAtaque(idTurnoActual);
	}
	
	public void setTurno(int idTurno) { idTurnoActual = idTurno; }
	
}