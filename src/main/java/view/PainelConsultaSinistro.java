package view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Color;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PainelConsultaSinistro extends JPanel {
	private JTextField txtNumero;
	private JTextField textField_1;
	private JTextField textField_3;
	private final JTable tableSinistro = new JTable();
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PainelConsultaSinistro() {
		setToolTipText("");
		setBackground(new Color(26, 158, 230));
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("31px"),
				ColumnSpec.decode("113px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("153px"),
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
				ColumnSpec.decode("259px"),
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("26px"),},
			new RowSpec[] {
				RowSpec.decode("31px"),
				RowSpec.decode("48px"),
				RowSpec.decode("31px"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				RowSpec.decode("25px"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("22px"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				RowSpec.decode("38px"),
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
				RowSpec.decode("21px"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblTItulo = new JLabel("Consulta Sinistro");
		lblTItulo.setIcon(new ImageIcon(PainelConsultaSinistro.class.getResource("/icones/icons8-lupa-48.png")));
		lblTItulo.setForeground(new Color(255, 255, 255));
		lblTItulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		add(lblTItulo, "3, 2, 7, 1, center, top");
		
		JLabel lblNumeroSinistro = new JLabel("N\u00FAmero Sinistro:");
		lblNumeroSinistro.setForeground(new Color(255, 255, 255));
		lblNumeroSinistro.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblNumeroSinistro, "2, 4, 3, 1, right, top");
		
		txtNumero = new JTextField();
		add(txtNumero, "6, 4, 5, 2, fill, fill");
		txtNumero.setColumns(10);
		
		JLabel lblDataDoSinistro = new JLabel("Data do sinistro:");
		lblDataDoSinistro.setForeground(Color.WHITE);
		lblDataDoSinistro.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblDataDoSinistro, "2, 7, 3, 1, right, top");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		add(textField_1, "6, 7, 1, 2, fill, fill");
		
		textField = new JTextField();
		textField.setColumns(10);
		add(textField, "8, 7, 3, 2, fill, default");
		
		JLabel lblNomeSegurado = new JLabel("Nome Segurado:");
		lblNomeSegurado.setForeground(Color.WHITE);
		lblNomeSegurado.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblNomeSegurado, "2, 10, 3, 1, right, top");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		add(textField_3, "6, 10, 5, 2, fill, fill");
		
		JLabel lblSitucao = new JLabel("Situa\u00E7\u00E3o:");
		lblSitucao.setForeground(Color.WHITE);
		lblSitucao.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblSitucao, "2, 13, 3, 1, right, center");
		
		JComboBox comboBox = new JComboBox();
		add(comboBox, "6, 13, 4, 1, fill, top");
		
		JButton btnBuscarTodos = new JButton("BuscarTodos");
		btnBuscarTodos.setBackground(new Color(227, 218, 28));
		btnBuscarTodos.setIcon(new ImageIcon(PainelConsultaSinistro.class.getResource("/icones/icons8-lupa-50.png")));
		add(btnBuscarTodos, "6, 15, 1, 3, fill, fill");
		
		JButton btnGerarplanilha = new JButton("GerarPlanilha");
		btnGerarplanilha.setIcon(new ImageIcon(PainelConsultaSinistro.class.getResource("/icones/icons8-planilha-50.png")));
		btnGerarplanilha.setBackground(new Color(227, 218, 28));
		add(btnGerarplanilha, "10, 15, 1, 3, right, fill");
		add(tableSinistro, "2, 19, 9, 17, fill, fill");
		tableSinistro.setModel(new DefaultTableModel(
			new Object[][] {
				{"N\u00FAmeroSinistro", "Segurado", "Ve\u00EDculo", "TipoSinistro", "Data", "Situa\u00E7\u00E3o"},
			},
			new String[] {
				"N\u00FAmeroSinistro", "Segurado", "Ve\u00EDculo", "TipoSinistro", "Data", "Situa\u00E7\u00E3o"
			}
		));
		tableSinistro.getColumnModel().getColumn(0).setPreferredWidth(89);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(PainelConsultaSinistro.class.getResource("/icones/icons8-editar-48.png")));
		btnEditar.setBackground(new Color(227, 218, 28));
		add(btnEditar, "6, 38, 1, 3, fill, fill");
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(PainelConsultaSinistro.class.getResource("/icones/icons8-excluir-48.png")));
		btnExcluir.setBackground(new Color(227, 218, 28));
		add(btnExcluir, "10, 38, 1, 3, right, fill");

	}
}
