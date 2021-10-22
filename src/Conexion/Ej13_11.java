package Conexion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ej13_11 extends JFrame implements ActionListener {
	static JFrame añadirframe;
	static JTextField nombretexto;
	static JTextField edadtexto;
	static JLabel titulo;
	static JLabel autor;
	static JPanel listaPosicion;
	static JPanel save;
	static DefaultListModel<Personas> dlm;
	static JButton añadir;
	static JButton editar;
	static JButton guardar;
	static JButton cancelar;
	static JList<Personas> lista;

	public static void main(String[] args) {
		new Ej13_11();

	}

	public Ej13_11() {

		setTitle("Personas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel marco = new JPanel(new FlowLayout(FlowLayout.CENTER));
		marco.add(añadir = new JButton("Añadir"));
		dlm = new DefaultListModel<Personas>();
		añadir.addActionListener(this);
		lista = new JList<Personas>(dlm);
		listaPosicion = new JPanel();
		listaPosicion.add(lista);
		listaPosicion.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(listaPosicion, BorderLayout.NORTH);
		add(marco, BorderLayout.CENTER);


		marco.add(editar = new JButton("Borrar"));
		editar.addActionListener(this);
		setLocation(850, 450);
		setMinimumSize(new Dimension(400, 100));

		add(marco);

		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String botones = e.getActionCommand();
		if (botones.equals("Añadir")) {
			lista.clearSelection();
			añadir();
		}
		if (botones.equals("Borar")) {
			editar();
		}
		if (botones.equals("Guardar")) {
			guardar();
		}
		if (botones.equals("Cancelar")) {
			añadirframe.dispose();
			setVisible(true);
		}
	}

	public void añadir() {
		añadirframe = new JFrame();
		añadirframe.setTitle("Personas");
		JPanel save = new JPanel(new GridLayout(4, 2, 5, 10));
		añadirframe.add(save);
		save.add(new JLabel("Nombre"));
		save.add(nombretexto = new JTextField(12));
		save.add(new JLabel("Edad"));
		save.add(edadtexto = new JTextField(11));

		añadirframe.setMinimumSize(new Dimension(400, 100));
		añadirframe.setLocation(850, 450);

		save.add(guardar = new JButton("Guardar"));
		save.add(cancelar = new JButton("Cancelar"));
		cancelar.addActionListener(this);
		guardar.addActionListener(this);
		añadirframe.pack();
		añadirframe.setVisible(true);
		dispose();

	}

	public void guardar() {

		try {

			Connection miCon = Conexion.conectar();
			PreparedStatement insertar = miCon.prepareStatement("INSERT INTO `persona` (`nombre`,`edad`) values (?,?)");
			insertar.setString(1, String.valueOf(nombretexto.getText()));
			insertar.setString(2, String.valueOf(edadtexto.getText()));
			insertar.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	public void editar() {
		try {
			Connection miCon = Conexion.conectar();
			PreparedStatement eliminar = miCon.prepareStatement("DELETE FROM `persona` WHERE nombre = (?)");
			eliminar.setString(1, nombretexto.getText());
			eliminar.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


}
