package calculadorag;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Window;

public class Usuario extends JFrame implements ActionListener {
    
    private JButton iniciarsB, registrarseB;
    private JLabel tituloL, infoL, imgLogo;
    ImgFondo fondo = new ImgFondo();
    
    public Usuario() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursos/icono.png")));
        configurarVentana();
        iniciarComponentes();
        setVisible(true);
    }
    
    private void configurarVentana() {
        setTitle(" Usuario "); 
        setSize(575, 600);
        this.setContentPane(fondo);
        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {

        tituloL = new JLabel("Bienvenido a " + (char)34 + "El Automaticón Cuántico" + (char)34);
        tituloL.setBounds(100, 20, 450, 75);
        tituloL.setFont(new Font("Console", Font.BOLD, 18));
        add(tituloL);
        
        infoL = new JLabel("¿Está presentando algún problema?");
        infoL.setFont(new Font("Console", Font.BOLD, 12));
        infoL.setBounds(5, 510, 250, 25);
        add(infoL);
        infoL = new JLabel("Envíenos un correo a: sipalvic@Gmail.com");
        infoL.setFont(new Font("Console", Font.BOLD, 12));
        infoL.setBounds(5, 522, 250, 25);
        add(infoL);
        
        imgLogo = new JLabel();
        imgLogo.setBounds(172, 100,200,200);
        imgLogo.setBorder(null);
        add(imgLogo);
        
        System.out.println(getClass().getResource("/recursos/logo.png"));
        System.out.println(getClass().getSimpleName());
        
        ImageIcon Logo = new ImageIcon(this.getClass().getResource("/recursos/logo.png"));
        Image img = Logo.getImage();
        ImageIcon nuevoIcon = new ImageIcon(img);
        imgLogo.setIcon(nuevoIcon);
        
        iniciarsB = new JButton("Iniciar Sesión");
        iniciarsB.setFont(new Font("Console", Font.BOLD, 16));
        iniciarsB.setBounds(190, 340, 165, 30);
        add(iniciarsB);
        iniciarsB.addActionListener(this);
        
        registrarseB = new JButton("Registrarse");
        registrarseB.setFont(new Font("Console", Font.BOLD, 16));
        registrarseB.setBounds(190, 400, 165,30);
        add(registrarseB);
        registrarseB.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(iniciarsB) ) {
            UsuarioI obj = new UsuarioI();
            obj.setVisible(true);
            this.setVisible(false);
        }
        else if (e.getSource().equals(registrarseB) ) {
            UsuarioR obj = new UsuarioR();
            obj.setVisible(true);
            this.setVisible(false);
        }
    }
}