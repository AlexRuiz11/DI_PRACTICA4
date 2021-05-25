package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import Jardineria.ModelClass.cliente;
import Jardineria.ModelClass.pedido;
import Jardineria.ModelClassDao.Dao;
import Jardineria.ModelClassDao.clienteDao;
import Jardineria.ModelClassDao.pedidosDao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Pedidos {
	public static String dato;

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedidos window = new Pedidos();
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
	public Pedidos() {
		initialize();
		this.frame.setLocationRelativeTo(null);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static Dao<pedido> pedidosDao = new pedidosDao();
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
					"ID_Cliente", "ID_Pedido", "Estado", "Comentarios"
				}
			));

		String miTexto = "";
		for (int i = 0; i < pedidosDao.getAll().size(); i++) {

			miTexto = miTexto + pedidosDao.get(i).get().getCodigo_pedido() + "\n";
			
			String[] fila= {String(pedidosDao.get(i).get().getCodigo_pedido_cliente()),String(pedidosDao.get(i).get().getCodigo_pedido()), pedidosDao.get(i).get().getEstado(), pedidosDao.get(i).get().getComentarios()};
			
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
		Volver.setBounds(63, 178, 89, 23);
		frame.getContentPane().add(Volver);

		JLabel lblNewLabel = new JLabel("Pedidos");
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
