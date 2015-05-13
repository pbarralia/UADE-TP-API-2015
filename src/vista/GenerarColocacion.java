package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import controlador.Sistema;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.*;

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
	private JTable tabla;
	private JScrollPane jScrollPane1;
	private JButton jButtonGenerar;
	private JButton jButtonAceptar;
	private JButton jButtonCancelar;
	private JList jList1;

	public GenerarColocacion(Sistema sist) {
		super();
		sistema = sist;
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setSize(839, 328);
				getContentPane().setLayout(null);
		
				
				
				


				
				
				{
					jButtonAceptar = new JButton();
					getContentPane().add(jButtonAceptar);
					jButtonAceptar.setText("Aceptar");
					jButtonAceptar.setBounds(588, 256, 103, 23);
					jButtonAceptar.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent arg0) {

							sistema.realizarColocacion();;

							JOptionPane.showMessageDialog(null,
									"Se genero la colocación.", "Mensaje",
									JOptionPane.INFORMATION_MESSAGE);

							dispose();
						}
					});
				}
				{
					jButtonCancelar = new JButton();
					getContentPane().add(jButtonCancelar);
					jButtonCancelar.setText("Cancelar");
					jButtonCancelar.setBounds(709, 256, 103, 23);
					jButtonCancelar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							dispose();
						}
					});
				}
				{
					
					jScrollPane1 = new JScrollPane();
					getContentPane().add(jScrollPane1);
					jScrollPane1.setBounds(30, 29, 775, 209);
			
					
					{

				
						
						
					    DefaultTableModel modelo = new DefaultTableModel();
						
						tabla = new JTable();
						jScrollPane1.setViewportView(tabla);
						
						tabla.setModel(modelo);

						modelo.addColumn("Publicacion");
						modelo.addColumn("Edicion");
						modelo.addColumn("F. Salida");
						modelo.addColumn("Vendedor");
						modelo.addColumn("Carga");
						modelo.addColumn("Zona");
						
                        
						Vector<ItemColocacionView> ic = sistema.mostrarColocacion();
						for (int i = 0; i< ic.size();i++){
							   Object []object = new Object[5];
						        object[0] = ic.elementAt(i).getPublicacionView().getTitulo();
						        object[1] = ic.elementAt(i).getEdicionView().getTituloTapa(); 
						        object[2] = ic.elementAt(i).getEdicionView().getFechaSalida(); 
						        object[3] = ic.elementAt(i).getVendedorView().getNroVendedor(); 
						        object[4] = ic.elementAt(i).getColocados(); 
						        object[5] = ic.elementAt(i).getVendedorView().getZona(); 

							    modelo.addRow(object);
						}
				     
				        
				           
						
				
						

					}
				}


			}

		} catch(Exception e){
			
		}
	}
}
