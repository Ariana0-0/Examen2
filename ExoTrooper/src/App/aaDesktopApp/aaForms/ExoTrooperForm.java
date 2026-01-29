package App.aaDesktopApp.aaForms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import BusinessLogic.aaTools.aaMunisionReader;
import DataAccess.aaDAOs.*;
import DataAccess.aaDTOs.*;
import Infrastructure.Tools.aaCMD;
import Infrastructure.Tools.aaCMDProgress;
import Infrastructure.aaAppMSG;

public class ExoTrooperForm extends JFrame {
    // Componentes de la interfaz
    private JLabel lblTitulo;
    private JLabel lblAlumnos;
    private JLabel lblCedula1, lblCedula2;
    private JTextField txtCedula1, txtCedula2;
    private JLabel lblNombre1, lblNombre2;
    private JTextField txtNombre1, txtNombre2;
    
    private JLabel lblTipoExobot;
    private JTextField txtTipoExobot;
    private JButton btnAgregar;
    private JButton btnBuscar;
    
    private JTable tblExobots;
    private DefaultTableModel tableModel;
    
    private JButton btnEntrenar;
    private JButton btnAccionArma;
    
    // DAO
    private aaExoBotDAO exoBotDAO = new aaExoBotDAO();
    
    public ExoTrooperForm() {
        initComponents();
        setupLayout();
        setupListeners();
        loadInitialData();
        setVisible(true);
    }
    
    private void initComponents() {
        // Configuración de la ventana
        setTitle("ExoTrooper");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(240, 240, 245));
        
        // Título principal
        lblTitulo = new JLabel("ExoTrooper", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setForeground(new Color(30, 60, 120));
        
        // Sección Alumno(s) - TU INFORMACIÓN
        lblAlumnos = new JLabel("Alumno(s):");
        lblAlumnos.setFont(new Font("Arial", Font.BOLD, 14));
        
        lblCedula1 = new JLabel("Cédula:");
        txtCedula1 = new JTextField(15);
        txtCedula1.setText("1726965542"); // TU CÉDULA
        
        lblNombre1 = new JLabel("nombres completos:");
        txtNombre1 = new JTextField(20);
        txtNombre1.setText("ARIANA THAIS ALOMOTO GRANIZO"); // TU NOMBRE
        
        lblCedula2 = new JLabel("Cédula:");
        txtCedula2 = new JTextField(15);
        txtCedula2.setText(""); // COMPAÑERO (opcional)
        
        lblNombre2 = new JLabel("nombres completos:");
        txtNombre2 = new JTextField(20);
        txtNombre2.setText(""); // COMPAÑERO (opcional)
        
        // Controles TipoExobot
        lblTipoExobot = new JLabel("TipoExobot");
        lblTipoExobot.setFont(new Font("Arial", Font.BOLD, 12));
        
        txtTipoExobot = new JTextField(15);
        
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBackground(new Color(70, 130, 180));
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setFont(new Font("Arial", Font.BOLD, 12));
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(100, 149, 237));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(new Font("Arial", Font.BOLD, 12));
        
        // Tabla
        String[] columnNames = {"IdExobot", "TipoExobot", "Entreno", "No. Accion"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0 || columnIndex == 3) return Integer.class;
                return String.class;
            }
        };
        
        tblExobots = new JTable(tableModel);
        tblExobots.setRowHeight(30);
        tblExobots.setFont(new Font("Arial", Font.PLAIN, 12));
        tblExobots.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tblExobots.getTableHeader().setBackground(new Color(200, 220, 240));
        tblExobots.setGridColor(new Color(180, 180, 180));
        tblExobots.setSelectionBackground(new Color(220, 240, 255));
        
        // Botones de acción - SEGÚN TU CÉDULA (termina en 2)
        btnEntrenar = new JButton("Entrenar 'disparar'");
        btnEntrenar.setBackground(new Color(34, 139, 34));
        btnEntrenar.setForeground(Color.WHITE);
        btnEntrenar.setFont(new Font("Arial", Font.BOLD, 14));
        btnEntrenar.setPreferredSize(new Dimension(200, 40));
        
        btnAccionArma = new JButton("'disparar_Fusil'");
        btnAccionArma.setBackground(new Color(178, 34, 34));
        btnAccionArma.setForeground(Color.WHITE);
        btnAccionArma.setFont(new Font("Arial", Font.BOLD, 14));
        btnAccionArma.setPreferredSize(new Dimension(200, 40));
    }
    
    private void setupLayout() {
        // Panel principal con márgenes
        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(240, 240, 245));
        
        // Panel superior con título
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(240, 240, 245));
        titlePanel.add(lblTitulo, BorderLayout.CENTER);
        
        // Panel de información de alumnos
        JPanel alumnosPanel = createAlumnosPanel();
        
        // Panel de controles
        JPanel controlsPanel = createControlsPanel();
        
        // Panel de la tabla
        JPanel tablePanel = createTablePanel();
        
        // Panel de botones de acción
        JPanel actionButtonsPanel = createActionButtonsPanel();
        
        // Crear un panel norte para título, alumnos y controles
        JPanel northPanel = new JPanel(new BorderLayout(10, 10));
        northPanel.add(titlePanel, BorderLayout.NORTH);
        northPanel.add(alumnosPanel, BorderLayout.CENTER);
        northPanel.add(controlsPanel, BorderLayout.SOUTH);
        
        // Crear un panel central para tabla y botones de acción
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.add(tablePanel, BorderLayout.CENTER);
        centerPanel.add(actionButtonsPanel, BorderLayout.SOUTH);
        
        // Agregar todo al frame
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        
        // Centrar ventana
        setLocationRelativeTo(null);
    }
    
    private JPanel createAlumnosPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(180, 180, 180), 2),
            "Alumno(s):"
        ));
        panel.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Fila 1: Cédula 1 y Nombre 1
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(lblCedula1, gbc);
        
        gbc.gridx = 1;
        panel.add(txtCedula1, gbc);
        
        gbc.gridx = 2;
        panel.add(lblNombre1, gbc);
        
        gbc.gridx = 3;
        panel.add(txtNombre1, gbc);
        
        // Fila 2: Cédula 2 y Nombre 2
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(lblCedula2, gbc);
        
        gbc.gridx = 1;
        panel.add(txtCedula2, gbc);
        
        gbc.gridx = 2;
        panel.add(lblNombre2, gbc);
        
        gbc.gridx = 3;
        panel.add(txtNombre2, gbc);
        
        return panel;
    }
    
    private JPanel createControlsPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        panel.setBackground(Color.WHITE);
        
        // Crear un subpanel para alinear verticalmente
        JPanel verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
        verticalPanel.setBackground(Color.WHITE);
        
        // Label TipoExobot centrado arriba
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.setBackground(Color.WHITE);
        labelPanel.add(lblTipoExobot);
        
        // Panel para controles
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        inputPanel.setBackground(Color.WHITE);
        inputPanel.add(txtTipoExobot);
        inputPanel.add(btnAgregar);
        inputPanel.add(btnBuscar);
        
        verticalPanel.add(labelPanel);
        verticalPanel.add(inputPanel);
        
        panel.add(verticalPanel);
        return panel;
    }
    
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane(tblExobots);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
        
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }
    
    private JPanel createActionButtonsPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 20));
        panel.setBackground(new Color(240, 240, 245));
        
        panel.add(btnEntrenar);
        panel.add(btnAccionArma);
        
        return panel;
    }
    
    private void setupListeners() {
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarExobot();
            }
        });
        
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarExobot();
            }
        });
        
        btnEntrenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entrenarExobot();
            }
        });
        
        btnAccionArma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarAccionArma();
            }
        });
    }
    
    private void loadInitialData() {
        try {
            aaCMDProgress.showSpinner();
            
            // Limpiar tabla
            tableModel.setRowCount(0);
            
            // Agregar datos iniciales según la captura
            tableModel.addRow(new Object[]{1, "ExoInfanteria", "SI", 22});
            tableModel.addRow(new Object[]{2, "ExoAsalto", "NO", 0});  // TU EXOBOT
            tableModel.addRow(new Object[]{3, "ExoInfanteria", "NO", 0});
            tableModel.addRow(new Object[]{4, "ExoMedico", "NO", 0});
            
            aaCMD.print("Datos iniciales cargados en la interfaz");
        } catch (Exception e) {
            aaCMD.printError("Error cargando datos iniciales: " + e.getMessage());
        }
    }
    
    private void agregarExobot() {
        String tipo = txtTipoExobot.getText().trim();
        
        if (tipo.isEmpty()) {
            aaAppMSG.showError("Ingrese un tipo de Exobot");
            return;
        }
        
        // Validar que sea un tipo válido
        String[] tiposValidos = {"ExoAsalto", "ExoExplorador", "ExoInfanteria", "ExoMedico", "ExoComando"};
        boolean tipoValido = false;
        for (String valido : tiposValidos) {
            if (tipo.equalsIgnoreCase(valido)) {
                tipoValido = true;
                tipo = valido; // Normalizar a formato correcto
                break;
            }
        }
        
        if (!tipoValido) {
            aaAppMSG.showError("Tipos válidos: ExoAsalto, ExoExplorador, ExoInfanteria, ExoMedico, ExoComando");
            return;
        }
        
        try {
            // Agregar a la tabla
            int nuevoId = tableModel.getRowCount() + 1;
            tableModel.addRow(new Object[]{nuevoId, tipo, "NO", 0});
            
            // Agregar al DAO
            aaExoBotDTO nuevoExobot = new aaExoBotDTO(tipo);
            exoBotDAO.aaAgregarExobot(nuevoExobot);
            
            // Limpiar campo
            txtTipoExobot.setText("");
            
            // Log
            aaCMD.printGood("Exobot agregado: " + tipo);
            
            aaAppMSG.show("Exobot agregado exitosamente:\nID: " + nuevoId + "\nTipo: " + tipo);
        } catch (Exception e) {
            aaCMD.printError("Error agregando Exobot: " + e.getMessage());
            aaAppMSG.showError("Error al agregar Exobot: " + e.getMessage());
        }
    }
    
    private void buscarExobot() {
        String busqueda = txtTipoExobot.getText().trim();
        
        if (busqueda.isEmpty()) {
            // Si está vacío, recargar todos
            loadInitialData();
            return;
        }
        
        try {
            // Filtrar la tabla
            for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
                String tipoExobot = ((String) tableModel.getValueAt(i, 1));
                if (!tipoExobot.equalsIgnoreCase(busqueda)) {
                    tableModel.removeRow(i);
                }
            }
            
            if (tableModel.getRowCount() == 0) {
                aaAppMSG.show("No se encontraron Exobots con: " + busqueda);
                loadInitialData(); // Recargar todos
            }
        } catch (Exception e) {
            aaCMD.printError("Error buscando Exobot: " + e.getMessage());
            aaAppMSG.showError("Error en la búsqueda");
        }
    }
    
    private void entrenarExobot() {
        int selectedRow = tblExobots.getSelectedRow();
        
        if (selectedRow == -1) {
            aaAppMSG.showError("Seleccione un Exobot de la tabla para entrenar");
            return;
        }
        
        int idExobot = (int) tableModel.getValueAt(selectedRow, 0);
        String tipoExobot = (String) tableModel.getValueAt(selectedRow, 1);
        String entrenado = (String) tableModel.getValueAt(selectedRow, 2);
        
        // Verificar si ya está entrenado
        if ("SI".equals(entrenado)) {
            aaAppMSG.show("Este Exobot ya está entrenado");
            return;
        }
        
        // SOLO ExoAsalto puede ser entrenado (según tu cédula termina en 2)
        if (!"ExoAsalto".equals(tipoExobot)) {
            String mensajeError = "SoldadoExperto Fusil disparar";
            aaCMD.printError(mensajeError);
            
            aaAppMSG.showError("Solo ExoAsalto puede ser entrenado para 'disparar' con Fusil\n" +
                "Su cédula termina en 2 → ExoAsalto");
            return;
        }
        
        try {
            // Crear soldado experto en Fusil
            BusinessLogic.aaEntities.aaSoldadoExperto soldadoExperto = 
                new BusinessLogic.aaEntities.aaSoldadoExperto("Soldado Experto Fusil", "Fusil");
            
            // Crear IABOT para asistencia
            BusinessLogic.aaEntities.aaIABOT iabot = new BusinessLogic.aaEntities.aaIABOT();
            
            // Crear Exobot
            BusinessLogic.aaEntities.aaExoAsalto exobot = new BusinessLogic.aaEntities.aaExoAsalto();
            
            // Asistencia del IABOT en el entrenamiento
            iabot.asistirEntrenamiento(soldadoExperto, exobot);
            
            // Entrenar exitosamente
            String mensajeExito = "SoldadoExperto Fusil disparar";
            aaCMD.printGood(mensajeExito);
            
            // Actualizar tabla
            tableModel.setValueAt("SI", selectedRow, 2);
            
            // Actualizar DAO
            exoBotDAO.aaActualizarEntrenamiento(idExobot, true);
            
            aaAppMSG.show("¡Exobot entrenado exitosamente!\n" +
                "Tipo: " + tipoExobot + "\n" +
                "Arma: Fusil\n" +
                "Acción: disparar");
        } catch (Exception e) {
            aaCMD.printError("Error entrenando Exobot: " + e.getMessage());
            aaAppMSG.showError("Error en el entrenamiento: " + e.getMessage());
        }
    }
    
    private void ejecutarAccionArma() {
        int selectedRow = tblExobots.getSelectedRow();
        
        if (selectedRow == -1) {
            aaAppMSG.showError("Seleccione un Exobot de la tabla para ejecutar acción");
            return;
        }
        
        int idExobot = (int) tableModel.getValueAt(selectedRow, 0);
        String tipoExobot = (String) tableModel.getValueAt(selectedRow, 1);
        String entrenado = (String) tableModel.getValueAt(selectedRow, 2);
        
        // Verificar si está entrenado
        if (!"SI".equals(entrenado)) {
            aaCMD.printError("El Exobot debe estar entrenado primero");
            aaAppMSG.showError("El Exobot debe estar entrenado antes de ejecutar acciones");
            return;
        }
        
        // Verificar que sea ExoAsalto
        if (!"ExoAsalto".equals(tipoExobot)) {
            aaCMD.printError("Solo ExoAsalto puede ejecutar 'disparar_Fusil'");
            aaAppMSG.showError("Solo ExoAsalto puede ejecutar 'disparar_Fusil'");
            return;
        }
        
        try {
            // Leer munición del archivo
            String municion = leerMunicionDelArchivo();
            
            if (municion.contains("No encontrado") || municion.contains("Error")) {
                String errorMsg = "Fusil disparar " + municion;
                aaCMD.printError(errorMsg);
                
                aaAppMSG.showError("No se encontró munición para Fusil en el archivo");
                return;
            }
            
            // Crear Exobot y IAEXO
            BusinessLogic.aaEntities.aaExoAsalto exobot = new BusinessLogic.aaEntities.aaExoAsalto();
            BusinessLogic.aaEntities.aaIAEXO iaexo = new BusinessLogic.aaEntities.aaIAEXO(exobot);
            
            // Crear Fusil y recurso
            BusinessLogic.aaEntities.aaFusil fusil = new BusinessLogic.aaEntities.aaFusil();
            BusinessLogic.aaEntities.aaRecurso recurso = new BusinessLogic.aaEntities.aaRecurso("Munición_Fusil", 10);
            fusil.aaSetRecurso(recurso);
            exobot.aaSetArma(fusil);
            
            // Ejecutar acción a través de IAEXO
            boolean accionExitosa = iaexo.aaEjecutarAccion();
            
            if (accionExitosa) {
                // Incrementar contador de acciones
                int accionesActuales = (int) tableModel.getValueAt(selectedRow, 3);
                tableModel.setValueAt(accionesActuales + 1, selectedRow, 3);
                
                // Actualizar DAO
                exoBotDAO.aaIncrementarAcciones(idExobot);
                
                // Log exitoso
                String successMsg = "Fusil disparar " + municion;
                aaCMD.printGood(successMsg);
                
                aaAppMSG.show("¡Acción ejecutada exitosamente!\n" +
                    "TipoArma: Fusil\n" +
                    "AcciónArma: disparar\n" +
                    "Munición: " + municion + "\n" +
                    "Total acciones: " + (accionesActuales + 1));
            } else {
                aaCMD.printError("Fallo la ejecución de la acción");
                aaAppMSG.showError("Fallo la ejecución de la acción");
            }
        } catch (Exception e) {
            aaCMD.printError("Error ejecutando acción: " + e.getMessage());
            aaAppMSG.showError("Error ejecutando acción: " + e.getMessage());
        }
    }
    
    private String leerMunicionDelArchivo() {
        try {
            // Leer el archivo ExoMunision.txt
            String contenido = aaMunisionReader.aaBuscarMunicionPorTipo("Munición_Fusil");
            
            // Si no encuentra específicamente, buscar cualquier munición
            if (contenido.contains("No encontrado")) {
                contenido = aaMunisionReader.aaBuscarMunicionPorTipo("Fusil");
            }
            
            return contenido;
        } catch (Exception e) {
            return "Error leyendo archivo: " + e.getMessage();
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    aaCMDProgress.showBar("#");
                    new ExoTrooperForm();
                } catch (Exception e) {
                    aaCMD.printError("Error iniciando aplicación: " + e.getMessage());
                }
            }
        });
    }
}