import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.TimerTask;
import java.util.Timer;

public class NPC extends Combatiente {

	private int nivel;
	public NPC(String pNombre, int pId, int pNivel) {
		super(pNombre, pId);
		nivel=pNivel;
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
					if (nivel==1) {
						// Buscamos aleatoriamente un pokemon al que atacar
						poke = ListaCombatientes.getMilistaCombatientes().escogerObjetivo(super.getId());

						// Y lo añadimos al campo de batalla, como la posicion de atacante esta ocupada, lo hara de defensor
						bool = CampoBatalla.getMiCampoBatalla().anadir(poke, poke.getIdCombatiente());

						System.out.println("Defiende el pokemon " + poke.getIdPokemon() + " de :" + poke.getIdCombatiente()); 
					}
					else if (nivel==2) {
						if (arrayPokemon[i].getEstado().getClass().getSimpleName().equals("EstadoEuforia"))
						{
							poke = elegirPokeEuforia(i);
						}
						else
						{
							poke = elegirPoke(i);
						}
						// Y lo añadimos al campo de batalla, como la posicion de atacante esta ocupada, lo hara de defensor
						bool = CampoBatalla.getMiCampoBatalla().anadir(poke, poke.getIdCombatiente());

						System.out.println("Defiende el pokemon " + poke.getIdPokemon() + " de :" + poke.getIdCombatiente());
					}
					else {
						poke = elegirPokeEuforia(i);
						
						// Y lo añadimos al campo de batalla, como la posicion de atacante esta ocupada, lo hara de defensor
						bool = CampoBatalla.getMiCampoBatalla().anadir(poke, poke.getIdCombatiente());

						System.out.println("Defiende el pokemon " + poke.getIdPokemon() + " de :" + poke.getIdCombatiente());
					}
					
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
	
	
	
	private Pokemon elegirPokeEuforia(int pIdPokeAtacante)
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
						poke = compararPokesEuforia(poke, pokeAct, pIdPokeAtacante);
					}
				}
			}
		}
		return poke;
	}
	
	private Pokemon compararPokesEuforia(Pokemon pPoke, Pokemon pPokeAct, int pIdPokeAtacante)
	{
		Pokemon pokeReturn = pPoke;
		String tipo = arrayPokemon[pIdPokeAtacante].getClass().getSimpleName();
		if (pPoke == null)
		{
			pokeReturn = pPokeAct;
		}
		else if (pPoke.getRestanteParaEuforia()==0) {
			if (pPokeAct.getRestanteParaEuforia()!=1) {
				pokeReturn = pPokeAct;
			}
			else {
				//pPoke está en EUFORIA, ¿interesa a pPoke o a pPokeAct?
				if (!pPokeAct.esDebil(tipo)&& arrayPokemon[pIdPokeAtacante].getAtaque()>=(pPokeAct.getVida()-pPokeAct.getDefensa())) {
					//Si matamos a pPokeAct atacamos
					pokeReturn=pPokeAct;
				}
				else if (arrayPokemon[pIdPokeAtacante].getAtaque()*2>=(pPokeAct.getVida()-pPokeAct.getDefensa())){
					pokeReturn=pPokeAct;
				}
			}
		}
		else if (pPoke.getRestanteParaEuforia()==1) {
			if (pPokeAct.getRestanteParaEuforia()==1) {pokeReturn=compararPokesDemencial(pPoke, pPokeAct, pIdPokeAtacante);}
			else if (!pPoke.esDebil(tipo)&& arrayPokemon[pIdPokeAtacante].getAtaque()<(pPoke.getVida()-pPoke.getDefensa())) {
				//Si no matamos a pPoke preferimos perder el ataque
				pokeReturn=pPokeAct;
			}
			else if (arrayPokemon[pIdPokeAtacante].getAtaque()*2<(pPoke.getVida()-pPoke.getDefensa())){
				pokeReturn=pPokeAct;
			}
			
		else if (pPokeAct.getRestanteParaEuforia()==0) {
			if (pPoke.getRestanteParaEuforia()==1) {
				//pPoke está en EUFORIA, ¿interesa a pPoke o a pPokeAct?
				if (!pPokeAct.esDebil(tipo)&& arrayPokemon[pIdPokeAtacante].getAtaque()>=(pPokeAct.getVida()-pPokeAct.getDefensa())) {
					//Si matamos a pPokeAct atacamos
					pokeReturn=pPokeAct;
				}
				else if (arrayPokemon[pIdPokeAtacante].getAtaque()*2>=(pPokeAct.getVida()-pPokeAct.getDefensa())) {
					pokeReturn=pPokeAct;
				}
			}
		}
		else if (pPokeAct.getRestanteParaEuforia()==1) {
			if (!pPokeAct.esDebil(tipo)&& arrayPokemon[pIdPokeAtacante].getAtaque()>=(pPokeAct.getVida()-pPokeAct.getDefensa())) {
				//Si no matamos a pPoke preferimos perder el ataque
				pokeReturn=pPokeAct;
			}
			else if (arrayPokemon[pIdPokeAtacante].getAtaque()*2>=(pPokeAct.getVida()-pPokeAct.getDefensa())) {
				pokeReturn = pPokeAct;
			}
		}
		else {
			pokeReturn=compararPokesDemencial(pPoke, pPokeAct, pIdPokeAtacante);
		}
	}
	return pokeReturn;
	}
	
	
	private Pokemon compararPokesDemencial(Pokemon pPoke, Pokemon pPokeAct, int pIdPokeAtacante)
	{
		Pokemon pokeReturn = pPoke;
		String tipo = arrayPokemon[pIdPokeAtacante].getClass().getSimpleName();
		int ataque = arrayPokemon[pIdPokeAtacante].getAtaque();
		if (pPoke == null)
		{
			pokeReturn = pPokeAct;
		}
		else if ((pPoke.esDebil(tipo) && pPokeAct.esDebil(tipo)) || ((!pPoke.esDebil(tipo) && !pPokeAct.esDebil(tipo))))
		{
			if ((ataque*2)>=(pPokeAct.getVida()-pPokeAct.getDefensa()) && pPoke.getVida()<pPokeAct.getVida())
			{
				pokeReturn = pPokeAct;
			}
			else if ((ataque)>=(pPokeAct.getVida()-pPokeAct.getDefensa()) && pPoke.getVida()<pPokeAct.getVida()) {
				pokeReturn = pPokeAct;
			}
		}
		else if (pPoke.esDebil(tipo) && (!pPokeAct.esDebil(tipo)) && (ataque)>=(pPokeAct.getVida()-pPokeAct.getDefensa()))
		{
			pokeReturn = pPokeAct;
		}
		
		return pokeReturn;
	}
}

