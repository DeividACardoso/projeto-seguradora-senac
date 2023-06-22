package view;

import java.awt.Color;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.github.lgooddatepicker.components.DatePicker;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class PainelConsultaCliente extends JPanel {
	private JTextField txtNome;

	private final JTable tableListagem = new JTable();
	private JLabel lblCpfList;
	private JLabel lblDtNascList;
	private JLabel lblAt;
	private JFormattedTextField txtCPF;
	private MaskFormatter mascaraCpf;

	/**
	 * Create the panel.
	 */
	public PainelConsultaCliente() {
		setBackground(new Color(26, 158, 230));
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("1px"),
				ColumnSpec.decode("39px"),
				ColumnSpec.decode("46px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("134px"),
				ColumnSpec.decode("3px"),
				ColumnSpec.decode("32px"),
				ColumnSpec.decode("11px"),
				ColumnSpec.decode("23px"),
				ColumnSpec.decode("156px"),},
			new RowSpec[] {
				RowSpec.decode("1px"),
				RowSpec.decode("21px"),
				RowSpec.decode("44px"),
				RowSpec.decode("36px"),
				RowSpec.decode("32px"),
				RowSpec.decode("26px"),
				RowSpec.decode("20px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("44px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("246px"),
				RowSpec.decode("25px"),
				RowSpec.decode("42px"),}));

		txtNome = new JTextField();
		add(txtNome, "4, 5, 2, 1, fill, bottom");
		txtNome.setColumns(10);

		JLabel lblNomeList = new JLabel("Nome:");
		lblNomeList.setForeground(new Color(255, 255, 255));
		lblNomeList.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblNomeList, "3, 5, fill, center");
		add(tableListagem, "3, 13, 8, 1, fill, fill");
		tableListagem.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nome", "Cpf", "Endere\u00E7o", "Telefone", "DataNascimento"},
			},
			new String[] {
				"Nome", "Cpf", "Endere\u00E7o", "Telefone", "DataNascimento"
			}
		));
		tableListagem.getColumnModel().getColumn(4).setPreferredWidth(93);
		
		lblCpfList = new JLabel("Cpf:");
		lblCpfList.setForeground(Color.WHITE);
		lblCpfList.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblCpfList, "6, 5, 3, 1, fill, fill");
		
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setValueContainsLiteralCharacters(false);
		} catch (ParseException erro) {
			//silent
		}
		
		txtCPF = new JFormattedTextField(mascaraCpf);
		add(txtCPF, "1, 1, fill, fill");
		
		lblDtNascList = new JLabel("Data de nascimento. De:");
		lblDtNascList.setForeground(Color.WHITE);
		lblDtNascList.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblDtNascList, "3, 7, 2, 1, fill, top");
		
		lblAt = new JLabel("At\u00E9:");
		lblAt.setForeground(Color.WHITE);
		lblAt.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblAt, "4, 9, right, top");
		
		JButton btnBuscarTodos = new JButton("BuscarTodos");
		btnBuscarTodos.setIcon(new ImageIcon(PainelConsultaCliente.class.getResource("/icones/icons8-lupa-50.png")));
		btnBuscarTodos.setBackground(new Color(231, 200, 24));
		add(btnBuscarTodos, "5, 11, 2, 1, left, fill");
		
		JButton btnGerarPlanilha = new JButton("GerarPlanilha");
		btnGerarPlanilha.setIcon(new ImageIcon(PainelConsultaCliente.class.getResource("/icones/icons8-planilha-50.png")));
		btnGerarPlanilha.setBackground(new Color(231, 200, 24));
		add(btnGerarPlanilha, "10, 11, fill, fill");
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(PainelConsultaCliente.class.getResource("/icones/icons8-editar-48.png")));
		btnEditar.setBackground(new Color(231, 200, 24));
		add(btnEditar, "5, 15, fill, fill");
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(PainelConsultaCliente.class.getResource("/icones/icons8-excluir-48.png")));
		btnExcluir.setBackground(new Color(231, 200, 24));
		add(btnExcluir, "10, 15, right, fill");
		
		JLabel lblTitulo = new JLabel("Consultar Cliente");
		lblTitulo.setIcon(new ImageIcon(PainelConsultaCliente.class.getResource("/icones/icons8-lupa-48.png")));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		add(lblTitulo, "4, 3, 5, 1, right, fill");
		
		DatePicker dpDataNascimento = new DatePicker();
		add(dpDataNascimento, "5, 7, 6, 1, fill, top");
		
		DatePicker dpDataNascimento_1 = new DatePicker();
		add(dpDataNascimento_1, "5, 9, 6, 1, fill, top");
		
		JFormattedTextField txtCPF = new JFormattedTextField((AbstractFormatter) null);
		add(txtCPF, "8, 5, 3, 1, fill, bottom");
		

	}
}
