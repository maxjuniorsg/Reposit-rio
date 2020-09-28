package max.desafio.ui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import max.desafio.exceptions.DesafioExcecao;
import max.desafio.model.Partida;
import max.desafio.services.PartidasService;
import max.desafio.services.impl.PartidasServiceImpl;
import max.desafio.utils.SwingUtils;
import java.awt.Dimension;

public class CadastroDialog extends JDialog {
	
	private PartidasService service = new PartidasServiceImpl();
	private JTextField placarField;
	private JTextField partidaNumero;

	public CadastroDialog() {
		setLocationByPlatform(true);
		setSize(new Dimension(400, 260));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Cadastro");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(8, 32, 8, 32));
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 0, 32, 8));
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirPartida();
			}
		});
		panel.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fechar();
			}
		});
		panel.add(btnCancelar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(8, 8, 8, 8));
		getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[] {30, 30, 0, 0, 0, 30};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Partida #:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		partidaNumero = new JTextField();
		GridBagConstraints gbc_partidaNumero = new GridBagConstraints();
		gbc_partidaNumero.insets = new Insets(0, 0, 5, 0);
		gbc_partidaNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_partidaNumero.gridx = 2;
		gbc_partidaNumero.gridy = 2;
		panel_1.add(partidaNumero, gbc_partidaNumero);
		partidaNumero.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Placar:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		placarField = new JTextField();
		GridBagConstraints gbc_placar = new GridBagConstraints();
		gbc_placar.fill = GridBagConstraints.HORIZONTAL;
		gbc_placar.gridx = 2;
		gbc_placar.gridy = 4;
		panel_1.add(placarField, gbc_placar);
		placarField.setColumns(10);
	}

	protected void fechar() {
		this.setVisible(false);
	}

	protected void inserirPartida() {
		try {
			int numero = validaNumero(partidaNumero.getText());
			int placar = validaPlacar(placarField.getText());
			service.inserir(new Partida(numero, placar));
			fechar();
		} catch (Exception e) {
			SwingUtils.mostrarErro(this, e.getMessage());
		}
	}

	private int validaPlacar(String text) throws DesafioExcecao {
		int placar = parseNumero(text);
		if (placar < 0 || placar > 1000)
			throw new DesafioExcecao("O placar deve ser um número entre 0 e 1000.");
		return placar;
	}

	private int parseNumero(String text) throws DesafioExcecao {
		try {
			return Integer.parseInt(text);
		} catch(NumberFormatException e) {
			throw new DesafioExcecao("Número inválido.");
		}
	}

	private int validaNumero(String text) throws DesafioExcecao {
		int numero = parseNumero(text);
		if (numero <= 0)
			throw new DesafioExcecao("O número da partida deve ser maior do que 1.");
		return numero;
	}

}
