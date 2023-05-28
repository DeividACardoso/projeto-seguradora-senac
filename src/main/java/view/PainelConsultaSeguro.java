package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class PainelConsultaSeguro extends JPanel {
	private JTextField txtNumeroProposta;
	private JTextField txtIncioVigencia;
	private JTextField txtFimVigencia;
	private JTable table;
	private JTable table_1;
	private final JTable tableListaSeguros = new JTable();

	/**
	 * Create the panel.
	 */
	public PainelConsultaSeguro() {
		setBackground(new Color(26, 158, 230));
		setLayout(null);
		
		JLabel lnlNumeroProposta = new JLabel("N\u00FAmero proposta:");
		lnlNumeroProposta.setForeground(new Color(255, 255, 255));
		lnlNumeroProposta.setBackground(new Color(255, 255, 255));
		lnlNumeroProposta.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lnlNumeroProposta.setBounds(46, 71, 133, 19);
		add(lnlNumeroProposta);
		
		JLabel lblVigenciaInicio = new JLabel("Data inic\u00EDo vig\u00EAncia. De:");
		lblVigenciaInicio.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblVigenciaInicio.setForeground(new Color(255, 255, 255));
		lblVigenciaInicio.setBounds(46, 119, 174, 19);
		add(lblVigenciaInicio);
		
		JLabel lblVigenciaIFim = new JLabel("At\u00E9:");
		lblVigenciaIFim.setForeground(Color.WHITE);
		lblVigenciaIFim.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblVigenciaIFim.setBounds(183, 162, 47, 19);
		add(lblVigenciaIFim);
		
		txtNumeroProposta = new JTextField();
		txtNumeroProposta.setBounds(172, 69, 420, 26);
		add(txtNumeroProposta);
		txtNumeroProposta.setColumns(10);
		
		txtIncioVigencia = new JTextField();
		txtIncioVigencia.setColumns(10);
		txtIncioVigencia.setBounds(217, 117, 375, 26);
		add(txtIncioVigencia);
		
		txtFimVigencia = new JTextField();
		txtFimVigencia.setColumns(10);
		txtFimVigencia.setBounds(217, 160, 375, 26);
		add(txtFimVigencia);
		tableListaSeguros.setBounds(46, 251, 546, 315);
		add(tableListaSeguros);
		tableListaSeguros.setModel(new DefaultTableModel(
			new Object[][] {
				{"Segurado", "Ve\u00EDculo", "Vig\u00EAncia", "Coberturas"},
			},
			new String[] {
				"Segurado", "Ve\u00EDculo", "Vig\u00EAncia", "Coberturas"
			}
		));
		
		JButton btnBuscarTodos = new JButton("BuscarTodos");
		btnBuscarTodos.setBounds(217, 208, 147, 32);
		add(btnBuscarTodos);
		
		JButton btnGerarPlanilha = new JButton("Gerar Planilha");
		btnGerarPlanilha.setBounds(445, 208, 147, 32);
		add(btnGerarPlanilha);
		
		
		
		

	}
}
