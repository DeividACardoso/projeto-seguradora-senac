package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PainelCadastroCliente extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public PainelCadastroCliente() {
		setBackground(new Color(26, 158, 230));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
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
				ColumnSpec.decode("default:grow"),
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
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNomeSegurado = new JLabel("Nome segurado:");
		lblNomeSegurado.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNomeSegurado.setForeground(new Color(255, 255, 255));
		add(lblNomeSegurado, "4, 6, right, default");
		
		textField = new JTextField();
		add(textField, "6, 6, 27, 2, fill, default");
		textField.setColumns(10);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblCpf, "4, 10, right, default");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		add(textField_2, "6, 10, 27, 2, fill, default");
		
		JLabel lblDatadeNascimento = new JLabel("Data de Nascimento:");
		lblDatadeNascimento.setForeground(Color.WHITE);
		lblDatadeNascimento.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblDatadeNascimento, "4, 14, right, default");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		add(textField_1, "6, 13, 14, 2, fill, default");
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblTelefone, "22, 14, right, default");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		add(textField_4, "24, 13, 9, 2, fill, default");
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setForeground(Color.WHITE);
		lblEndereo.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblEndereo, "4, 18, right, default");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		add(textField_3, "6, 18, 23, 2, fill, default");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(231, 200, 24));
		btnSalvar.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		add(btnSalvar, "6, 23, 15, 3");
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(231, 200, 24));
		add(btnVoltar, "24, 23, 9, 3");

	}

}
