package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.EnderecoController;
import controller.PessoaController;
import model.exception.CampoInvalidoException;
import model.vo.Endereco;
import model.vo.Pessoa;

public class PainelCadastroCliente extends JPanel {
	private Pessoa cliente;
	private JTextField txtNome;
	private MaskFormatter mascaraCpf;
	private MaskFormatter mascaraTelefone;
	private JFormattedTextField txtCPF;
	private JFormattedTextField txtTelefone;
	private JButton btnSalvar;
	private DatePicker dpDataNascimento;
	private JComboBox cbEndereco;

	/**
	 * Create the panel.
	 */
	public PainelCadastroCliente() {
		setBackground(new Color(26, 158, 230));
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(36dlu;default)"),
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(105dlu;default):grow"),
				ColumnSpec.decode("max(46dlu;default)"),
				ColumnSpec.decode("max(68dlu;default)"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("max(32dlu;default):grow"),},
				new RowSpec[] {
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						RowSpec.decode("max(54dlu;default)"),}));

		JLabel lblTitulo = new JLabel("Novo Cliente");
		lblTitulo.setIcon(new ImageIcon(PainelCadastroCliente.class.getResource("/icones/icons8-adicionar-64.png")));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		add(lblTitulo, "3, 1, 4, 1, center, default");

		JLabel lblNomeSegurado = new JLabel("Nome segurado:");
		lblNomeSegurado.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNomeSegurado.setForeground(new Color(255, 255, 255));
		add(lblNomeSegurado, "2, 5, center, default");

		txtNome = new JTextField();
		add(txtNome, "3, 5, 4, 1, fill, default");
		txtNome.setColumns(10);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblCpf, "2, 11, center, default");

		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setValueContainsLiteralCharacters(false);
		} catch (ParseException erro) {
			//silent
		}

		txtCPF = new JFormattedTextField(mascaraCpf);
		add(txtCPF, "3, 11, 4, 1, fill, default");

		JLabel lblDatadeNascimento = new JLabel("Data de Nascimento:");
		lblDatadeNascimento.setForeground(Color.WHITE);
		lblDatadeNascimento.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblDatadeNascimento, "2, 18, center, default");

		dpDataNascimento = new DatePicker();
		add(dpDataNascimento, "3, 18, left, default");

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblTelefone, "5, 18, center, center");

		try {
			mascaraTelefone = new MaskFormatter("(##)9####-####");
			mascaraTelefone.setValueContainsLiteralCharacters(false);
		} catch (ParseException erro) {
			//silent
			erro.printStackTrace();
		}

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setForeground(Color.WHITE);
		lblEndereco.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblEndereco, "2, 23, right, default");

		txtTelefone = new JFormattedTextField(mascaraTelefone);
		txtTelefone.setForeground(Color.BLUE);
		txtTelefone.setBounds(90, 60, 270, 20);
		add(txtTelefone, "6, 18, fill, default");

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PessoaController controller = new PessoaController();

				if(cliente == null) {
					cliente = new Pessoa();
				}
				cliente.setNome(txtNome.getText());
				cliente.setDataNascimento(dpDataNascimento.getDate());
				//Pega o valor do CPF sem a máscara
				try {
					String cpfSemMascara = mascaraCpf.stringToValue(txtCPF.getText()).toString();
					cliente.setCpf(cpfSemMascara);

					String telefoneSemMascara = mascaraTelefone.stringToValue(txtTelefone.getText()).toString();
					cliente.setTelefone(telefoneSemMascara);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				cliente.setEndereco((Endereco) cbEndereco.getSelectedItem());

				if(cliente.getId() == null) {
					try {
						controller.inserir(cliente);
						JOptionPane.showMessageDialog(null, "Pessoa salva com sucesso!", 
								"Sucesso", JOptionPane.INFORMATION_MESSAGE);
					} catch (CampoInvalidoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), 
								"Atenção", JOptionPane.ERROR_MESSAGE);
					}
				}		
			}
		});

		EnderecoController enderecoController = new EnderecoController();
		List<Endereco> todosOsEnderecos = enderecoController.consultarTodos();
		cbEndereco = new JComboBox(todosOsEnderecos.toArray());
		cbEndereco.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		add(cbEndereco, "3, 23, 4, 1, fill, default");

		btnSalvar.setBackground(new Color(231, 200, 24));
		btnSalvar.setIcon(new ImageIcon(PainelCadastroCliente.class.getResource("/icones/icons8-salvar-50.png")));
		add(btnSalvar, "3, 28");

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnVoltar.setIcon(new ImageIcon(PainelCadastroCliente.class.getResource("/icones/icons8-voltar-50.png")));
		btnVoltar.setBackground(new Color(231, 200, 24));
		add(btnVoltar, "6, 28");
	}
}