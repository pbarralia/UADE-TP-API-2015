package vista;

import controlador.Sistema;

@SuppressWarnings("serial")
public class GenerarColocacion extends javax.swing.JFrame {

	private Sistema sistema;
	
	public GenerarColocacion(Sistema sist) {
		super();
		sistema = sist;
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setSize(359, 154);
			}

		} catch(Exception e){
			
		}
	}
}
