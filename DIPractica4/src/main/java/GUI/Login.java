package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class Login {

	private JFrame frame;
	private JTextField UserField;
	private JTextField PasswordField;
	private JPasswordField passwordField;
	private String text = "Recuperar contraseña";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
		this.frame.setLocationRelativeTo(null);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel User = new JLabel("User");
		User.setFont(new Font("Tahoma", Font.PLAIN, 18));
		User.setBounds(30, 72, 57, 14);
		frame.getContentPane().add(User);

		JLabel Password = new JLabel("Password");
		Password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Password.setBounds(30, 123, 114, 14);
		frame.getContentPane().add(Password);

		UserField = new JTextField();
		UserField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		UserField.setBounds(171, 69, 156, 23);
		frame.getContentPane().add(UserField);
		UserField.setColumns(10);

		final JPasswordField PasswordField = new JPasswordField();
		PasswordField.setBounds(171, 122, 156, 23);
		frame.getContentPane().add(PasswordField);

		JButton LogginButton = new JButton("Login");
		LogginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String Usern = UserField.getText();
				String Pass = PasswordField.getText();

				if (Usern.equals("admin") && Pass.equals("admin")) {

					JOptionPane.showMessageDialog(frame, "Correctamente logeado");
					close();

					Main window = new Main();
					window.frame.setVisible(true);
					window.frame.setDefaultCloseOperation(2);

				} else {

					JOptionPane.showMessageDialog(frame, "Log Error");

				}

			}
		});
		LogginButton.setBounds(129, 204, 102, 23);
		frame.getContentPane().add(LogginButton);

		final JCheckBox chckbxMostratContrasea = new JCheckBox("Mostrat contraseña");
		chckbxMostratContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!chckbxMostratContrasea.isSelected()) {

					PasswordField.setEchoChar('*');

				} else {

					PasswordField.setEchoChar((char) 0);
				}

			}
		});
		chckbxMostratContrasea.setBounds(171, 152, 137, 23);
		frame.getContentPane().add(chckbxMostratContrasea);

		final JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(129, 232, 156, 20);
		frame.getContentPane().add(lblNewLabel);

		lblNewLabel.setForeground(Color.BLUE.darker());
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblNewLabel.setText("<html><a href=''>Recuperar contraseña</a></html>");

		lblNewLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://www.google.com"));
				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setText(text);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setText("<html><a href=''>" + text + "</a></html>");
			}

		});

	}

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this.frame, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);

	}
}
