package max.desafio.utils;

import java.awt.Component;

import javax.swing.JOptionPane;

public class SwingUtils {

	public static void mostrarErro(Component parentComponent, String message) {
		JOptionPane.showConfirmDialog(parentComponent, message, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
	}

}
