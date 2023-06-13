package view;

import javax.swing.JPanel;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;

public class PainelCadastroSeguro extends JPanel {
	private JTextField txtNumeroProposta;
	private JTextField txtVigencia;
	private JTextField txtVigenciaFim;
	private JTextField txtNome;
	private JTextField txtPlaca;

	/**
	 * Create the panel.
	 */
	public PainelCadastroSeguro() {
		setBackground(new Color(26, 158, 230));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
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
		
		JLabel lblTItulo = new JLabel("NovoSeguro");
		lblTItulo.setIcon(new ImageIcon(PainelCadastroSeguro.class.getResource("/icones/icons8-adicionar-64.png")));
		lblTItulo.setForeground(new Color(255, 255, 255));
		lblTItulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		add(lblTItulo, "8, 4, 28, 1, center, default");
		
		JLabel lblNumeroProposta = new JLabel("N\u00FAmero Proposta:");
		lblNumeroProposta.setForeground(new Color(255, 255, 255));
		lblNumeroProposta.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblNumeroProposta, "4, 8, right, default");
		
		txtNumeroProposta = new JTextField();
		add(txtNumeroProposta, "6, 8, 37, 2, fill, default");
		txtNumeroProposta.setColumns(10);
		
		JLabel lblDataDeVigncia = new JLabel("Data de vig\u00EAncia:");
		lblDataDeVigncia.setForeground(Color.WHITE);
		lblDataDeVigncia.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblDataDeVigncia, "4, 12, right, default");
		
		txtVigencia = new JTextField();
		txtVigencia.setColumns(10);
		add(txtVigencia, "6, 11, 21, 2, fill, default");
		
		txtVigenciaFim = new JTextField();
		txtVigenciaFim.setColumns(10);
		add(txtVigenciaFim, "29, 11, 4, 2, fill, default");
		
		JLabel lblNomeSegurado = new JLabel("Nome Segurado:");
		lblNomeSegurado.setForeground(Color.WHITE);
		lblNomeSegurado.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblNomeSegurado, "4, 16, right, default");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		add(txtNome, "6, 15, 37, 2, fill, default");
		
		JLabel lblVeculoPlaca = new JLabel("Placa Ve\u00EDculo:");
		lblVeculoPlaca.setForeground(Color.WHITE);
		lblVeculoPlaca.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblVeculoPlaca, "32, 20, right, default");
		
		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		add(txtPlaca, "34, 19, 9, 2, fill, default");
		
		JLabel lblCoberturas = new JLabel("Coberturas");
		lblCoberturas.setForeground(Color.WHITE);
		lblCoberturas.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblCoberturas, "4, 22, center, default");
		
		JLabel lblRcfDanosMateriais = new JLabel("RCF- Danos Materiais");
		lblRcfDanosMateriais.setForeground(Color.WHITE);
		lblRcfDanosMateriais.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblRcfDanosMateriais, "4, 24");
		
		JComboBox cbRCF_DM = new JComboBox();
		add(cbRCF_DM, "8, 24, 19, 1, fill, default");
		
		JLabel lblRcfDanosCorporais = new JLabel("RCF- Danos Corporais");
		lblRcfDanosCorporais.setForeground(Color.WHITE);
		lblRcfDanosCorporais.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblRcfDanosCorporais, "4, 26");
		
		JComboBox cbRCF_DC = new JComboBox();
		add(cbRCF_DC, "8, 26, 19, 1, fill, default");
		
		JLabel lblFranquia = new JLabel("Franquia");
		lblFranquia.setForeground(Color.WHITE);
		lblFranquia.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblFranquia, "4, 28, right, default");
		
		JComboBox cbFranquia = new JComboBox();
		add(cbFranquia, "8, 28, 23, 1, fill, default");
		
		JLabel lblAssistncia = new JLabel("Assist\u00EAncia");
		lblAssistncia.setForeground(Color.WHITE);
		lblAssistncia.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblAssistncia, "4, 30, right, default");
		
		JComboBox cbAssistencia = new JComboBox();
		add(cbAssistencia, "8, 30, 23, 1, fill, default");
		
		JLabel lblCarroReserva = new JLabel("Carro Reserva");
		lblCarroReserva.setForeground(Color.WHITE);
		lblCarroReserva.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblCarroReserva, "4, 32, right, default");
		
		JComboBox cbAssistencia_1 = new JComboBox();
		add(cbAssistencia_1, "8, 32, 23, 1, fill, default");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(PainelCadastroSeguro.class.getResource("/icones/icons8-salvar-50.png")));
		btnSalvar.setBackground(new Color(227, 218, 28));
		btnSalvar.setForeground(new Color(0, 0, 0));
		add(btnSalvar, "8, 35, 20, 4");
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(PainelCadastroSeguro.class.getResource("/icones/icons8-voltar-50.png")));
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(new Color(227, 218, 28));
		add(btnVoltar, "33, 35, 10, 4");

	}

	public AbstractButton getbtnVoltar() {
		// TODO Auto-generated method stub
		return null;
	}

}
