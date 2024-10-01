package calculadorag;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class UsuarioR extends JFrame implements ActionListener {
    
    private JTextField nombreT, edadT, correoT, ocupacionT, semestreT;
    private JPasswordField contrasenaT;
    private JButton registrarseB;
    private JLabel nombreL, edadL, correoL, contrasenaL, ocupacionL, semestreL, infoL;
    private ArrayList<aUsuario> Registro = new ArrayList<>();
    Archivo oArchivo = new Archivo();
    ImgFondo fondo = new ImgFondo();
    
    public UsuarioR() {
        this.Registro = oArchivo.leer();
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursos/icono.png")));
        configurarVentana();
        iniciarComponentes();
    }
    
    private void configurarVentana() {
        setTitle(" Usuario-Registrarse "); 
        setSize(575, 600); 
        this.setContentPane(fondo);
        getContentPane().setBackground(Color.white);

        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        
        infoL = new JLabel("¿Está presentando algún problema?");
        infoL.setFont(new Font("Console", Font.BOLD, 12));
        infoL.setBounds(5, 510, 250, 25);
        add(infoL);
        infoL = new JLabel("Envíenos un correo a: sipalvic@Gmail.com");
        infoL.setFont(new Font("Console", Font.BOLD, 12));
        infoL.setBounds(5, 522, 250, 25);
        add(infoL);
        
        nombreL = new JLabel("Nombre:");
        nombreL.setFont(new Font("Console", Font.BOLD, 16));
        nombreL.setBounds(40, 10, 100, 20);
        add(nombreL);
        
        edadL = new JLabel("Edad:");
        edadL.setFont(new Font("Console", Font.BOLD, 16));
        edadL.setBounds(40, 70, 100, 20);
        add(edadL);
        
        correoL = new JLabel("Correo Electrónico:");
        correoL.setFont(new Font("Console", Font.BOLD, 16));
        correoL.setBounds(40, 130, 200, 20);
        add(correoL);
        
        contrasenaL = new JLabel("Constraseña:");
        contrasenaL.setFont(new Font("Console", Font.BOLD, 16));
        contrasenaL.setBounds(40, 190, 150, 20);
        add(contrasenaL);
        
        ocupacionL = new JLabel("Ocupación:");
        ocupacionL.setFont(new Font("Console", Font.BOLD, 16));
        ocupacionL.setBounds(40, 250, 100, 20);
        add(ocupacionL);
        
        semestreL = new JLabel("Semestre:");
        semestreL.setFont(new Font("Console", Font.BOLD, 16));
        semestreL.setBounds(40, 310, 100, 20);
        add(semestreL);
        
        nombreT = new JTextField();
        nombreT.setBounds(60, 38, 425, 25);
        add(nombreT);
        
        edadT = new JTextField();
        edadT.setBounds(60, 98, 425, 25);
        add(edadT);
        
        correoT = new JTextField();
        correoT.setBounds(60, 158, 425, 25);
        add(correoT);
        
        contrasenaT = new JPasswordField();
        contrasenaT.setBounds(60, 218, 425, 25);
        add(contrasenaT);
        
        ocupacionT = new JTextField();
        ocupacionT.setBounds(60, 278, 425, 25);
        add(ocupacionT);
        
        semestreT = new JTextField();
        semestreT.setBounds(60, 338, 425, 25);
        add(semestreT);
        
        registrarseB = new JButton("Registrarse");
        registrarseB.setFont(new Font("Console", Font.BOLD, 16));
        registrarseB.setBounds(122, 400, 295, 30);
        add(registrarseB);
        registrarseB.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(registrarseB) ) {
            aUsuario objUsuario = new aUsuario();
            String Nombre = nombreT.getText();
            objUsuario.setNombre(Nombre);
            String Edad = edadT.getText();
            objUsuario.setEdad(Integer.parseInt(Edad));
            String Correo = correoT.getText();
            objUsuario.setCorreo(Correo.trim());
            String Contrasena = contrasenaT.getText();
            objUsuario.setContrasena(Contrasena.trim());
            String Ocupacion = ocupacionT.getText();
            objUsuario.setOcupacion(Ocupacion);
            String Semestre = semestreT.getText();
            objUsuario.setSemestre(Semestre);
            int confirmado = JOptionPane.showConfirmDialog(null, "¿Desea registrar al usuario?", "Registrar Usuario", JOptionPane.YES_NO_OPTION);
            if (JOptionPane.OK_OPTION == confirmado){
               JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");
               Registro.add(objUsuario);
               oArchivo.serializar(Registro);
               dispose();
               Index obj = new Index();
            }
            else{
            JOptionPane.showMessageDialog(null, "No se registró al usuario");
            }
        }
    }
}