import java.util.Random;
import java.util.stream.Stream;
import java.util.Observable;
public abstract class Pokemon extends Observable implements Cloneable
{
	protected int numPokemon;  			// numero en pokedex
	protected int idPokemon;   			// id del pokemon
	protected int idCombatiente;		// id del dueño
	
	protected String nombre;			// Nombre del pokemon
	protected int vida;
	protected int ataque;               // Ataque original del pokémon
	protected int defensa;              // Defensa original del pokémon
	protected EstadoPokemon estado;     // Estado del pokémon, patrón STATE
	
	/*
	 * Los atributos "ataque" y "defensa" son los valores asignados al pokémon al inicio de la partida.
	 * Sin embargo, los valores reales vendrán dados por el estado en el que se encuentre el pokémon, 
	 * estado original (ninguna evolución), primera evolución, segunda evolución o euforia.
	 
	 * Por ello, se definen dos métodos obtAtaqueReal() y obtDefensaReal() para obtener el verdadero 
	 * valor de ambos datos en función del estado del pokémon.
	 * Estos métodos devuelven el valor de ataque y defensa del estado, es decir, estado.getAtaque()
	 * y estado.getDefensa().
	 
	 * Para más información, consultar la clase EstadoPokemon.java
	 */
	
	protected String[] arrayDebilidades;
	
	protected int numEvoluciones;		// Cuantas veces mas puede evolucionar
	protected int evolucionesHechas;	// Cuantas evoluciones lleva
	protected int vidaParaEvol;			// Cuando evolucionara
	protected String[] nombresEvoluciones;
	
	protected int ataquesParaEuforia;	// Ataque a recibir para cambiar al estado Euforia

	
	public Pokemon(String pNombre, int pVida, int pAtaque, int pDefensa, int pNumEvoluciones, int pNumPoke) 
	{
		nombre = pNombre;
		numPokemon = pNumPoke;
		
		Random aleatorio = new Random();
		vida = pVida + aleatorio.nextInt(1,21);
		ataque = pAtaque + aleatorio.nextInt(1,8);
		defensa = pDefensa + aleatorio.nextInt(1,5);
		
		numEvoluciones = pNumEvoluciones;
		evolucionesHechas = 0;
		vidaParaEvol = vida/2;          // La primera evolución se realiza cuando la vida es inferior a la vida original
		nombresEvoluciones = new String[pNumEvoluciones];
		
		ataquesParaEuforia = aleatorio.nextInt(3,8);
		estado = new EstadoEvol0();     // El pokémon comienza en el estado inicial, representado por EstadoEvol0
		
	}
	
	public void daAviso() 
	{
		String str = getClass().getSimpleName();
		if((String) this.getClass().getSimpleName() == "Electrico")
		{
			str = "Eléctrico";
		}
		setChanged();
		notifyObservers(new Object[] {0, nombre, vida, ataque, defensa, numPokemon, str, ataquesParaEuforia});
		
	}

	
	public void setEvolNames(int pInt, String pName)
	{
		nombresEvoluciones[pInt] = pName;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * Métodos obtAtaqueReal() y obtDefensaReal() referentes al patrón STATE "EstadoPokemon"
	 * y usados para conocer el ataque y defensa del pokémon en cada momento de la partida,
	 * que dependerá del estado en el que se encuentre.
	 
	 * En consecuencia, cuando se quiera hacer uso del ataque o defensa del pokémon no se 
	 * accederá a los atributos de "ataque" y "defensa" (getAtaque(), por ejemplo), sino 
	 * a estos métodos que cogiendo como base los atributos anteriores, nos devolverán el 
	 * valor real acorde al estado.
	 
	 */
	
	public int obtAtaqueReal()
	{
		return this.getEstado().getAtaque(ataque);
	}
	public int obtDefensaReal()
	{
		return this.getEstado().getDefensa(defensa);
	}
	
	public boolean danar(int pAtaque, String pTipo)
	{
		int dano;
		if (esDebil(pTipo))
		{
			pAtaque = pAtaque * 2;
		}
		dano = (pAtaque - obtDefensaReal());

		if (dano >= 0) 
		{
			vida = vida - dano;
			
			if(vida <= 0)
			{
				vida = 0;
			}
			else
			{
				if (numEvoluciones != 0 && vida <= vidaParaEvol)
				{
					evolucionar();
					setChanged();
					notifyObservers(new Object[] {2, obtAtaqueReal(), obtDefensaReal(), numPokemon, ataquesParaEuforia, evolucionesHechas, nombresEvoluciones[evolucionesHechas-1]});
				
				}
				ataquesParaEuforia--;
				if (ataquesParaEuforia==0) 
				{
					Random aleatorio = new Random();
					ataquesParaEuforia = aleatorio.nextInt(3,8);
					this.changeState(new EstadoEuforia());
					setChanged();
					notifyObservers(new Object[] {3, obtAtaqueReal(), obtDefensaReal(), evolucionesHechas, (ataquesParaEuforia)});
					
				}
			}
			boolean vivo = estaVivo();
			setChanged();
			notifyObservers(new Object[] {1, vida, (ataquesParaEuforia)});
			
			return vivo;
		}
		else 
		{
			return estaVivo();
		}
	}
		
	public boolean esDebil(String pTipo)
	{
		boolean bool = false;
		if (arrayDebilidades !=null)
		{
			bool = Stream.of(arrayDebilidades).anyMatch(tipo -> tipo.equals(pTipo));
		}
		return bool;
	}
	
	public int getAtaque(){ return ataque; }

	public int getIdCombatiente(){ return idCombatiente; }
	
	public int getIdPokemon(){ return idPokemon; }
	
	public int getDefensa() { return defensa;}
	
	public int getVida() { return vida;}
	
	public boolean estaVivo() {	return (vida > 0); }
	
	public void setIdCombatiente(int pId){ idCombatiente = pId; }
	
	public void setIdPokemon(int pId){ idPokemon = pId;	}
	public int getEvolucionesHechas()
	{
		return this.evolucionesHechas;
	}
	
	private void evolucionar() 
	{
		if (numEvoluciones == 0) {}
		
		else if (numEvoluciones == 1) 
		{
			if (evolucionesHechas == 0) 
			{				
				changeState(new EstadoEvol1());
				evolucionesHechas++;
				numEvoluciones--;
				vidaParaEvol = vidaParaEvol * 2/5; //Actualizamos la vida límite para la segunda evolución

				System.out.println("EVOLUCIÓN 1");
			}
			else if (evolucionesHechas == 1) 
			{				
				changeState(new EstadoEvol2());
				evolucionesHechas++;
				numEvoluciones--;
				vidaParaEvol = 0;

				System.out.println("EVOLUCIÓN 2");
			}
		}
		else if (numEvoluciones == 2) 
		{
			if (evolucionesHechas == 0) 
			{
				changeState(new EstadoEvol1());
				evolucionesHechas++;
				numEvoluciones--;
				vidaParaEvol = vidaParaEvol * 2/5; //Actualizamos la vida límite para la segunda evolución

				System.out.println("EVOLUCIÓN 1");
			}
		}
	}
	

	/*
	 * El método changeState() nos permitirá cambiar el estado del pokémon a lo largo de la partida.
	 
	 * Esta función tiene su complejidad, puesto que antes de pasar a Euforia, tendremos que conocer 
	 * la información real del pokémon. Téngase en cuenta que el pokémon pueder estar en Evol0, Evol1 
	 * o en Evol2. En cualquiera de los tres casos, el incremento que deberá realizar la Euforia será
	 * diferente.
	 
	 
	 * Por ello, se comprueba si el estado al que cambiamos es Euforia (pEstado=Euforia). En este caso,
	 * neceitamos obtener información de ambos estados. Es decir, en VISTA tendremos que mostrar la euforia,
	 * pero esta euforia será en relación al estado que le precede. 
	 * Para lograr este efecto, se avisa a la Vista antes de cambiar el estado, para no perder el estado
	 * predecesor y poder indicarle a la interfaz gráfica la euforia correcta, que será:
	 * 
	 * pEstado.getAtaque(obtAtaqueReal())
	 * 
	 * Recordemos que pEstado es euforia y obtAtaqueReal() el valor sobre el que se debe aplicar la euforia.
	 
	 
	 * Por otra parte, si el estado actual es Euforia (estado=Euforia), cambiamos al nuevo estado, establecemos
	 * un nuevo número de defensas necesarias para entrar en euforia y notifyObservers cont tipo update 4.
	 
	 
	 * Y en el último caso, en el que el estado Euforia no está implicado, cambiamos al estado nuevo, y notifyObservers
	 * con tipo update 2.
	 
	 
	 * Los tipos de update se tratan en el método update() de la clase JPokemon.java
	 */
	
	public void changeState(EstadoPokemon pEstado) 
	{
		if (pEstado.getClass().getSimpleName().equals("EstadoEuforia"))
		{
			setChanged();
			notifyObservers(new Object[] {3, obtAtaqueReal(), obtDefensaReal(), evolucionesHechas, (ataquesParaEuforia)});
			estado = pEstado;
		}
		else if (estado.getClass().getSimpleName().equals("EstadoEuforia"))
		{
			estado = pEstado;
			Random aleatorio = new Random();
			ataquesParaEuforia = aleatorio.nextInt(3,8);
			setChanged();
			notifyObservers(new Object[] {4, obtAtaqueReal(), obtDefensaReal(), evolucionesHechas, (ataquesParaEuforia)});
			
		}
		else {
			estado = pEstado;
			setChanged();
			notifyObservers(new Object[] {2, obtAtaqueReal(), obtDefensaReal(), numPokemon, ataquesParaEuforia, evolucionesHechas, nombresEvoluciones[evolucionesHechas]});
			
		}
	}
	
	public EstadoPokemon getEstado() 
	{
		return estado;
	}

	public int getRestanteParaEuforia() {
		return ataquesParaEuforia;
	}
	
	public boolean getEuforiaActiva()
	{
		return estado.getClass().getSimpleName().equals("EstadoEuforia");
	}
	
	public void quitarEuforia() {
		EstadoPokemon estadoSiguiente = new EstadoEvol0();
		if (getEvolucionesHechas()==1){estadoSiguiente= new EstadoEvol1();}
		else if(getEvolucionesHechas()==2){estadoSiguiente= new EstadoEvol2();}
		changeState(estadoSiguiente);
	}

	
}