package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.github.lgooddatepicker.components.DatePicker;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.SinistroController;
import model.dao.SeguroDAO;
import model.dao.VeiculoDAO;
import model.exception.CampoInvalidoException;
import model.exception.PessoaInvalidaException;
import model.exception.VeiculoInvalidaException;
import model.util.JNumberFormatField;
import model.vo.Seguro;
import model.vo.Sinistro;
import model.vo.Situacao;
import model.vo.TipoSinistro;

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
	private List<Seguro> seguros = new ArrayList<Seguro>();
	private JComboBox cbTipoSinistro;
	private Sinistro sinistro;
	private JLabel lblTitulo;
	private JComboBox cbSeguro;
	private JLabel lblHora;
	private JTextField fTxtHora;
	private JNumberFormatField fTxtValorPago;
	private Sinistro sin;
	/**
	 * Create the panel.V  
	 */
	public PainelCadastroSinistro(Sinistro sinistroParaEditar) {
		if(sinistroParaEditar != null) {
			this.sinistro = sinistroParaEditar;
		} else {
			this.sinistro = new Sinistro();
		}
		setBackground(new Color(26, 158, 230));
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(46dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("69dlu:grow"),
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
		add(lblTitulo, "7, 4");

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
		add(lblValorFranquia, "7, 8, right, default");

		fTxtValorFranquia = new JNumberFormatField(2);
		fTxtValorFranquia.setColumns(10);
		add(fTxtValorFranquia, "9, 8, fill, default");

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
		add(lblValorOrcado, "7, 11, right, default");

		fTxtValorOrcado = new JNumberFormatField(2);
		fTxtValorOrcado.setColumns(10);
		add(fTxtValorOrcado, "9, 11, fill, default");

		JLabel lblSegurado = new JLabel("Seguro:");
		lblSegurado.setForeground(Color.WHITE);
		lblSegurado.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblSegurado, "3, 14, right, default");

		SeguroDAO seguroDAO = new SeguroDAO();
		seguros.addAll(seguroDAO.consultarTodos());
		cbSeguro = new JComboBox(seguros.toArray());
		cbSeguro.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		add(cbSeguro, "5, 14, fill, default");


		JLabel lblValorPago = new JLabel("Valor Pago:");
		lblValorPago.setForeground(Color.WHITE);
		lblValorPago.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblValorPago, "7, 14, right, default");

		fTxtValorPago = new JNumberFormatField(2);
		fTxtValorPago.setColumns(10);
		add(fTxtValorPago, "9, 14, fill, default");

		JLabel lblData = new JLabel("Data Sinistro:");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblData, "3, 17, right, default");

		dpData= new DatePicker();
		add(dpData, "5, 17, fill, fill");

		txtMotivo = new JTextField();
		txtMotivo.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtMotivo.setColumns(10);
		add(txtMotivo, "9, 20, 1, 4");

		JLabel lblSituacaoSinistro = new JLabel("Situação:");
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
				sinistro.setNumeroSinistro(txtNumeroSinistro.getText());
				sinistro.setTipoSinistro((TipoSinistro) cbTipoSinistro.getSelectedItem());
				sinistro.setSeguro((Seguro) cbSeguro.getSelectedItem());
				sinistro.setDataSinistro(dpData.getDate());
				sinistro.setMotivo(txtMotivo.getText());
				sinistro.setSituacao((Situacao) cbSituacao.getSelectedItem());
				try {
					String valorFranquiaSemMascara = fTxtValorFranquia.getText().replace(".", "").replace(",", ".");
					sinistro.setValorFranquia(Double.parseDouble(valorFranquiaSemMascara));
					String valorOrcadoSemMascara = fTxtValorOrcado.getText().replace(".", "").replace(",", ".");
					sinistro.setValorOrcado(Double.parseDouble(valorOrcadoSemMascara));
					String valorPagoSemMascara = fTxtValorPago.getText().replace(".", "").replace(",", ".");
					sinistro.setValorPago(Double.parseDouble(valorPagoSemMascara));
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Erro", "Erro ao converter double para String", JOptionPane.WARNING_MESSAGE);
				}
				
				if(sinistro.getId() == null) {
					try {
						sinController.inserir(sinistro);
						JOptionPane.showMessageDialog(null, "Sinistro salvo com sucesso!", 
								"Sucesso!", JOptionPane.INFORMATION_MESSAGE);
						limparCamposDoPainel();
					} catch (PessoaInvalidaException | VeiculoInvalidaException | CampoInvalidoException excecao) {
						JOptionPane.showMessageDialog(null, excecao.getMessage(),
								"Erro", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					sinController.atualizar(sinistro);
					JOptionPane.showMessageDialog(null, "Sinistro alterado com sucesso!", 
							"Sucesso!", JOptionPane.INFORMATION_MESSAGE);
				}
			}

		
		});

		JLabel lblMotivo = new JLabel("Motivo:");
		lblMotivo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMotivo.setForeground(Color.WHITE);
		lblMotivo.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblMotivo, "7, 20, right, default");
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
		add(btnVoltar, "9, 26");


		if(this.sinistro.getId() != null) {
			preencherCamposDaTela();
			txtNumeroSinistro.setEditable(false);
			dpData.setEnabled(false);
		}
	}
	private void preencherCamposDaTela() {
		this.txtNumeroSinistro.setText(this.sinistro.getNumeroSinistro());
		this.cbTipoSinistro.setSelectedItem(this.sinistro.getTipoSinistro());
		this.cbSeguro.setSelectedItem(this.sinistro.getSeguro());
		this.dpData.setDate(this.sinistro.getDataSinistro());
		this.fTxtValorFranquia.setText(String.valueOf(this.sinistro.getValorFranquia()));
		this.fTxtValorOrcado.setText(String.valueOf(this.sinistro.getValorOrcado()));
		this.fTxtValorPago.setText(String.valueOf(this.sinistro.getValorPago()));
		this.cbSituacao.setSelectedItem(this.sinistro.getSituacao());
		this.txtMotivo.setText(this.sinistro.getMotivo());
	}

	private void limparCamposDoPainel() {
		txtNumeroSinistro.setText("");
		cbTipoSinistro.setSelectedIndex(-1);
		cbSeguro.setSelectedIndex(-1);
		dpData.clear();
		txtMotivo.setText("");
		cbSituacao.setSelectedIndex(-1);
		fTxtValorFranquia.setText("");
		fTxtValorOrcado.setText("");
		fTxtValorPago.setText("");
	}
	
	public JButton getBtnVoltar() {
		return btnVoltar;
	}
}
