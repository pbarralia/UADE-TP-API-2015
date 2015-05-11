package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

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
public class MenuPrincipal extends javax.swing.JFrame {
	private JMenuBar barraMenues;
	private JMenu menuEdiciones;
	private JMenu menuPautas;
	private JMenu menuSistema;
	private JMenuItem mItemSalir;
	private JMenuItem mItemGenColocacion;
	private JMenuItem mItemListaCol;
	private JMenuItem mItemResCol;
	private JMenuItem mItemVerProp;
	private JMenuItem mItemDesacPauta;
	private JMenuItem mItemActPauta;
	private JMenuItem mItemBajaEd;
	private JMenuItem mItemModEd;
	private JMenuItem mItemAltaEd;
	private JMenu menuReportes;
	private JMenu menuColocaciones;
	private Sistema sistema;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MenuPrincipal inst = new MenuPrincipal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public MenuPrincipal() {
		super();
		sistema = Sistema.getControlador();
		initGUI();
	}

	private void initGUI() {
		try {
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Sistema de Colocación de Publicaciones");
			{
				barraMenues = new JMenuBar();
				setJMenuBar(barraMenues);
				{
					menuEdiciones = new JMenu();
					barraMenues.add(menuEdiciones);
					menuEdiciones.setText("Ediciones");
					{
						mItemAltaEd = new JMenuItem();
						menuEdiciones.add(mItemAltaEd);
						mItemAltaEd.setText("Alta");
						mItemAltaEd.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								//System.out.println("mItemAltaEd.actionPerformed, event="+evt);
								new AltaEdicion();
							}
						});
					}
					{
						mItemModEd = new JMenuItem();
						menuEdiciones.add(mItemModEd);
						mItemModEd.setText("Modificación");
					}
					{
						mItemBajaEd = new JMenuItem();
						menuEdiciones.add(mItemBajaEd);
						mItemBajaEd.setText("Baja");
					}
				}
				{
					menuPautas = new JMenu();
					barraMenues.add(menuPautas);
					menuPautas.setText("Pautas de Colocación");
					{
						mItemActPauta = new JMenuItem();
						menuPautas.add(mItemActPauta);
						mItemActPauta.setText("Activar");
						mItemActPauta.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								if (sistema.buscarPautaActiva() == null) {
									ActivarPauta vista = new ActivarPauta(
											sistema);
									vista.setVisible(true);
								} else {
									JOptionPane
											.showMessageDialog(
													null,
													"Ya hay una pauta de colocacion activa."
															+ "\n"
															+ "Por favor, desactivela para activar otra.",
													"Error",
													JOptionPane.ERROR_MESSAGE);
								}
							}
						});
					}
					{
						mItemDesacPauta = new JMenuItem();
						menuPautas.add(mItemDesacPauta);
						mItemDesacPauta.setText("Desactivar");
						mItemDesacPauta.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								if (sistema.buscarPautaActiva() != null) {
									DesactivarPauta vista = new DesactivarPauta(
											sistema);
									vista.setVisible(true);
								} else {
									JOptionPane
											.showMessageDialog(
													null,
													"No hay una pauta de colocacion activa."
															+ "\n"
															+ "Por favor, active una para poder desactivarla.",
													"Error",
													JOptionPane.ERROR_MESSAGE);
								}
							}
						});
					}
				}
				{
					menuColocaciones = new JMenu();
					barraMenues.add(menuColocaciones);
					menuColocaciones.setText("Colocaciones");
					{
						mItemGenColocacion = new JMenuItem();
						menuColocaciones.add(mItemGenColocacion);
						mItemGenColocacion.setText("Generar propuesta de colocación");
						mItemGenColocacion.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								GenerarColocacion vista = new GenerarColocacion(sistema);
								vista.setVisible(true);
							}
						});
					}
					{
						mItemVerProp = new JMenuItem();
						menuColocaciones.add(mItemVerProp);
						mItemVerProp.setText("Ver propuestas generadas");
					}
				}
				{
					menuReportes = new JMenu();
					barraMenues.add(menuReportes);
					menuReportes.setText("Reportes");
					{
						mItemResCol = new JMenuItem();
						menuReportes.add(mItemResCol);
						mItemResCol.setText("Resúmen de Colocación");
					}
					{
						mItemListaCol = new JMenuItem();
						menuReportes.add(mItemListaCol);
						mItemListaCol.setText("Listado de Colocaciones");
					}
				}
				{
					menuSistema = new JMenu();
					barraMenues.add(menuSistema);
					menuSistema.setText("Sistema");
					{
						mItemSalir = new JMenuItem();
						menuSistema.add(mItemSalir);
						mItemSalir.setText("Salir");
						mItemSalir.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								if (JOptionPane.showConfirmDialog(null,
										"¿Está seguro que desea salir?",
										"Salir", JOptionPane.YES_NO_OPTION) == 0) {
									System.exit(0);
								}
							}
						});
					}
					menuSistema.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
						}
					});
				}
			}
			pack();
			setSize(1024, 768);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
