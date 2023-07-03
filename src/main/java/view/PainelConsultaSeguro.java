package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
import model.exception.ClienteComSeguroException;
import model.seletor.SeguroSeletor;
import model.util.DateUtil;
import model.vo.Seguro;

public class PainelConsultaSeguro extends JPanel {

	private DatePicker primeiraDataVigenciaInicial;
	private DatePicker ultimaDataVigenciaInicial;

	private JTable tblListaSeguros;
	private ArrayList<Seguro> seguros;
	private String[] nomesColunas = { "Segurado", "Proposta", "Ve�culo", "Vig�nciaInicial ", "VigêciaFinal",
			" RCFMaterial", "RCF-Corporais", "Franquia", "Assistência", "CarroReserva" };
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
	private final int TAMANHO_PAGINA = 7;
	private int paginaAtual = 1;
	private int totalPaginas = 0;

	private SeguroSeletor seletor = new SeguroSeletor();
	private JButton btnVoltarPagina;
	private JButton btnAvancarPagina;
	private JLabel lblPaginacao;

	private void limparTabelaSeguros() {
		tblListaSeguros.setModel(new DefaultTableModel(
			new Object[][] {
				{"Segurado", "Proposta", "Veículo", "VigênciaInicial ", "VigêciaFinal", " RCFMaterial", "RCF-Corporais", "Franquia", "Assistência", "CarroReserva"},
			},
			new String[] {
				"Segurado", "Proposta", "Veículo", "VigênciaInicial ", "VigêciaFinal ", " RCFMaterial", "RCF-Corporais", "Franquia", "Assistência", "CarroReserva"
			}
		));
	}

	private void atualizarTabelaSeguros() {
		this.limparTabelaSeguros();

		DefaultTableModel model = (DefaultTableModel) tblListaSeguros.getModel();

		for (Seguro s : seguros) {
			Object[] novaLinhaDaTabela = new Object[10];
			novaLinhaDaTabela[0] = s.getIdPessoa();
			novaLinhaDaTabela[1] = s.getNumeroProposta();
			novaLinhaDaTabela[2] = s.getIdVeiculo();
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

		lnlNumeroProposta = new JLabel("Número proposta:");
		lnlNumeroProposta.setForeground(new Color(255, 255, 255));
		lnlNumeroProposta.setBackground(new Color(255, 255, 255));
		lnlNumeroProposta.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lnlNumeroProposta.setBounds(87, 109, 133, 19);
		add(lnlNumeroProposta);

		txtNumeroProposta = new JTextField();
		txtNumeroProposta.setBackground(new Color(255, 255, 255));
		txtNumeroProposta.setBounds(217, 107, 477, 26);
		add(txtNumeroProposta);
		txtNumeroProposta.setColumns(10);

		lblVigenciaInicio = new JLabel("Data início vigência De:");
		add(lblVigenciaInicio);
		lblVigenciaInicio.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblVigenciaInicio.setForeground(new Color(255, 255, 255));
		lblVigenciaInicio.setBounds(37, 158, 205, 19);

		primeiraDataVigenciaInicial = new DatePicker();
		primeiraDataVigenciaInicial.getComponentToggleCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		primeiraDataVigenciaInicial.setBounds(217, 157, 324, 26);
		this.add(primeiraDataVigenciaInicial);

		lblAte = new JLabel("Até:");
		lblAte.setForeground(Color.WHITE);
		lblAte.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblAte.setBounds(173, 196, 47, 19);
		add(lblAte);

		ultimaDataVigenciaInicial = new DatePicker();
		ultimaDataVigenciaInicial.setBounds(217, 194, 324, 26);
		this.add(ultimaDataVigenciaInicial);

		tblListaSeguros = new JTable();
		this.limparTabelaSeguros();

		tblListaSeguros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indiceSelecionado = tblListaSeguros.getSelectedRow();

				if (indiceSelecionado > 0) {
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
					seguroSelecionado = seguros.get(indiceSelecionado - 1);
				} else {
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(true);
				}
			}
		});
		tblListaSeguros.setBounds(37, 282, 1189, 143);
		add(tblListaSeguros);

//		tblListaSeguros.setModel(new DefaultTableModel(
//				new Object[][] { { "Segurado", "Proposta", "Ve\u00EDculo", " RCFMaterial", "RCF-Corporais", "Franquia",
//						"Assist\u00EAncia", "CarroReserva", "Vig\u00EAnciaInicial ", "Vig\u00EAnciaFinal" }, },
//				new String[] { "Segurado", "NumeroProposta", "Ve\u00EDculo", "Coberturas", "", "", "", "",
//						"Vig\u00EAnciaInicial ", "Vig\u00EAnciaFinal" }));
//		tblListaSeguros.getColumnModel().getColumn(0).setPreferredWidth(241);
//		tblListaSeguros.getColumnModel().getColumn(2).setPreferredWidth(102);
//		tblListaSeguros.getColumnModel().getColumn(3).setPreferredWidth(141);
//		tblListaSeguros.getColumnModel().getColumn(4).setPreferredWidth(138);
//		tblListaSeguros.getColumnModel().getColumn(5).setPreferredWidth(186);
//		tblListaSeguros.getColumnModel().getColumn(6).setPreferredWidth(187);
//		tblListaSeguros.getColumnModel().getColumn(7).setPreferredWidth(201);
//		tblListaSeguros.getColumnModel().getColumn(8).setPreferredWidth(121);
//		tblListaSeguros.getColumnModel().getColumn(9).setPreferredWidth(131);

		btnBuscarTodos = new JButton("BuscarTodos");
		btnBuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscarSegurosComFiltros();
					atualizarTabelaSeguros();
				} catch (CampoInvalidoException e1) {
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
				
				JFileChooser janelaSelecaoDestinoArquivo = new JFileChooser();
				janelaSelecaoDestinoArquivo.setDialogTitle("Selecione um destino para a planilha...");

				int opcaoSelecionada = janelaSelecaoDestinoArquivo.showSaveDialog(null);
				if (opcaoSelecionada == JFileChooser.APPROVE_OPTION) {
					String caminhoEscolhido = janelaSelecaoDestinoArquivo.getSelectedFile().getAbsolutePath();
					String resultado;
					try {
						resultado = controller.gerarPlanilha(seguros, caminhoEscolhido);
						JOptionPane.showMessageDialog(null, resultado);
					} catch (CampoInvalidoException e1) {
						JOptionPane.showConfirmDialog(null, e1.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
					}
				}
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
		btnEditar.setBounds(250, 487, 147, 38);
		add(btnEditar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcaoSelecionada = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do seguro selecionado?");
				if (opcaoSelecionada == JOptionPane.YES_OPTION) {
					try {
						controller.excluir(seguroSelecionado.getId());
						JOptionPane.showMessageDialog(null, "Seguro exclu�do com sucesso");
						seguros = (ArrayList<Seguro>) controller.consultarTodos();
						atualizarTabelaSeguros();
					} catch (ClienteComSeguroException e1) {
						JOptionPane.showConfirmDialog(null, e1.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		this.add(btnExcluir);

		btnExcluir.setHorizontalAlignment(SwingConstants.LEFT);
		btnExcluir.setIcon(new ImageIcon(PainelConsultaSeguro.class.getResource("/icones/icons8-excluir-48.png")));
		btnExcluir.setBackground(new Color(231, 200, 24));
		btnExcluir.setBounds(510, 487, 133, 38);
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
		btnVoltarPagina.setBounds(275, 436, 123, 23);
		add(btnVoltarPagina);

		btnAvancarPagina = new JButton("Avançar");
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
		btnAvancarPagina.setBounds(510, 436, 123, 23);
		add(btnAvancarPagina);

		lblPaginacao = new JLabel("1 / 0");
		lblPaginacao.setForeground(new Color(255, 255, 255));
		lblPaginacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPaginacao.setBounds(435, 439, 46, 14);
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
		if (txtNumeroProposta != null && !txtNumeroProposta.getText().isEmpty()) {
			try {
				int numeroProposta = Integer.parseInt(txtNumeroProposta.getText());
				seletor.setNumeroProposta(numeroProposta);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Número de proposta inv�lido");

				return;
			}
		}

		seletor.setPrimeiraDataInicioVigencia(primeiraDataVigenciaInicial.getDate());
		seletor.setUltimaDataInicioVigencia(ultimaDataVigenciaInicial.getDate());
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
