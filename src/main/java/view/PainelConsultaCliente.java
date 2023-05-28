package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JButton;

public class PainelConsultaCliente extends JPanel {
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtDtnascimentoLsitc;
	private JTextField txtAte;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private final JTable tableListagem = new JTable();
	private JLabel lblCpfList;
	private JLabel lblDtNascList;
	private JLabel lblAt;

	/**
	 * Create the panel.
	 */
	public PainelConsultaCliente() {
		setBackground(new Color(26, 158, 230));
		setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(97, 71, 261, 26);
		add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNomeList = new JLabel("Nome:");
		lblNomeList.setForeground(new Color(255, 255, 255));
		lblNomeList.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNomeList.setBounds(52, 75, 46, 14);
		add(lblNomeList);

		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(410, 72, 182, 26);
		add(txtCpf);

		txtDtnascimentoLsitc = new JTextField();
		txtDtnascimentoLsitc.setColumns(10);
		txtDtnascimentoLsitc.setBounds(223, 117, 369, 26);
		add(txtDtnascimentoLsitc);

		txtAte = new JTextField();
		txtAte.setColumns(10);
		txtAte.setBounds(223, 160, 369, 26);
		add(txtAte);
		tableListagem.setBounds(52, 252, 540, 312);
		add(tableListagem);
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
		lblCpfList.setBounds(368, 67, 46, 32);
		add(lblCpfList);
		
		lblDtNascList = new JLabel("Data de nascimento. De:");
		lblDtNascList.setForeground(Color.WHITE);
		lblDtNascList.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblDtNascList.setBounds(52, 121, 176, 14);
		add(lblDtNascList);
		
		lblAt = new JLabel("At\u00E9:");
		lblAt.setForeground(Color.WHITE);
		lblAt.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblAt.setBounds(52, 164, 176, 14);
		add(lblAt);
		
		JButton btnBuscarTodos = new JButton("BuscarTodos");
		btnBuscarTodos.setBounds(223, 209, 157, 32);
		add(btnBuscarTodos);
		
		JButton btnGerarPlanilha = new JButton("GerarPlanilha");
		btnGerarPlanilha.setBounds(435, 209, 157, 32);
		add(btnGerarPlanilha);
		

	}
}
