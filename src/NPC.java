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
		CampoBatalla.getMiCampoBatalla().setTurno(super.getId());
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Turno NPC");
		boolean bool = false;
		for (int i = 0; i < super.arrayPokemon.length; i++)
		{
			CampoBatalla.getMiCampoBatalla().anadir(arrayPokemon[i], super.getId());
			//super.arrayUsados[i] = true;
			System.out.println(" ");
			System.out.println("Ataca el pokemon " + i);
			while (!bool)
			{
				Pokemon poke = ListaCombatientes.getMiListaCombatientes().escogerObjetivo(super.getId());
				bool = CampoBatalla.getMiCampoBatalla().anadir(poke, poke.getIdCombatiente());
				System.out.println("Defiende el pokemon " + poke.getIdPokemon() + " de :" + poke.getIdCombatiente());
			}
		}
		super.ponerAFalse();
		ListaCombatientes.getMiListaCombatientes().escogeCombatiente();
	}

}
