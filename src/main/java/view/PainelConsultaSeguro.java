package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;

import controller.SeguroController;
import model.seletor.SeguroSeletor;
import model.vo.Seguro;


public class PainelConsultaSeguro extends JPanel {

	private DatePicker dtVigenciaInicial;
	private DatePicker dtVigenciaFinal;
	
	private JTable tblListaSeguros;
	private ArrayList<Seguro> seguros;
	private String[] nomesColunas = { "Segurado", "Veículo", "Coberturas", "Vigência" };
	private JTextField txtNumeroProposta;
	private JLabel lnlNumeroProposta;
	private JLabel lblVigenciaInicio;
	private JLabel lblAte;
	private JButton btnBuscarTodos;
	private JButton btnGerarPlanilha;
	private JButton btnExcluir;
	private JButton BtnEditar;
	
	private MaskFormatter mascaraData;
	

	private SeguroController controller = new SeguroController();
	private Seguro seguroSelecionado;

	
	
	//Atributos para a PAGINAÇÃO
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
				Object[] novaLinhaDaTabela = new Object[5];
				novaLinhaDaTabela[0] = s.getNomeSegurado();
				novaLinhaDaTabela[1] = s.getPlacaVeiculo();
				novaLinhaDaTabela[2] = s.getRcf_danos_materiais();
				novaLinhaDaTabela[3] = s.getRcf_danos_corporais();
				novaLinhaDaTabela[4] = s.getFranquia();
				novaLinhaDaTabela[5] = s.getAssistencia();
				novaLinhaDaTabela[6] = s.getCarroReserva();
				novaLinhaDaTabela[7] = s.getDt_inicio_vigencia();
				novaLinhaDaTabela[8] = s.getDt_fim_vigencia();
				

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
		txtNumeroProposta.setBounds(217, 107, 496, 26);
		add(txtNumeroProposta);
		txtNumeroProposta.setColumns(10);
		
		
		lblVigenciaInicio = new JLabel("Data inicío vigência. De:");
		add(lblVigenciaInicio);
		lblVigenciaInicio.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblVigenciaInicio.setForeground(new Color(255, 255, 255));
		lblVigenciaInicio.setBounds(46, 157, 174, 19);
		
		dtVigenciaInicial = new DatePicker();
		dtVigenciaInicial.getComponentToggleCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		dtVigenciaInicial.setBounds(217, 157, 324, 26);
		this.add(dtVigenciaInicial);
		
		lblAte = new JLabel("Até:");
		lblAte.setForeground(Color.WHITE);
		lblAte.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblAte.setBounds(173, 196, 47, 19);
		add(lblAte);
		
		dtVigenciaFinal = new DatePicker();
		dtVigenciaFinal.setBounds(217, 194, 324, 26);
		this.add(dtVigenciaFinal);
		
		tblListaSeguros = new JTable();
		tblListaSeguros.setBounds(33, 282, 948, 235);
		add(tblListaSeguros);
		tblListaSeguros
				.setModel(new DefaultTableModel(
			new Object[][] {
				{"Segurado", "Ve\u00EDculo", " RCFMaterial", "RCF-Corporais", "Franquia", "Assist\u00EAncia", "CarroReserva", "Vig\u00EAnciaInicial ", "Vig\u00EAnciaFinal"},
			},
			new String[] {
				"Segurado", "Ve\u00EDculo", "Coberturas", "", "", "", "", "Vig\u00EAnciaInicial ", "Vig\u00EAnciaFinal"
			}
		));
		tblListaSeguros.getColumnModel().getColumn(0).setPreferredWidth(149);
		tblListaSeguros.getColumnModel().getColumn(1).setPreferredWidth(102);
		tblListaSeguros.getColumnModel().getColumn(2).setPreferredWidth(141);
		tblListaSeguros.getColumnModel().getColumn(3).setPreferredWidth(138);
		tblListaSeguros.getColumnModel().getColumn(4).setPreferredWidth(186);
		tblListaSeguros.getColumnModel().getColumn(5).setPreferredWidth(187);
		tblListaSeguros.getColumnModel().getColumn(6).setPreferredWidth(201);
		tblListaSeguros.getColumnModel().getColumn(7).setPreferredWidth(121);
		tblListaSeguros.getColumnModel().getColumn(8).setPreferredWidth(131);

		btnBuscarTodos = new JButton("BuscarTodos");
		btnBuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarSegurosComFiltros();
			}
		});
		btnBuscarTodos.setIcon(new ImageIcon(PainelConsultaSeguro.class.getResource("/icones/icons8-lupa-50.png")));
		btnBuscarTodos.setBackground(new Color(231, 200, 24));
		btnBuscarTodos.setBounds(217, 231, 181, 38);
		add(btnBuscarTodos);

		btnGerarPlanilha = new JButton("Gerar Planilha");
		btnGerarPlanilha
				.setIcon(new ImageIcon(PainelConsultaSeguro.class.getResource("/icones/icons8-planilha-50.png")));
		btnGerarPlanilha.setBackground(new Color(231, 200, 24));
		btnGerarPlanilha.setBounds(510, 231, 184, 38);
		add(btnGerarPlanilha);

		BtnEditar = new JButton("Editar");
		BtnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionadaNaTabela = tblListaSeguros.getSelectedRow();
				Seguro seguroSelecionado = seguros.get(linhaSelecionadaNaTabela - 1);

				 JOptionPane.showMessageDialog(null, "Chamar a tela de edição para o seguro com ID: " + seguroSelecionado.getId());
	        }
		});

		BtnEditar.setIcon(new ImageIcon(PainelConsultaSeguro.class.getResource("/icones/icons8-editar-48.png")));
		BtnEditar.setBackground(new Color(231, 200, 24));
		BtnEditar.setBounds(254, 583, 147, 38);
		add(BtnEditar);

		btnExcluir = new JButton("Excluir");
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
				buscarSegurosComFiltros();
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
				buscarSegurosComFiltros();
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
		//Cálculo do total de páginas (poderia ser feito no backend)
		int totalRegistros = controller.contarTotalRegistrosComFiltros(seletor);
		
		//QUOCIENTE da divisão inteira
		totalPaginas = totalRegistros / TAMANHO_PAGINA;
		
		//RESTO da divisão inteira
		if(totalRegistros % TAMANHO_PAGINA > 0) { 
			totalPaginas++;
		}
		
		lblPaginacao.setText(paginaAtual + " / " + totalPaginas);
	}
	
	protected void buscarSegurosComFiltros() {
		seletor = new SeguroSeletor();
		seletor.setLimite(TAMANHO_PAGINA);
		seletor.setPagina(paginaAtual);
		seletor.setNumero_proposta(Integer.parseInt(txtNumeroProposta.getText()));
		
		seletor.setDt_inicio_vigencia(dtVigenciaInicial.getDate());
		seletor.setDt_fim_vigencia(dtVigenciaFinal.getDate());
		seguros = (ArrayList<Seguro>) controller.consultarComFiltros(seletor);
		atualizarTabelaSeguros();
		atualizarQuantidadePaginas();
	}

	
	public JButton getBtnEditar() {
		return BtnEditar;

	}

	public Seguro getSeguroSelecionado() {
		return seguroSelecionado;
	}

}
