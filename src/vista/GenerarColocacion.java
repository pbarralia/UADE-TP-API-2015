package vista;

import controlador.Sistema;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ListModel;

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
public class GenerarColocacion extends javax.swing.JFrame {

	private Sistema sistema;
	private JButton jButtonCancelar;
	private JButton jButtonAceptar;
	private JList jList1;

	public GenerarColocacion(Sistema sist) {
		super();
		sistema = sist;
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setSize(511, 328);
				getContentPane().setLayout(null);
				{
					ListModel jList1Model = 
							new DefaultComboBoxModel(
									new String[] { "Item One", "Item Two" });
					jList1 = new JList();
					getContentPane().add(jList1);
					jList1.setModel(jList1Model);
					jList1.setBounds(30, 22, 318, 247);
				}
				{
					jButtonAceptar = new JButton();
					getContentPane().add(jButtonAceptar);
					jButtonAceptar.setText("Aceptar");
					jButtonAceptar.setBounds(372, 168, 103, 23);
				}
				{
					jButtonCancelar = new JButton();
					getContentPane().add(jButtonCancelar);
					jButtonCancelar.setText("Cancelar");
					jButtonCancelar.setBounds(372, 224, 103, 23);
				}
			}

		} catch(Exception e){
			
		}
	}
}
