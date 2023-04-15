import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.TimerTask;
import java.util.Timer;

public class NPC extends Combatiente {

	public NPC(String pNombre, int pId) {
		super(pNombre, pId);
	}

	
	public void tuTurno2()
	{
		setChanged();
		notifyObservers(new Object[] {1});
		
		miTurno = true;
		
		// Avisa al campo de batalla de que le toca atacar
		CampoBatalla.getMiCampoBatalla().setTurno(super.getId());
		
		// Ponemos a false la lista de usados (aquellos pokemon que ya han atacado)
		usados = new boolean[arrayPokemon.length];
		
		
		System.out.println(" ");      					 	
		System.out.println(" ");							
		System.out.println("Turno NPC : " + super.nombre);
		
		
		for (int i = 0; i < super.arrayPokemon.length; i++)
		{
			// Añadimos al campo de batalla el pokemon en posicion i para que ataque
			if (arrayPokemon[i] != null)
			{
				CampoBatalla.getMiCampoBatalla().anadir(arrayPokemon[i], super.getId());
				boolean bool = false;
				while (!bool) {
					// Buscamos aleatoriamente un pokemon al que atacar
					Pokemon poke = ListaCombatientes.getMilistaCombatientes().escogerObjetivo(super.getId());

					// Y lo añadimos al campo de batalla, como la posicion de atacante esta ocupada, lo hara de defensor
					bool = CampoBatalla.getMiCampoBatalla().anadir(poke, poke.getIdCombatiente());

					System.out.println("Defiende el pokemon " + poke.getIdPokemon() + " de :" + poke.getIdCombatiente());    //////////////////////////////////////////////////////////////////
				}
			}
		}
		miTurno = false;
		Timer t = new Timer();
		TimerTask tt = new TimerTask() {@Override public void run() {pasaDeTurno();}};
		t.schedule(tt, 2000);
	}

	private Pokemon elegirPoke(int pIdPokeAtacante)
	{
		// recorrer la lista de los combatientes
		// dentro del while cuando se esté en la misma id que el NPC se salte ese jugador

		boolean bool = false;
		int i = 0;
		int j = 0;
		if (this.getId()==i)
		{
			i++;
		}
		Pokemon poke = ListaCombatientes.getMilistaCombatientes().getCombatiente(i).getPokemon(0);
		Pokemon pokeAct = poke;
		// que el combatiente no este muerto y que el pokemon que no este muerto!
		for (i = i; i < ListaCombatientes.getMilistaCombatientes().getNumCombatientes(); i++)
		{
			if (ListaCombatientes.getMilistaCombatientes() == null)
			{
				System.out.println("ListaComb vacía!");
			}
			else if (ListaCombatientes.getMilistaCombatientes().getCombatiente(i) == null || i == super.getId())
			{
				System.out.println("Combatiente muerto!");
			}
			else
			{
				for (j = 0; j<ListaCombatientes.getMilistaCombatientes().getCombatiente(i).getLengthArrayPoke(); j++)
				{
					pokeAct = ListaCombatientes.getMilistaCombatientes().getCombatiente(i).getPokemon(j);
					if (pokeAct!= null && pokeAct.estaVivo())
					{
						poke = compararPokes(poke, pokeAct, pIdPokeAtacante);
					}
				}
			}
		}
		return poke;
	}
	private Pokemon compararPokes(Pokemon pPoke, Pokemon pPokeAct, int pIdPokeAtacante)
	{
		Pokemon pokeReturn = pPoke;
		String tipo = arrayPokemon[pIdPokeAtacante].getClass().getSimpleName();
		if (pPoke == null)
		{
			pokeReturn = pPokeAct;
		}
		else if ((pPoke.esDebil(tipo) && pPokeAct.esDebil(tipo)) || ((!pPoke.esDebil(tipo) && !pPokeAct.esDebil(tipo))))
		{
			if (pPoke.getVida() > pPokeAct.getVida())
			{
				pokeReturn = pPokeAct;
			}
		}
		else if ((pPokeAct.esDebil(tipo)))
		{
			pokeReturn = pPokeAct;
		}
		return pokeReturn;
	}
	public void tuTurno()
	{
		setChanged();
		notifyObservers(new Object[] {1});

		miTurno = true;

		// Avisa al campo de batalla de que le toca atacar
		CampoBatalla.getMiCampoBatalla().setTurno(super.getId());

		// Ponemos a false la lista de usados (aquellos pokemon que ya han atacado)
		usados = new boolean[arrayPokemon.length];


		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Turno NPC : " + super.nombre);


		for (int i = 0; i < super.arrayPokemon.length; i++)
		{
			// Añadimos al campo de batalla el pokemon en posicion i para que ataque
			if (arrayPokemon[i] != null)
			{
				CampoBatalla.getMiCampoBatalla().anadir(arrayPokemon[i], super.getId());
				boolean bool = false;
				while (!bool) {
					// Buscamos aleatoriamente un pokemon al que atacar
					Pokemon poke;
					if (arrayPokemon[i].getEstado().getClass().getSimpleName().equals("EstadoEuforia"))
					{
						poke = ListaCombatientes.getMilistaCombatientes().escogerObjetivo(super.getId());
					}
					else
					{
						poke = elegirPoke(i);
					}
					// Y lo añadimos al campo de batalla, como la posicion de atacante esta ocupada, lo hara de defensor
					bool = CampoBatalla.getMiCampoBatalla().anadir(poke, poke.getIdCombatiente());

					System.out.println("Defiende el pokemon " + poke.getIdPokemon() + " de :" + poke.getIdCombatiente());
				}
			}
		}
		miTurno = false;
		Timer t = new Timer();
		TimerTask tt = new TimerTask() {@Override public void run() {pasaDeTurno();}};
		t.schedule(tt, 2000);
	}
}
