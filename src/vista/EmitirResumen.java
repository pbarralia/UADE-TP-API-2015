package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlador.Sistema;

@SuppressWarnings("serial")
public class EmitirResumen extends JFrame{
		private	JTable  jTable;
		private JButton jButton_Cancel,
						jButton_Colocar;
		private Sistema sistema;
		private Vector<VendedorView> vendedoresViews;
		private int codigoColocacion;
				
		public EmitirResumen(Vector<VendedorView> vendedoresView, int codigoColocacion){
			sistema = Sistema.getControlador();
			vendedoresViews = vendedoresView;
			this.codigoColocacion = codigoColocacion;
			propiedades(vendedoresView);
			componentes();
			comportamientos();
		}

		private void propiedades(Vector<VendedorView> vendedoresView) {
			Container c = this.getContentPane();
			c.setLayout(new BorderLayout());
			
			JPanel panelCentro = new JPanel();
			JPanel panelSur    = new JPanel();
			
			panelCentro.setLayout(new GridLayout (1,1));
			panelSur.setLayout(new GridLayout (1,2));
			
			c.add(panelCentro, BorderLayout.CENTER);
			c.add(panelSur   , BorderLayout.SOUTH);
			
			String[] columnNames = {"Nro Vendedor", "Edicion", "Cantidad"};
			
			DefaultTableModel modelo = new DefaultTableModel(null, columnNames);
			
			for (VendedorView v: vendedoresView){
				Vector<ItemColocacionView> itemColocacionesView= v.getItemsColocaciones();
				for (ItemColocacionView i: itemColocacionesView){
					modelo.addRow(new Object[]{v.getNroVendedor(), i.getEdicionView().getTituloTapa() ,i.getColocados()});
				}
			}
			
			jTable = new JTable(modelo);
			jTable.setEnabled(false);
			
			JScrollPane scrollPane = new JScrollPane(jTable); 
			panelCentro.add(scrollPane, BorderLayout.CENTER);
			
			jButton_Cancel  = new JButton ("Cancelar");
			jButton_Colocar = new JButton ("Colocar");
			
			panelSur.add(jButton_Cancel);
			panelSur.add(jButton_Colocar);
		}
		
		private void componentes() {
			this.setVisible(true);
			this.setSize(400,400);
			this.setLocation(300,300);
			this.setTitle("Resumen de colocación");
		}
		
		private void comportamientos() {
			interna n = new interna();
			jButton_Cancel.addActionListener(n);
			jButton_Colocar.addActionListener(n);
		}
		
		class interna implements ActionListener{
			public void actionPerformed (ActionEvent a){
				jButton_Cancel(a);
				jButton_Colocar(a);
			}

			private void jButton_Cancel(ActionEvent a) {
				if (a.getSource().equals(jButton_Cancel)){
					setVisible(false);
				}
			}
			
			private void jButton_Colocar(ActionEvent a) {
				if (a.getSource().equals(jButton_Colocar)){
					for (VendedorView v: vendedoresViews){
						Vector<ItemColocacionView> items = new Vector<ItemColocacionView>();
						items = v.getItemsColocaciones();
						for (ItemColocacionView i: items){
							i.setColocado(true);
							sistema.updateItemColocacion (codigoColocacion, i);
						}
					}
					setVisible(false);
				}
			}
		}
}