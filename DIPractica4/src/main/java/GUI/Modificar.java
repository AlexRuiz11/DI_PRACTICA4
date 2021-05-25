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

public class Modificar {

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
					Modificar window = new Modificar();
					window.frame.setVisible(true);
					// window.frame.setDefaultCloseOperation(2);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Modificar() {
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
		CodigoCliente.setBounds(34, 93, 88, 29);
		frame.getContentPane().add(CodigoCliente);

		JLabel NombreCliente = new JLabel("NombreCliente");
		NombreCliente.setBounds(34, 156, 88, 29);
		frame.getContentPane().add(NombreCliente);

		JLabel Domicilio = new JLabel("Domicilio");
		Domicilio.setBounds(34, 208, 88, 29);
		frame.getContentPane().add(Domicilio);

		JLabel Telefono = new JLabel("Telefono");
		Telefono.setBounds(34, 251, 88, 29);
		frame.getContentPane().add(Telefono);

		JLabel LimiteCredito = new JLabel("LimiteCredito");
		LimiteCredito.setBounds(34, 291, 81, 29);
		frame.getContentPane().add(LimiteCredito);

		JLabel codigoEmpleado = new JLabel("codigoEmpleado");
		codigoEmpleado.setBounds(443, 93, 115, 29);
		frame.getContentPane().add(codigoEmpleado);

		JLabel DNI = new JLabel("DNI");
		DNI.setBounds(443, 156, 33, 29);
		frame.getContentPane().add(DNI);

		JLabel EMAIL = new JLabel("EMAIL");
		EMAIL.setBounds(443, 208, 88, 29);
		frame.getContentPane().add(EMAIL);

		JLabel password = new JLabel("password");
		password.setBounds(443, 251, 88, 29);
		frame.getContentPane().add(password);

		CodigoClienteField = new JTextField();
		CodigoClienteField.setBounds(213, 97, 123, 20);
		frame.getContentPane().add(CodigoClienteField);
		CodigoClienteField.setColumns(10);

		NombreClienteField = new JTextField();
		NombreClienteField.setColumns(10);
		NombreClienteField.setBounds(213, 160, 123, 20);
		frame.getContentPane().add(NombreClienteField);

		DomicilioField = new JTextField();
		DomicilioField.setColumns(10);
		DomicilioField.setBounds(213, 217, 123, 20);
		frame.getContentPane().add(DomicilioField);

		TelefonoField = new JTextField();
		TelefonoField.setColumns(10);
		TelefonoField.setBounds(213, 255, 123, 20);
		frame.getContentPane().add(TelefonoField);

		codigoEmpleadoField = new JTextField();
		codigoEmpleadoField.setColumns(10);
		codigoEmpleadoField.setBounds(581, 97, 144, 20);
		frame.getContentPane().add(codigoEmpleadoField);

		EMAILField = new JTextField();
		EMAILField.setColumns(10);
		EMAILField.setBounds(581, 212, 144, 20);
		frame.getContentPane().add(EMAILField);

		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(581, 255, 144, 20);
		frame.getContentPane().add(passwordField);

		dniField = new JTextField();
		dniField.setBounds(581, 160, 144, 20);
		frame.getContentPane().add(dniField);
		dniField.setColumns(10);

		LimiteCreditoField = new JTextField();
		LimiteCreditoField.setBounds(213, 297, 123, 20);
		frame.getContentPane().add(LimiteCreditoField);
		LimiteCreditoField.setColumns(10);
		
		
		

		JButton CrearClienteButton = new JButton("Modificar Cliente");
		CrearClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 int codigo_cliente = Integer.parseInt(CodigoClienteField.getText());
				 String nombre_cliente = NombreClienteField.getText();
				
			
				
				
				 String domicilio = DomicilioField.getText();
				 int telefono ;
				 String numCadena=TelefonoField.getText();

				 double limite_credit;
				 String numCadenalimite_credit = LimiteCreditoField.getText().replace(",", ".");

				 String codigo_empleado_rep_ventas = codigoEmpleadoField.getText();
				 String dni = dniField.getText();
				 String email = EMAILField.getText();
				 String password = passwordField.getText();

				
					 int contrador=0;
					
					
					for(int x=0; x<ventana.clientesDao.getAll().size();x++) {			

					if(codigo_cliente== ventana.clientesDao.getAll().get(x).getCodigo_cliente()) {
						
						System.out.println("Cliente encontrado y cambiado");				


						if(nombre_cliente.equalsIgnoreCase("")) {
							
							nombre_cliente=	ventana.clientesDao.getAll().get(x).getNombre_cliente();
							ventana.clientesDao.getAll().get(x).setNombre_cliente(nombre_cliente);


							}else {
								ventana.clientesDao.getAll().get(x).setNombre_cliente(nombre_cliente);
							}
					
						if(dni.equalsIgnoreCase("")) {
							
							dni=	ventana.clientesDao.getAll().get(x).getDni();
							ventana.clientesDao.getAll().get(x).setDni(dni);


							}else {
								ventana.clientesDao.getAll().get(x).setDni(dni);
							}
						
						

						if(numCadena.equalsIgnoreCase("")) {
							
							telefono=	ventana.clientesDao.getAll().get(x).getTelefono();
							ventana.clientesDao.getAll().get(x).setTelefono(telefono);


							}else {
								telefono=	Integer.parseInt(TelefonoField.getText());

								ventana.clientesDao.getAll().get(x).setTelefono(telefono);
							}
							
						
						if(domicilio.equalsIgnoreCase("")) {
							
							domicilio=	ventana.clientesDao.getAll().get(x).getDomicilio();
							ventana.clientesDao.getAll().get(x).setDomicilio(domicilio);


							}else {
								ventana.clientesDao.getAll().get(x).setDomicilio(domicilio);
							
							}
						
						
						if(codigo_empleado_rep_ventas.equalsIgnoreCase("")) {
							
							codigo_empleado_rep_ventas=	ventana.clientesDao.getAll().get(x).getCodigo_empleado_rep_ventas();
							ventana.clientesDao.getAll().get(x).setCodigo_empleado_rep_ventas(codigo_empleado_rep_ventas);


							}else {
								ventana.clientesDao.getAll().get(x).setCodigo_empleado_rep_ventas(codigo_empleado_rep_ventas);
							
							}
						
		
						
						if(email.equalsIgnoreCase("")) {
							
							email=	ventana.clientesDao.getAll().get(x).getEmail();
							ventana.clientesDao.getAll().get(x).setEmail(email);


							}else {
								ventana.clientesDao.getAll().get(x).setEmail(email);
							
							}
						
						if(password.equalsIgnoreCase("")) {
							
							password=	ventana.clientesDao.getAll().get(x).getPassword();
							ventana.clientesDao.getAll().get(x).setPassword(password);


							}else {
								ventana.clientesDao.getAll().get(x).setPassword(password);
							
							}
						
						
						
						
						if(numCadenalimite_credit.equalsIgnoreCase("")) {
							
							limite_credit=	ventana.clientesDao.getAll().get(x).getLimite_credit();
							ventana.clientesDao.getAll().get(x).setLimite_credit(limite_credit);


							}else {
								limite_credit=	Double.parseDouble(LimiteCreditoField.getText().replace(",", "."));

								ventana.clientesDao.getAll().get(x).setLimite_credit(limite_credit);
							
							}
						
						
						
						


						contrador++;
					}
				}
				
			
				
			if(contrador==0) {
				System.out.println("No hay ningun  cliente con ese codigo");
			}
					
					
				
			}
			
		});
		CrearClienteButton.setBounds(116, 401, 153, 23);
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
		MainButton.setBounds(473, 401, 153, 23);
		frame.getContentPane().add(MainButton);

		JLabel lblNewLabel = new JLabel("Modificar datos de un cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(213, 11, 375, 20);
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
		btnNewButton.setBounds(326, 401, 123, 23);
		frame.getContentPane().add(btnNewButton);

	}

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this.frame, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);

	}
	
	
	
}
