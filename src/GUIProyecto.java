import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import archivosFrutas.fruta;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class GUIProyecto extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    String tipopiel;
    String edadSeleccionada;
    boolean tieneRosacea = false;
    boolean tieneAcne = false;
    private JTextField textField;
    rutina nuevaRutina = new rutina();
    producto nuevoProductos = new producto();
    String nombre;
    private ArrayList<rutina> historialRutinas = new ArrayList<>();
    private ArrayList<String> historialProductos = new ArrayList<>();
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
                tipopiel = comboBoxpiel.getSelectedItem().toString();
            }
        });

        comboBoxpiel.setBounds(202, 182, 83, 22);
        contentPane.add(comboBoxpiel);

        JLabel lblNewLabel_1 = new JLabel("Selecciona tu tipo de piel:");
        lblNewLabel_1.setFont(new Font("YouYuan", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(133, 149, 240, 22);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Selecciona tu rango de edad:");
        lblNewLabel_2.setFont(new Font("YouYuan", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(110, 232, 268, 22);
        contentPane.add(lblNewLabel_2);

        JComboBox<String> comboBoxedad = new JComboBox<>(new String[]{
            "Adolescentes (13-19 años)", 
            "Jóvenes adultos (20-29 años)", 
            "Adultos (30-39 años)", 
            "Adultos (40-49 años)", 
            "50 años en adelante"
        });
        comboBoxedad.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBoxedad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                edadSeleccionada = comboBoxedad.getSelectedItem().toString();
            }
        });
        comboBoxedad.setBounds(127, 274, 234, 28);
        contentPane.add(comboBoxedad);

        JLabel lblNewLabel_3 = new JLabel("¿Especificaciones?");
        lblNewLabel_3.setFont(new Font("YouYuan", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(148, 330, 192, 22);
        contentPane.add(lblNewLabel_3);

        JRadioButton rdbtnRosacea = new JRadioButton("Rosacea");
        rdbtnRosacea.setFont(new Font("YouYuan", Font.PLAIN, 22));
        rdbtnRosacea.setBounds(84, 374, 122, 23);
        rdbtnRosacea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tieneRosacea = rdbtnRosacea.isSelected();
            }
        });
        contentPane.add(rdbtnRosacea);

        JRadioButton rdbtnAcne = new JRadioButton("Acné");
        rdbtnAcne.setFont(new Font("YouYuan", Font.PLAIN, 22));
        rdbtnAcne.setBounds(315, 374, 120, 23);
        rdbtnAcne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tieneAcne = rdbtnAcne.isSelected();
            }
        });
        contentPane.add(rdbtnAcne);

        JButton btnRutina = new JButton("Consultar RUTINA");
        btnRutina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
  
                
                // Convertir el rango de edad a un valor numérico para los métodos
                int edad = convertirEdad(edadSeleccionada);
                nombre = textField.getText();
                // Establecer los valores en la clase
                nuevaRutina.setUsuario(nombre);
                nuevaRutina.setTipoPiel(tipopiel);
                nuevaRutina.setEdad(edad);
                nuevaRutina.setTieneRosacea(tieneRosacea);
                nuevaRutina.setTieneAcne(tieneAcne);
               
                
                // Obtener resultados de los métodos
                String mensajeRutina = nuevaRutina.getUsuario() + "\n" +
                		nuevaRutina.limpiar(tipopiel, tieneAcne, tieneRosacea) + "\n" +
                		nuevaRutina.tonificar(tipopiel) + "\n" +
                		nuevaRutina.tratamientos(tipopiel, tieneRosacea, tieneAcne) + "\n" +
                		nuevaRutina.hidratar(tipopiel, edad) + "\n" +
                		nuevaRutina.protectorSolar(tipopiel, edad);

                // Mostrar resultados en JOptionPane
                JOptionPane.showMessageDialog(null, mensajeRutina, "Rutina de Skincare", JOptionPane.INFORMATION_MESSAGE);             
                historialRutinas.add(nuevaRutina);
                try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("rutinas.dat"))) {
		            // serializacion
		            salida.writeObject(nuevaRutina);
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
            }
        });
        btnRutina.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
        btnRutina.setBounds(10, 426, 213, 70);
        contentPane.add(btnRutina);

        JButton btnProductos = new JButton("Consultar PRODUCTOS");
        btnProductos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

            }
        });


        btnBuscarResultadosAnteriores.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
        btnBuscarResultadosAnteriores.setBounds(93, 511, 302, 70);
        contentPane.add(btnBuscarResultadosAnteriores);
    }

    // Método para convertir la edad seleccionada a un número para los métodos de RutinaCuidadoFacial
    private int convertirEdad(String rangoEdad) {
        switch (rangoEdad) {
            case "Adolescentes (13-19 años)": return 17;
            case "Jóvenes adultos (20-29 años)": return 25;
            case "Adultos (30-39 años)": return 35;
            case "Adultos (40-49 años)": return 45;
            case "50 años en adelante": return 50;
            default: return 0;
        }
    }
}
