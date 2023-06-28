package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.SinistroController;
import model.dao.PessoaDAO;
import model.dao.VeiculoDAO;
import model.exception.CampoInvalidoException;
import model.exception.PessoaInvalidaException;
import model.exception.VeiculoInvalidaException;
import model.util.JNumberFormatField;
import model.vo.Pessoa;
import model.vo.Sinistro;
import model.vo.Situacao;
import model.vo.TipoSinistro;
import model.vo.Veiculo;

public class PainelCadastroSinistro extends JPanel {
	private JTextField txtNumeroSinistro;
	private JTextField fTxtValorFranquia;
	private JTextField valorOrcadoSemMascara;
	private JTextField fTxtValorOrcado;
	private JTextField txtMotivo;
	private JButton btnSalvar;
	private JButton btnVoltar;
	private DatePicker dpData;
	private JComboBox cbSituacao;
	private List<Situacao> situacaoEnum = new ArrayList<Situacao>();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	private JComboBox cbTipoSinistro;
	private Sinistro sinistro;
	private JLabel lblTitulo;
	private JComboBox cbSegurado;
	private JComboBox cbVeiculo;
	private JLabel lblHora;
	private JTextField fTxtHora;
	private JNumberFormatField fTxtValorPago;
	/**
	 * Create the panel.V  
	 */
	public PainelCadastroSinistro(final Sinistro sinistroParaEditar) {
		if(sinistroParaEditar != null) {
			this.sinistro = sinistroParaEditar;
		} else {
			this.sinistro = new Sinistro();
		}
		setBackground(new Color(26, 158, 230));
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(10dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("69dlu:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(5dlu;default)"),
				ColumnSpec.decode("88dlu:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("32dlu:grow"),},
				new RowSpec[] {
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("fill:default"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
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
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("fill:default"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,}));


		lblTitulo = new JLabel(sinistro.getId() == null ? "NOVO SINISTRO" : "EDIÇÃO DE SINISTRO");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		add(lblTitulo, "8, 4");

		JLabel lblNumeroSinistro = new JLabel("Número Sinistro:");
		lblNumeroSinistro.setForeground(new Color(255, 255, 255));
		lblNumeroSinistro.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblNumeroSinistro, "3, 8, right, default");

		txtNumeroSinistro = new JTextField();
		add(txtNumeroSinistro, "5, 8, fill, default");
		txtNumeroSinistro.setColumns(10);

		JLabel lblValorFranquia = new JLabel("Valor Franquia:");
		lblValorFranquia.setHorizontalAlignment(SwingConstants.TRAILING);
		lblValorFranquia.setForeground(Color.WHITE);
		lblValorFranquia.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblValorFranquia, "8, 8, right, default");

		fTxtValorFranquia = new JNumberFormatField(2);
		fTxtValorFranquia.setColumns(10);
		add(fTxtValorFranquia, "10, 8, fill, default");

		JLabel lblTipoSinistro = new JLabel("Tipo Sinistro:");
		lblTipoSinistro.setForeground(Color.WHITE);
		lblTipoSinistro.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblTipoSinistro, "3, 11, right, default");

		cbTipoSinistro = new JComboBox();
		cbTipoSinistro.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		cbTipoSinistro.setModel(new DefaultComboBoxModel(TipoSinistro.values()));
		add(cbTipoSinistro, "5, 11, fill, default");

		JLabel lblValorOrcado = new JLabel("Valor Or\u00E7ado:");
		lblValorOrcado.setForeground(Color.WHITE);
		lblValorOrcado.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblValorOrcado, "8, 11, right, default");

		fTxtValorOrcado = new JNumberFormatField(2);
		fTxtValorOrcado.setColumns(10);
		add(fTxtValorOrcado, "10, 11, fill, default");

		JLabel lblSegurado = new JLabel("Segurado:");
		lblSegurado.setForeground(Color.WHITE);
		lblSegurado.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblSegurado, "3, 14, right, default");

		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoas.addAll(pessoaDAO.consultarTodos());
		cbSegurado = new JComboBox(pessoas.toArray());
		cbSegurado.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		add(cbSegurado, "5, 14, fill, default");

		VeiculoDAO veiculoDAO = new VeiculoDAO();
		veiculos.addAll(veiculoDAO.consultarTodos());

		JLabel lblValorPago = new JLabel("Valor Pago:");
		lblValorPago.setForeground(Color.WHITE);
		lblValorPago.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblValorPago, "8, 14, right, default");

		fTxtValorPago = new JNumberFormatField(2);
		fTxtValorPago.setColumns(10);
		add(fTxtValorPago, "10, 14, fill, default");

		JLabel lblData = new JLabel("Data Sinistro:");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblData, "3, 17, right, default");

		dpData= new DatePicker();
		add(dpData, "5, 17, fill, fill");

		txtMotivo = new JTextField();
		txtMotivo.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtMotivo.setColumns(10);
		add(txtMotivo, "10, 20, 1, 4");

		JLabel lblSituacaoSinistro = new JLabel("Situa��o:");
		lblSituacaoSinistro.setForeground(Color.WHITE);
		lblSituacaoSinistro.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblSituacaoSinistro, "3, 20, right, default");

		cbSituacao = new JComboBox();
		cbSituacao.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		cbSituacao.setModel(new DefaultComboBoxModel(Situacao.values()));
		add(cbSituacao, "5, 20, fill, default");

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SinistroController sinController = new SinistroController();
				Sinistro sin = new Sinistro();
				sin.setNumeroSinistro(txtNumeroSinistro.getText());
				sin.setTipoSinistro((TipoSinistro) cbTipoSinistro.getSelectedItem());
				sin.setPessoa((Pessoa) cbSegurado.getSelectedItem());
				sin.setVeiculo((Veiculo) cbVeiculo.getSelectedItem());
				sin.setDataSinistro(dpData.getDate());
				sin.setMotivo(txtMotivo.getText());
				sin.setSituacao((Situacao) cbSituacao.getSelectedItem());
				try {
					String valorFranquiaSemMascara = fTxtValorFranquia.getText().replace(".", "").replace(",", ".");
					sin.setValorFranquia(Double.parseDouble(valorFranquiaSemMascara));
					String valorOrcadoSemMascara = fTxtValorOrcado.getText().replace(".", "").replace(",", ".");
					sin.setValorOrcado(Double.parseDouble(valorOrcadoSemMascara));
					String valorPagoSemMascara = fTxtValorPago.getText().replace(".", "").replace(",", ".");
					sin.setValorPago(Double.parseDouble(valorPagoSemMascara));
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Erro", "Erro ao converter double para String", JOptionPane.WARNING_MESSAGE);
				}
				if(sin.getId() == null) {
					try {
						sinController.inserir(sin);
						JOptionPane.showMessageDialog(null, "Sinistro salvo com sucesso!", 
								"Sucesso!", JOptionPane.INFORMATION_MESSAGE);

						txtNumeroSinistro.setText("");
						cbTipoSinistro.setSelectedIndex(0);
						cbSegurado.setSelectedIndex(0);
						cbVeiculo.setSelectedIndex(0);
						dpData.clear();
						txtMotivo.setText("");
						cbSituacao.setSelectedIndex(0);
						fTxtValorFranquia.setText("");
						fTxtValorOrcado.setText("");
						fTxtValorPago.setText("");
					} catch (PessoaInvalidaException | VeiculoInvalidaException | CampoInvalidoException excecao) {
						JOptionPane.showMessageDialog(null, excecao.getMessage(),
								"Erro", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					sinController.atualizar(sinistro);
				}
			}
		});

		JLabel lblMotivo = new JLabel("Motivo:");
		lblMotivo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMotivo.setForeground(Color.WHITE);
		lblMotivo.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblMotivo, "8, 20, right, default");

		JLabel lblVeculo = new JLabel("Placa Ve�culo:");
		lblVeculo.setForeground(Color.WHITE);
		lblVeculo.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblVeculo, "3, 23, right, default");
		cbVeiculo = new JComboBox(veiculos.toArray());
		cbVeiculo.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		add(cbVeiculo, "5, 23, fill, default");
		btnSalvar.setIcon(new ImageIcon(PainelCadastroSinistro.class.getResource("/icones/icons8-salvar-50.png")));
		btnSalvar.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnSalvar.setBackground(new Color(231, 200, 24));
		btnSalvar.setForeground(new Color(0, 0, 0));
		add(btnSalvar, "5, 26");

		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(PainelCadastroSinistro.class.getResource("/icones/icons8-voltar-50.png")));
		btnVoltar.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(new Color(231, 200, 24));
		add(btnVoltar, "10, 26");


		if(this.sinistro.getId() != null) {
			preencherCamposDaTela();
			txtNumeroSinistro.setEditable(false);
			dpData.setEnabled(false);
			cbVeiculo.setEnabled(false);
		}
	}
	private void preencherCamposDaTela() {
		this.txtNumeroSinistro.setText(this.sinistro.getNumeroSinistro());
		this.cbTipoSinistro.setSelectedItem(this.sinistro.getTipoSinistro());
		this.cbSegurado.setSelectedItem(this.sinistro.getPessoa().getNome().toUpperCase());
		this.dpData.setDate(this.sinistro.getDataSinistro());
		this.fTxtValorFranquia.setText(String.valueOf(this.sinistro.getValorFranquia()));
		this.fTxtValorOrcado.setText(String.valueOf(this.sinistro.getValorOrcado()));
		this.fTxtValorPago.setText(String.valueOf(this.sinistro.getValorPago()));
		this.cbSituacao.setSelectedItem(this.sinistro.getSituacao());
		this.txtMotivo.setText(this.sinistro.getMotivo());
		this.cbVeiculo.setSelectedItem(this.sinistro.getVeiculo());
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}
}
