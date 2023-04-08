import java.util.Random;
import java.util.stream.Stream;
import java.util.Observable;
public abstract class Pokemon extends Observable implements Cloneable
{
	protected int numPokemon;  // numero en pokedex
	protected int idPokemon;   // id del pokemon
	protected int idCombatiente;
	protected String nombre;
	protected int vida;
	protected int ataque;
	protected int defensa;
	protected int numEvoluciones; // TODO ****************
								// boolean Evoluciona --> Pokemon evolucion (Y cuando llegue a mitad de la vida actual cambia de pokemon)
	protected int evolucionesHechas;
	protected int vidaParaEvol;
	protected int vidaPrimeraEvol;
	protected int vidaSegundaEvol;
	protected String[] arrayDebilidades;
	public Pokemon(String pNombre, int pVida, int pAtaque, int pDefensa, int pNumEvoluciones) 
	{
		nombre = pNombre;
		Random aleatorio = new Random();
		vida = pVida + aleatorio.nextInt(1,21);
		ataque = pAtaque + aleatorio.nextInt(1,8);
		defensa = pDefensa + aleatorio.nextInt(1,5);
		numEvoluciones=pNumEvoluciones;
		evolucionesHechas=0;
		
		vidaParaEvol=vida/2;
		//vidaPrimeraEvol = vida/2;
		//vidaSegundaEvol = vida/5;
		
	}
	@Override
	public Pokemon clone() throws CloneNotSupportedException{
		Pokemon rdo = (Pokemon)super.clone();
		return rdo;
	}
	
	
	public void daAviso() 
	{
		setChanged();
		notifyObservers(new Object[] {nombre, vida, ataque, defensa, numPokemon, obtenerClase(), 0, evolucionesHechas});
		
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
		int tipoUpdate=1;
		int dano;
		if (esDebil(pTipo))
		{
			pAtaque = pAtaque * 2;
		}
		dano = (pAtaque - defensa);
		vida = vida - dano;
		if(vida < 0)
		{
			vida = 0;
		}
		else if ((vida<=vidaParaEvol && numEvoluciones!=0)) {
			evolucionar();
			tipoUpdate=2;
		}
		boolean vivo = estaVivo();
		setChanged();
		notifyObservers(new Object[] {nombre, vida, ataque, defensa, numPokemon, obtenerClase(), tipoUpdate, evolucionesHechas});
		return vivo;
	}
	
	private boolean esDebil(String pTipo) 
	{
		boolean bool = false;
		if (arrayDebilidades !=null)
		{
			bool = Stream.of(arrayDebilidades).anyMatch(tipo -> tipo.equals(pTipo));
		}
		return bool;
	}
	public int getAtaque(){ return ataque; }

	/*
	public int getDefensa() { return defensa; }
	*/
	public int getIdCombatiente(){ return idCombatiente; }
	
	public int getIdPokemon(){ return idPokemon; }
	
	public String getNombre() {return nombre;}
	
	public int getNumEvoluciones() {return numEvoluciones;}
	
	public int getDefensa() {return defensa;}
	
	public int getVida() {return vida;}
	
	public boolean estaVivo() {	return (vida>0); }
	
	public void setIdCombatiente(int pId){ idCombatiente = pId; }
	
	public void setIdPokemon(int pId){ idPokemon = pId;	}
	
	private void evolucionar() {
		if (numEvoluciones==0) {
			/*this.ataque+=5;
			this.defensa+=3;
			numEvoluciones--;
			vidaParaEvol=vidaParaEvol*2/5;
			System.out.println("EVOLUCIÓN 1");*/
		}
		else if (numEvoluciones==1) {
			if (evolucionesHechas==0) {
				this.ataque+=5;
				this.defensa+=3;
				numEvoluciones--;
				vidaParaEvol=vidaParaEvol*2/5;
				evolucionesHechas++;
				System.out.println("EVOLUCIÓN 1");
			}
			else if (evolucionesHechas==1) {
				this.ataque+=2;
				this.defensa+=2;
				numEvoluciones--;
				vidaParaEvol=vidaParaEvol*2/5;
				evolucionesHechas++;
				System.out.println("EVOLUCIÓN 2");
			}
			
		}
		else if (numEvoluciones==2) {
			if (evolucionesHechas==0) {
				this.ataque+=5;
				this.defensa+=3;
				numEvoluciones--;
				vidaParaEvol=vidaParaEvol*2/5;
				evolucionesHechas++;
				System.out.println("EVOLUCIÓN 1");
			}
		}
	}
	

	
}
