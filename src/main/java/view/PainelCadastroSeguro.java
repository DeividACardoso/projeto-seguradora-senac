package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DatePicker;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.SeguroController;
import model.exception.CampoInvalidoException;
import model.exception.ClienteComSeguroException;
import model.seletor.SeguroSeletor;
import model.util.DateUtil;
import model.vo.Seguro;

public class PainelCadastroSeguro extends JPanel {

	private DatePicker dataVigenciaInicial;
	private DatePicker dataVigenciaFinal;

	private Seguro seguro;
	private JTextField txtNumeroProposta;
	private JTextField txtNome;
	private JTextField txtPlaca;
	private JLabel lblTItulo;
	private JLabel lblNumeroProposta;
	private JLabel lblDataDeVigenciaInicial;
	private JLabel lblNomeSegurado;
	private JLabel lblFranquia;
	private JLabel lblRcfDanosCorporais;
	private JLabel lblRcfDanosMateriais;
	private JComponent lblVeculoPlaca;
	private JComponent lblCoberturas;
	private JComponent lblCarroReserva;
	private JComponent lblAssistncia;
	private JComboBox cbRCFDanosCorporais;
	private JComboBox cbRCFDanosMateriais;
	private JComboBox cbFranquia;
	private JComboBox cbAssistencia;
	private JComboBox cbCarro_reserva;
	private JButton btnSalvar;
	private JButton btnVoltar;
	private Double[] rcfDanosMaeriais = { 350.000, 300.000, 250.000, 200.000, 150.000, 100.000 };
	private Double[] rcfDanosCorporais = { 350.000, 300.000, 250.000, 200.000, 150.000, 100.000 };

	private SeguroSeletor seletor = new SeguroSeletor();
	private JLabel lblNewLabel;
	private JLabel lblDataVigenciaFinal;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public PainelCadastroSeguro(Seguro seguroParaEditar) {
		if (seguroParaEditar != null) {
			this.seguro = seguroParaEditar;
		} else {
			this.seguro = new Seguro();
		}
		setBackground(new Color(26, 158, 230));
		setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(61dlu;default):grow"),
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(74dlu;default):grow"), FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(79dlu;default)"), FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("max(66dlu;default)"), }));

		lblTItulo = new JLabel(seguro.getId() == null ? "NOVO SEGURO" : "EDI��O DE SEGURO");
		lblTItulo.setIcon(new ImageIcon(PainelCadastroSeguro.class.getResource("/icones/icons8-adicionar-64.png")));
		lblTItulo.setForeground(new Color(255, 255, 255));
		lblTItulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		add(lblTItulo, "9, 4, 6, 1, center, default");

		lblNumeroProposta = new JLabel("Número Proposta:");
		lblNumeroProposta.setForeground(new Color(255, 255, 255));
		lblNumeroProposta.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblNumeroProposta, "6, 8, right, default");

		txtNumeroProposta = new JTextField();
		add(txtNumeroProposta, "10, 8, 8, 2, fill, default");
		txtNumeroProposta.setColumns(10);

		lblDataDeVigenciaInicial = new JLabel("Data de vigência:");
		add(lblDataDeVigenciaInicial, "6, 12, right, default");
		lblDataDeVigenciaInicial.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblDataDeVigenciaInicial.setForeground(Color.WHITE);
		lblDataDeVigenciaInicial.setForeground(new Color(255, 255, 255));
		lblDataDeVigenciaInicial.setBounds(68, 158, 174, 19);

		dataVigenciaInicial = new DatePicker();
		dataVigenciaInicial.getComponentToggleCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dataVigenciaInicial.setBounds(10, 12, 4, 1);
		add(dataVigenciaInicial, "10, 12");
		

		dataVigenciaFinal = new DatePicker();
		dataVigenciaFinal.setBounds(14, 12, 4, 1);
		add(dataVigenciaFinal, "16, 12");
		
		
		lblDataVigenciaFinal = new JLabel("Até: ");
		lblDataVigenciaFinal.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblDataVigenciaFinal.setForeground(new Color(255, 255, 255));
		add(lblDataVigenciaFinal, "14, 12, right, default");
		
		
		

		lblNomeSegurado = new JLabel("Nome Segurado:");
		lblNomeSegurado.setForeground(Color.WHITE);
		lblNomeSegurado.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblNomeSegurado, "6, 16, right, default");

		txtNome = new JTextField();
		txtNome.setColumns(10);
		add(txtNome, "10, 15, 8, 2, fill, default");

		lblVeculoPlaca = new JLabel("Placa Veículo:");
		lblVeculoPlaca.setForeground(Color.WHITE);
		lblVeculoPlaca.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblVeculoPlaca, "14, 18, right, default");

		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		add(txtPlaca, "16, 18, 2, 2, fill, default");

		lblCoberturas = new JLabel("Coberturas");
		lblCoberturas.setForeground(Color.WHITE);
		lblCoberturas.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblCoberturas, "6, 22, center, default");

		lblRcfDanosMateriais = new JLabel("RCF- Danos Materiais");
		lblRcfDanosMateriais.setForeground(Color.WHITE);
		lblRcfDanosMateriais.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblRcfDanosMateriais, "6, 24");

		
		cbRCFDanosMateriais = new JComboBox(rcfDanosMaeriais);
		add(cbRCFDanosMateriais, "10, 24, 4, 1, fill, default");

		lblRcfDanosCorporais = new JLabel("RCF- Danos Corporais");
		lblRcfDanosCorporais.setForeground(Color.WHITE);
		lblRcfDanosCorporais.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblRcfDanosCorporais, "6, 26");

		
		cbRCFDanosCorporais = new JComboBox(rcfDanosCorporais);
		add(cbRCFDanosCorporais, "10, 26, 4, 1, fill, default");

		lblFranquia = new JLabel("Franquia");
		lblFranquia.setForeground(Color.WHITE);
		lblFranquia.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblFranquia, "6, 28, right, default");

		String[] franquia = { "Padrão", "Reduzida" };
		cbFranquia = new JComboBox(franquia);
		add(cbFranquia, "10, 28, 5, 1, fill, default");

		lblAssistncia = new JLabel("Assistência");
		lblAssistncia.setForeground(Color.WHITE);
		lblAssistncia.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblAssistncia, "6, 30, right, default");

		String[] assistencia = { "Básica", "Completa", "Plus" };
		cbAssistencia = new JComboBox(assistencia);
		add(cbAssistencia, "10, 30, 5, 1, fill, default");

		lblCarroReserva = new JLabel("Carro Reserva");
		lblCarroReserva.setForeground(Color.WHITE);
		lblCarroReserva.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblCarroReserva, "6, 32, right, default");

		String[] carroReserva = { "7 Dias básico", "15 Dias Completo", "30 Dias Plus" };
		cbCarro_reserva = new JComboBox(carroReserva);
		add(cbCarro_reserva, "10, 32, 5, 1, fill, default");

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seguro.setIdPessoa(Integer.parseInt(txtNome.getText()));
				seguro.setNumeroProposta(Integer.parseInt(txtNumeroProposta.getText()));
				if (txtNumeroProposta != null && !txtNumeroProposta.getText().isEmpty()) {
					try {
						int numeroProposta = Integer.parseInt(txtNumeroProposta.getText());
						seletor.setNumeroProposta(numeroProposta);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "N�mero de proposta inv�ilido");
					}
				}
				seguro.setIdVeiculo(Integer.parseInt(txtPlaca.getText()));
				seguro.setDtInicioVigencia(dataVigenciaInicial.getDate());
				seguro.setDtFimVigencia(dataVigenciaFinal.getDate());
				seguro.setRcfDanosMateriais((double) cbRCFDanosMateriais.getSelectedItem());
				seguro.setRcfDanosCorporais((double) cbRCFDanosCorporais.getSelectedItem());
				seguro.setFranquia((String) cbFranquia.getSelectedItem());
				seguro.setAssistencia((String) cbAssistencia.getSelectedItem());
				seguro.setCarroReserva((String) cbCarro_reserva.getSelectedItem());

				SeguroController controller = new SeguroController();
				try {
					if (seguro.getId() == null) {
						controller.inserir(seguro);
						JOptionPane.showMessageDialog(null, "Seguro SALVO com sucesso!", "Sucesso",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						controller.atualizar(seguro);
						JOptionPane.showMessageDialog(null, "Seguro ATUALIZADO com sucesso!", "Sucesso",
								JOptionPane.INFORMATION_MESSAGE);

					}
				} catch (ClienteComSeguroException | CampoInvalidoException excecao) {
					JOptionPane.showMessageDialog(null, excecao.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		if (this.seguro.getId() != null) {
			preencherCamposDaTela();
		}
		btnSalvar.setIcon(new ImageIcon(PainelCadastroSeguro.class.getResource("/icones/icons8-salvar-50.png")));
		btnSalvar.setBackground(new Color(227, 218, 28));
		btnSalvar.setForeground(new Color(0, 0, 0));
		add(btnSalvar, "10, 36, 4, 1");

		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(PainelCadastroSeguro.class.getResource("/icones/icons8-voltar-50.png")));
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(new Color(227, 218, 28));
		add(btnVoltar, "16, 36, 2, 1");
	}

	
	
	private void preencherCamposDaTela() {
		this.txtNome.setText(Integer.toString(this.seguro.getIdPessoa()));
		this.txtNumeroProposta.setText(Integer.toString(this.seguro.getNumeroProposta()));
		this.txtPlaca.setText(Integer.toString(this.seguro.getIdVeiculo()));
		this.seguro.setDtInicioVigencia(this.seguro.getDtInicioVigencia());
		this.seguro.setDtFimVigencia(this.seguro.getDtFimVigencia());
		this.cbRCFDanosMateriais.setSelectedItem(this.seguro.getRcfDanosMateriais());
		this.cbRCFDanosCorporais.setSelectedItem(this.seguro.getRcfDanosCorporais() );
		this.cbFranquia.setSelectedItem(this.seguro.getFranquia());
		this.cbAssistencia.setSelectedItem(this.seguro.getAssistencia());
		this.cbCarro_reserva.setSelectedItem(this.seguro.getCarroReserva());
	}

	public JButton getbtnVoltar() {
		return btnVoltar;
	}

}
