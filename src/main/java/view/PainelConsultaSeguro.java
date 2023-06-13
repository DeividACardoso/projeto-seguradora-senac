package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.AbstractButton;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.SeguroController;
import model.vo.Seguro;

public class PainelConsultaSeguro extends JPanel {

	private ArrayList<Seguro> seguros;
	private JTextField txtNumeroProposta;
	private JTextField txtIncioVigencia;
	private JTextField txtFimVigencia;
	private JTable tblListaSeguros;
	private JLabel lnlNumeroProposta;
	private JLabel lblVigenciaInicio;
	private JLabel lblVigenciaIFim;
	private JButton btnBuscarTodos;
	private JButton btnGerarPlanilha;
	private JButton btnExcluir;
	private JButton BtnEditar;

	private SeguroController controller = new SeguroController();
	private Seguro seguroSelecionado;

	/**
	 * Create the panel.
	 */
	public PainelConsultaSeguro() {
		setBackground(new Color(26, 158, 230));
		setLayout(null);

		lnlNumeroProposta = new JLabel("N\u00FAmero proposta:");
		lnlNumeroProposta.setForeground(new Color(255, 255, 255));
		lnlNumeroProposta.setBackground(new Color(255, 255, 255));
		lnlNumeroProposta.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lnlNumeroProposta.setBounds(46, 109, 133, 19);
		add(lnlNumeroProposta);

		lblVigenciaInicio = new JLabel("Data inic\u00EDo vig\u00EAncia. De:");
		lblVigenciaInicio.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblVigenciaInicio.setForeground(new Color(255, 255, 255));
		lblVigenciaInicio.setBounds(46, 157, 174, 19);
		add(lblVigenciaInicio);

		lblVigenciaIFim = new JLabel("At\u00E9:");
		lblVigenciaIFim.setForeground(Color.WHITE);
		lblVigenciaIFim.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblVigenciaIFim.setBounds(185, 196, 47, 19);
		add(lblVigenciaIFim);

		txtNumeroProposta = new JTextField();
		txtNumeroProposta.setBackground(new Color(255, 255, 255));
		txtNumeroProposta.setBounds(172, 107, 420, 26);
		add(txtNumeroProposta);
		txtNumeroProposta.setColumns(10);

		txtIncioVigencia = new JTextField();
		txtIncioVigencia.setColumns(10);
		txtIncioVigencia.setBounds(217, 155, 375, 26);
		add(txtIncioVigencia);

		txtFimVigencia = new JTextField();
		txtFimVigencia.setColumns(10);
		txtFimVigencia.setBounds(217, 194, 375, 26);
		add(txtFimVigencia);
		
		tblListaSeguros.setForeground(new Color(0, 0, 0));
		tblListaSeguros.setBackground(new Color(255, 255, 255));
		tblListaSeguros.setBounds(46, 280, 546, 257);
		add(tblListaSeguros);
		tblListaSeguros.setModel(
				new DefaultTableModel(new Object[][] { { "Segurado", "Ve\u00EDculo", "Vig\u00EAncia", "Coberturas" }, },
						new String[] { "Segurado", "Ve\u00EDculo", "Vig\u00EAncia", "Coberturas" }));

		btnBuscarTodos = new JButton("BuscarTodos");
		btnBuscarTodos.setIcon(new ImageIcon(PainelConsultaSeguro.class.getResource("/icones/icons8-lupa-50.png")));
		btnBuscarTodos.setBackground(new Color(231, 200, 24));
		btnBuscarTodos.setBounds(217, 231, 147, 38);
		add(btnBuscarTodos);

		btnGerarPlanilha = new JButton("Gerar Planilha");
		btnGerarPlanilha
				.setIcon(new ImageIcon(PainelConsultaSeguro.class.getResource("/icones/icons8-planilha-50.png")));
		btnGerarPlanilha.setBackground(new Color(231, 200, 24));
		btnGerarPlanilha.setBounds(423, 231, 169, 38);
		add(btnGerarPlanilha);

		BtnEditar = new JButton("Editar");
		BtnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionadaNaTabela = tblListaSeguros.getSelectedRow();
				Seguro seguroSelecionado = seguros.get(linhaSelecionadaNaTabela - 1);
				JOptionPane.showMessageDialog(null, "Chamar a tela de edição e passar o objeto seguroSelecionado...");
			}
		});

		BtnEditar.setIcon(new ImageIcon(PainelConsultaSeguro.class.getResource("/icones/icons8-editar-48.png")));
		BtnEditar.setBackground(new Color(231, 200, 24));
		BtnEditar.setBounds(217, 562, 147, 38);
		add(BtnEditar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setHorizontalAlignment(SwingConstants.LEFT);
		btnExcluir.setIcon(new ImageIcon(PainelConsultaSeguro.class.getResource("/icones/icons8-excluir-48.png")));
		btnExcluir.setBackground(new Color(231, 200, 24));
		btnExcluir.setBounds(459, 562, 133, 38);
		add(btnExcluir);

		JLabel lblIconeTitulo = new JLabel("Consultar Seguro");
		lblIconeTitulo.setIcon(new ImageIcon(PainelConsultaSeguro.class.getResource("/icones/icons8-lupa-48.png")));
		lblIconeTitulo.setForeground(new Color(255, 255, 255));
		lblIconeTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblIconeTitulo.setBounds(217, 24, 181, 47);
		add(lblIconeTitulo);

	}

	public JButton getBtnEditar() {
		return BtnEditar;

	}

	public Seguro getSeguroSelecionado() {
		return seguroSelecionado;
	}

	public AbstractButton getBtnEditar() {
		// TODO Auto-generated method stub
		return null;
	}

	public LayoutManager getSeguroSelecionado() {
		// TODO Auto-generated method stub
		return null;
	}
}
