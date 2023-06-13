package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import model.vo.Seguro;

public class PainelCadastroSeguro extends JPanel {
	private Seguro seguro;
	private JTextField txtNumeroProposta;
	private JTextField txtVigencia;
	private JTextField txtVigenciaFim;
	private JTextField txtNome;
	private JTextField txtPlaca;
	private JLabel lblTItulo;
	private JLabel lblNumeroProposta;
	private JLabel lblDataDeVigncia;
	private JLabel lblNomeSegurado;
	private JLabel lblFranquia;
	private JLabel lblRcfDanosCorporais;
	private JLabel lblRcfDanosMateriais;
	private JComponent lblVeculoPlaca;
	private JComponent lblCoberturas;
	private Component cbRCF_DM;
	private JComponent lblCarroReserva;
	private JComponent lblAssistncia;
	private JComboBox cbRCF_DC;
	private JComboBox cbFranquia;
	private JComboBox cbAssistencia;
	private JComboBox cbCarro_reserva;
	private JButton btnSalvar;
	private JButton btnVoltar;

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
		
		lblTItulo = new JLabel("NovoSeguro");
		lblTItulo.setIcon(new ImageIcon(PainelCadastroSeguro.class.getResource("/icones/icons8-adicionar-64.png")));
		lblTItulo.setForeground(new Color(255, 255, 255));
		lblTItulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		add(lblTItulo, "8, 4, 28, 1, center, default");
		
		lblNumeroProposta = new JLabel("N\u00FAmero Proposta:");
		lblNumeroProposta.setForeground(new Color(255, 255, 255));
		lblNumeroProposta.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblNumeroProposta, "4, 8, right, default");
		
		txtNumeroProposta = new JTextField();
		add(txtNumeroProposta, "6, 8, 37, 2, fill, default");
		txtNumeroProposta.setColumns(10);
		
		lblDataDeVigncia = new JLabel("Data de vig\u00EAncia:");
		lblDataDeVigncia.setForeground(Color.WHITE);
		lblDataDeVigncia.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblDataDeVigncia, "4, 12, right, default");
		
		txtVigencia = new JTextField();
		txtVigencia.setColumns(10);
		add(txtVigencia, "6, 11, 21, 2, fill, default");
		
		txtVigenciaFim = new JTextField();
		txtVigenciaFim.setColumns(10);
		add(txtVigenciaFim, "29, 11, 4, 2, fill, default");
		
		lblNomeSegurado = new JLabel("Nome Segurado:");
		lblNomeSegurado.setForeground(Color.WHITE);
		lblNomeSegurado.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblNomeSegurado, "4, 16, right, default");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		add(txtNome, "6, 15, 37, 2, fill, default");
		
		lblVeculoPlaca = new JLabel("Placa Ve\u00EDculo:");
		lblVeculoPlaca.setForeground(Color.WHITE);
		lblVeculoPlaca.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblVeculoPlaca, "32, 20, right, default");
		
		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		add(txtPlaca, "34, 19, 9, 2, fill, default");
		
		lblCoberturas = new JLabel("Coberturas");
		lblCoberturas.setForeground(Color.WHITE);
		lblCoberturas.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblCoberturas, "4, 22, center, default");
		
		lblRcfDanosMateriais = new JLabel("RCF- Danos Materiais");
		lblRcfDanosMateriais.setForeground(Color.WHITE);
		lblRcfDanosMateriais.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblRcfDanosMateriais, "4, 24");
		
		cbRCF_DM = new JComboBox();
		add(cbRCF_DM, "8, 24, 19, 1, fill, default");
		
		lblRcfDanosCorporais = new JLabel("RCF- Danos Corporais");
		lblRcfDanosCorporais.setForeground(Color.WHITE);
		lblRcfDanosCorporais.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblRcfDanosCorporais, "4, 26");
		
		cbRCF_DC = new JComboBox();
		add(cbRCF_DC, "8, 26, 19, 1, fill, default");
		
		lblFranquia = new JLabel("Franquia");
		lblFranquia.setForeground(Color.WHITE);
		lblFranquia.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblFranquia, "4, 28, right, default");
		
		cbFranquia = new JComboBox();
		add(cbFranquia, "8, 28, 23, 1, fill, default");
		
		lblAssistncia = new JLabel("Assist\u00EAncia");
		lblAssistncia.setForeground(Color.WHITE);
		lblAssistncia.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblAssistncia, "4, 30, right, default");
		
		
		lblCarroReserva = new JLabel("Carro Reserva");
		lblCarroReserva.setForeground(Color.WHITE);
		lblCarroReserva.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblCarroReserva, "4, 32, right, default");
		
		cbAssistencia = new JComboBox();
		add(cbAssistencia, "8, 30, 23, 1, fill, default");
		
		cbCarro_reserva = new JComboBox();
		add(cbCarro_reserva, "8, 32, 23, 1, fill, default");
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSalvar.setIcon(new ImageIcon(PainelCadastroSeguro.class.getResource("/icones/icons8-salvar-50.png")));
		btnSalvar.setBackground(new Color(227, 218, 28));
		btnSalvar.setForeground(new Color(0, 0, 0));
		add(btnSalvar, "8, 35, 20, 4");
		
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(PainelCadastroSeguro.class.getResource("/icones/icons8-voltar-50.png")));
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(new Color(227, 218, 28));
		add(btnVoltar, "33, 35, 10, 4");

	}

	public JButton getbtnVoltar() {
		return btnVoltar;
	}

}
