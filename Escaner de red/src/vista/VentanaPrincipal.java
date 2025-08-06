package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private JTextField campoIPInicio;
    private JTextField campoIPFin;
    private JSpinner spinnerTimeout;
    private JButton botonEscanear;
    private JButton botonLimpiar;
    private JButton botonGuardar;
    private JTable tablaResultados;
    private JProgressBar barraProgreso;
    private DefaultTableModel modeloTabla;

    public VentanaPrincipal() {
        setTitle("Escáner de Red");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelSuperior = new JPanel(new GridLayout(3, 4, 5, 5));

        campoIPInicio = new JTextField();
        campoIPFin = new JTextField();
        spinnerTimeout = new JSpinner(new SpinnerNumberModel(1000, 100, 10000, 100));
        botonEscanear = new JButton("Comenzar escaneo");
        botonLimpiar = new JButton("Limpiar");
        botonGuardar = new JButton("Guardar resultados");

        panelSuperior.setBorder(BorderFactory.createTitledBorder("Configuración de escaneo"));
        panelSuperior.add(new JLabel("IP de inicio:"));
        panelSuperior.add(campoIPInicio);
        panelSuperior.add(new JLabel("IP de fin:"));
        panelSuperior.add(campoIPFin);
        panelSuperior.add(new JLabel("Tiempo de espera (ms):"));
        panelSuperior.add(spinnerTimeout);
        panelSuperior.add(botonEscanear);
        panelSuperior.add(botonLimpiar);
        panelSuperior.add(new JLabel(""));
        panelSuperior.add(botonGuardar);

        modeloTabla = new DefaultTableModel(new String[]{"Dirección IP", "Nombre del equipo", "Conectado", "Tiempo de respuesta (ms)"}, 0);
        tablaResultados = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaResultados);

        barraProgreso = new JProgressBar();
        barraProgreso.setStringPainted(true);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(barraProgreso, BorderLayout.SOUTH);

        add(panelPrincipal);

        botonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoIPInicio.setText("");
                campoIPFin.setText("");
                spinnerTimeout.setValue(1000);
                modeloTabla.setRowCount(0);
                barraProgreso.setValue(0);
            }
        });
    }
}
