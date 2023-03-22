import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

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
	JPanel zonaNombrePokemon;
	JLabel nombrePokemon;
	JLabel tipo;
	JLabel spritePokemon;
	JProgressBar barraHp;
	JPanel estadisticas;
	JPanel panelNombresEstats;
	JPanel panelBarrasEstats;
	JProgressBar barraAtaque;
	JProgressBar barraDefensa;
	
	public JPokemon (int pNumPokemon, String pNombrePokemon, String pTipo, int pAtaque, int pDefensa)
	{
		//Variables para añadir fotos
				URL url;
				Icon imageIcon;
				
				// Panel general pokemon
				//pokemon = new JPanel();
				this.setPreferredSize(new Dimension(155, 240));
				this.setMaximumSize(new Dimension(155, 240));
				this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
				
					// Panel cabezebra : Nombre / Tipo ////////////////////////////////////////////
					zonaNombrePokemon = new JPanel();
					zonaNombrePokemon.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				
						// Nombre
						nombrePokemon = new JLabel(pNombrePokemon);
						nombrePokemon.setAlignmentX(this.CENTER_ALIGNMENT);
						zonaNombrePokemon.add(nombrePokemon);
						
						// Tipo1
						tipo = new JLabel();
						url = this.getClass().getResource(pTipo + ".png");
						imageIcon = new ImageIcon(url);
						tipo.setIcon(imageIcon);
						zonaNombrePokemon.add(tipo);
						
						
			   this.add(zonaNombrePokemon);
				
				
					// Imagen pokemon //////////////////////////////////////////////////////////////////////////		
					spritePokemon = new JLabel();
					url = this.getClass().getResource(pNumPokemon + ".png");
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
					estadisticas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					
					
						// Zona Nombres Estadisticas
						panelNombresEstats = new JPanel();
						panelNombresEstats.setLayout(new GridLayout(5, 1, 0, 0));
						
						panelNombresEstats.add(new JLabel("Ata."));
						panelNombresEstats.add(new JLabel("Def."));
					
					estadisticas.add(panelNombresEstats);
					
						panelBarrasEstats = new JPanel();
						panelBarrasEstats.setLayout(new GridLayout(5, 1, 0, 0));
						
							barraAtaque = barraEstatt(pAtaque, new Color(255, 255, 0));
							panelBarrasEstats.add(barraAtaque);
							barraDefensa = barraEstatt(pDefensa, new Color(255, 255, 0));
							panelBarrasEstats.add(barraDefensa);
				
						estadisticas.add(panelBarrasEstats);
				this.add(estadisticas);
	}
	@Override
	public void update(Observable o, Object arg) 
	{
		// TODO Auto-generated method stub
		
	}

	private JProgressBar barraEstatt(int stat, Color color) 
	{
		JProgressBar barra = new JProgressBar();
		barra.setValue((int) (stat*100/255));
		barra.setForeground(color);
		barra.setPreferredSize(new Dimension(100, 14));
		barra.setMaximumSize(new Dimension(100, 14));
		return barra;
	}
	
	
}
