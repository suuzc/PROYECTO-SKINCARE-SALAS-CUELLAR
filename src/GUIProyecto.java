import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIProyecto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIProyecto frame = new GUIProyecto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIProyecto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Essentia Skincare");
		lblNewLabel.setForeground(new Color(128, 0, 64));
		lblNewLabel.setFont(new Font("Castellar", Font.PLAIN, 30));
		lblNewLabel.setBounds(74, 25, 337, 46);
		contentPane.add(lblNewLabel);
		
		JComboBox<String> comboBoxpiel = new JComboBox<>(new String[]{"Seca", "Grasa", "Mixta", "Normal"});
		comboBoxpiel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBoxpiel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String tipopiel = comboBoxpiel.getSelectedItem().toString();
			    }
			});
		
		comboBoxpiel.setBounds(192, 165, 83, 22);
		contentPane.add(comboBoxpiel);
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona tu tipo de piel:");
		lblNewLabel_1.setFont(new Font("YouYuan", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(95, 120, 290, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Selecciona tu rango de edad:");
		lblNewLabel_2.setFont(new Font("YouYuan", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(116, 215, 295, 22);
		contentPane.add(lblNewLabel_2);
		
		JComboBox<String> comboBoxedad = new JComboBox<>(new String[]{"Adolescentes (13-19 años)", "Jóvenes adultos (20-29 años)", "Adultos (30-39 años)", "Adultos (40-49 años)", "50 años en adelante"});
		comboBoxedad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String edad = comboBoxpiel.getSelectedItem().toString();
			}
		});
		comboBoxedad.setBounds(139, 265, 234, 28);
		contentPane.add(comboBoxedad);
		
		JLabel lblNewLabel_3 = new JLabel("¿Especificaciones?");
		lblNewLabel_3.setFont(new Font("YouYuan", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(139, 334, 230, 22);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Rosacea");
		rdbtnNewRadioButton.setFont(new Font("YouYuan", Font.PLAIN, 22));
		rdbtnNewRadioButton.setBounds(84, 374, 122, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Acné");
		rdbtnNewRadioButton_1.setFont(new Font("YouYuan", Font.PLAIN, 22));
		rdbtnNewRadioButton_1.setBounds(315, 374, 120, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Consultar PRODUCTOS");
		btnNewButton.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		btnNewButton.setBounds(246, 504, 234, 70);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Consultar RUTINA");
		btnNewButton_1.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		btnNewButton_1.setBounds(10, 504, 213, 70);
		contentPane.add(btnNewButton_1);
	}
}
