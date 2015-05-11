package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import controlador.Sistema;

@SuppressWarnings("serial")
public class DesactivarPauta extends javax.swing.JFrame {
	private JButton btnCancelar;
	private JButton btnDesctivar;
	private JLabel lblPautaActiva;
	private JLabel lblPautaActivaNombre;
	private Sistema sistema;
	private PautaView pautaActiva;

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public DesactivarPauta(Sistema sist) {
		super();
		sistema = sist;
		this.pautaActiva = sistema.buscarPautaActiva();
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
				PautaView pautaActiva = sistema.buscarPautaActiva();

				lblPautaActiva = new JLabel();
				getContentPane().add(lblPautaActiva);
				lblPautaActiva.setText("Pauta activa:");
				lblPautaActiva.setBounds(24, 25, 125, 16);
				lblPautaActiva.setHorizontalAlignment(SwingConstants.LEFT);

				lblPautaActivaNombre = new JLabel();
				getContentPane().add(lblPautaActivaNombre);
				lblPautaActivaNombre.setText(pautaActiva.getNombre());
				lblPautaActivaNombre.setBounds(24, 25, 125, 16);
				lblPautaActivaNombre
						.setHorizontalAlignment(SwingConstants.LEFT);

			}
			{
				btnDesctivar = new JButton();
				getContentPane().add(btnDesctivar);
				btnDesctivar.setText("Desactivar");
				btnDesctivar.setBounds(252, 68, 85, 23);
				btnDesctivar.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						sistema.desactivarPauta(pautaActiva.getCodigo());

						JOptionPane.showMessageDialog(null,
								"Pauta de colocacion deactivada.", "Mensaje",
								JOptionPane.INFORMATION_MESSAGE);

						dispose();
					}
				});
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar);
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
}