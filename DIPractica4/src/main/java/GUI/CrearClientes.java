package GUI;

import java.awt.EventQueue;
import java.awt.Font;
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

public class CrearClientes {

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
					CrearClientes window = new CrearClientes();
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
	public CrearClientes() {
		initialize();
		this.frame.setLocationRelativeTo(null);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static String nombre_clienteEnivar = "";
	public static Dao<cliente> clientesDao = new clienteDao();

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel CodigoCliente = new JLabel("CodigoCliente");
		CodigoCliente.setBounds(34, 60, 88, 29);
		frame.getContentPane().add(CodigoCliente);

		JLabel NombreCliente = new JLabel("NombreCliente");
		NombreCliente.setBounds(34, 132, 88, 29);
		frame.getContentPane().add(NombreCliente);

		JLabel Domicilio = new JLabel("Domicilio");
		Domicilio.setBounds(34, 208, 88, 29);
		frame.getContentPane().add(Domicilio);

		JLabel Telefono = new JLabel("Telefono");
		Telefono.setBounds(34, 269, 88, 29);
		frame.getContentPane().add(Telefono);

		JLabel LimiteCredito = new JLabel("LimiteCredito");
		LimiteCredito.setBounds(34, 322, 81, 29);
		frame.getContentPane().add(LimiteCredito);

		JLabel codigoEmpleado = new JLabel("codigoEmpleado");
		codigoEmpleado.setBounds(421, 60, 108, 29);
		frame.getContentPane().add(codigoEmpleado);

		JLabel DNI = new JLabel("DNI");
		DNI.setBounds(421, 132, 33, 29);
		frame.getContentPane().add(DNI);

		JLabel EMAIL = new JLabel("EMAIL");
		EMAIL.setBounds(421, 208, 88, 29);
		frame.getContentPane().add(EMAIL);

		JLabel password = new JLabel("password");
		password.setBounds(421, 273, 88, 29);
		frame.getContentPane().add(password);

		CodigoClienteField = new JTextField();
		CodigoClienteField.setBounds(186, 64, 145, 20);
		frame.getContentPane().add(CodigoClienteField);
		CodigoClienteField.setColumns(10);

		NombreClienteField = new JTextField();
		NombreClienteField.setColumns(10);
		NombreClienteField.setBounds(186, 136, 145, 20);
		frame.getContentPane().add(NombreClienteField);

		DomicilioField = new JTextField();
		DomicilioField.setColumns(10);
		DomicilioField.setBounds(186, 212, 145, 20);
		frame.getContentPane().add(DomicilioField);

		TelefonoField = new JTextField();
		TelefonoField.setColumns(10);
		TelefonoField.setBounds(186, 273, 145, 20);
		frame.getContentPane().add(TelefonoField);

		codigoEmpleadoField = new JTextField();
		codigoEmpleadoField.setColumns(10);
		codigoEmpleadoField.setBounds(597, 64, 144, 20);
		frame.getContentPane().add(codigoEmpleadoField);

		EMAILField = new JTextField();
		EMAILField.setColumns(10);
		EMAILField.setBounds(597, 212, 144, 20);
		frame.getContentPane().add(EMAILField);

		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(597, 273, 144, 20);
		frame.getContentPane().add(passwordField);

		dniField = new JTextField();
		dniField.setBounds(596, 136, 145, 20);
		frame.getContentPane().add(dniField);
		dniField.setColumns(10);

		LimiteCreditoField = new JTextField();
		LimiteCreditoField.setBounds(186, 326, 145, 20);
		frame.getContentPane().add(LimiteCreditoField);
		LimiteCreditoField.setColumns(10);

		JButton CrearClienteButton = new JButton("CrearCliente");
		CrearClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int codigo_cliente = Integer.parseInt(CodigoClienteField.getText());
				String nombre_cliente = NombreClienteField.getText();
				String domicilio = DomicilioField.getText();
				int telefono = Integer.parseInt(TelefonoField.getText());

				double limite_credit = Double.parseDouble(LimiteCreditoField.getText().replace(",", "."));

				String codigo_empleado_rep_ventas = codigoEmpleadoField.getText();
				String dni = dniField.getText();
				String email = EMAILField.getText();
				String password = passwordField.getText();

				try {
					clientesDao.save(new BuilderCliente(codigo_cliente, nombre_cliente, domicilio, telefono,
							limite_credit, codigo_empleado_rep_ventas, dni, email, password).Buildeo());
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				nombre_clienteEnivar = nombre_clienteEnivar + NombreClienteField.getText() + "\n";
				
			}
		});
		CrearClienteButton.setBounds(115, 405, 153, 23);
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
		MainButton.setBounds(464, 405, 153, 23);
		frame.getContentPane().add(MainButton);

		JLabel lblNewLabel = new JLabel("Crear un cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(279, 11, 175, 20);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Vaciar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CodigoClienteField.setText(null);
				NombreClienteField.setText(null);
				DomicilioField.setText(null);
				TelefonoField.setText(null);
				codigoEmpleadoField.setText(null);
				EMAILField.setText(null);
				passwordField.setText(null);
				dniField.setText(null);
				LimiteCreditoField.setText(null);

			}
		});
		btnNewButton.setBounds(303, 405, 123, 23);
		frame.getContentPane().add(btnNewButton);

	}

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this.frame, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);

	}

}
