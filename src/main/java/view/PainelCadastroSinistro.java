package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;

public class PainelCadastroSinistro extends JPanel {
	private JTextField txtNumeroSinistro;
	private JTextField txtTipoSinistro;
	private JTextField txtData;
	private JTextField txtHora;
	private JTextField txtValorFranquia;
	private JTextField txtValorPago;
	private JTextField txtValorOrcado;
	private JTextField txtMotivo;
	private JTextField txtSegurado;
	private JTextField txtPlaca;
	private JButton btnSalvar;
	private JButton btnVoltar;

	/**
	 * Create the panel.V  
	 */
	public PainelCadastroSinistro() {
		setBackground(new Color(26, 158, 230));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("69dlu:grow"),
				ColumnSpec.decode("center:4dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(5dlu;default)"),
				ColumnSpec.decode("94dlu:grow"),
				ColumnSpec.decode("center:32dlu:grow"),
				ColumnSpec.decode("center:4dlu"),
				ColumnSpec.decode("center:4dlu"),
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(7dlu;default)"),
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("7dlu:grow"),
				RowSpec.decode("fill:4dlu"),
				RowSpec.decode("fill:default"),
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
		
		JLabel lblTitulo = new JLabel("Novo Sinistro");
		lblTitulo.setIcon(new ImageIcon(PainelCadastroSinistro.class.getResource("/icones/icons8-adicionar-64.png")));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		add(lblTitulo, "9, 2, center, default");
		
		JLabel lblNumeroSinistro = new JLabel("Número Sinistro:");
		lblNumeroSinistro.setForeground(new Color(255, 255, 255));
		lblNumeroSinistro.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblNumeroSinistro, "4, 6, right, default");
		
		txtNumeroSinistro = new JTextField();
		add(txtNumeroSinistro, "6, 6, fill, default");
		txtNumeroSinistro.setColumns(10);
		
		JLabel lblValorFranquia = new JLabel("Valor Franquia:");
		lblValorFranquia.setHorizontalAlignment(SwingConstants.TRAILING);
		lblValorFranquia.setForeground(Color.WHITE);
		lblValorFranquia.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblValorFranquia, "11, 6, right, default");
		
		txtValorFranquia = new JTextField();
		txtValorFranquia.setColumns(10);
		add(txtValorFranquia, "13, 6, fill, default");
		
		JLabel lblTipoSinistro = new JLabel("Tipo Sinistro:");
		lblTipoSinistro.setForeground(Color.WHITE);
		lblTipoSinistro.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblTipoSinistro, "4, 8, right, default");
		
		txtTipoSinistro = new JTextField();
		txtTipoSinistro.setColumns(10);
		add(txtTipoSinistro, "6, 8, fill, default");
		
		JLabel lblValorOrcado = new JLabel("Valor Or\u00E7ado:");
		lblValorOrcado.setForeground(Color.WHITE);
		lblValorOrcado.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblValorOrcado, "11, 8, right, default");
		
		txtValorOrcado = new JTextField();
		txtValorOrcado.setColumns(10);
		add(txtValorOrcado, "13, 8, fill, default");
		
		JLabel lblSegurado = new JLabel("Segurado:");
		lblSegurado.setForeground(Color.WHITE);
		lblSegurado.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblSegurado, "4, 10, right, default");
		
		txtSegurado = new JTextField();
		txtSegurado.setColumns(10);
		add(txtSegurado, "6, 10, fill, default");
		
		JLabel lblVeculo = new JLabel("Placa Ve\u00EDculo:");
		lblVeculo.setForeground(Color.WHITE);
		lblVeculo.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblVeculo, "11, 10, right, default");
		
		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		add(txtPlaca, "13, 10, fill, default");
		
		JLabel lblData = new JLabel("Data Sinistro:");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblData, "4, 12, right, default");
		
		txtData = new JTextField();
		txtData.setColumns(10);
		add(txtData, "6, 12, fill, default");
		
		JLabel lblValorPago = new JLabel("Valor Pago:");
		lblValorPago.setForeground(Color.WHITE);
		lblValorPago.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblValorPago, "11, 12, right, default");
		
		txtValorPago = new JTextField();
		txtValorPago.setColumns(10);
		add(txtValorPago, "13, 12, fill, default");
		
		JLabel lblHoraSinistro = new JLabel("Hora:");
		lblHoraSinistro.setForeground(Color.WHITE);
		lblHoraSinistro.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblHoraSinistro, "4, 14, right, default");
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		add(txtHora, "6, 14, fill, default");
		
		JLabel lblMotivo = new JLabel("Motivo:");
		lblMotivo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMotivo.setForeground(Color.WHITE);
		lblMotivo.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblMotivo, "11, 14, right, default");
		
		txtMotivo = new JTextField();
		txtMotivo.setColumns(10);
		add(txtMotivo, "13, 14, 1, 3, fill, default");
		
		JLabel lblSituacaoSinistro = new JLabel("Situao:");
		lblSituacaoSinistro.setForeground(Color.WHITE);
		lblSituacaoSinistro.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblSituacaoSinistro, "4, 16, right, default");
		
		JComboBox cbSituacao = new JComboBox();
		add(cbSituacao, "6, 16, fill, default");
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(PainelCadastroSinistro.class.getResource("/icones/icons8-salvar-50.png")));
		btnSalvar.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnSalvar.setBackground(new Color(231, 200, 24));
		btnSalvar.setForeground(new Color(0, 0, 0));
		add(btnSalvar, "6, 19");
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(PainelCadastroSinistro.class.getResource("/icones/icons8-voltar-50.png")));
		btnVoltar.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(new Color(231, 200, 24));
		add(btnVoltar, "13, 19");

	}
	
	public JButton getBtnVoltar(ActionListener e) {
		return btnVoltar;
	}
}
