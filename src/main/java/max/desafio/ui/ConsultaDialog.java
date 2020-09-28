package max.desafio.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import max.desafio.exceptions.DesafioExcecao;
import max.desafio.model.PartidaResultado;
import max.desafio.services.PartidasService;
import max.desafio.services.impl.PartidasServiceImpl;
import java.awt.Dimension;

public class ConsultaDialog extends JDialog {

	private PartidasService service = new PartidasServiceImpl();
	private JLabel lblResultado;

	public ConsultaDialog() throws DesafioExcecao {
		setSize(new Dimension(500, 300));
		setModal(true);
		setTitle("Consulta");

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		lblResultado = new JLabel(buildText());
		scrollPane.setViewportView(lblResultado);
	}

	private String buildText() throws DesafioExcecao {
		List<PartidaResultado> todas = service.buscarTodas();
		StringBuilder sb = new StringBuilder("<html><head>\n"
				+ "<style>\n"
				+ "  .odd { background: #a0a0a0; } \n"
				+ "  .even { background: #e0e0e0; } \n"
				+ "  .header { background: #0000f0; color: white; } \n"
				+ "</style>\n"
				+ "</head><body><table><tr><td class=\"header\">Jogo</td><td class=\"header\">Placar</td><td class=\"header\">Mínimo da temporada</td><td class=\"header\">Máximo da temporada</td><td class=\"header\">Quebra recorde min.</td><td class=\"header\">Quebra recorde máx.</td></tr>");
		int i = 0;
		for (PartidaResultado resultado : todas) {
			String cls = (i++) % 2 == 0 ? "odd" : "even";
			String linha = "<tr><td class=\"" + cls + "\">" + resultado.getPartida().getNumero() + "</td><td class=\""
					+ cls + "\">" + resultado.getPartida().getPlacar() + "</td><td class=\"" + cls + "\">"
					+ resultado.getMinimoTemporada() + "</td><td class=\"" + cls + "\">"
					+ resultado.getMaximoTemporada() + "</td><td class=\"" + cls + "\">"
					+ resultado.getQuebraRecordeMin() + "</td><td class=\"" + cls + "\">"
					+ resultado.getQuebraRecordeMax() + "</td></tr>";
			sb.append(linha);
		}
		sb.append("</table></body>" + "</html>");
		return sb.toString();
	}

}
