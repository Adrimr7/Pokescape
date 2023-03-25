import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

import java.util.Observable;
import java.util.Observer;
public class VentanaJugador extends JFrame implements Observer{

	private JPanel contentPane;
	private JPanel pokemons;
	
	/*
	private JPanel panelPokemon;
	private JLabel lblNombrePokemon;
	private JLabel lblSpritePokemon;
	private JProgressBar barraVida;
	private JPanel zonaAtaques;
	private JButton ataqueUno;
	private JButton ataqueDos;
	private JProgressBar progressBar_1;
	private JProgressBar progressBar_2;
	private JProgressBar progressBar_3;
	private JProgressBar progressBar_4;
	private JProgressBar progressBar_5;
	private JPanel panelEstadisticas;
	private JPanel panelNombresEstadisticas;
	private JPanel panelBarrasEstadisticas;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JPanel zonaNombreTipo;
	private JLabel lblTipo;
	*/


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJugador frame = new VentanaJugador("Jugador");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	//Create the frame.

	public VentanaJugador(String nomVentana) {
		
		// GUIA (12)
		// GUIA : Pues aqui estamos, creando una pantalla para mostrar nuesto luchador y nuestros pokemon (-es a sujerecia de A.)
		
		setTitle(nomVentana);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// GUIA : Esta pequeña variable, todavia sin colocar correctamente, se usa para ajustar el largo de la venta, no ocupan los mismo un pokemon que tres, al igual que no ocupa lo mismo un wailorde que tu ...
		
		//Cambiando esta variable cambia el tamaño de la ventana para cuadrar los pokemon
		int numPokemon = 4;
		//-------------------------------------------------------------------------------
		setBounds(100, 100, 155*numPokemon + 155, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel_1(), BorderLayout.CENTER);

		JPanel personaje = new JPanel();
		contentPane.add(personaje, BorderLayout.WEST);
		personaje.setLayout(new BoxLayout(personaje, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("Japupp10");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		personaje.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		URL url;
		Icon imageIcon;
		url = this.getClass().getResource("201-a.png");
		imageIcon = new ImageIcon(url);
		lblNewLabel_1.setIcon(imageIcon);
		personaje.add(lblNewLabel_1);
		
		// GUIA : Tras definir los diferentes apartados, el nombre, la imagen del jugador, el panel donde estaran los pokemon... empieza otra fiesta
		// GUIA : La fiesta de pasar los datos de los pokemon a su respectivo lugar
	}
	
	private JPanel getPanel_1() {
		if (pokemons == null) {
			pokemons = new JPanel();
			pokemons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			// GUIA : Como podemos ver el panel pokemon esta vacio, cosa que cambiara en un futuro cercano
			
			// ESPECTADOR : Porque?
			
			// GUIA : Buena pregunta espectador promedio
			
		}
		return pokemons;
	}


	@Override
	public void update(Observable o, Object arg) 
	{
		
		// GUIA : En este apartado deberia estar la creacion de los diferentes paneles de cada pokemon
		// GUIA : Estos paneles son de JPokemon, una clase expecial que implementa el JPanel y que debera generar  
		
		// GUIA : Al igual que con el notifyObservers de Pokescape, el notifyObservers de cada Combatiente hara saltar el update de su respectiva ventana jugador
		// GUIA : Entonces es cuando sucede la magia, cada ventanaJugador accedera a su correspondiente Combatiente a traves de ListaCombatienes
		// GUIA : y generara tantos JPokemon como Pokemon tenga cada Combatiente
		
		// GUIA : A la vez, ira asigando cada JPokemon como Observer de su correspondiente Pokemon, y entonces todo estar enlazado.
		// GUIA : Cada pokemon con su JPokemon y cada Combatiente con su VentanaJugador.
		
		// GUIA : Tras esto volveremos a ventanaInicio y la cerraremos, quedando unicamente ventanasJugador aparentemente vacias.
		
		// GUIA : En este momento, entra en juego una secuencia de notifyObservers y updates.
		
		// GUIA : 
		//		Paso 1:
		//					Cerrar ventanaInicio
		
		//		Paso 2:		
		//					Recorrer cada Combatiente para que mediante notifyObservers y updates pase su respectiva ventana el numero de pokemon, su nombre ...
		
		//		Paso 3:
		//					Recorrer cada Pokemon de cada Combatiente para que mediante notifyObservers y updates para toda la informacion del pokemon
		//					y asi rellenar las ventanas vacias
		//
		//		Paso 4:
		//					De vuelta en Pokescape, el combate comienza
		
		// GUIA : Y con esto acaba el tour, ya se que es una pena que solo llegue hasta el inicio del combate pero prometo que nos veremos mas adelantes
		
		// GUIA : *susurra* para cualquier donacion se agradece un bizum al 688892016
		
		
		
		//pokemons.add(new JPokemon(151, "Mew", "Psíquico", 200, 50));
		//pokemons.add(new JPokemon(348, "Makuhita", "Lucha", 250, 100));
		//pokemons.add(new JPokemon(591, "Amongus", "Hierba", 100, 200));
		//pokemons.add(new JPokemon(222, "Corsola", "Agua", 10, 5));
		
		// hace un bucle con el numero de pokemon y va generando los siguientes pokemon
		// pokemon vacios y les añade el que es el observer de cada pokemon.
		// luego mas adelante 
		
		
		
		if (o instanceof Combatiente)
		{
			// GUIA : Y despues de comprobar que lo que ha recibido es de Pokescape
			if (arg instanceof Object[])
			{
				// GUIA : Y que es la informacion que nos interesa, se pone manos a la obra
				// GUIA : Lo primero es tener bien repartiditos los datos
				Object[] lista = (Object[]) arg;
				int numPoke = (int) lista[0];
				int numComb = (int) lista[1];
				
				setBounds(100, 100, 155*numPoke + 155, 240);
				
				
				// GUIA : Y lo segundo usarlos para algo
				// GUIA : Como ya sabeis tenemos todos los pokemon en cada Jugador
				// GUIA : Entonces vamos a crear los diferentes jpokemon para los combatientes
				for (int i = 0; i < numPoke; i++)
				{
					
					
					
					JPokemon poketoMonsta = new JPokemon();
					// GUIA : Una vez creados hacemos que estos Jpokemon observen a sus respectivos pokemon de su combatiente
					ListaCombatientes.getMiListaCombatientes().getCombatiente(numComb).getPokemon(i).addObserver(poketoMonsta);
					
					// GUIA : Y lo añadimos a la ventana actual
					pokemons.add(poketoMonsta);
						
				}
	
			}
		}
		
		
	}
	

	/*
	
	private JPanel getPanelPokemon() {
		if (panelPokemon == null) {
			panelPokemon = new JPanel();
			panelPokemon.setLayout(new BoxLayout(panelPokemon, BoxLayout.Y_AXIS));
			panelPokemon.add(getZonaNombreTipo());
			panelPokemon.add(getLblSpritePokemon());
			panelPokemon.add(getBarraVida());
			panelPokemon.add(getZonaAtaques());
			panelPokemon.add(getPanelEstadisticas());
		}
		return panelPokemon;
	}
	private JLabel getLblNombrePokemon() {
		if (lblNombrePokemon == null) {
			lblNombrePokemon = new JLabel("Haxorus");
			//lblNewLabel.setPreferredSize(new Dimension(20, 30));
			lblNombrePokemon.setAlignmentX(panelPokemon.CENTER_ALIGNMENT);
		}
		return lblNombrePokemon;
	}
	private JLabel getLblSpritePokemon() {
		if (lblSpritePokemon == null) {
			lblSpritePokemon = new JLabel("Haxorus.png");
			URL url = this.getClass().getResource("haxorus.png");
			Icon imageIcon = new ImageIcon(url);
			lblSpritePokemon = new JLabel();
			lblSpritePokemon.setIcon(imageIcon);
			lblSpritePokemon.setAlignmentX(panelPokemon.CENTER_ALIGNMENT);
		}
		return lblSpritePokemon;
	}
	private JProgressBar getBarraVida() {
		if (barraVida == null) {
			barraVida = new JProgressBar();
			barraVida.setBackground(new Color(128, 255, 0));
			barraVida.setForeground(new Color(128, 255, 0));
			barraVida.setValue(100);
		}
		return barraVida;
	}
	private JPanel getZonaAtaques() {
		if (zonaAtaques == null) {
			zonaAtaques = new JPanel();
			zonaAtaques.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			zonaAtaques.add(getAtaqueUno());
			zonaAtaques.add(getAtaqueDos());
		}
		return zonaAtaques;
	}
	private JButton getAtaqueUno() {
		if (ataqueUno == null) {
			ataqueUno = new JButton("Ataque1");
		}
		return ataqueUno;
	}
	private JButton getAtaqueDos() {
		if (ataqueDos == null) {
			ataqueDos = new JButton("Ataque2");
		}
		return ataqueDos;
	}
	private JProgressBar getProgressBar_1() {
		if (progressBar_1 == null) {
			progressBar_1 = new JProgressBar();
			progressBar_1.setValue(57);
			progressBar_1.setForeground(new Color(255, 0, 0));
		}
		return progressBar_1;
	}
	private JProgressBar getProgressBar_2() {
		if (progressBar_2 == null) {
			progressBar_2 = new JProgressBar();
			progressBar_2.setValue(35);
		}
		return progressBar_2;
	}
	private JProgressBar getProgressBar_3() {
		if (progressBar_3 == null) {
			progressBar_3 = new JProgressBar();
			progressBar_3.setValue(38);
		}
		return progressBar_3;
	}
	private JProgressBar getProgressBar_4() {
		if (progressBar_4 == null) {
			progressBar_4 = new JProgressBar();
			progressBar_4.setValue(23);
		}
		return progressBar_4;
	}
	private JProgressBar getProgressBar_5() {
		if (progressBar_5 == null) {
			progressBar_5 = new JProgressBar();
			progressBar_5.setValue(27);
		}
		return progressBar_5;
	}
	private JPanel getPanelEstadisticas() {
		if (panelEstadisticas == null) {
			panelEstadisticas = new JPanel();
			panelEstadisticas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelEstadisticas.add(getPanelNombresEstadisticas());
			panelEstadisticas.add(getPanelBarrasEstadisticas());
		}
		return panelEstadisticas;
	}
	private JPanel getPanelNombresEstadisticas() {
		if (panelNombresEstadisticas == null) {
			panelNombresEstadisticas = new JPanel();
			panelNombresEstadisticas.setLayout(new GridLayout(5, 1, 0, 0));
			panelNombresEstadisticas.add(getLblNewLabel_2());
			panelNombresEstadisticas.add(getLblNewLabel_3());
			panelNombresEstadisticas.add(getLblNewLabel_4());
			panelNombresEstadisticas.add(getLblNewLabel_5());
			panelNombresEstadisticas.add(getLblNewLabel_6());
		}
		return panelNombresEstadisticas;
	}
	private JPanel getPanelBarrasEstadisticas() {
		if (panelBarrasEstadisticas == null) {
			panelBarrasEstadisticas = new JPanel();
			panelBarrasEstadisticas.setLayout(new GridLayout(5, 1, 0, 0));
			panelBarrasEstadisticas.add(getProgressBar_1());
			panelBarrasEstadisticas.add(getProgressBar_2());
			panelBarrasEstadisticas.add(getProgressBar_3());
			panelBarrasEstadisticas.add(getProgressBar_4());
			panelBarrasEstadisticas.add(getProgressBar_5());
		}
		return panelBarrasEstadisticas;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Ata.");
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Def.");
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Vel.");
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("Ata.E.");
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("Def.E.");
		}
		return lblNewLabel_6;
	}
	private JPanel getZonaNombreTipo() {
		if (zonaNombreTipo == null) {
			zonaNombreTipo = new JPanel();
			zonaNombreTipo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			zonaNombreTipo.add(getLblNombrePokemon());
			zonaNombreTipo.add(getLblTipo());
		}
		return zonaNombreTipo;
	}
	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel();
			URL url = this.getClass().getResource("Dragon.png");
			Icon imageIcon = new ImageIcon(url);
			lblTipo.setIcon(imageIcon);
		}
		return lblTipo;
	}

	
	*/

	/*
	//Creador de pokemionnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
	private JPanel getNuevoPokemonOriginal(int pNumPokemon, String pNombrePokemon, String pTipo1, String pTipo2, String pAtaque1, String pAtaque2, int pAtaque, int pAtaqueE, int pDefensa,  int pDefensaE,  int pVelocidad)
	{
		
		//Variables para añadir fotos
		URL url;
		Icon imageIcon;
		
		
		// Panel general pokemon
		JPanel pokemon = new JPanel();
		pokemon.setLayout(new BoxLayout(pokemon, BoxLayout.Y_AXIS));
		
			// Panel cabezera : Nombre / Tipo1 / Tipo2 //////////////////////////////////////////////////
			JPanel zonaNombrePokemon = new JPanel();
			zonaNombrePokemon.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
				// Nombre
				JLabel nombrePokemon = new JLabel(pNombrePokemon);
				nombrePokemon.setAlignmentX(pokemon.CENTER_ALIGNMENT);
				zonaNombrePokemon.add(nombrePokemon);
				
				
				// Tipo1
				JLabel tipo1 = new JLabel();
				url = this.getClass().getResource(pTipo1 + ".png");
				imageIcon = new ImageIcon(url);
				tipo1.setIcon(imageIcon);
				zonaNombrePokemon.add(tipo1);
				
				
				// Tipo2
				if(pTipo2 != null) 
				{
					JLabel tipo2 = new JLabel();
					url = this.getClass().getResource(pTipo2 + ".png");
					imageIcon = new ImageIcon(url);
					tipo2.setIcon(imageIcon);
					zonaNombrePokemon.add(tipo2);
				}
				
		pokemon.add(zonaNombrePokemon);
		
		
			// Imagen pokemon //////////////////////////////////////////////////////////////////////////		
			JLabel spritePokemon = new JLabel();
			url = this.getClass().getResource(pNumPokemon + ".png");
			imageIcon = new ImageIcon(url);
			spritePokemon.setIcon(imageIcon);
			spritePokemon.setAlignmentX(pokemon.CENTER_ALIGNMENT);
		
		pokemon.add(spritePokemon);
		
			
			// Barra Vida //////////////////////////////////////////////////////////////////////////	
			JProgressBar barraHp = new JProgressBar();
			//barraHp.setBackground(new Color(128, 255, 0));
			barraHp.setForeground(new Color(128, 255, 0));
			barraHp.setValue(100);
			
		pokemon.add(barraHp);
			
			
			// Zona Ataques //////////////////////////////////////////////////////////////////////////	
			JPanel zonaAtak = new JPanel();
			zonaAtak.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			
				// Ataque 1
				JButton atak1 = new JButton(pAtaque1);
				zonaAtak.add(atak1);
			
				
				// Ataque 2
				JButton atak2 = new JButton(pAtaque2);
				zonaAtak.add(atak2);
			
		pokemon.add(zonaAtak);
				
			
			// Zona Estadisticas //////////////////////////////////////////////////////////////////////////

			JPanel estadisticas = new JPanel();
			estadisticas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			
				// Zona Nombres Estadisticas
				JPanel panelNombresEstats = new JPanel();
				panelNombresEstats.setLayout(new GridLayout(5, 1, 0, 0));
				
				panelNombresEstats.add(new JLabel("Ata."));
				panelNombresEstats.add(new JLabel("Ata.E."));
				panelNombresEstats.add(new JLabel("Def."));
				panelNombresEstats.add(new JLabel("Def.E."));
				panelNombresEstats.add(new JLabel("Spe."));
			
			estadisticas.add(panelNombresEstats);
			
				JPanel panelBarrasEstats = new JPanel();
				panelBarrasEstats.setLayout(new GridLayout(5, 1, 0, 0));
				
					panelBarrasEstats.add(barraEstatt(pAtaque, new Color(255, 255, 0)));
					panelBarrasEstats.add(barraEstatt(pAtaqueE, new Color(255, 255, 0)));
					panelBarrasEstats.add(barraEstatt(pDefensa, new Color(255, 255, 0)));
					panelBarrasEstats.add(barraEstatt(pDefensaE, new Color(255, 255, 0)));
					panelBarrasEstats.add(barraEstatt(pVelocidad, new Color(255, 255, 0)));

				estadisticas.add(panelBarrasEstats);
			
			
		pokemon.add(estadisticas);
		
		
		return pokemon;
		
	}
	*/
	
	/*

	//Creador de pokemionnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
	private JPanel getNuevoPokemon(int pNumPokemon, String pNombrePokemon, String pTipo1, int pAtaque, int pDefensa)
	{
		
		//Variables para añadir fotos
		URL url;
		Icon imageIcon;
		
		
		// Panel general pokemon
		JPanel pokemon = new JPanel();
		pokemon.setPreferredSize(new Dimension(155, 240));
		pokemon.setMaximumSize(new Dimension(155, 240));
		pokemon.setLayout(new BoxLayout(pokemon, BoxLayout.Y_AXIS));
		
			// Panel cabezera : Nombre / Tipo1 / Tipo2 //////////////////////////////////////////////////
			JPanel zonaNombrePokemon = new JPanel();
			zonaNombrePokemon.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
				// Nombre
				JLabel nombrePokemon = new JLabel(pNombrePokemon);
				nombrePokemon.setAlignmentX(pokemon.CENTER_ALIGNMENT);
				zonaNombrePokemon.add(nombrePokemon);
				
				
				// Tipo1
				JLabel tipo1 = new JLabel();
				url = this.getClass().getResource(pTipo1 + ".png");
				imageIcon = new ImageIcon(url);
				tipo1.setIcon(imageIcon);
				zonaNombrePokemon.add(tipo1);
				
				
		pokemon.add(zonaNombrePokemon);
		
		
			// Imagen pokemon //////////////////////////////////////////////////////////////////////////		
			JLabel spritePokemon = new JLabel();
			url = this.getClass().getResource(pNumPokemon + ".png");
			imageIcon = new ImageIcon(url);
			spritePokemon.setIcon(imageIcon);
			spritePokemon.setAlignmentX(pokemon.CENTER_ALIGNMENT);
		
		pokemon.add(spritePokemon);
		
			
			// Barra Vida //////////////////////////////////////////////////////////////////////////	
			JProgressBar barraHp = new JProgressBar();
			//barraHp.setBackground(new Color(128, 255, 0));
			barraHp.setForeground(new Color(128, 255, 0));
			barraHp.setValue(100);
			barraHp.setPreferredSize(new Dimension(150, 14));
			barraHp.setMaximumSize(new Dimension(150, 14));
			
		pokemon.add(barraHp);
				
			
			// Zona Estadisticas //////////////////////////////////////////////////////////////////////////

			JPanel estadisticas = new JPanel();
			estadisticas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			
				// Zona Nombres Estadisticas
				JPanel panelNombresEstats = new JPanel();
				panelNombresEstats.setLayout(new GridLayout(5, 1, 0, 0));
				
				panelNombresEstats.add(new JLabel("Ata."));
				//panelNombresEstats.add(new JLabel("Ata.E."));
				panelNombresEstats.add(new JLabel("Def."));
				//panelNombresEstats.add(new JLabel("Def.E."));
				//panelNombresEstats.add(new JLabel("Spe."));
			
			estadisticas.add(panelNombresEstats);
			
				JPanel panelBarrasEstats = new JPanel();
				panelBarrasEstats.setLayout(new GridLayout(5, 1, 0, 0));
				
					panelBarrasEstats.add(barraEstatt(pAtaque, new Color(255, 255, 0)));
					//panelBarrasEstats.add(barraEstatt(pAtaqueE, new Color(255, 255, 0)));
					panelBarrasEstats.add(barraEstatt(pDefensa, new Color(255, 255, 0)));
					//panelBarrasEstats.add(barraEstatt(pDefensaE, new Color(255, 255, 0)));
					//panelBarrasEstats.add(barraEstatt(pVelocidad, new Color(255, 255, 0)));

				estadisticas.add(panelBarrasEstats);
			
			
		pokemon.add(estadisticas);
		
		return pokemon;	
	}
	
	private JProgressBar barraEstatt(int stat, Color color) 
	{
		JProgressBar barra = new JProgressBar();
		barra.setValue((int) (stat*100/255));
		barra.setForeground(color);
		barra.setPreferredSize(new Dimension(120, 14));
		barra.setMaximumSize(new Dimension(120, 14));
		
		return barra;
	}
	*/
}
