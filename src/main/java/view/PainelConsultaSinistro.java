package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.SinistroController;
import model.exception.CampoInvalidoException;
import model.seletor.SinistroSeletor;
import model.vo.Sinistro;
import model.vo.Situacao;

public class PainelConsultaSinistro extends JPanel {
	private final int TAMANHO_PAGINA = 7;
	private int paginaAtual = 1;
	private int totalPaginas = 0;
	private JTextField txtNumero;
	private JTextField txtNomeSegurado;
	private DatePickerSettings dateSettings;
	private DatePicker dataInicio;
	private DatePicker dataFim;
	private SinistroController controller = new SinistroController();
	private List<Sinistro> sinistros = new ArrayList();
	private String[] nomeColunas = {"ID", "Número Sinistro", "Segurado", "Veículo", "TipoSinistro", "Data", "Situação"};
	private final JTable tableSinistro = new JTable();
	private JButton btnEditar;
	private JButton btnExcluir;
	private Sinistro sinistroSelecionado;
	private PainelConsultaSinistro painelConsultaSinistro;
	private SinistroSeletor seletor = new SinistroSeletor();
	private DatePicker dpDataInicio;
	private DatePicker dpDataFim;
	private JComboBox cbSituacao;
	private JButton btnGerarPlanilha;
	private JButton btnLimpar;

	private void limparTabela() {
		tableSinistro.setModel(new DefaultTableModel(new Object[][] {nomeColunas, }, nomeColunas));
	}
	private void atualizarTabela() {
		this.limparTabela();
		
		DefaultTableModel model = (DefaultTableModel) tableSinistro.getModel();
		
		for(Sinistro s : this.sinistros) {
			Object[] novaLinhaDaTabela = new Object[7];
			novaLinhaDaTabela[0] = s.getId();
			novaLinhaDaTabela[1] = s.getNumeroSinistro();
			novaLinhaDaTabela[2] = s.getPessoa().getNome();
			novaLinhaDaTabela[3] = s.getVeiculo().getPlacaVeiculo();
			novaLinhaDaTabela[4] = s.getTipoSinistro();
			novaLinhaDaTabela[5] = s.getDataSinistro();
			novaLinhaDaTabela[6] = s.getSituacao();
			
			model.addRow(novaLinhaDaTabela);
		}
	}
	private void buscarSinistros() {
		this.sinistros = controller.consultarTodos();
		this.atualizarTabela();
	}
	/**
	 * Create the panel.
	 */
	public PainelConsultaSinistro() {
		setToolTipText("");
		setBackground(new Color(26, 158, 230));
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("31px:grow"),
				ColumnSpec.decode("113px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("161px:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(54dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(94dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(106dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(44dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(51dlu;default)"),
				ColumnSpec.decode("26px:grow"),},
			new RowSpec[] {
				RowSpec.decode("18px"),
				RowSpec.decode("65px"),
				RowSpec.decode("24px"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:48px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("38px:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Consultar Sinistro");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblNewLabel.setIcon(new ImageIcon(PainelConsultaSinistro.class.getResource("/icones/icons8-lupa-48.png")));
		add(lblNewLabel, "2, 2, 13, 1");
		
		JLabel lblNumeroSinistro = new JLabel("Número Sinistro:");
		lblNumeroSinistro.setForeground(new Color(255, 255, 255));
		lblNumeroSinistro.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblNumeroSinistro, "2, 4, right, top");
		
		txtNumero = new JTextField();
		add(txtNumero, "4, 4, 7, 1, fill, fill");
		txtNumero.setColumns(10);
		
		JLabel lblNomeSegurado = new JLabel("Nome Segurado:");
		lblNomeSegurado.setForeground(Color.WHITE);
		lblNomeSegurado.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblNomeSegurado, "2, 7, right, top");
		
		txtNomeSegurado = new JTextField();
		txtNomeSegurado.setColumns(10);
		add(txtNomeSegurado, "4, 7, 7, 1, fill, fill");
		
		JLabel lblDe = new JLabel("De: ");
		lblDe.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblDe.setForeground(new Color(255, 255, 255));
		lblDe.setHorizontalAlignment(SwingConstants.TRAILING);
		add(lblDe, "2, 10");
		
		dpDataInicio = new DatePicker();
		add(dpDataInicio, "4, 10, 2, 1, fill, fill");
		
		JLabel lblAte = new JLabel("Até: ");
		lblAte.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAte.setForeground(Color.WHITE);
		lblAte.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblAte, "8, 10");
		
		dpDataFim = new DatePicker();
		add(dpDataFim, "10, 10, fill, fill");
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(227, 218, 28));
		btnBuscar.setIcon(new ImageIcon(PainelConsultaSinistro.class.getResource("/icones/icons8-lupa-50.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					buscarSinistrosComFiltros();
					atualizarTabela();
			}
		});
		add(btnBuscar, "4, 16, fill, fill");
		
		JLabel lblSituacao = new JLabel("Situação:");
		lblSituacao.setForeground(Color.WHITE);
		lblSituacao.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblSituacao, "2, 13, right, center");
		
		cbSituacao = new JComboBox(Situacao.values());
		cbSituacao.setSelectedIndex(-1);
		add(cbSituacao, "4, 13, fill, center");
		
		btnGerarPlanilha = new JButton("Gerar Planilha");
		btnGerarPlanilha.setIcon(new ImageIcon(PainelConsultaSinistro.class.getResource("/icones/icons8-planilha-50.png")));
		btnGerarPlanilha.setBackground(new Color(227, 218, 28));
		btnGerarPlanilha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser janelaSelecaoDestinoArquivo = new JFileChooser();
				janelaSelecaoDestinoArquivo.setDialogTitle("Selecione um destino para a planilha...");

				int opcaoSelecionada = janelaSelecaoDestinoArquivo.showSaveDialog(null);
				if (opcaoSelecionada == JFileChooser.APPROVE_OPTION) {
					String caminhoEscolhido = janelaSelecaoDestinoArquivo.getSelectedFile().getAbsolutePath();
					String resultado;
					try {
						resultado = controller.gerarPlanilha(sinistros, caminhoEscolhido);
						JOptionPane.showMessageDialog(null, resultado);
					} catch (CampoInvalidoException e1) {
						JOptionPane.showConfirmDialog(null, e1.getMessage(), "Aten��o", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		add(btnGerarPlanilha, "8, 16, default, fill");
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNumero.setText("");
				txtNomeSegurado.setText("");
				cbSituacao.setSelectedIndex(-1);
				dpDataInicio.clear();
				dpDataFim.clear();
			}
		});
		btnLimpar.setBackground(new Color(227, 218, 28));
		add(btnLimpar, "10, 16");
		
		
		add(tableSinistro, "2, 19, 13, 2, fill, fill");
		
		tableSinistro.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int indiceSelecionado = tableSinistro.getSelectedRow();

				if (indiceSelecionado > 0) {
					sinistroSelecionado = sinistros.get(indiceSelecionado - 1);
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
					btnGerarPlanilha.setEnabled(true);
				} else {
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);
					btnGerarPlanilha.setEnabled(false);
				}
			}
		});
		
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setIcon(new ImageIcon(PainelConsultaSinistro.class.getResource("/icones/icons8-editar-48.png")));
		btnEditar.setBackground(new Color(227, 218, 28));
		add(btnEditar, "10, 23, fill, fill");
		btnEditar.setEnabled(false);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(PainelConsultaSinistro.class.getResource("/icones/icons8-excluir-48.png")));
		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int opcaoSelecionada = JOptionPane.showConfirmDialog(null, "Confirma a exclusão?");
				if (opcaoSelecionada == JOptionPane.YES_OPTION) {
					if(controller.excluir(sinistroSelecionado.getId())) {
						JOptionPane.showMessageDialog(null, "Excluido com sucesso");
						atualizarTabela();
						buscarSinistros();
					}
				}
			}
			
		});
		btnExcluir.setBackground(new Color(227, 218, 28));
		add(btnExcluir, "12, 23, default, fill");
		btnExcluir.setEnabled(false);
		buscarSinistros();
		
	}
	protected void buscarSinistrosComFiltros() {
		seletor = new SinistroSeletor();
		seletor.setLimite(TAMANHO_PAGINA);
		seletor.setPagina(paginaAtual);
		
		seletor.setNomeSegurado(txtNomeSegurado.getText());
		seletor.setNumeroSinistro(txtNumero.getText());
		seletor.setDtInicio(dpDataInicio.getDate());
		seletor.setDtInicio(dpDataFim.getDate());
		if(cbSituacao.getSelectedIndex() == -1) {
			seletor.setSituacao("");
		} else {
			seletor.setSituacao(cbSituacao.getSelectedItem().toString());
		}
		
		sinistros = (ArrayList<Sinistro>) controller.consultarComFiltros(seletor);
		this.atualizarTabela();
		this.atualizarQuantidadePaginas();
	}
	private void atualizarQuantidadePaginas() {
		int totalRegistros = controller.contarTotalRegistrosComFiltros(seletor);
		
	}
	public JButton getBtnEditar() {
		return this.btnEditar;
	}
	public Sinistro getSinistroSelecionado() {
		return sinistroSelecionado;
	}
	
}
