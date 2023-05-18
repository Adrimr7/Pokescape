import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;


public class VentanaInicio extends JFrame implements Observer{

	private JPanel contentPane;
	private JPanel Imagen;
	private JPanel Botones;
	private static JTextField textFieldBots;
	private static JTextField textFieldJugadores;
	private static JTextField textFieldPokemons;
	private static JButton btnNewButton;
	private static JButton btnNewButton2;
	private static JButton btnNewButton3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	
	private VentanaJugador[] listaVentanas;

	public VentanaInicio() {
		
		// GUIA (3)
		// GUIA : Muy bien, como podeis ver nos encontramos en la constructora
		// GUIA : Esta preciosidad se encarga de darle forma a la ventana que veremos y la hace "agradable" a la vista
		// GUIA : No son entretendremos mucho pero haremos una breve explicacion
		
		// GUIA : Aqui definimos el titulo de la ventana, el nombre que sale arriba
		setTitle("Pokescape");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// GUIA : Gracias a esta funcion podemos darle el tamaño adecuado
		setBounds(100, 100, 730, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		// GUIA : En estas tres siguientes preparamos la disposicion, es decir, donde ira cada cosa
		contentPane.setLayout(new BorderLayout(0, 0));
		// GUIA : A la izquierda el titulo del juego
		contentPane.add(getImagen(), BorderLayout.CENTER);
		// GUIA : Y a la derecha los botones
		contentPane.add(getBotones(), BorderLayout.EAST);
		// GUIA : Hablando de botones, vamos a ir a la funcion "getBtnNewButton" para ver como funcionan
		// GUIA : Siganme ...
	}

	private JPanel getImagen() {
		if (Imagen == null) {
			Imagen = new JPanel();
			Imagen.setLayout(new BoxLayout(Imagen, BoxLayout.Y_AXIS));
			Imagen.add(getPanel());
			Imagen.add(getPanel_1());
		}
		return Imagen;
	}
	private JPanel getBotones() {
		if (Botones == null) {
			Botones = new JPanel();
			Botones.setLayout(new BoxLayout(Botones, BoxLayout.Y_AXIS));
			Botones.add(getLblLabelBots());
			Botones.add(getTextBots());
			Botones.add(getLblLabelJugadores());
			Botones.add(getTextJugadores());
			Botones.add(getLblLabelPokemons());
			Botones.add(getTextPokemons());
			Botones.add(getBtnNewButton());
			Botones.add(getBtnNewButton2());
			Botones.add(getBtnNewButton3());
			Botones.add(new JLabel("¿Necesitas ayuda?"));
			Botones.add(new JLabel("Habla con stunkfisk"));
			Botones.add(getLblNewLabel());
		}
		return Botones;
	}
	private JTextField getTextBots() {
		if (textFieldBots == null) {
			textFieldBots = new JTextField();
			textFieldBots.setColumns(10);
			textFieldBots.setText("2");
		}
		return textFieldBots;
	}
	private JTextField getTextJugadores() {
		if (textFieldJugadores == null) {
			textFieldJugadores = new JTextField();
			textFieldJugadores.setColumns(10);
			textFieldJugadores.setText("1");
		}
		return textFieldJugadores;
	}
	private JTextField getTextPokemons() {
		if (textFieldPokemons == null) {
			textFieldPokemons = new JTextField();
			textFieldPokemons.setColumns(10);
			textFieldPokemons.setText("3");
		}
		return textFieldPokemons;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) 
		{
			btnNewButton = new JButton("Jugar Nivel Fácil");
		}
		btnNewButton.addActionListener(ControladorInicio.getControladorInicio());
		return btnNewButton;
		
		// GUIA (4)
		// GUIA : Bien, como podemos ver, añadirmos al boton un "actionListener", que aunque suene raro es facil de entender
		// GUIA : Es como una señora de un pequeño pueblo que se sienta al lado de la ventana del primer piso que da a la plaza del pueblo
		// GUIA : Es decir, se entera de todo lo que pasa, en este caso se entera de si alguien ha pulsado el boton.
		// GUIA : En este caso la vieja seria "ControladorInicio" que sera la proxima clase que investigaremos. Es facil de encontrar por que este definida en esta misma clase
		// GUIA : Siganme...
		
	}
	
	private JButton getBtnNewButton2() {
		if (btnNewButton2 == null) 
		{
			btnNewButton2 = new JButton("Jugar Nivel Medio");
		}
		btnNewButton2.addActionListener(ControladorInicio.getControladorInicio());
		return btnNewButton2;
	}
	
	private JButton getBtnNewButton3() {
		if (btnNewButton3 == null) 
		{
			btnNewButton3 = new JButton("Jugar Nivel Difícil");
		}
		btnNewButton3.addActionListener(ControladorInicio.getControladorInicio());
		return btnNewButton3;
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel();
			URL url;
			Icon imageIcon;
			url = this.getClass().getResource("618.png");
			imageIcon = new ImageIcon(url);
			lblNewLabel.setIcon(imageIcon);
			lblNewLabel.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseClicked(MouseEvent e) 
				{
					 Object[] opciones = {"Entendido maestro Stunfisk"};
					 int n = JOptionPane.showOptionDialog(null,
							 "Stunfisk <._.> \n \n"
										+ "      ·  Escoge cuantos pokemon usarás, el número de bots y jugadores, y un nivel adecuado para ti \n\n"
										+ "      ·  Cuando el combate comience, espera tu turno y ataca con sabiduria. \n\n"
										+ "      ·  Con solo tocar un pokemon, se prepara para atacar, y el siguiente será su objetivo. \n\n"
										+ "      ·  Pero ten cuidado con tus ataques, no vayas a despertar la furia de un contrincante. \n\n"
										+ "      ·  Ten paciencia y aprende las debilidades de tu enemigo, por que como un dia un Stunfisk de \n"
										+ "         Galar dijo : \n\n"
										+ "                'Conoce a tu oponente, conócete a ti mismo y no pondrás en peligro tu victoria'\n"
										+ "                                                                                                             - Stunfisk de Galar\n ",
										"Stunfisk <._.>", 
					      JOptionPane.OK_OPTION,
					      JOptionPane.PLAIN_MESSAGE,
					      null,
					      opciones,
					      opciones[0]);
					 
					
				}
			}
										);
		}
		return lblNewLabel;
	}
	private JLabel getLblLabelBots() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Nº Bots");
		}
		return lblNewLabel_1;
	}
	private JLabel getLblLabelJugadores() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Nº Jugadores");
		}
		return lblNewLabel_2;
	}
	private JLabel getLblLabelPokemons() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Nº Pokemon");
		}
		return lblNewLabel_3;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel.add(getLblNewLabel_4());
			panel.add(getLblNewLabel_5());
			panel.add(getLblNewLabel_6());
			panel.add(getLblNewLabel_7());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_1.add(getLblNewLabel_8());
			panel_1.add(getLblNewLabel_9());
			panel_1.add(getLblNewLabel_10());
			panel_1.add(getLblNewLabel_11());
			panel_1.add(getLblNewLabel_12());
		}
		return panel_1;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
			URL url;
			Icon imageIcon;
			url = this.getClass().getResource("201-p.png");
			imageIcon = new ImageIcon(url);
			lblNewLabel_4.setIcon(imageIcon);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("");
			URL url;
			Icon imageIcon;
			url = this.getClass().getResource("201-o.png");
			imageIcon = new ImageIcon(url);
			lblNewLabel_5.setIcon(imageIcon);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("");
			URL url;
			Icon imageIcon;
			url = this.getClass().getResource("201-k.png");
			imageIcon = new ImageIcon(url);
			lblNewLabel_6.setIcon(imageIcon);
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("");
			URL url;
			Icon imageIcon;
			url = this.getClass().getResource("201-e.png");
			imageIcon = new ImageIcon(url);
			lblNewLabel_7.setIcon(imageIcon);
		}
		return lblNewLabel_7;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("");
			URL url;
			Icon imageIcon;
			url = this.getClass().getResource("201-s.png");
			imageIcon = new ImageIcon(url);
			lblNewLabel_8.setIcon(imageIcon);
		}
		return lblNewLabel_8;
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("");
			URL url;
			Icon imageIcon;
			url = this.getClass().getResource("201-c.png");
			imageIcon = new ImageIcon(url);
			lblNewLabel_9.setIcon(imageIcon);
		}
		return lblNewLabel_9;
	}
	private JLabel getLblNewLabel_10() {
		if (lblNewLabel_10 == null) {
			lblNewLabel_10 = new JLabel("");
			URL url;
			Icon imageIcon;
			url = this.getClass().getResource("201-a.png");
			imageIcon = new ImageIcon(url);
			lblNewLabel_10.setIcon(imageIcon);
		}
		return lblNewLabel_10;
	}
	private JLabel getLblNewLabel_11() {
		if (lblNewLabel_11 == null) {
			lblNewLabel_11 = new JLabel("");
			URL url;
			Icon imageIcon;
			url = this.getClass().getResource("201-p.png");
			imageIcon = new ImageIcon(url);
			lblNewLabel_11.setIcon(imageIcon);
		}
		return lblNewLabel_11;
	}
	private JLabel getLblNewLabel_12() {
		if (lblNewLabel_12 == null) {
			lblNewLabel_12 = new JLabel("");
			URL url;
			Icon imageIcon;
			url = this.getClass().getResource("201-e.png");
			imageIcon = new ImageIcon(url);
			lblNewLabel_12.setIcon(imageIcon);
		}
		return lblNewLabel_12;
	}
		static private class ControladorInicio implements ActionListener 
		{
			// Pues aqui estamos, en una MAE definida dentro de VentanaInicio 
			private static ControladorInicio miControladorInicio;
		
			private ControladorInicio() {}
		
			// Como hemos visto antes lo que añade como ActionListener es esta clase, que como se ve en la cabecera lo implementa
			public static ControladorInicio getControladorInicio()
			{
				if(miControladorInicio == null) 
				{
					miControladorInicio = new ControladorInicio();
				}
				return miControladorInicio;
			}
			
			// Pero la parte interesante esta aqui
			// En actionPerformed, este metodo propio de ActionListener lo mas parecido a la abuela del pueblo
			// Si antes hemos colocado a la vieja al lado de la plaza, este metodo hace que en cuanto note algo deje el periodico y se ponga a escuchar
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				int nivel=1;
				if (e.getSource().equals(btnNewButton))
				{nivel=1;}
				else if (e.getSource().equals(btnNewButton2))
				{nivel=2;}
				else if (e.getSource().equals(btnNewButton3))
				{nivel=3;}
					// Y si es aquello que nos interesa, en este caso el boton se poner a pedir informacion
					// El objetivo del listener en este caso es que si se le da al boton, avise al modelo, en este caso a Pokescape para que comience el juego.
					
					// Estos tres datos son los que nos interesa entonces se los guarda
					String strb = textFieldBots.getText();
					String strj = textFieldJugadores.getText();
					String strp = textFieldPokemons.getText();
					int numb = Integer.parseInt(strb);
					int numj = Integer.parseInt(strj);
					int nump = Integer.parseInt(strp);
					System.out.println(numb + " " + numj + " " + nump);
					if (numb>10 || numj>10 || nump>20 || (numb+numj)<2){System.out.println("Prueba con un valor mas bajo.");}
					else
					{
						System.out.println("Pasamos a Pokescape");
						// Volvemos a Pokescape, concretamente al metodo "iniciarCombate"
						Pokescape.getMiPokescape().iniciarCombate(numb, numj, nump, nivel);
						System.out.println("Aqui me quedo.");
					}
				}	
			}
		


		@Override
		public void update(Observable o, Object arg) 
		{
			// Bien, cuando Pokescape dice que algo ha pasado, este esta con la oreja puesta
			
			if (o instanceof Pokescape)
			{
				// Y despues de comprobar que lo que ha recibido es de Pokescape
				if (arg instanceof Object[])
				{
					// Y que es la informacion que nos interesa, se pone manos a la obra
					// Lo primero es tener bien repartidos los datos
					Object[] lista = (Object[]) arg;
					int numBots = (int) lista[0];
					int numJugs = (int) lista[1];
					int numPoke = (int) lista[2];
					
					listaVentanas = new VentanaJugador[numJugs+numBots];
					
					// Y lo segundo usarlos para algo
					// Como ya sabeis tenemos todos los combatientes y pokemon creados en el modelo, pero en el la vista
					// Entonces vamos a crear las diferentes ventanas para los combatientes
					for (int i = 0; i< numBots+numJugs; i++)
					{
						listaVentanas[i] = new VentanaJugador("Jugador" + i);
						
						// Al igual que con VentanaInicio y Pokescape, cada ventanaJugador estara observando a su correspondiente combatiente por si se quiere pasar informacion
						ListaCombatientes.getMilistaCombatientes().getCombatiente(i).addObserver(listaVentanas[i]);

						listaVentanas[i].setVisible(true);
						// Dicho esto vamos a ver como se crean las ventanas de VentanaJugador
					}
					
					this.setVisible(false);
		
				}
			}
			
		}
	}
