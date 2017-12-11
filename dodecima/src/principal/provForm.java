package principal;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class provForm extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					provForm frame = new provForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public provForm() {
		getContentPane().setBackground(new Color(102, 153, 204));
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(205, 27, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(205, 58, 86, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(205, 89, 86, 20);
		getContentPane().add(textField_2);
		
		JLabel lblCodigo = new JLabel("CODIGO");
		lblCodigo.setBounds(50, 30, 68, 14);
		getContentPane().add(lblCodigo);
		
		JLabel lblNombre = new JLabel("NOMBRE      ");
		lblNombre.setBounds(50, 61, 86, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblEmpresa = new JLabel("EMPRESA");
		lblEmpresa.setBounds(50, 92, 68, 14);
		getContentPane().add(lblEmpresa);
		
		JButton button = new JButton("<<");
		button.setBounds(29, 159, 89, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("<");
		button_1.setBounds(128, 159, 89, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton(">");
		button_2.setBounds(227, 159, 89, 23);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton(">>");
		button_3.setBounds(326, 159, 89, 23);
		getContentPane().add(button_3);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(326, 11, 89, 23);
		getContentPane().add(btnNuevo);
		
		JButton btnGrabar = new JButton("GRABAR");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JOptionPane .showMessageDialog(null, "REGISTRO GUARDADO");
			
			}
		});
		btnGrabar.setBounds(326, 37, 89, 23);
		getContentPane().add(btnGrabar);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(326, 61, 89, 23);
		getContentPane().add(btnEditar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(326, 88, 89, 23);
		getContentPane().add(btnEliminar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				int n =JOptionPane.showConfirmDialog(rootPane, "Desear salir?", "Seleccione su opcion", JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_OPTION)
				
				setVisible(false);
			}
		});
		btnSalir.setBounds(326, 113, 89, 23);
		getContentPane().add(btnSalir);
		setTitle("PROVEEDOR");
		setBounds(100, 100, 450, 300);

	}
}
