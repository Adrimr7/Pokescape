import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import VentanaInicio.ControladorInicio;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class VentanaJugador extends JFrame implements Observer
{

	private JPanel contentPane;
	private JPanel pokemons;
	private ArrayList<JPokemon> jpoke;
	private JLabel foto;
	private int idCombee;
	private JLabel lblNewLabel;
	private JLabel lblTurno;
	private boolean turno;

	public VentanaJugador(String nomVentana) {
		
		// Se crea una pantalla para mostrar nuesto luchador y nuestros pokemon 
		
		setTitle(nomVentana);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Esta variable, se usa para ajustar el largo de la venta, no ocupan los mismo un pokemon que tres
		// Cambiando esta variable cambia el tamaño de la ventana para cuadrar los pokemon
		int numPokemon = 4;

		setBounds(100, 100, 170*numPokemon + 155, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		contentPane.setBackground(new Color(220, 247, 255));
		contentPane.setOpaque(true);

		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel_1(), BorderLayout.CENTER);

		JPanel personaje = new JPanel();
		personaje.setOpaque(false);
		contentPane.add(personaje, BorderLayout.WEST);
		personaje.setLayout(new BoxLayout(personaje, BoxLayout.Y_AXIS));
		
		
		lblNewLabel = new JLabel("Unown Promedio");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		personaje.add(lblNewLabel);
		
		foto = new JLabel("");
		URL url;
		Icon imageIcon;
		url = this.getClass().getResource("201-a.png");
		imageIcon = new ImageIcon(url);
		foto.setIcon(imageIcon);
		personaje.add(foto);
	
		lblTurno = new JLabel("  Wait ", SwingConstants.CENTER);
		lblTurno.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurno.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTurno.setForeground(new Color(200, 247, 255));
		
		ControladorJugador cj = new ControladorJugador();
		lblTurno.addMouseListener(cj);
		
		personaje.add(lblTurno);
		
		
		// Tras definir los diferentes apartados, el nombre, la imagen del jugador, el panel donde estaran los pokemon...
		// Pasar los datos de los pokemon a su respectivo lugar
	}
	
	private JPanel getPanel_1() {
		if (pokemons == null) {
			pokemons = new JPanel();
			pokemons.setOpaque(false);
			pokemons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			// Como podemos ver el panel pokemon esta vacio
			
		}
		return pokemons;
	}


	@Override
	public void update(Observable o, Object arg) 
	{
		
		// En este apartado deberia estar la creacion de los diferentes paneles de cada pokemon
		// Estos paneles son de JPokemon, una clase expecial que implementa el JPanel y que debera generar  
		
		// Al igual que con el notifyObservers de Pokescape, el notifyObservers de cada Combatiente hara saltar el update de su respectiva ventana jugador
		// Entonces es cuando sucede la magia, cada ventanaJugador accedera a su correspondiente Combatiente a traves de listaCombatienes
		// y generara tantos JPokemon como Pokemon tenga cada Combatiente
		
		// A la vez, ira asigando cada JPokemon como Observer de su correspondiente Pokemon, y entonces todo estar enlazado.
		// Cada pokemon con su JPokemon y cada Combatiente con su VentanaJugador.
		
		// Tras esto volveremos a ventanaInicio y la cerraremos, quedando unicamente ventanasJugador aparentemente vacias.
		
		// En este momento, entra en juego una secuencia de notifyObservers y updates.
		
		//
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

		
		if (o instanceof Combatiente)
		{
			// Despues de comprobar que lo que ha recibido es de Pokescape
			if (arg instanceof Object[])
			{
				// Y que es la informacion que nos interesa, se pone manos a la obra
				// Lo primero es tener bien repartidos los datos
				Object[] lista = (Object[]) arg;
				
				int codigo = (int) lista[0];
				
				if(codigo == 0) 
				{
					
					int numComb = (int) lista[1];
					String nombre = (String) lista[2];
					int numPoke = (int) lista[3];
					idCombee = (int) lista[4];
					
				
					setTitle(nombre);
					setBounds(100, 100, 155*numPoke + 155, 300);
					
					String nom = "Spr_B2W2_";
					String bre = "";
					ArrayList<String> listaImagenes = new ArrayList<String>();
					listaImagenes.add("Ace_Trainer_M");
					listaImagenes.add("Alder");
					listaImagenes.add("Artist");
					listaImagenes.add("Backpacker_M");
					listaImagenes.add("Benga");
					listaImagenes.add("Biker");
					listaImagenes.add("Black_Belt");
					listaImagenes.add("Blaine");
					listaImagenes.add("Brawly");
					listaImagenes.add("Brock");
					listaImagenes.add("Brycen");
					listaImagenes.add("Bugsy");
					listaImagenes.add("Burgh");
					listaImagenes.add("Byron");
					listaImagenes.add("Cheren");
					listaImagenes.add("Chili");
					listaImagenes.add("Chuck");
					listaImagenes.add("Cilan");
					listaImagenes.add("Clay");
					listaImagenes.add("Clerk_M");
					listaImagenes.add("Clerk_M_B");
					listaImagenes.add("Colress");
					listaImagenes.add("Crasher_Wake");
					listaImagenes.add("Cyclist_M");
					listaImagenes.add("Dancer");
					listaImagenes.add("Depot_Agent");
					listaImagenes.add("Doctor");
					listaImagenes.add("Drayden");
					listaImagenes.add("Emmet");
					listaImagenes.add("Falkner");
					listaImagenes.add("Fisherman");
					listaImagenes.add("Gentleman");
					
					listaImagenes.add("Veteran_M");
					listaImagenes.add("Janitor");
					
					Random rd = new Random();
					int numeroFoto = rd.nextInt(0, listaImagenes.size());
					bre = listaImagenes.get(numeroFoto);
					
					String nomBre = nom + bre;
					if (bre.length()>7) {setBounds(100, 100, 170*numPoke + 155 + (7*bre.length()-4), 300);}
					if (nombre.contains("Humano"))
					{
						lblNewLabel.setText(bre + " (Humano)");
						
					}
					else
					{
						lblNewLabel.setText(bre + " (NPC)");
					}
					
					URL url = this.getClass().getResource(nomBre + ".png");
					Icon imageIcon = new ImageIcon(url);
					foto.setIcon(imageIcon);
						
						
					// GUIA : Y lo segundo usarlos para algo
					// GUIA : Como ya sabeis tenemos todos los pokemon en cada Jugador
					// GUIA : Entonces vamos a crear los diferentes jpokemon para los combatientes

					jpoke = new ArrayList<JPokemon>();
					for (int i = 0; i < numPoke; i++)
					{
						JPokemon poketoMonsta = new JPokemon();
						// Una vez creados hacemos que estos Jpokemon observen a sus respectivos pokemon de su combatiente
						ListaCombatientes.getMilistaCombatientes().getCombatiente(numComb).getPokemon(i).addObserver(poketoMonsta);
						
						// Y lo añadimos a la ventana actual
						pokemons.add(poketoMonsta);
						
						ControladorJugador cj = new ControladorJugador();
						poketoMonsta.addMouseListener(cj);
						
						jpoke.add(poketoMonsta);
					}
				} 
				else if(codigo == 1) 
				{
					lblTurno.setText("GO!!");
					turno = true;
								
					
					contentPane.setBackground(new Color(200, 247, 255));
					lblTurno.setForeground(new Color(99, 91, 255));
					
				}
				else if(codigo == 2) 
				{
					//Fin turno

					turno = false;
					lblTurno.setText("Wait");
					contentPane.setBackground(new Color(220, 247, 255));
					lblTurno.setForeground(new Color(200, 247, 255));

				}
				
				else if(codigo == 3) 
				{
					this.setVisible(false);
				}
				
				else if(codigo == 4) 
				{
					lblTurno.setText("Fin");
					this.setTitle("Ganador");
				}
			}
		}
	}
	

	private class ControladorJugador implements MouseListener 
	{
	
		public ControladorJugador() {}

		@Override
		public void mouseClicked(MouseEvent e) 
		{
			
			if(e.getSource() == lblTurno && turno) 
			{
				ListaCombatientes.getMilistaCombatientes().getCombatiente(idCombee).clickGo();
			}
			else if(e.getSource() != lblTurno)
			{
				ListaCombatientes.getMilistaCombatientes().seleccionado(idCombee, jpoke.indexOf(e.getSource()));
			}
			
			
		}


		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
	
		}


		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}