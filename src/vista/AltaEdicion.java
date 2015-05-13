package vista;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import controlador.Sistema;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings("serial")
public class AltaEdicion extends javax.swing.JFrame {
	private JButton BAlta;
	private JLabel jLTitulo;
	private JTextField jTDia;
	private JTextField jTAnio;
	private JLabel jLabel1;
	private JTextField jTMes;
	private JLabel jLBarra1;
	private JTextField jTPrecio;
	private JTextField jTTitulo;
	private JTextField jTCodigoPub;
	private JLabel jLFecha;
	private JLabel jLPrecio;
	private JLabel jLCodigoPub;
	
	public AltaEdicion() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			
			this.setTitle("Alta de Edicion");
			this.setLocation(500, 500);
			
			getContentPane().setLayout(null);
			{
				BAlta = new JButton();
				getContentPane().add(BAlta);
				BAlta.setText("Ingresar");
				BAlta.setBounds(143, 186, 93, 28);
				BAlta.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						System.out.println("BAlta.actionPerformed, event="+evt);
						int codigoPub = Integer.parseInt(jTCodigoPub.getText());
						String tituloEdicion = jTTitulo.getText();
						float precio = Float.parseFloat(jTPrecio.getText());
						String fecha = jTDia.getText()+jTMes.getText()+jTAnio.getText();
						Sistema.getControlador().agregarEdicion(codigoPub, tituloEdicion, precio, fecha);
						setVisible(false);
					}
				});
			}
			{
				jLTitulo = new JLabel();
				getContentPane().add(jLTitulo);
				jLTitulo.setText("Titulo Edicion");
				jLTitulo.setBounds(49, 62, 91, 21);
			}
			{
				jLCodigoPub = new JLabel();
				getContentPane().add(jLCodigoPub);
				jLCodigoPub.setText("Codigo de Publicacion");
				jLCodigoPub.setBounds(49, 22, 150, 21);
			}
			{
				jLPrecio = new JLabel();
				getContentPane().add(jLPrecio);
				jLPrecio.setText("Precio");
				jLPrecio.setBounds(49, 102, 41, 21);
			}
			{
				jLFecha = new JLabel();
				getContentPane().add(jLFecha);
				jLFecha.setText("Fecha de salida");
				jLFecha.setBounds(49, 142, 102, 21);
			}
			{
				jTCodigoPub = new JTextField();
				getContentPane().add(jTCodigoPub);
				jTCodigoPub.setBounds(246, 15, 124, 28);
			}
			{
				jTTitulo = new JTextField();
				getContentPane().add(jTTitulo);
				jTTitulo.setBounds(246, 55, 124, 28);
			}
			{
				jTPrecio = new JTextField();
				getContentPane().add(jTPrecio);
				jTPrecio.setBounds(246, 95, 124, 28);
			}
			{
				jLBarra1 = new JLabel();
				getContentPane().add(jLBarra1);
				jLBarra1.setText("/");
				jLBarra1.setBounds(275, 132, 16, 33);
			}
			{
				jTMes = new JTextField();
				getContentPane().add(jTMes);
				jTMes.setBounds(283, 135, 33, 28);
				jTMes.setText("mm");
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("/");
				jLabel1.setBounds(317, 132, 16, 33);
			}
			{
				jTAnio = new JTextField();
				getContentPane().add(jTAnio);
				jTAnio.setBounds(326, 135, 39, 28);
				jTAnio.setText("aaaa");
			}
			{
				jTDia = new JTextField();
				getContentPane().add(jTDia);
				jTDia.setText("dd");
				jTDia.setBounds(247, 135, 24, 28);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
