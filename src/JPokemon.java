import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class JPokemon extends JPanel implements Observer
{
	
	//JPanel pokemon;
	private JPanel zonaNombrePokemon;
	private JLabel nombrePokemon;
	private JLabel tipo;
	private JLabel spritePokemon;
	private JProgressBar barraHp;
	private JPanel estadisticas;
	private JPanel panelNombresEstats;
	private JPanel panelBarrasEstats;
	private JProgressBar barraAtaque;
	private JProgressBar barraDefensa;
	private int vidaMax;
	private String nombreTipo;
	
	public JPokemon ()
	{
		//Variables para añadir fotos
				URL url;
				Icon imageIcon;
				
				// Panel general pokemon
				//pokemon = new JPanel();
				this.setPreferredSize(new Dimension(155, 240));
				this.setMaximumSize(new Dimension(155, 240));
				this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
				
				this.setBackground(new Color(201, 238, 250));
				
				
				
					// Panel cabezebra : Nombre / Tipo ////////////////////////////////////////////
					zonaNombrePokemon = new JPanel();
					zonaNombrePokemon.setOpaque(false);
					zonaNombrePokemon.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				
						// Nombre
						nombrePokemon = new JLabel("Vaporeon");
						nombrePokemon.setAlignmentX(this.CENTER_ALIGNMENT);
						zonaNombrePokemon.add(nombrePokemon);
						
						// Tipo1
						tipo = new JLabel();
						url = this.getClass().getResource("Agua" + ".png");
						imageIcon = new ImageIcon(url);
						tipo.setIcon(imageIcon);
						zonaNombrePokemon.add(tipo);
						
						
			   this.add(zonaNombrePokemon);
				
				
					// Imagen pokemon //////////////////////////////////////////////////////////////////////////		
					spritePokemon = new JLabel();
					url = this.getClass().getResource(134 + ".png");
					imageIcon = new ImageIcon(url);
					spritePokemon.setIcon(imageIcon);
					spritePokemon.setAlignmentX(this.CENTER_ALIGNMENT);
				
				this.add(spritePokemon);
				
					
					// Barra Vida //////////////////////////////////////////////////////////////////////////	
					barraHp = new JProgressBar();
					barraHp.setForeground(new Color(128, 255, 0));
					barraHp.setValue(100);
					barraHp.setPreferredSize(new Dimension(150, 14));
					barraHp.setMaximumSize(new Dimension(150, 14));
					
				this.add(barraHp);
						
					
					// Zona Estadisticas //////////////////////////////////////////////////////////////////////////

					estadisticas = new JPanel();
					estadisticas.setOpaque(false);
					estadisticas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					
					
						// Zona Nombres Estadisticas
						panelNombresEstats = new JPanel();
						panelNombresEstats.setOpaque(false);
						panelNombresEstats.setLayout(new GridLayout(5, 1, 0, 0));
						
						panelNombresEstats.add(new JLabel("Ata."));
						panelNombresEstats.add(new JLabel("Def."));
					
					estadisticas.add(panelNombresEstats);
					
						panelBarrasEstats = new JPanel();
						panelBarrasEstats.setOpaque(false);
						panelBarrasEstats.setLayout(new GridLayout(5, 1, 0, 0));
						
							barraAtaque = barraEstatt(150, new Color(255, 255, 0));
							panelBarrasEstats.add(barraAtaque);
							barraDefensa = barraEstatt(150, new Color(255, 255, 0));
							panelBarrasEstats.add(barraDefensa);
				
						estadisticas.add(panelBarrasEstats);
				this.add(estadisticas);
	}
	
	public void actualizarDatos(int pNumPokemon, String pNombrePokemon, String pTipo, int pAtaque, int pDefensa, int pVida)
	{
		//Variables para añadir fotos
				URL url;
				Icon imageIcon;
				
				vidaMax = pVida;
				
				nombrePokemon.setText(pNombrePokemon);
	
					
				url = this.getClass().getResource(pTipo + ".png");
				imageIcon = new ImageIcon(url);
				tipo.setIcon(imageIcon);
				
				nombreTipo = pTipo;
				
				actualizarColor();
				
				
				url = this.getClass().getResource(pNumPokemon + ".png");
				imageIcon = new ImageIcon(url);
				spritePokemon.setIcon(imageIcon);
	
				
				barraHp.setValue(pVida);
						
				barraAtaque.setValue((int) (pAtaque*5));
				barraDefensa.setValue((int) (pDefensa*5));
	}
	
	public void actualizarColor()
	{
		if(nombreTipo.equals("Agua"))
		{
			this.setBackground(new Color(201, 238, 250));
		} 
		else if(nombreTipo.equals("Planta"))
		{
			this.setBackground(new Color(201, 250, 211));
		} 
		else if(nombreTipo.equals("Fuego"))
		{
			this.setBackground(new Color(250, 219, 201));
		} 
		else if(nombreTipo.equals("Eléctrico"))
		{
			this.setBackground(new Color(250, 242, 201));
		}
		else
		{
			this.setBackground(Color.gray);
		}
	}
	
	public void apagar()
	{
		this.setBackground(new Color(225, 205, 249));
	}
	public void actualizarVida(int pVida)
	{
		//System.out.println("Vida max :" + vidaMax + "  "  + barraHp.getValue() + "  "   + (double) pVida/vidaMax);
		//System.out.println("Vida :" + pVida + "  " + (int) (barraHp.getValue() - (double) pVida/vidaMax));
		barraHp.setForeground((Color.red));
		Timer t = new Timer();
		TimerTask tt = new TimerTask() {@Override public void run() {
																	barraHp.setForeground(new Color(128, 255, 0));
																	}};
		t.schedule(tt, 200);
		barraHp.setValue((int) (double) (pVida*100/vidaMax));
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		// TODO Auto-generated method stub
		Object[] lista = (Object[]) arg;
		//nombre, vida, ataque, defensa
		String nombre = (String) lista[0];
		int vida = (int) lista[1];
		//System.out.println("VIDA EN UPDATE ES DE" + vida);
		int ataque = (int) lista[2];
		int defensa = (int) lista[3];
		int numPoke = (int) lista[4];
		String pTipo = (String) lista[5];
		int tipoUpdate = (int) lista[6];
		//System.out.println("TIPO DE UPDATE ES DE" + tipoUpdate);
		if(tipoUpdate == 0) 
		{
			actualizarDatos(numPoke, nombre, pTipo, ataque, defensa, vida);
		}
		else
		{
			
			
			if(vida <= 0)
			{
				URL url;
				Icon imageIcon;

				url = this.getClass().getResource(92 + ".png");
				imageIcon = new ImageIcon(url);
				this.apagar();
				spritePokemon.setIcon(imageIcon);
				
				actualizarVida(0);
			}
			else
			{
				actualizarVida(vida);
			}
		}
		
		
	}

	private JProgressBar barraEstatt(int stat, Color color) 
	{
		JProgressBar barra = new JProgressBar();
		barra.setValue((int) (stat*5));
		barra.setForeground(color);
		barra.setPreferredSize(new Dimension(100, 14));
		barra.setMaximumSize(new Dimension(100, 14));
		return barra;
	}
	
	
	
}
