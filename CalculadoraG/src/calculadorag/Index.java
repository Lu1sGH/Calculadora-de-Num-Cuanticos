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

public class Index extends JFrame implements ActionListener {
    
    private JButton calculadoraB, problemarioB, cerrarB;
    private JLabel usuarioL, infoL;
    private ArrayList<aUsuario> Registro = new ArrayList<>();
    Archivo objArchivo = new Archivo();
    ImgFondo fondo = new ImgFondo();
    
    public Index() {
        Registro = objArchivo.leer();
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursos/icono.png")));
        configurarVentana();
        iniciarComponentes();
        setVisible(true);
    }
    
    private void configurarVentana() {
        setTitle(" El Automaticón Cuántico "); 
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

        calculadoraB = new JButton("Calculadora");
        calculadoraB.setFont(new Font("Console", Font.BOLD, 16));
        calculadoraB.setBounds(175, 125, 200, 50);
        add(calculadoraB);
        
        calculadoraB.addActionListener(this);
        problemarioB = new JButton("Problemario");
        problemarioB.setFont(new Font("Console", Font.BOLD, 16));
        problemarioB.setBounds(175, 225, 200,50);
        add(problemarioB);
        
        problemarioB.addActionListener(this);
        cerrarB = new JButton("Cerrar sesión y salir");
        cerrarB.setFont(new Font("Console", Font.BOLD, 16));
        cerrarB.setBounds(175, 325, 200,50);
        add(cerrarB);
        cerrarB.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(calculadoraB) ) {
            dispose();
            Calculadora obj = new Calculadora();
        }
        else if (e.getSource().equals(problemarioB) ) {
            dispose();
            Problemario obj = new Problemario();
        }
        else if (e.getSource().equals(cerrarB) ) {
            System.exit(0);
        }
    }
}