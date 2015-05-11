package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import controlador.Sistema;

@SuppressWarnings("serial")
public class ActivarPauta extends javax.swing.JFrame {
	private JButton btnCancelar;
	private JButton btnActivar;
	private JLabel lblSelPauta;
	private JComboBox cbxListaPautas;
	private Sistema sistema;
	private Vector<PautaView> pautasDisponibles;

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public ActivarPauta(Sistema sist) {
		super();
		sistema = sist;
		this.pautasDisponibles = sistema.obtenerPautas();
		initGUI();
	}

	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Activar Pauta");
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			{
				lblSelPauta = new JLabel();
				getContentPane().add(lblSelPauta);
				lblSelPauta.setText("Seleccione la pauta:");
				lblSelPauta.setBounds(24, 25, 125, 16);
				lblSelPauta.setHorizontalAlignment(SwingConstants.LEFT);
			}
			{
				btnActivar = new JButton();
				getContentPane().add(btnActivar);
				btnActivar.setText("Activar");
				btnActivar.setBounds(252, 68, 85, 23);
				btnActivar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						sistema.activarPauta(obtenerPautaSeleccionada());

						JOptionPane.showMessageDialog(null,
								"Pauta de colocación activada.", "Mensaje",
								JOptionPane.INFORMATION_MESSAGE);

						dispose();
					}

					private int obtenerPautaSeleccionada() {
						String pauta = (String) cbxListaPautas
								.getSelectedItem();
						for (int i = 0; i < pautasDisponibles.size(); i++) {
							if (pautasDisponibles.elementAt(i).getNombre() == pauta) {
								return pautasDisponibles.elementAt(i)
										.getCodigo();
							}
						}
						return 0;
					}
				});
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar);
				getContentPane().add(getCbxListaPautas());
				btnCancelar.setText("Cancelar");
				btnCancelar.setBounds(348, 68, 85, 23);
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						dispose();
					}
				});
			}
			pack();
			this.setSize(471, 150);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JComboBox getCbxListaPautas() {
		if (cbxListaPautas == null) {
			String[] valores = new String[pautasDisponibles.size()];

			for (int i = 0; i < pautasDisponibles.size(); i++) {
				valores[i] = pautasDisponibles.elementAt(i).getNombre();
			}

			ComboBoxModel cbxListaPautasModel = new DefaultComboBoxModel(
					valores);
			cbxListaPautas = new JComboBox();
			cbxListaPautas.setModel(cbxListaPautasModel);
			cbxListaPautas.setBounds(161, 22, 272, 23);
		}
		return cbxListaPautas;
	}
}