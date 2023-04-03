import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;

public class NPC extends Combatiente {

	public NPC(String pNombre, int pId) {
		super(pNombre, pId);
	}

	
	public void tuTurno()
	{
		
		// Avisa al campo de batalla de que le toca atacar
		CampoBatalla.getMiCampoBatalla().setTurno(super.getId());
		
		// Ponemos a false la lista de usados (aquellos pokemon que ya han atacado)
		usados = new boolean[arrayPokemon.length];
		
		
		System.out.println(" ");      					 	//////////////////////////////////////////////////////////////////
		System.out.println(" ");							//////////////////////////////////////////////////////////////////
		System.out.println("Turno NPC : " + super.nombre);	//////////////////////////////////////////////////////////////////
		
		
		
		for (int i = 0; i < super.arrayPokemon.length; i++)
		{
			// Añadimos al campo de batalla el pokemon en posicion i para que ataque
			if (arrayPokemon[i] != null)
			{
				CampoBatalla.getMiCampoBatalla().anadir(arrayPokemon[i], super.getId());
				boolean bool = false;
				while (!bool) {
					// Buscamos aleatoriamente un pokemon al que atacar
					Pokemon poke = ListaCombatientes.getMiListaCombatientes().escogerObjetivo(super.getId());

					// Y lo añadimos al campo de batalla, como la posicion de atacante esta ocupada, lo hara de defensor
					bool = CampoBatalla.getMiCampoBatalla().anadir(poke, poke.getIdCombatiente());

					System.out.println("Defiende el pokemon " + poke.getIdPokemon() + " de :" + poke.getIdCombatiente());    //////////////////////////////////////////////////////////////////
				}
			}
		}
		ListaCombatientes.getMiListaCombatientes().escogeCombatiente();
	}

}
