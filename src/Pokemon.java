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
	protected int ataque;
	protected int defensa;
	
	protected String[] arrayDebilidades;
	
	protected int numEvoluciones;		// Cuantas veces mas puede evolucionar
	protected int evolucionesHechas;	// Cuantas evoluciones lleva
	protected int vidaParaEvol;			// Cuando evolucionara
	
	protected int ataquesParaEuforia;	
	protected int ataquesRecibidos;
	protected EstadoPokemon estado;
	
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
		
		vidaParaEvol = vida/2;
		
		ataquesParaEuforia = aleatorio.nextInt(3,8);
		ataquesRecibidos = 0;
		estado = new EstadoNormal();
		
	}
	
	public void daAviso() 
	{
		setChanged();
		notifyObservers(new Object[] {nombre, vida, ataque, defensa, numPokemon, obtenerClase(), 0, evolucionesHechas, (ataquesParaEuforia-ataquesRecibidos)});
		
	}
	public void setNumPokemon(int pNumPoke)
	{
		numPokemon = pNumPoke;
	}
	
	private String obtenerClase()
	{
		if((String) this.getClass().getSimpleName() == "Electrico")
		{
			return "Eléctrico";
		}
		else
		{
			return this.getClass().getSimpleName();
		}
	}
	
	public boolean danar(int pAtaque, String pTipo)
	{
		int dano;
		
		if (esDebil(pTipo))
		{
			pAtaque = pAtaque * 2;
		}
		dano = (pAtaque - defensa);
		
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
					notifyObservers(new Object[] {nombre, vida, ataque, defensa, numPokemon, obtenerClase(), 2, evolucionesHechas, (ataquesParaEuforia-ataquesRecibidos)});
					
				}
			
				ataquesRecibidos++;
			
				if (ataquesRecibidos >= ataquesParaEuforia) 
				{
					ataquesRecibidos = 0;
				
					Random aleatorio = new Random();
					ataquesParaEuforia = aleatorio.nextInt(3,8);
				
					this.changeState(new EstadoEuforia());
					ataque = estado.getAtaque(ataque);
					defensa = estado.getDefensa(defensa);
					setChanged();
					notifyObservers(new Object[] {nombre, vida, ataque, defensa, numPokemon, obtenerClase(), 3, evolucionesHechas, (ataquesParaEuforia-ataquesRecibidos)});
					
				}
			}
			boolean vivo = estaVivo();
			setChanged();
			notifyObservers(new Object[] {nombre, vida, ataque, defensa, numPokemon, obtenerClase(), 1, evolucionesHechas, (ataquesParaEuforia-ataquesRecibidos)});
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
	
	public String getNombre() { return nombre;}
	
	public int getNumEvoluciones() { return numEvoluciones;}
	
	public int getDefensa() { return defensa;}
	
	public int getVida() { return vida;}
	
	public boolean estaVivo() {	return (vida > 0); }
	
	public void setIdCombatiente(int pId){ idCombatiente = pId; }
	
	public void setIdPokemon(int pId){ idPokemon = pId;	}
	
	private void evolucionar() 
	{
		if (numEvoluciones == 0) {}
		
		else if (numEvoluciones == 1) 
		{
			if (evolucionesHechas == 0) 
			{
				this.ataque += 5;
				this.defensa += 3;
				
				evolucionesHechas++;
				numEvoluciones--;
				vidaParaEvol = vidaParaEvol * 2/5;

				System.out.println("EVOLUCIÓN 1");
			}
			else if (evolucionesHechas == 1) 
			{
				this.ataque+=2;
				this.defensa+=2;
				
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
				this.ataque += 5;
				this.defensa += 3;
				
				evolucionesHechas++;
				numEvoluciones--;
				vidaParaEvol = vidaParaEvol * 2/5;

				System.out.println("EVOLUCIÓN 1");
			}
		}
	}
	
	public void changeState(EstadoPokemon pEstado) 
	{
		estado = pEstado;
		
		if (pEstado.getClass().getSimpleName().equals("EstadoNormal")) {
			ataque=estado.getAtaque(ataque);
			defensa=estado.getDefensa(defensa);
			
			Random aleatorio = new Random();
			ataquesParaEuforia = aleatorio.nextInt(3,8);
			setChanged();
			notifyObservers(new Object[] {nombre, vida, ataque, defensa, numPokemon, obtenerClase(), 4, evolucionesHechas, (ataquesParaEuforia-ataquesRecibidos)});
		}
	}
	
	public EstadoPokemon getEstado() 
	{
		return estado;
	}

	
}
