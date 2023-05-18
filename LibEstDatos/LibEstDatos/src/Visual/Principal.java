/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visual;

import Clases.Cliente;
import Clases.Empleado;
import Clases.Producto;
import Listas_Pilas_Colas.ColaImprimir;
import Listas_Pilas_Colas.NodoCliente;
import Listas_Pilas_Colas.NodoEmpleado;
import Listas_Pilas_Colas.ListaClientes;
import Listas_Pilas_Colas.ListaEmpleados;
import Listas_Pilas_Colas.ListaProductos;
import Listas_Pilas_Colas.NodoCola;
import Listas_Pilas_Colas.NodoPila;
import Listas_Pilas_Colas.NodoProducto;
import Listas_Pilas_Colas.PilaCarrito;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/**
 *
 * @author maged
 */
public class Principal extends javax.swing.JFrame {

    ListaClientes ListCli = new ListaClientes();
    ListaEmpleados ListEmpl = new ListaEmpleados();
    ListaProductos ListProd = new ListaProductos();
    PilaCarrito PilCarr = new PilaCarrito();
    int valortotal=0;
    int numPersona=0;
    ColaImprimir ColaImp=new ColaImprimir();

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        AgregarEjemplos();

    }

    public void AgregarEjemplos() {
        ListCli.insertarCliente(new Cliente(11456788, "Sarah Hernandez", "88675634", "HerandezSarah88@gmail.com"));
        ListCli.insertarCliente(new Cliente(11659033, "Pedro Sanchez", "88781222", "SanchezPedro22@gmail.com"));
        ListCli.insertarCliente(new Cliente(19213342, "Paco Umania", "62728989", "UmaniaPaco89@gmail.com"));

        ListEmpl.insertarEmpleado(new Empleado(1, "Nikole Ledezma", "Cajera", "LedezmanNikole@gmail.com"));
        ListEmpl.insertarEmpleado(new Empleado(2, "Derek Cervantes", "Acomodador", "CervantesDerek@gmail.com"));
        ListEmpl.insertarEmpleado(new Empleado(3, "Paula Bonilla", "Acomodador", "BonillaPaula@gmail.com"));

        ListProd.insertarProducto(new Producto(1, "caperucita roja", "libro", "libro infantil", 5500));
        ListProd.insertarProducto(new Producto(2, "Dinosaurios", "rompecabezas", "rompecabezas de dinosaurios", 11000));
        ListProd.insertarProducto(new Producto(3, "Harry Potter", "libro", "libro fantasía aventura", 25000));
        ListProd.insertarProducto(new Producto(4, "Klean Kanteen", "botella", "botella rosa", 30000));

        DefaultTableModel modCarrito = new DefaultTableModel();
        modCarrito.addColumn("Nombre");
        modCarrito.addColumn("Precio");
        TablaCarrito.setModel(modCarrito);

        actualizarTablas();

    }

    public void actualizarTablas() {

        DefaultTableModel modClientes = new DefaultTableModel();
        DefaultTableModel modEmpleado = new DefaultTableModel();
        DefaultTableModel modProducto = new DefaultTableModel();

        DefaultTableModel shortymodProducto = new DefaultTableModel();

        DefaultComboBoxModel boxClientes = new DefaultComboBoxModel();
        DefaultComboBoxModel boxEmpleados = new DefaultComboBoxModel();

        modClientes.addColumn("Cedula");
        modClientes.addColumn("Nombre");
        modClientes.addColumn("Telefono");
        modClientes.addColumn("Correo");

        modEmpleado.addColumn("Identificacion");
        modEmpleado.addColumn("Nombre");
        modEmpleado.addColumn("Departamento");
        modEmpleado.addColumn("Correo");

        modProducto.addColumn("Id");
        modProducto.addColumn("Nombre");
        modProducto.addColumn("Tipo");
        modProducto.addColumn("Descripcion");
        modProducto.addColumn("Precio");

        shortymodProducto.addColumn("Nombre");
        shortymodProducto.addColumn("Precio");

        NodoEmpleado aux2 = ListEmpl.Cabeza;
        NodoCliente aux = ListCli.Cabeza;
        NodoProducto aux3 = ListProd.Cabeza;

        while (aux != null) {
            modClientes.addRow(new Object[]{
                aux.getDatoCliente().getIdCliente(),
                aux.getDatoCliente().getNombreCliente(),
                aux.getDatoCliente().getTelefonoCliente(),
                aux.getDatoCliente().getCorreoCliente()
            });
            aux = aux.getNextCliente();

        }
        aux = ListCli.Cabeza;

        while (aux2 != null) {
            modEmpleado.addRow(new Object[]{
                aux2.getDatoEmpleado().getIdEmpleado(),
                aux2.getDatoEmpleado().getNombreEmpleado(),
                aux2.getDatoEmpleado().getDepaEmpleado(),
                aux2.getDatoEmpleado().getCorreoEmpleado()
            });
            aux2 = aux2.getNextEmpleado();

        }
        aux2 = ListEmpl.Cabeza;

        while (aux2 != null) {
            boxEmpleados.addElement(aux2.getDatoEmpleado().getNombreEmpleado());

            aux2 = aux2.getNextEmpleado();

        }

        while (aux3 != null) {
            modProducto.addRow(new Object[]{
                aux3.getDatoProducto().getIdProducto(),
                aux3.getDatoProducto().getNombreProducto(),
                aux3.getDatoProducto().getTipoProducto(),
                aux3.getDatoProducto().getDescripcionProducto(),
                aux3.getDatoProducto().getPrecioProducto()
            });

            aux3 = aux3.getNextProducto();
        }
        aux3 = ListProd.Cabeza;

        while (aux3 != null) {
            shortymodProducto.addRow(new Object[]{
                aux3.getDatoProducto().getNombreProducto(),
                aux3.getDatoProducto().getPrecioProducto()
            });

            aux3 = aux3.getNextProducto();
        }

        while (aux != null) {
            boxClientes.addElement(aux.getDatoCliente().getNombreCliente());
            aux = aux.getNextCliente();

        }

        JComboClientes.setModel(boxClientes);
        JComboEmpleados.setModel(boxEmpleados);

        TablaProductosCobrar.setModel(shortymodProducto);

        Tabla_Clientes.setModel(modClientes);
        Tabla_Empleados.setModel(modEmpleado);
        Tabla_Producto.setModel(modProducto);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel2 = new FondoPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Empleados = new javax.swing.JTable();
        TextCorreoEmpleados = new javax.swing.JTextField();
        TextDepartamentoEmpleados = new javax.swing.JTextField();
        TextNombreEmpleados = new javax.swing.JTextField();
        TextIdEmpleados = new javax.swing.JTextField();
        IdEmpleado = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new FondoPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla_Clientes = new javax.swing.JTable();
        TextIDCliente = new javax.swing.JTextField();
        TextNombreCliente = new javax.swing.JTextField();
        TextTelefonoCliente = new javax.swing.JTextField();
        TextCorreoCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new FondoPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla_Producto = new javax.swing.JTable();
        IdProducto = new javax.swing.JLabel();
        TextIdProducto = new javax.swing.JTextField();
        TextNombreProducto = new javax.swing.JTextField();
        TextTipoProducto = new javax.swing.JTextField();
        TextDescripcion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        NombreProducto = new javax.swing.JLabel();
        TextCantidadProducto = new javax.swing.JTextField();
        Precio = new javax.swing.JLabel();
        jPanel5 = new FondoPanel();
        jLabel12 = new javax.swing.JLabel();
        JComboClientes = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        JComboEmpleados = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaCarrito = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaProductosCobrar = new javax.swing.JTable();
        BotonRestablecer = new javax.swing.JButton();
        PrecioTotalField = new javax.swing.JTextField();
        BotonAgregarCarrito = new javax.swing.JButton();
        BotonImprimir = new javax.swing.JButton();
        BotonSalir = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        BotonAgregar = new javax.swing.JButton();
        BotonEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("menu_principal"); // NOI18N
        setResizable(false);

        jTabbedPane.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabbedPane.setForeground(new java.awt.Color(255, 204, 204));

        Tabla_Empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabla_Empleados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Tabla_Empleados);

        TextCorreoEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        TextDepartamentoEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        TextNombreEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        TextIdEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextIdEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextIdEmpleadosActionPerformed(evt);
            }
        });

        IdEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        IdEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        IdEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        IdEmpleado.setText("ID");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NOMBRE");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DEPARTAMENTO");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CORREO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IdEmpleado)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextIdEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextNombreEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextDepartamentoEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextCorreoEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextIdEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdEmpleado))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextNombreEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextDepartamentoEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextCorreoEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Empleados", jPanel2);

        Tabla_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabla_Clientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(Tabla_Clientes);

        TextIDCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextIDCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextIDClienteActionPerformed(evt);
            }
        });

        TextNombreCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        TextTelefonoCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        TextCorreoCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("IDENTIFICACION");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TELEFONO");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CORREO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1007, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Clientes", jPanel3);

        Tabla_Producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabla_Producto.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(Tabla_Producto);

        IdProducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        IdProducto.setForeground(new java.awt.Color(255, 255, 255));
        IdProducto.setText("ID");

        TextIdProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextIdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextIdProductoActionPerformed(evt);
            }
        });

        TextNombreProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        TextTipoProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        TextDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DESCRIPCION");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TIPO");

        NombreProducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NombreProducto.setForeground(new java.awt.Color(255, 255, 255));
        NombreProducto.setText("NOMBRE");

        TextCantidadProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        Precio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Precio.setForeground(new java.awt.Color(255, 255, 255));
        Precio.setText("PRECIO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1043, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IdProducto)
                    .addComponent(NombreProducto)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(Precio))
                .addGap(78, 78, 78)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdProducto))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreProducto))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Precio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Producto", jPanel4);

        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("PRECIO TOTAL");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("CLIENTES");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("EMPLEADOS");

        JComboEmpleados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        TablaCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaCarrito.setColumnSelectionAllowed(true);
        TablaCarrito.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TablaCarrito);
        TablaCarrito.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        TablaProductosCobrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaProductosCobrar.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(TablaProductosCobrar);
        TablaProductosCobrar.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        BotonRestablecer.setText("RESTABLECER");
        BotonRestablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRestablecerActionPerformed(evt);
            }
        });

        PrecioTotalField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        BotonAgregarCarrito.setText("AGREGAR A CARRITO");
        BotonAgregarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarCarritoActionPerformed(evt);
            }
        });

        BotonImprimir.setText("IMPRIMIR");
        BotonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(JComboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(JComboEmpleados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(BotonRestablecer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonAgregarCarrito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(PrecioTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(221, 221, 221))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PrecioTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(12, 12, 12)
                                .addComponent(JComboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JComboEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114)
                                .addComponent(BotonAgregarCarrito)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonRestablecer, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BotonImprimir, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Cobrar", jPanel5);

        BotonSalir.setText("SALIR");
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });

        Actualizar.setText("ACTUALIZAR");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        BotonAgregar.setText("AGREGAR");
        BotonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarActionPerformed(evt);
            }
        });

        BotonEliminar.setText("ELIMINAR");
        BotonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(BotonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 463, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jTabbedPane.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
        // TODO add your handling code here:
        
        System.out.println(ColaImp.toString());
        
        System.exit(0);
    }//GEN-LAST:event_BotonSalirActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        // TODO add your handling code here:
        actualizarTablas();
    }//GEN-LAST:event_ActualizarActionPerformed

    private void BotonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarActionPerformed
        // TODO add your handling code here:

        int Index = jTabbedPane.getSelectedIndex();

        switch (Index) {
            case 0 -> {
                int IdEmpleadoAdd = Integer.parseInt(TextIdEmpleados.getText());
                String NombreEmpleado = TextNombreEmpleados.getText();
                String DeparEmpleado = TextDepartamentoEmpleados.getText();
                String CorreoEmpleado = TextCorreoEmpleados.getText();
                NodoEmpleado addEmpleado = new NodoEmpleado(new Empleado(IdEmpleadoAdd, NombreEmpleado, DeparEmpleado, CorreoEmpleado));
                if (ListEmpl.Cabeza == null) {
                    ListEmpl.Cabeza = addEmpleado;
                } else {
                    NodoEmpleado aux2 = ListEmpl.Cabeza;
                    while (aux2.getNextEmpleado() != null) {
                        aux2 = aux2.getNextEmpleado();
                    }
                    NodoEmpleado temp2 = addEmpleado;
                    temp2.setNextEmpleado(aux2.getNextEmpleado());
                    aux2.setNextEmpleado(temp2);
                }
            }
            case 1 -> {
                int IdCliente = Integer.parseInt(TextIDCliente.getText());
                String NombreCliente = TextNombreCliente.getText();
                String TelefonoCliente = TextTelefonoCliente.getText();
                String CorreoCliente = TextCorreoCliente.getText();

                NodoCliente addCliente = new NodoCliente(new Cliente(IdCliente, NombreCliente, TelefonoCliente, CorreoCliente));
                if (ListCli.Cabeza == null) {

                    ListCli.Cabeza = addCliente;
                } else {
                    NodoCliente aux = ListCli.Cabeza;
                    while (aux.getNextCliente() != null) {
                        aux = aux.getNextCliente();
                    }

                    NodoCliente temp = addCliente;
                    temp.setNextCliente(aux.getNextCliente());
                    aux.setNextCliente(temp);
                }
            }
            case 2 -> {
                int IdProducto = Integer.parseInt(TextIdProducto.getText());
                String NombreProducto = TextNombreProducto.getText();
                String TipoProducto = TextTipoProducto.getText();
                String DescripcionProducto = TextDescripcion.getText();
                int CantidadProducto = Integer.parseInt(TextCantidadProducto.getText());

                NodoProducto addProducto = new NodoProducto(new Producto(IdProducto, NombreProducto, TipoProducto, DescripcionProducto, CantidadProducto));
                if (ListProd.Cabeza == null) {
                    ListProd.Cabeza = addProducto;
                } else {
                    NodoProducto aux = ListProd.Cabeza;
                    while (aux.getNextProducto() != null) {
                        aux = aux.getNextProducto();
                    }
                    NodoProducto temp = addProducto;
                    temp.setNextProducto(aux.getNextProducto());
                    aux.setNextProducto(temp);
                }
            }

        }
    }//GEN-LAST:event_BotonAgregarActionPerformed

    private void BotonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarActionPerformed
        // TODO add your handling code here:

        int Index = jTabbedPane.getSelectedIndex();
        switch (Index) {
            case 0 -> {
                String respuesta = JOptionPane.showInputDialog(null, "Digite la Id del empleado a eliminiar", "BORRAR", JOptionPane.INFORMATION_MESSAGE);
                NodoEmpleado antEmp = ListEmpl.temp;
                NodoEmpleado aux = ListEmpl.Cabeza;
                int num = Integer.parseInt(respuesta);

                if (!respuesta.isEmpty() && ListEmpl.Cabeza != null) {
                    while (aux != null) {
                        if (aux.getDatoEmpleado().getIdEmpleado() == num) {
                            if (aux == ListEmpl.Cabeza) {
                                ListEmpl.Cabeza = ListEmpl.Cabeza.getNextEmpleado();
                                aux = ListEmpl.Cabeza;
                            } else {
                                antEmp.setNextEmpleado(aux.getNextEmpleado());
                                aux = antEmp.getNextEmpleado();
                            }
                        } else {
                            antEmp = aux;
                            aux = aux.getNextEmpleado();
                        }
                    }
                }
            }
            case 1 -> {
                String respuesta2 = JOptionPane.showInputDialog(null, "Digite la Identificacion del cliente a eliminiar", "BORRAR", JOptionPane.INFORMATION_MESSAGE);
                NodoCliente antCln = ListCli.temp;
                NodoCliente aux2 = ListCli.Cabeza;
                int num2 = Integer.parseInt(respuesta2);

                if (!respuesta2.isEmpty() && ListCli.Cabeza != null) {
                    while (aux2 != null) {
                        if (aux2.getDatoCliente().getIdCliente() == num2) {
                            if (aux2 == ListCli.Cabeza) {
                                ListCli.Cabeza = ListCli.Cabeza.getNextCliente();
                                aux2 = ListCli.Cabeza;
                            } else {
                                antCln.setNextCliente(aux2.getNextCliente());
                                aux2 = antCln.getNextCliente();
                            }
                        } else {
                            antCln = aux2;
                            aux2 = aux2.getNextCliente();
                        }
                    }
                }
            }
            case 2 -> {
                String respuesta3 = JOptionPane.showInputDialog(null, "Digite el ID del producto a eliminiar", "BORRAR", JOptionPane.INFORMATION_MESSAGE);
                NodoProducto antPrd = ListProd.temp;
                NodoProducto aux3 = ListProd.Cabeza;
                int num2 = Integer.parseInt(respuesta3);

                if (!respuesta3.isEmpty() && ListCli.Cabeza != null) {
                    while (aux3 != null) {
                        if (aux3.getDatoProducto().getIdProducto() == num2) {
                            if (aux3 == ListProd.Cabeza) {
                                ListProd.Cabeza = ListProd.Cabeza.getNextProducto();
                                aux3 = ListProd.Cabeza;
                            } else {
                                antPrd.setNextProducto(aux3.getNextProducto());
                                aux3 = antPrd.getNextProducto();
                            }
                        } else {
                            antPrd = aux3;
                            aux3 = aux3.getNextProducto();
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_BotonEliminarActionPerformed

    private void TextIDClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextIDClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextIDClienteActionPerformed

    private void TextIdEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextIdEmpleadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextIdEmpleadosActionPerformed

    private void TextIdProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextIdProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextIdProductoActionPerformed

    private void BotonAgregarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarCarritoActionPerformed

        valortotal=0;
        DefaultTableModel modCarrito = new DefaultTableModel();

        int medidor;
        
        modCarrito.addColumn("Nombre");
        modCarrito.addColumn("Precio");
        
        try {
            medidor = (int) TablaProductosCobrar.getSelectedRow() + 1;
            PilCarr.pushPilaCarrito(new NodoPila(ListProd.obtenerProducto(medidor)));

        } catch (NumberFormatException e) {
            System.out.println("No funciona");
        }
        NodoPila CimaPila = PilCarr.cima;
        while (CimaPila != null) {
            modCarrito.addRow(new Object[]{
                CimaPila.getPilaProducto().getNombreProducto(),
                CimaPila.getPilaProducto().getPrecioProducto()
            });
            valortotal=valortotal+CimaPila.getPilaProducto().getPrecioProducto();
            CimaPila = CimaPila.getAbajo();
        }
        TablaCarrito.setModel(modCarrito);
        PrecioTotalField.setText("$"+valortotal);
    }//GEN-LAST:event_BotonAgregarCarritoActionPerformed

    private void BotonRestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRestablecerActionPerformed
        DefaultTableModel modCarrito = new DefaultTableModel();
        modCarrito.addColumn("Nombre");
        modCarrito.addColumn("Precio");
        TablaCarrito.setModel(modCarrito);
        PilCarr.popPilaCarrito();
        PrecioTotalField.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonRestablecerActionPerformed

    private void BotonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonImprimirActionPerformed
        numPersona++;
        ColaImp.encola(new NodoCola(
                """
                ______________________________________________________________________
                Cliente atendido: """+String.valueOf(JComboClientes.getSelectedItem())+"\n"
                + "Numero de Cliente: "+numPersona+"\n"
                + "Empleado en el mostrador: "+String.valueOf(JComboEmpleados.getSelectedItem()+"\n"
                + "Lista de productos comprados: "+"\n"
                + PilCarr.toString())+"\n"
                + "Total de dinero ganado: "+PrecioTotalField.getText()+"\n"
                +"______________________________________________________________________\n"
                ));
        
        
        
    }//GEN-LAST:event_BotonImprimirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton BotonAgregar;
    private javax.swing.JButton BotonAgregarCarrito;
    private javax.swing.JButton BotonEliminar;
    private javax.swing.JButton BotonImprimir;
    private javax.swing.JButton BotonRestablecer;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JLabel IdEmpleado;
    private javax.swing.JLabel IdProducto;
    private javax.swing.JComboBox<String> JComboClientes;
    private javax.swing.JComboBox<String> JComboEmpleados;
    private javax.swing.JLabel NombreProducto;
    private javax.swing.JLabel Precio;
    private javax.swing.JTextField PrecioTotalField;
    private javax.swing.JTable TablaCarrito;
    private javax.swing.JTable TablaProductosCobrar;
    private javax.swing.JTable Tabla_Clientes;
    private javax.swing.JTable Tabla_Empleados;
    private javax.swing.JTable Tabla_Producto;
    private javax.swing.JTextField TextCantidadProducto;
    private javax.swing.JTextField TextCorreoCliente;
    private javax.swing.JTextField TextCorreoEmpleados;
    private javax.swing.JTextField TextDepartamentoEmpleados;
    private javax.swing.JTextField TextDescripcion;
    private javax.swing.JTextField TextIDCliente;
    private javax.swing.JTextField TextIdEmpleados;
    private javax.swing.JTextField TextIdProducto;
    private javax.swing.JTextField TextNombreCliente;
    private javax.swing.JTextField TextNombreEmpleados;
    private javax.swing.JTextField TextNombreProducto;
    private javax.swing.JTextField TextTelefonoCliente;
    private javax.swing.JTextField TextTipoProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables
}

class FondoPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        Dimension dimension = this.getSize();
        ImageIcon icon = new ImageIcon(getClass().getResource("/IMGs/Fondo.jpeg"));
        g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
        setOpaque(false);
        super.paintChildren(g);
    }
}
