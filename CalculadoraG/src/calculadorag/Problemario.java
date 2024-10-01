package calculadorag;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Problemario extends JFrame implements ActionListener {
    
    private JTextField simboloT, numeroT, nT, lT, mlT, msT;
    private JButton RevisardatosB, regresarB;
    private JLabel simboloL, numeroL, nL, lL, mlL, msL, infoL;
    ImgFondo fondo = new ImgFondo();
    
    public Problemario() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursos/icono.png")));
        configurarVentana();
        iniciarComponentes();
        setVisible(true);
    }
    
    private void configurarVentana() {
        setTitle(" Problemario "); 
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
        
        simboloL = new JLabel("Símbolo del elemento:");
        simboloL.setFont(new Font("Console", Font.BOLD, 16));
        simboloL.setBounds(150, 40, 200, 20);
        add(simboloL);
        numeroL = new JLabel("Número de electrones:");
        numeroL.setFont(new Font("Console", Font.BOLD, 16));
        numeroL.setBounds(150, 100, 200, 20);
        add(numeroL);
        nL = new JLabel("n:");
        nL.setFont(new Font("Console", Font.BOLD, 16));
        nL.setBounds(150, 160, 200, 20);
        add(nL);
        lL = new JLabel("l:");
        lL.setFont(new Font("Console", Font.BOLD, 16));
        lL.setBounds(150, 220, 150, 20);
        add(lL);
        mlL = new JLabel("ml:");
        mlL.setFont(new Font("Console", Font.BOLD, 16));
        mlL.setBounds(150, 280, 100, 20);
        add(mlL);
        msL = new JLabel("ms:");
        msL.setFont(new Font("Console", Font.BOLD, 16));
        msL.setBounds(150, 340, 100, 20);
        add(msL);
        
        simboloT = new JTextField();
        simboloT.setBounds(160, 68, 225, 25);
        add(simboloT);
        numeroT = new JTextField();
        numeroT.setBounds(160, 128, 225, 25);
        add(numeroT);
        nT = new JTextField();
        nT.setBounds(160, 188, 225, 25);
        add(nT);
        lT = new JTextField();
        lT.setBounds(160, 248, 225, 25);
        add(lT);
        mlT = new JTextField();
        mlT.setBounds(160, 308, 225, 25);
        add(mlT);
        msT = new JTextField();
        msT.setBounds(160, 368, 225, 25);
        add(msT);
        
        RevisardatosB = new JButton("Revisar datos.");
        RevisardatosB.setFont(new Font("Console", Font.BOLD, 16));
        RevisardatosB.setBounds(191, 440, 165,30);
        add(RevisardatosB);
        RevisardatosB.addActionListener(this);
        regresarB = new JButton("Regresar");
        regresarB.setFont(new Font("Console", Font.BOLD, 14));
        regresarB.setBounds(20, 15, 120,25);
        add(regresarB);
        regresarB.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(RevisardatosB) ) {
            cCal oPro = new cCal();
            String dato1 = simboloT.getText();
            oPro.setElemento(dato1);
            String dato2 = numeroT.getText();
            oPro.setElectrones(Integer.parseInt(dato2));
            int n = Integer.parseInt(nT.getText());
            int l = Integer.parseInt(lT.getText());
            int ml = Integer.parseInt(mlT.getText());
            String ms = msT.getText();
            oPro.datos();
            oPro.Calcular();
            oPro.rCuestionario(n, l, ml, ms);
        }
        else if (e.getSource().equals(regresarB) ){
            dispose();
            Index obj = new Index();
        }
    }
}