package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Clientes {
	public static String dato;

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes window = new Clientes();
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
	public Clientes() {
		initialize();
		this.frame.setLocationRelativeTo(null);


	}
	private JTable table;

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 36, 379, 138);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nombre", "DNI", "Telefono"
				}
			));
		

		CrearClientes ventana = new CrearClientes();		
		for (int i = 0; i < ventana.clientesDao.getAll().size(); i++) {

			String[] fila= {String(ventana.clientesDao.get(i).get().getCodigo_cliente()),ventana.clientesDao.get(i).get().getNombre_cliente(), ventana.clientesDao.get(i).get().getDni(), String(ventana.clientesDao.get(i).get().getTelefono())};
			
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.addRow(fila);

		}

		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main window = new Main();
				close();
				window.frame.setVisible(true);
				window.frame.setDefaultCloseOperation(2);

			}
		});
		Volver.setBounds(63, 211, 89, 23);
		frame.getContentPane().add(Volver);

		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(156, 5, 152, 20);
		frame.getContentPane().add(lblNewLabel);
		
	
	
	

	}

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this.frame, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);

	}
	
	public String String(int a){
		
		
		String numCadena =String.valueOf(a);
		return numCadena;
		
	}
}
