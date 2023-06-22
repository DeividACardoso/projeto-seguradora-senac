package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.github.lgooddatepicker.components.DatePicker;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.SinistroController;
import model.dao.PessoaDAO;
import model.vo.Pessoa;
import model.vo.Sinistro;
import model.vo.Situacao;
import model.vo.TipoSinistro;

public class PainelCadastroSinistro extends JPanel {
	private JTextField txtNumeroSinistro;
	private JTextField txtHora;
	private JTextField txtValorFranquia;
	private JTextField txtValorPago;
	private JTextField txtValorOrcado;
	private JTextField txtMotivo;
	private JTextField txtPlaca;
	private JButton btnSalvar;
	private JButton btnVoltar;
	private DatePicker dpDataInicio;
	private JComboBox cbSituacao;
	private List<Situacao> situacaoEnum = new ArrayList<Situacao>();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private JComboBox cbTipoSinistro;
	private Sinistro sinistro;
	private JLabel lblTitulo;
	private JComboBox cbSegurado;
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
		
		txtValorFranquia = new JTextField();
		txtValorFranquia.setColumns(10);
		add(txtValorFranquia, "10, 8, fill, default");
		
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
		
		txtValorOrcado = new JTextField();
		txtValorOrcado.setColumns(10);
		add(txtValorOrcado, "10, 11, fill, default");
		
		JLabel lblSegurado = new JLabel("Segurado:");
		lblSegurado.setForeground(Color.WHITE);
		lblSegurado.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblSegurado, "3, 14, right, default");
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoas.addAll(pessoaDAO.consultarTodos());
		cbSegurado = new JComboBox((ComboBoxModel) pessoas);
		cbSegurado.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		add(cbSegurado, "5, 14, fill, default");
		
		JLabel lblVeculo = new JLabel("Placa Ve\u00EDculo:");
		lblVeculo.setForeground(Color.WHITE);
		lblVeculo.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblVeculo, "8, 14, right, default");
		
		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		add(txtPlaca, "10, 14, fill, default");
		
		JLabel lblData = new JLabel("Data Sinistro:");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblData, "3, 17, right, default");
		
		dpDataInicio = new DatePicker();
		add(dpDataInicio, "5, 17, fill, fill");
		
		JLabel lblValorPago = new JLabel("Valor Pago:");
		lblValorPago.setForeground(Color.WHITE);
		lblValorPago.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblValorPago, "8, 17, right, default");
		
		txtValorPago = new JTextField();
		txtValorPago.setColumns(10);
		add(txtValorPago, "10, 17, fill, default");
		
		JLabel lblHoraSinistro = new JLabel("Hora:");
		lblHoraSinistro.setForeground(Color.WHITE);
		lblHoraSinistro.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblHoraSinistro, "3, 20, right, default");
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		add(txtHora, "5, 20, fill, default");
		
		JLabel lblMotivo = new JLabel("Motivo:");
		lblMotivo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMotivo.setForeground(Color.WHITE);
		lblMotivo.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblMotivo, "8, 20, right, default");
		
		txtMotivo = new JTextField();
		txtMotivo.setColumns(10);
		add(txtMotivo, "10, 20, 1, 4, fill, default");
		
		JLabel lblSituacaoSinistro = new JLabel("Situação:");
		lblSituacaoSinistro.setForeground(Color.WHITE);
		lblSituacaoSinistro.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblSituacaoSinistro, "3, 23, right, default");
		
		cbSituacao = new JComboBox();
		cbSituacao.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		cbSituacao.setModel(new DefaultComboBoxModel(Situacao.values()));
		add(cbSituacao, "5, 23, fill, default");
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SinistroController sinController = new SinistroController();
				Sinistro sin = new Sinistro();
				sin.setNumeroSinistro(txtNumeroSinistro.getText());
				sin.setTipoSinistro((TipoSinistro) cbTipoSinistro.getSelectedItem());
				//TODO Segurado, Veiculo
				sin.setDataSinistro(dpDataInicio.getDate());
				sin.setMotivo(txtMotivo.getText());
				sin.setSituacao((Situacao) cbSituacao.getSelectedItem());
			}
		});
		btnSalvar.setIcon(new ImageIcon(PainelCadastroSinistro.class.getResource("/icones/icons8-salvar-50.png")));
		btnSalvar.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnSalvar.setBackground(new Color(231, 200, 24));
		btnSalvar.setForeground(new Color(0, 0, 0));
		add(btnSalvar, "5, 26");
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVoltar.setIcon(new ImageIcon(PainelCadastroSinistro.class.getResource("/icones/icons8-voltar-50.png")));
		btnVoltar.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(new Color(231, 200, 24));
		add(btnVoltar, "10, 26");
		
	}
	public JButton getBtnVoltar() {
		return btnVoltar;
	}
	
}
