package vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.Sistema;

//NOTAS Joaquin
//string.valueOf(int)
//parseInt
//parseFloat


@SuppressWarnings("serial")
public class ModificarEdicion extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel5;
	private JTextArea jTextArea1;
	private JButton jButton2;
	private JButton jButton1;
	private JLabel jLabel4;
	private Sistema sistema;

	/**
	* Auto-generated main method to display this JFrame
	*/
	/*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ModificarEdicion inst = new ModificarEdicion();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	*/
	public ModificarEdicion(Sistema s) {
		super();
		this.sistema = s;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Modificar Edición");
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Código de Edición:");
				jLabel1.setBounds(55, 49, 108, 15);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Título de Tapa:");
				jLabel2.setBounds(55, 91, 89, 15);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Precio:");
				jLabel3.setBounds(55, 134, 41, 15);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Fecha de Salida:");
				jLabel4.setBounds(55, 178, 94, 15);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Cancelar");
				jButton1.setBounds(106, 229, 64, 22);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButton1.actionPerformed, event="+evt);
						sistema.cancelarModificarEdicion();
						JOptionPane.showMessageDialog(null, "Modificación cancelada.");
					}
				});
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Modificar");
				jButton2.setBounds(219, 229, 67, 22);
			}
			{
				jTextArea1 = new JTextArea();
				getContentPane().add(jTextArea1);
				jTextArea1.setText(sistema.getEdicionActual().getTituloTapa());
				jTextArea1.setBounds(204, 91, 150, 19);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				StringBuilder sb = new StringBuilder();
				sb.append("");
				sb.append(sistema.getEdicionActual().getCodigoEdicion());
				String strI = sb.toString();
				jLabel5.setText(sb);
				jLabel5.setBounds(204, 49, 150, 15);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
