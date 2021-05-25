package GUI;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Jardineria.ModelClass.cliente;
import Jardineria.ModelClassDao.Dao;
import Jardineria.ModelClassDao.clienteDao;
import Jardineria.ModelClassDao.pedidosDao;
import Jardineria.PatronBuilder.BuilderCliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Borrar {

	JFrame frame;
	private JTextField CodigoClienteField;
	private JTextField NombreClienteField;
	private JTextField DomicilioField;
	private JTextField TelefonoField;
	private JTextField codigoEmpleadoField;
	private JTextField EMAILField;
	private JTextField passwordField;
	private JTextField dniField;
	private JTextField LimiteCreditoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Borrar window = new Borrar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Borrar() {
		initialize();
		this.frame.setLocationRelativeTo(null);

	}

	/**
	 * Initialize the contents of the frame.
	 */

	public static Dao<cliente> clientesDao = new clienteDao();
	CrearClientes ventana = new CrearClientes();

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel CodigoCliente = new JLabel("CodigoCliente");
		CodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CodigoCliente.setBounds(165, 165, 132, 29);
		frame.getContentPane().add(CodigoCliente);

		CodigoClienteField = new JTextField();
		CodigoClienteField.setBounds(483, 169, 123, 20);
		frame.getContentPane().add(CodigoClienteField);
		CodigoClienteField.setColumns(10);
		

		
		
		JButton CrearClienteButton = new JButton("Borrar Cliente");
		CrearClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 int i = Integer.parseInt(CodigoClienteField.getText());
				 int contrador=0;
				int codigo_cliente = Integer.parseInt(CodigoClienteField.getText());
				
				
				for(int x=0; x<ventana.clientesDao.getAll().size();x++) {			

				if(i== ventana.clientesDao.getAll().get(x).getCodigo_cliente()) {
					
					System.out.println("Cliente encontrado y borrado");
					ventana.clientesDao.delete(ventana.clientesDao.getAll().get(x));
					contrador++;
				}
			}
			
		
			
		if(contrador==0) {
			System.out.println("No hay ningun  cliente con ese codigo");
		}

			

			}
		});
		CrearClienteButton.setBounds(165, 343, 153, 23);
		frame.getContentPane().add(CrearClienteButton);

		JButton MainButton = new JButton("Main");
		MainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// nombre_cliente= nombre_cliente+ NombreClienteField.getText() +"\n";

				close();
				Main window = new Main();
				window.frame.setVisible(true);
				window.frame.setDefaultCloseOperation(2);

			}
		});
		MainButton.setBounds(453, 343, 153, 23);
		frame.getContentPane().add(MainButton);

		JLabel lblNewLabel = new JLabel("Borrar un cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(284, 11, 202, 20);
		frame.getContentPane().add(lblNewLabel);

	}

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this.frame, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);

	}

}
