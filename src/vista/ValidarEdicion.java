package vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controlador.Sistema;

@SuppressWarnings("serial")
public class ValidarEdicion extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JButton jButton1;
	private JTextField txtEdicion;
	private JTextField txtPublicacion;
	private Sistema sistema;

	/*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ValidarEdicion inst = new ValidarEdicion();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	*/
	public ValidarEdicion(Sistema s) {
		super();
		this.sistema = s;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Modificar Edición");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Introduzca los datos solicitados.");
				jLabel1.setBounds(107, 25, 185, 15);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Código de Publicación:");
				jLabel2.setBounds(53, 88, 131, 15);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Código de Edición:");
				jLabel3.setBounds(53, 148, 108, 15);
			}
			{
				txtPublicacion = new JTextField();
				getContentPane().add(txtPublicacion);
				txtPublicacion.setBounds(202, 85, 154, 22);
			}
			{
				txtEdicion = new JTextField();
				getContentPane().add(txtEdicion);
				txtEdicion.setBounds(202, 145, 154, 22);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Aceptar");
				jButton1.setBounds(170, 212, 59, 22);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButton1.actionPerformed, event="+evt);
						if(!txtPublicacion.getText().isEmpty() && !txtEdicion.getText().isEmpty()){
							//JOAQUIN: esto sirve?
							int p = Integer.parseInt(txtPublicacion.getText());
							int e = Integer.parseInt(txtEdicion.getText());
							//JOAQUIN: aca me gustaria validar que es un numero valido, pero no se si es suf
							if(p > 0 && e > 0){
								sistema.validarEdicion(p, e);
							} else {
								JOptionPane.showMessageDialog(null, "Complete los campos con numeros enteros positivos.");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Complete todos los campos con numeros enteros.");
						}
					}
				});
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
