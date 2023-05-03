
public class CampoBatalla 
{
	private static CampoBatalla miCampoBatalla;
	private Pokemon atacante;
	private Pokemon defensor;
	private CampoBatalla(){}
	private int idTurnoActual;
	
	public static CampoBatalla getMiCampoBatalla()
	{
		// getter caracteristico del patron singleton
		if (miCampoBatalla == null)
		{
			miCampoBatalla = new CampoBatalla();
		}
		return miCampoBatalla;
	}
	
	public boolean anadir(Pokemon poke, int idAtacante)
	{
		// este metodo anade un pokemon al campo de batalla, haciendo varias comprobaciones por el camino
		boolean correcto = false;
		boolean fin = ListaCombatientes.getMilistaCombatientes().getFinPartida();
		if (fin)
		{
			correcto = fin;
		}
		else
		{
			if (atacante == null && idAtacante == idTurnoActual && poke != null)
			{	 
				System.out.println("Añadimos pokemon de " + idAtacante + " como atacante");
				atacante = poke;
				defensor = null;
				correcto = true;
			}
			else if (defensor == null && atacante != null && atacante.getIdCombatiente() != idAtacante && poke != null)
			{
					defensor = poke;
					System.out.println("Añadimos defensor"); 
					iniciarAtaque();
					correcto = true;
			}
			else if(poke == null)
			{
				System.out.println("No puedes añadir un pokemon nulo"); 
			}
			else if(atacante == null && idAtacante != idTurnoActual)
			{
				System.out.println("No puedes añadir un atacante, no es tu turno"); 
			}
			else if(atacante!= null && atacante.getIdCombatiente() == idAtacante)
			{
				System.out.println("No puedes atacarte a ti mismo"); 
			}
			else 
			{
				System.out.println("Esta ocupado"); 
			}
		}
		return correcto;
	}
	
	public void finTurno()
	{
		atacante = null;
		defensor = null;
	}
	
	private void iniciarAtaque()
	{
		System.out.println("Iniciamos ataque"); 
		
		// Danamos al defensor con el ataque del atacante
		boolean vivo = defensor.danar(atacante.obtAtaqueReal(), atacante.getClass().getSimpleName());
		
		if (!vivo)
		{
			// Si no ha sobrevivido al ataque, lo debilitamos (Se pone a null en su respectiva lista)
			ListaCombatientes.getMilistaCombatientes().debilitar(defensor.getIdPokemon(), defensor.getIdCombatiente());
		}
		
		if (atacante.getEstado().getClass().getSimpleName().equals("EstadoEuforia"))
		{
			atacante.quitarEuforia();
		}
		
		finTurno();
		// avisar del fin del ataque
		ListaCombatientes.getMilistaCombatientes().avisaFinAtaque(idTurnoActual);
	}

	public void setTurno(int idTurno) { idTurnoActual = idTurno; }
	
}