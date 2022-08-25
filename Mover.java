import javax.swing.*;
import java.awt.event.*;

public class Mover implements ActionListener
{
	private JFrame ventana;
	private JButton btn_boton, btn_subir, btn_bajar, btn_derecha, btn_izquierda;
	private int direcciony, direccionx;

	Timer timer = new Timer(200, new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			int x,y;
			x= btn_boton.getLocation().x;
			y= btn_boton.getLocation().y;

			if (direccionx == 0)
				btn_boton.setLocation(x,y+direcciony);
			else 
				btn_boton.setLocation(x+direccionx,y);

			System.out.println(ventana.getHeight() + " y+direcciony " + (y+direcciony) + " direcciony " +direcciony);
			if (y+direcciony < 0 || y+direcciony > ventana.getHeight() -80)
				direcciony = - direcciony; //direcciony*=-1

			System.out.println(ventana.getWidth() + " x+direccionx " + (x+direccionx) + " direccionx " +direccionx);
			if (x+direccionx < 0 || x+direccionx > ventana.getWidth() -70)
				direccionx = -direccionx; //direccionx*=-1
		}
	});

	public static void main(String[] args) 
	{
		new Mover();
	}

	Mover()
	{

		ventana = new JFrame("JUEGO DE ROMPECABEZA");
		ventana.setBounds(100,100,500,500);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btn_boton = new JButton();
		btn_boton.setBounds(100,200,40,40);
		ventana.add(btn_boton);

		btn_subir = new JButton("Subir");
		btn_subir.setBounds(300,75,70,20);
		btn_subir.addActionListener(this);
		ventana.add(btn_subir);

		btn_bajar = new JButton("Bajar");
		btn_bajar.setBounds(300,100,70,20);
		btn_bajar.addActionListener(this);
		ventana.add(btn_bajar);

		btn_derecha = new JButton("Derecha");
		btn_derecha.setBounds(210,85,85,20);
		btn_derecha.addActionListener(this);
		ventana.add(btn_derecha);

		btn_izquierda = new JButton("Izquierda");
		btn_izquierda.setBounds(375,85,95,20);
		btn_izquierda.addActionListener(this);
		ventana.add(btn_izquierda);

		ventana.setVisible(true);

	}

	public void actionPerformed(ActionEvent e)
	{
		direccionx = 0;
		direcciony = 0; 

		if (e.getSource() == btn_subir)
			direcciony = -10;
		
		if (e.getSource() == btn_bajar)
			direcciony = +10;

		if (e.getSource() == btn_derecha)
			direccionx = -10;

		if (e.getSource() == btn_izquierda)
			direccionx = +10;
		
		timer.start();
	}
}
