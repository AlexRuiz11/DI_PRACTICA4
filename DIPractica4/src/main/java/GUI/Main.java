package GUI;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Main {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
					window.frame.setDefaultCloseOperation(2);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	CrearClientes window = new CrearClientes();
	Clientes window2 = new Clientes();
	Pedidos window3 = new Pedidos();

	public Main() {
		initialize();

		this.frame.setLocationRelativeTo(null);
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.setUndecorated(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
    ImageIcon iconobtn = new ImageIcon("src\\main\\java\\Imagenes\\cerrar.png");

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		
		JButton btnCerrar = new JButton();
		btnCerrar.setBounds(396, 0, 54, 22);
		iconobtn = new ImageIcon(iconobtn.getImage().getScaledInstance(btnCerrar.getWidth(), btnCerrar.getHeight(),Image.SCALE_DEFAULT));
		btnCerrar.setIcon(iconobtn);

		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				confirmarSalida();
			}
		});
		
		frame.getContentPane().add(btnCerrar);
		
	
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 22);
		frame.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Opicones");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Borrar");
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Crear");
		mnNewMenu.add(mntmNewMenuItem_1);
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Modificar");
		mnNewMenu.add(mntmNewMenuItem_2);

		JButton ClientesButton = new JButton("Clientes");
		ClientesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				close();
				window2.frame.setVisible(true);
				window2.frame.setDefaultCloseOperation(2);

			}
		});
		ClientesButton.setBounds(77, 129, 89, 23);
		frame.getContentPane().add(ClientesButton);

		JButton PedidosButton = new JButton("Pedidos");
		PedidosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				close();
				window3.frame.setVisible(true);
				window3.frame.setDefaultCloseOperation(2);

			}
		});
		PedidosButton.setBounds(255, 129, 89, 23);
		frame.getContentPane().add(PedidosButton);

		class mostrarClientes implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				close();
				window.frame.setVisible(true);
				window.frame.setDefaultCloseOperation(2);

			}
		}

		class modificarClientes implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "El codigo del cliente no puede ser nulo.El resto de campos nulos se tendran en cuenta como que no se quieren cambiar.");

				close();

				Modificar windowModifi = new Modificar();

				windowModifi.frame.setVisible(true);
				windowModifi.frame.setDefaultCloseOperation(2);

			}
		}

		class BorrarClientes implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				close();
				Borrar window = new Borrar();
				window.frame.setVisible(true);
				window.frame.setDefaultCloseOperation(2);

			}
		}

		mntmNewMenuItem_1.addActionListener(new mostrarClientes());
		mntmNewMenuItem_2.addActionListener(new modificarClientes());
		mntmNewMenuItem.addActionListener(new BorrarClientes());

	}

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this.frame, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);

	}

	public void confirmarSalida() {
		int valor = JOptionPane.showConfirmDialog(this.frame, "¿Estas seguro de que quiere cerrar la aplicación?",
				"Advertecia", JOptionPane.YES_NO_OPTION);
		if (valor == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Gracias por su visita, Hasta pronto");
			System.exit(0);
		}

	}

}
