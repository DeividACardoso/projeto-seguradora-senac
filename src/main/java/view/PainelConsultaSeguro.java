package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

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
		txtNumeroProposta.setBackground(new Color(255, 255, 255));
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
		tableListaSeguros.setForeground(new Color(0, 0, 0));
		tableListaSeguros.setBackground(new Color(255, 255, 255));
		tableListaSeguros.setBounds(46, 251, 546, 257);
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
		btnBuscarTodos.setIcon(new ImageIcon(PainelConsultaSeguro.class.getResource("/icones/icons8-lupa-50.png")));
		btnBuscarTodos.setBackground(new Color(231, 200, 24));
		btnBuscarTodos.setBounds(217, 202, 147, 38);
		add(btnBuscarTodos);
		
		JButton btnGerarPlanilha = new JButton("Gerar Planilha");
		btnGerarPlanilha.setIcon(new ImageIcon(PainelConsultaSeguro.class.getResource("/icones/icons8-planilha-50.png")));
		btnGerarPlanilha.setBackground(new Color(231, 200, 24));
		btnGerarPlanilha.setBounds(423, 202, 169, 38);
		add(btnGerarPlanilha);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(PainelConsultaSeguro.class.getResource("/icones/icons8-editar-48.png")));
		btnEditar.setBackground(new Color(231, 200, 24));
		btnEditar.setBounds(217, 519, 147, 38);
		add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setHorizontalAlignment(SwingConstants.LEFT);
		btnExcluir.setIcon(new ImageIcon(PainelConsultaSeguro.class.getResource("/icones/icons8-excluir-48.png")));
		btnExcluir.setBackground(new Color(231, 200, 24));
		btnExcluir.setBounds(459, 519, 133, 38);
		add(btnExcluir);
		
		
		
		

	}
}
