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
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DatePicker;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelConsultaSinistro extends JPanel {
	private JTextField txtNumero;
	private JTextField txtNomeSegurado;
	private DatePickerSettings dateSettings;
	private DatePicker dataInicio;
	private DatePicker dataFim;
	private final JTable tableSinistro = new JTable();

	/**
	 * Create the panel.
	 */
	public PainelConsultaSinistro() {
		setToolTipText("");
		setBackground(new Color(26, 158, 230));
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("31px:grow"),
				ColumnSpec.decode("113px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("161px:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(54dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(94dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(106dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(44dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(51dlu;default)"),
				ColumnSpec.decode("26px:grow"),},
			new RowSpec[] {
				RowSpec.decode("18px"),
				RowSpec.decode("65px"),
				RowSpec.decode("24px"),
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
				RowSpec.decode("fill:48px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("38px:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Consultar Sinistro");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblNewLabel.setIcon(new ImageIcon(PainelConsultaSinistro.class.getResource("/icones/icons8-lupa-48.png")));
		add(lblNewLabel, "2, 2, 13, 1");
		
		JLabel lblNumeroSinistro = new JLabel("N\u00FAmero Sinistro:");
		lblNumeroSinistro.setForeground(new Color(255, 255, 255));
		lblNumeroSinistro.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblNumeroSinistro, "2, 4, right, top");
		
		txtNumero = new JTextField();
		add(txtNumero, "4, 4, 5, 1, fill, fill");
		txtNumero.setColumns(10);
		
		JLabel lblNomeSegurado = new JLabel("Nome Segurado:");
		lblNomeSegurado.setForeground(Color.WHITE);
		lblNomeSegurado.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblNomeSegurado, "2, 7, right, top");
		
		txtNomeSegurado = new JTextField();
		txtNomeSegurado.setColumns(10);
		add(txtNomeSegurado, "4, 7, 5, 1, fill, fill");
		
		JLabel lblDe = new JLabel("De: ");
		lblDe.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblDe.setForeground(new Color(255, 255, 255));
		lblDe.setHorizontalAlignment(SwingConstants.TRAILING);
		add(lblDe, "2, 10");
		
		DatePicker dpDataInicio = new DatePicker();
		add(dpDataInicio, "4, 10, 2, 1, fill, fill");
		
		JLabel lblAte = new JLabel("Até: ");
		lblAte.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAte.setForeground(Color.WHITE);
		lblAte.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblAte, "6, 10");
		
		DatePicker dpDataFim = new DatePicker();
		add(dpDataFim, "8, 10, fill, fill");
		
		JButton btnBuscarTodos = new JButton("BuscarTodos");
		btnBuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JLabel lblSitucao = new JLabel("Situa\u00E7\u00E3o:");
		lblSitucao.setForeground(Color.WHITE);
		lblSitucao.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblSitucao, "2, 13, right, center");
		
		JComboBox cbSituacao = new JComboBox();
		add(cbSituacao, "4, 13, fill, center");
		btnBuscarTodos.setBackground(new Color(227, 218, 28));
		btnBuscarTodos.setIcon(new ImageIcon(PainelConsultaSinistro.class.getResource("/icones/icons8-lupa-50.png")));
		add(btnBuscarTodos, "4, 16, fill, fill");
		
		JButton btnGerarplanilha = new JButton("GerarPlanilha");
		btnGerarplanilha.setIcon(new ImageIcon(PainelConsultaSinistro.class.getResource("/icones/icons8-planilha-50.png")));
		btnGerarplanilha.setBackground(new Color(227, 218, 28));
		add(btnGerarplanilha, "8, 16, default, fill");
		add(tableSinistro, "2, 19, 13, 2, fill, fill");
		tableSinistro.setModel(new DefaultTableModel(
			new Object[][] {
				{"Número Sinistro", "Segurado", "Veículo", "TipoSinistro", "Data", "Situação"},
			},
			new String[] {
					"Número Sinistro", "Segurado", "Veículo", "TipoSinistro", "Data", "Situação"
			}
		));
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(PainelConsultaSinistro.class.getResource("/icones/icons8-editar-48.png")));
		btnEditar.setBackground(new Color(227, 218, 28));
		add(btnEditar, "10, 23, fill, fill");
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(PainelConsultaSinistro.class.getResource("/icones/icons8-excluir-48.png")));
		btnExcluir.setBackground(new Color(227, 218, 28));
		add(btnExcluir, "12, 23, default, fill");
		tableSinistro.getColumnModel().getColumn(0).setPreferredWidth(89);

	}
}
