package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;

import controller.SeguroController;
import model.exception.CampoInvalidoException;
import model.seletor.SeguroSeletor;
import model.util.DateUtil;
import model.vo.Seguro;

public class PainelConsultaSeguro extends JPanel {

	private DatePicker dataVigenciaInicial;
	private DatePicker dataVigenciaFinal;

	private JTable tblListaSeguros;
	private ArrayList<Seguro> seguros;
	private String[] nomesColunas = { "Segurado", "Proposta", "Ve�culo", "Vig�nciaInicial ", "Vig�nciaFinal",
			" RCFMaterial", "RCF-Corporais", "Franquia", "Assist�ncia", "CarroReserva" };
	private JTextField txtNumeroProposta;
	private JLabel lnlNumeroProposta;
	private JLabel lblVigenciaInicio;
	private JLabel lblAte;
	private JButton btnBuscarTodos;
	private JButton btnGerarPlanilha;
	private JButton btnExcluir;
	private JButton btnEditar;

	private SeguroController controller = new SeguroController();
	private Seguro seguroSelecionado;

	// Atributos para a PAGINA��O
	private final int TAMANHO_PAGINA = 5;
	private int paginaAtual = 1;
	private int totalPaginas = 0;

	private SeguroSeletor seletor = new SeguroSeletor();
	private JButton btnVoltarPagina;
	private JButton btnAvancarPagina;
	private JLabel lblPaginacao;

	private void limparTabelaSeguros() {
		tblListaSeguros.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}

	private void atualizarTabelaSeguros() {
		this.limparTabelaSeguros();

		DefaultTableModel model = (DefaultTableModel) tblListaSeguros.getModel();

		for (Seguro s : seguros) {
			Object[] novaLinhaDaTabela = new Object[10];
			novaLinhaDaTabela[0] = s.getNomeSegurado();
			novaLinhaDaTabela[1] = s.getNumeroProposta();
			novaLinhaDaTabela[2] = s.getPlacaVeiculo();
			novaLinhaDaTabela[3] = DateUtil.formatarDataPadraoBrasil(s.getDtInicioVigencia());
			novaLinhaDaTabela[4] = DateUtil.formatarDataPadraoBrasil(s.getDtFimVigencia());
			novaLinhaDaTabela[5] = s.getRcfDanosMateriais();
			novaLinhaDaTabela[6] = s.getRcfDanosCorporais();
			novaLinhaDaTabela[7] = s.getFranquia();
			novaLinhaDaTabela[8] = s.getAssistencia();
			novaLinhaDaTabela[9] = s.getCarroReserva();

			model.addRow(novaLinhaDaTabela);
		}
	}

	public PainelConsultaSeguro() {
		setBackground(new Color(26, 158, 230));
		setLayout(null);

		lnlNumeroProposta = new JLabel("N�mero proposta:");
		lnlNumeroProposta.setForeground(new Color(255, 255, 255));
		lnlNumeroProposta.setBackground(new Color(255, 255, 255));
		lnlNumeroProposta.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lnlNumeroProposta.setBounds(87, 109, 133, 19);
		add(lnlNumeroProposta);

		txtNumeroProposta = new JTextField();
		txtNumeroProposta.setBackground(new Color(255, 255, 255));
		txtNumeroProposta.setBounds(217, 107, 496, 26);
		add(txtNumeroProposta);
		txtNumeroProposta.setColumns(10);

		lblVigenciaInicio = new JLabel("Data inic�o vig�ncia. De:");
		add(lblVigenciaInicio);
		lblVigenciaInicio.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblVigenciaInicio.setForeground(new Color(255, 255, 255));
		lblVigenciaInicio.setBounds(46, 157, 174, 19);

		dataVigenciaInicial = new DatePicker();
		dataVigenciaInicial.getComponentToggleCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		dataVigenciaInicial.setBounds(217, 157, 324, 26);
		this.add(dataVigenciaInicial);

		lblAte = new JLabel("At�:");
		lblAte.setForeground(Color.WHITE);
		lblAte.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblAte.setBounds(173, 196, 47, 19);
		add(lblAte);

		dataVigenciaFinal = new DatePicker();
		dataVigenciaFinal.setBounds(217, 194, 324, 26);
		this.add(dataVigenciaFinal);

		tblListaSeguros = new JTable();
		tblListaSeguros.setBounds(37, 282, 1086, 235);
		add(tblListaSeguros);
		tblListaSeguros.setModel(new DefaultTableModel(
			new Object[][] {
				{"Segurado", "Proposta", "Ve\u00EDculo", " RCFMaterial", "RCF-Corporais", "Franquia", "Assist\u00EAncia", "CarroReserva", "Vig\u00EAnciaInicial ", "Vig\u00EAnciaFinal"},
			},
			new String[] {
				"Segurado", "NumeroProposta", "Ve\u00EDculo", "Coberturas", "", "", "", "", "Vig\u00EAnciaInicial ", "Vig\u00EAnciaFinal"
			}
		));
		tblListaSeguros.getColumnModel().getColumn(0).setPreferredWidth(241);
		tblListaSeguros.getColumnModel().getColumn(2).setPreferredWidth(102);
		tblListaSeguros.getColumnModel().getColumn(3).setPreferredWidth(141);
		tblListaSeguros.getColumnModel().getColumn(4).setPreferredWidth(138);
		tblListaSeguros.getColumnModel().getColumn(5).setPreferredWidth(186);
		tblListaSeguros.getColumnModel().getColumn(6).setPreferredWidth(187);
		tblListaSeguros.getColumnModel().getColumn(7).setPreferredWidth(201);
		tblListaSeguros.getColumnModel().getColumn(8).setPreferredWidth(121);
		tblListaSeguros.getColumnModel().getColumn(9).setPreferredWidth(131);

		btnBuscarTodos = new JButton("BuscarTodos");
		btnBuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscarSegurosComFiltros();
				} catch (CampoInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuscarTodos.setIcon(new ImageIcon(PainelConsultaSeguro.class.getResource("/icones/icons8-lupa-50.png")));
		btnBuscarTodos.setBackground(new Color(231, 200, 24));
		btnBuscarTodos.setBounds(217, 231, 181, 38);
		add(btnBuscarTodos);

		btnGerarPlanilha = new JButton("Gerar Planilha");
		btnGerarPlanilha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGerarPlanilha
				.setIcon(new ImageIcon(PainelConsultaSeguro.class.getResource("/icones/icons8-planilha-50.png")));
		btnGerarPlanilha.setBackground(new Color(231, 200, 24));
		btnGerarPlanilha.setBounds(510, 231, 184, 38);
		add(btnGerarPlanilha);

		btnEditar = new JButton("Editar");
		

		btnEditar.setIcon(new ImageIcon(PainelConsultaSeguro.class.getResource("/icones/icons8-editar-48.png")));
		btnEditar.setBackground(new Color(231, 200, 24));
		btnEditar.setBounds(254, 583, 147, 38);
		add(btnEditar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnExcluir.setHorizontalAlignment(SwingConstants.LEFT);
		btnExcluir.setIcon(new ImageIcon(PainelConsultaSeguro.class.getResource("/icones/icons8-excluir-48.png")));
		btnExcluir.setBackground(new Color(231, 200, 24));
		btnExcluir.setBounds(561, 583, 133, 38);
		add(btnExcluir);

		JLabel lblIconeTitulo = new JLabel("Consultar Seguro");
		lblIconeTitulo.setIcon(new ImageIcon(PainelConsultaSeguro.class.getResource("/icones/icons8-lupa-48.png")));
		lblIconeTitulo.setForeground(new Color(255, 255, 255));
		lblIconeTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblIconeTitulo.setBounds(409, 25, 181, 47);
		add(lblIconeTitulo);

		btnVoltarPagina = new JButton("<< Voltar");
		btnVoltarPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paginaAtual--;
				try {
					buscarSegurosComFiltros();
				} catch (CampoInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lblPaginacao.setText(paginaAtual + " / " + totalPaginas);
				btnVoltarPagina.setEnabled(paginaAtual > 1);
				btnAvancarPagina.setEnabled(paginaAtual < totalPaginas);
			}
		});
		btnVoltarPagina.setBounds(295, 528, 123, 23);
		add(btnVoltarPagina);

		btnAvancarPagina = new JButton("Avançar >>");
		btnAvancarPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paginaAtual++;
				try {
					buscarSegurosComFiltros();
				} catch (CampoInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lblPaginacao.setText(paginaAtual + " / " + totalPaginas);
				btnVoltarPagina.setEnabled(paginaAtual > 1);
				btnAvancarPagina.setEnabled(paginaAtual < totalPaginas);
			}
		});
		btnAvancarPagina.setBounds(538, 528, 123, 23);
		add(btnAvancarPagina);

		lblPaginacao = new JLabel("1 / 0");
		lblPaginacao.setForeground(new Color(255, 255, 255));
		lblPaginacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPaginacao.setBounds(455, 535, 46, 14);
		add(lblPaginacao);

	}

	private void atualizarQuantidadePaginas() {
		// C�lculo do total de p�ginas (poderia ser feito no backend)
		int totalRegistros = controller.contarTotalRegistrosComFiltros(seletor);

		// QUOCIENTE da divis�o inteira
		totalPaginas = totalRegistros / TAMANHO_PAGINA;

		// RESTO da divis�o inteira
		if (totalRegistros % TAMANHO_PAGINA > 0) {
			totalPaginas++;
		}

		lblPaginacao.setText(paginaAtual + " / " + totalPaginas);
	}

	protected void buscarSegurosComFiltros() throws CampoInvalidoException {
		seletor = new SeguroSeletor();
		seletor.setLimite(TAMANHO_PAGINA);
		seletor.setPagina(paginaAtual);
		String textoNumeroProposta = txtNumeroProposta.getText();
		if (textoNumeroProposta != null && !textoNumeroProposta.trim().isEmpty()) {
			seletor.setNumero_proposta(Integer.parseInt(txtNumeroProposta.getText()));

		}

		seletor.setDt_inicio_vigencia(dataVigenciaInicial.getDate());
		seletor.setDt_fim_vigencia(dataVigenciaFinal.getDate());
		seguros = (ArrayList<Seguro>) controller.consultarComFiltros(seletor);
		atualizarTabelaSeguros();
		atualizarQuantidadePaginas();
	}

	public JButton getBtnEditar() {
		return btnEditar;

	}

	public Seguro getSeguroSelecionado() {
		return seguroSelecionado;
	}


}
