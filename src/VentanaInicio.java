import java.awt.EventQueue;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import java.awt.FlowLayout;
import javax.swing.Action;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	private JPanel Imagen;
	private JPanel Botones;
	private static JTextField textFieldBots;
	private static JTextField textFieldJugadores;
	private static JTextField textFieldPokemons;
	private static JButton btnNewButton;
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

	public VentanaInicio() {
		setTitle("Pokescape");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getImagen(), BorderLayout.CENTER);
		contentPane.add(getBotones(), BorderLayout.EAST);
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
			btnNewButton = new JButton("Jugar");
		}
		btnNewButton.addActionListener(ControladorInicio.getControladorInicio());
		return btnNewButton;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel();
			URL url;
			Icon imageIcon;
			url = this.getClass().getResource("618.png");
			imageIcon = new ImageIcon(url);
			lblNewLabel.setIcon(imageIcon);
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
			private static ControladorInicio miControladorInicio;
		
			private ControladorInicio() {}
		
			public static ControladorInicio getControladorInicio()
			{
				if(miControladorInicio == null) 
				{
					miControladorInicio = new ControladorInicio();
				}
				return miControladorInicio;
			}
			

			@Override
			public void actionPerformed(ActionEvent e) 
			{
			
				if (e.getSource().equals(btnNewButton))
				{
					//modelo.comenzar();
					String strb = textFieldBots.getText();
					String strj = textFieldJugadores.getText();
					String strp = textFieldPokemons.getText();
					
					int numb;
					int numj;
					int nump;
					
					try 
					{
						numb = Integer.parseInt(strb);
						numj = Integer.parseInt(strj);
						nump = Integer.parseInt(strp);
					
						System.out.println(numb + " " + numj + " " + nump);
						// TODO ******************************
						if (numb>10 || numj>10 || nump>20){System.out.println("Prueba con un valor mas bajo.");}
						else
						{
							Pokescape.getMiPokescape().iniciarCombate(numb, numj, nump);
						}
					}
					catch(Exception ex) 
					{
						System.out.println("Valores no validos");
					}	
				}	
			}
		}
	}
