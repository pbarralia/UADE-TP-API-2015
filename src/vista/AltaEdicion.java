package vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class AltaEdicion extends javax.swing.JFrame {
	private JButton BAlta;
	private JLabel jLTitulo;
	private JTextField jTFecha;
	private JTextField jTPrecio;
	private JTextField jTTitulo;
	private JTextField jTCodigoPub;
	private JLabel jLFecha;
	private JLabel jLPrecio;
	private JLabel jLCodigoPub;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AltaEdicion inst = new AltaEdicion();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AltaEdicion() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			
			this.setVisible(true);
			this.setTitle("Alta de Edicion");
			this.setLocation(500, 500);
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				BAlta = new JButton();
				getContentPane().add(BAlta);
				BAlta.setText("Ingresar");
				BAlta.setBounds(143, 186, 93, 28);
				BAlta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("BAlta.actionPerformed, event="+evt);
						/*int codigoPub = Integer.parseInt(jTCodigoPub.getText());
						String tituloEdicion = jTTitulo.getText();
						float precio = Float.parseFloat(jTPrecio.getText());
						String fecha = jTFecha.getText();
						Sistema.getControlador().agregarEdicion(codigoPub, tituloEdicion, precio, fecha);
						*/setVisible(false);
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
				jTFecha = new JTextField();
				getContentPane().add(jTFecha);
				jTFecha.setBounds(246, 135, 124, 28);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
