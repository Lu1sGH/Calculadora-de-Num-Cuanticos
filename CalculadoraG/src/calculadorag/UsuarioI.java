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

public class UsuarioI extends JFrame implements ActionListener {
    
    private JTextField correoT;
    private JPasswordField contrasenaT;
    private JButton iniciarsB, regresarB;
    private JLabel correoL, contrasenaL, infoL;
    private ArrayList<aUsuario> Registro = new ArrayList<>();
    Archivo oArchivo = new Archivo();
    ImgFondo fondo = new ImgFondo();
    
    public UsuarioI() {
        this.Registro = oArchivo.leer();
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursos/icono.png")));
        configurarVentana();
        iniciarComponentes();
    }
    
    private void configurarVentana() {
        setTitle(" Usuario-Iniciar Sesión "); 
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
        
        correoL = new JLabel("Correo Electrónico:");
        correoL.setFont(new Font("Console", Font.BOLD, 16));
        correoL.setBounds(40, 155, 200, 20);
        add(correoL);
        contrasenaL = new JLabel("Contraseña:");
        contrasenaL.setFont(new Font("Console", Font.BOLD, 16));
        contrasenaL.setBounds(40, 235, 150, 20);
        add(contrasenaL);
        
        correoT = new JTextField();
        correoT.setBounds(60, 190, 425, 31);
        add(correoT);
        
        contrasenaT = new JPasswordField();
        contrasenaT.setBounds(60, 270, 425, 31);
        add(contrasenaT);
        
        iniciarsB = new JButton("Iniciar Sesión");
        iniciarsB.setFont(new Font("Console", Font.BOLD, 16));
        iniciarsB.setBounds(130, 400, 295, 30);
        add(iniciarsB);
        iniciarsB.addActionListener(this);
        
        regresarB = new JButton("Regresar");
        regresarB.setFont(new Font("Console", Font.BOLD, 14));
        regresarB.setBounds(20, 15, 120,25);
        add(regresarB);
        regresarB.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(iniciarsB) ) {
            String Nombre = "";
            Boolean Aceptado = false;
            aUsuario objUsuario = new aUsuario();
            String Correo = correoT.getText();
            String Contrasena = contrasenaT.getText();
            for (int i = 0; i < Registro.size(); i++) {
                if (Registro.get(i).getCorreo().equals(Correo.trim())) {
                    if (Registro.get(i).getContrasena().equals(Contrasena.trim())){
                        Nombre = Registro.get(i).getNombre();
                        Aceptado = true;
                        break;
                    }
                    else{
                        Aceptado = false;
                    }
                }
            }
            
            if (Aceptado==true) {
                JOptionPane.showMessageDialog(null, "Bienvenido "+Nombre);
                dispose();
                Index obj = new Index();
            }
            else{
                JOptionPane.showMessageDialog(null, "Alguno de los datos que usted ingresó es incorrecto.");
            }
            
        }
        else{
            if (e.getSource().equals(regresarB)) {
                dispose();
                Usuario obj = new Usuario();
            }
        }
    }
}