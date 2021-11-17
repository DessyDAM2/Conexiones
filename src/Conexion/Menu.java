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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//Autor Álvaro Dessy
public class Menu extends JFrame implements ActionListener {
	//Creamos todas las variables que vamos a utilizar
	static JFrame ventana;
	static JTextField nombretexto;
	static JTextField edadtexto;
	static JLabel titulo;
	static JLabel autor;
	static JPanel listaPosicion;
	static JPanel save;
	static DefaultListModel<Personas> dlm;
	DefaultListModel dm = new DefaultListModel();
	static JButton añadir;
	static JButton Borrar;
	static JButton guardar;
	static JButton cancelar;
	static JList<Personas> lista;
	static JButton ordenarNombre;
	static JButton ordenarEdad;
	static JButton Mostrar;

	public static void main(String[] args) {
		new Menu();

	}

	//Creamos la ventana principal con los botones y la lista para mostrar los nombres de la base de datos
	public Menu() {

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
		listaPosicion.setMinimumSize(new Dimension(800,400));
		add(listaPosicion, BorderLayout.NORTH);
		add(marco, BorderLayout.CENTER);


		marco.add(Borrar = new JButton("Modificar"));
		Borrar.addActionListener(this);
		marco.add(ordenarNombre = new JButton("ordenarNombre"));
		ordenarNombre.addActionListener(this);
		marco.add(ordenarEdad = new JButton("ordenarEdad"));
		ordenarEdad.addActionListener(this);
		setLocation(850, 450);
		setMinimumSize(new Dimension(400, 100));



		add(marco);

		pack();
		mostrarLista();
		setVisible(true);
	}
	//Creamos un método para hacer funcionar los botones
	@Override
	public void actionPerformed(ActionEvent e) {
		String botones = e.getActionCommand();
		if (botones.equals("Añadir")) {
			lista.clearSelection();
			añadir();
		}
		if (botones.equals("Borrar")) {
			Borrar();
		}
		if (botones.equals("Guardar")) {
			guardar();
		}
		if (botones.equals("Cancelar")||botones.equals("Atras")) {
			ventana.dispose();
			setVisible(true);
		}
		if (botones.equals("Modificar")){
			modificar();
			try {
				PreparedStatement mostrar = Conexion.conectar().prepareStatement("select nombre from `persona` where nombre = (?)");
				mostrar.setString(1, String.valueOf(lista.getSelectedIndex()));
				nombretexto.setText(String.valueOf(lista.getSelectedValue()));
				ResultSet rs = mostrar.executeQuery();
			}catch(SQLException ex){

			}
		}
		if (botones.equals("ordenarNombre")){
			dm.clear();
			ordenarNombre();
		}
		if (botones.equals(("ordenarEdad"))){
			dm.clear();
			ordenarEdad();
		}

	}

	//Creamos una ventana para añadir
	public void añadir() {
		ventana = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setTitle("Personas");
		JPanel save = new JPanel(new GridLayout(4, 2, 5, 10));
		ventana.add(save);
		save.add(new JLabel("Nombre"));
		save.add(nombretexto = new JTextField(12));
		save.add(new JLabel("Edad"));
		save.add(edadtexto = new JTextField(11));

		ventana.setMinimumSize(new Dimension(400, 100));
		ventana.setLocation(850, 450);

		save.add(guardar = new JButton("Guardar"));
		save.add(cancelar = new JButton("Cancelar"));
		cancelar.addActionListener(this);
		guardar.addActionListener(this);
		ventana.pack();
		ventana.setVisible(true);
		dispose();

	}

	//Creamos un método para el botón guardar
	public void guardar() {

		try {

			Connection miCon = Conexion.conectar();
			PreparedStatement insertar = miCon.prepareStatement("INSERT INTO `persona` (`nombre`,`edad`) values (?,?)");
			insertar.setString(1, String.valueOf(nombretexto.getText()));
			insertar.setString(2, String.valueOf(edadtexto.getText()));
			insertar.executeUpdate();
			dm.clear();
			mostrarLista();

		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	//Creamos un método para el botón borrar
	public void Borrar() {
		try {
			Connection miCon = Conexion.conectar();
			PreparedStatement eliminar = miCon.prepareStatement("DELETE FROM `persona` WHERE nombre = (?)");
			eliminar.setString(1, nombretexto.getText());
			eliminar.executeUpdate();
			System.out.println("Borrado");
			dm.clear();
			mostrarLista();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//Creamos una ventana para modificar la lista
	public void modificar(){
		ventana = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setTitle("Personas");
		JPanel delete = new JPanel(new GridLayout(4, 2, 5, 10));
		ventana.add(delete);
		delete.add(new JLabel("Nombre"));
		delete.add(nombretexto = new JTextField(12));

		ventana.setMinimumSize(new Dimension(400, 100));
		ventana.setLocation(850, 450);

		delete.add(Borrar = new JButton("Borrar"));
		delete.add(cancelar = new JButton("Cancelar"));
		cancelar.addActionListener(this);
		Borrar.addActionListener(this);
		ventana.pack();
		ventana.setVisible(true);
		dispose();

	}

	//Creamos un método para el botón ordenarNombre
	public void ordenarNombre(){
		try{
			String query ="select * from `persona` order by nombre ASC";
			PreparedStatement mostrar = Conexion.conectar().prepareStatement(query);
			ResultSet rs = mostrar.executeQuery();
			while(rs.next()){
				dm.addElement(rs.getString("nombre"));
			}
			lista.setModel(dm);
			mostrar.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//Creamos un método para el botón ordenarEdad
	public void ordenarEdad(){
		try{
			String query ="select * from `persona` order by edad DESC";
			PreparedStatement mostrar = Conexion.conectar().prepareStatement(query);
			ResultSet rs = mostrar.executeQuery();
			while(rs.next()){
				dm.addElement(rs.getString("nombre"));
			}
			lista.setModel(dm);
			mostrar.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//Creamos un método para mostrar la lista al iniciar el programa en la ventana principal
	public void mostrarLista(){
		try{
			String query ="select * from `persona`";
			PreparedStatement mostrar = Conexion.conectar().prepareStatement(query);
			ResultSet rs = mostrar.executeQuery();
			while(rs.next()){
				dm.addElement(rs.getString("nombre"));
			}
			lista.setModel(dm);
			mostrar.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
