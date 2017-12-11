package principal;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import dao.productoDAO;
import dao.productoVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;




public class productoForm extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	productoDAO objproductoDao=new productoDAO();
	ResultSet rsProducto;
	boolean sw;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton btnNuevo;
	private JButton btnGrabar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnCancelar;
	private JButton btnSalir;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					productoForm frame = new productoForm();
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
	public productoForm() {
		setTitle("PRODUCTOS");
		getContentPane().setBackground(new Color(153, 153, 204));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(155, 52, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(155, 80, 86, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(155, 114, 86, 20);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(155, 145, 86, 20);
		getContentPane().add(textField_3);
		
		JLabel lblCodigo = new JLabel("CODIGO");
		lblCodigo.setBounds(31, 55, 46, 14);
		getContentPane().add(lblCodigo);
		
		JLabel lblDescripcin = new JLabel("DESCRIPCI\u00D3N");
		lblDescripcin.setBounds(31, 80, 114, 14);
		getContentPane().add(lblDescripcin);
		
		JLabel lblCategoria = new JLabel("CATEGORIA");
		lblCategoria.setBounds(31, 114, 66, 14);
		getContentPane().add(lblCategoria);
		
		JLabel lblProveedor = new JLabel("PROVEEDOR");
		lblProveedor.setBounds(31, 148, 86, 14);
		getContentPane().add(lblProveedor);
		
		button = new JButton("<<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					rsProducto.first();
					mostrarRegistro();
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			
			}
		});
		button.setBounds(31, 217, 89, 23);
		getContentPane().add(button);
		
		button_1 = new JButton("<");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
	
				
				
				try {
					rsProducto.previous();
					if(rsProducto.isBeforeFirst())
					{
						rsProducto.first();
						}
					mostrarRegistro();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
					
			}
				
				
				
		});
		button_1.setBounds(129, 217, 89, 23);
		getContentPane().add(button_1);
		
		button_2 = new JButton(">");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				
				
				
				try {
					rsProducto.next();
					if(rsProducto.isAfterLast())
					{
						rsProducto.last();
						}
					mostrarRegistro();
					
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(235, 217, 89, 23);
		getContentPane().add(button_2);
		
		button_3 = new JButton(">>");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					rsProducto.last();
					mostrarRegistro();
					
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			
			}
		});
		button_3.setBounds(334, 217, 89, 23);
		getContentPane().add(button_3);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				habilitaControles(true);
				limpiar();
				getRootPane().setDefaultButton(btnCancelar);
				sw=true;
			}
		});
		btnNuevo.setBounds(316, 11, 89, 23);
		getContentPane().add(btnNuevo);
		
		btnGrabar = new JButton("GRABAR");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {productoVO objproductoVo= new productoVO();
				objproductoVo.setCodigo(textField.getText());
				objproductoVo.setNombre(textField_1.getText());
				objproductoVo.setCatego(textField_2.getText());
				objproductoVo.setProvee(textField_3.getText());
				
				if(sw)
				{objproductoDao.insert(objproductoVo);
				JOptionPane.showMessageDialog(null,"REGISTRO GUARDADO");
				limpiar();
				}else{
					
					objproductoVo.setCodigo(textField.getText());
					objproductoDao.actual(objproductoVo);
					JOptionPane.showMessageDialog(null,"REGISTRO ACTUALIZADO");
				}
				cargaRegistro();
				mostrarRegistro();
				habilitaControles(true);
				getRootPane().setDefaultButton(btnNuevo);
				
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				
				
				
			
			}
		});
		btnGrabar.setBounds(316, 33, 89, 23);
		getContentPane().add(btnGrabar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				habilitaControles(true);
				getRootPane().setDefaultButton(btnGrabar);
				sw=false;
			
			}
		});
		btnEditar.setBounds(316, 52, 89, 23);
		getContentPane().add(btnEditar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try { int op=JOptionPane.showConfirmDialog(null, "Desea borrar","Pregunta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(op==JOptionPane.YES_OPTION)
				{
					productoVO objproductoVo =new productoVO();
					objproductoVo.setCodigo(textField.getText());
					objproductoDao.elimina(objproductoVo);
					JOptionPane.showMessageDialog(null,"Registro borrado");
					cargaRegistro();
					mostrarRegistro();
				}
					
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				}
			
		});
		btnEliminar.setBounds(316, 76, 89, 23);
		getContentPane().add(btnEliminar);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitaControles(false);
				limpiar();
				getRootPane().setDefaultButton(btnNuevo);
				cargaRegistro();
				mostrarRegistro();
				
			}
		});
		btnCancelar.setBounds(316, 99, 89, 23);
		getContentPane().add(btnCancelar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				int n =JOptionPane.showConfirmDialog(rootPane, "Desear salir?", "Seleccione su opcion", JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_OPTION)
				
				setVisible(false);
			}
		});
		btnSalir.setBounds(316, 139, 89, 23);
		getContentPane().add(btnSalir);

	}
	
	
	private void cargaRegistro()
	{ try {
		rsProducto =objproductoDao.cargaRegistro();
		rsProducto .next();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}
	
	private void mostrarRegistro()
	{ try {
		textField.setText(rsProducto.getString(1));
		textField_1.setText(rsProducto.getString(2));
		textField_2.setText(rsProducto.getString(3));
		textField_3 .setText(rsProducto.getString(4));
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"No hay  registros");

	e.printStackTrace();
	}
		
	}

	private void habilitaControles(boolean b)
	{
		
		textField.setEditable(b);
		textField_1.setEditable(b);
		textField_2.setEditable(b);
		textField_3.setEditable(b);
		
		JButton[]  control={button,button_1,button_2,button_3,btnEditar,btnEliminar};
		for(JButton objButton:control)
		{
			objButton.setEnabled(b);
		}
		btnGrabar.setEnabled(b);
		btnCancelar.setEnabled(b);
		textField_1.grabFocus();
		
	}
	
	
	
	private void limpiar()
	{
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
	
	}
}
