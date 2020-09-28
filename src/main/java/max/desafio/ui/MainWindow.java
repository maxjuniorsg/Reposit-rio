package max.desafio.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import max.desafio.utils.SwingUtils;

public class MainWindow extends JFrame {
	
	public MainWindow() {
		setLocationByPlatform(true);
		setSize(new Dimension(500, 300));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Desafio Java");

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(64, 32, 64, 32));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 32, 32));

		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		btnCadastro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btnCadastro);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btnConsultar);
	}

	protected void consultar() {
		try {
			ConsultaDialog consultaDlg = new ConsultaDialog();
			consultaDlg.setVisible(true);
			consultaDlg.dispose();
		} catch (Exception e) {
			SwingUtils.mostrarErro(this, e.getMessage());
		}
	}

	protected void cadastrar() {
		CadastroDialog cadastroDlg = new CadastroDialog();
		cadastroDlg.setVisible(true);
		cadastroDlg.dispose();
	}

}
