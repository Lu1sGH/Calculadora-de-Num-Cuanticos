package calculadorag;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Calculadora extends JFrame implements ActionListener {
    
    private JTextField simboloT, numeroT;
    private JButton calcularB, regresarB;
    private JLabel simboloL, numeroL, confiL, guionL, nL, lL, mlL, msL, infoL, nRL, lRL, mlRL, msRL, simbolo2L, numero2L, elementoL;
    ImgFondo fondo = new ImgFondo();
    
    public Calculadora() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursos/icono.png")));
        configurarVentana();
        iniciarComponentes();
        setVisible(true);
    }
    
    private void configurarVentana() {
        setTitle(" Calculadora "); 
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
        simboloL.setBounds(125, 80, 200, 20);
        add(simboloL);
        
        numeroL = new JLabel("Número de electrones:");
        numeroL.setFont(new Font("Console", Font.BOLD, 16));
        numeroL.setBounds(125, 140, 200, 20);
        add(numeroL);
        
        confiL = new JLabel("Configuración Electrónica:");
        confiL.setFont(new Font("Console", Font.BOLD, 16));
        confiL.setBounds(40, 265, 250, 20);
        add(confiL);
        
        guionL = new JLabel("");
        guionL.setFont(new Font("Console", Font.BOLD, 16));
        guionL.setBounds(55, 290, 450, 20);
        add(guionL);
        
        nL = new JLabel("n:");
        nL.setFont(new Font("Console", Font.BOLD, 16));
        nL.setBounds(42, 340, 200, 20);
        add(nL);
        
        lL = new JLabel("l:");
        lL.setFont(new Font("Console", Font.BOLD, 16));
        lL.setBounds(42, 380, 150, 20);
        add(lL);
        
        mlL = new JLabel("ml:");
        mlL.setFont(new Font("Console", Font.BOLD, 16));
        mlL.setBounds(42, 420, 100, 20);
        add(mlL);
        
        msL = new JLabel("ms:");
        msL.setFont(new Font("Console", Font.BOLD, 16));
        msL.setBounds(42, 460, 100, 20);
        add(msL);
        
        nRL = new JLabel("");
        nRL.setFont(new Font("Console", Font.BOLD, 16));
        nRL.setBounds(92, 340, 200, 20);
        add(nRL);
        
        lRL = new JLabel("");
        lRL.setFont(new Font("Console", Font.BOLD, 16));
        lRL.setBounds(92, 380, 150, 20);
        add(lRL);
        
        mlRL = new JLabel("");
        mlRL.setFont(new Font("Console", Font.BOLD, 16));
        mlRL.setBounds(92, 420, 100, 20);
        add(mlRL);
        
        msRL = new JLabel("");
        msRL.setFont(new Font("Console", Font.BOLD, 16));
        msRL.setBounds(92, 460, 100, 20);
        add(msRL);
        
        elementoL = new JLabel("Elemento: ");
        elementoL.setFont(new Font("Console", Font.BOLD, 16));
        elementoL.setBounds(280, 340, 200, 20);
        add(elementoL);
        
        simbolo2L = new JLabel("");
        simbolo2L.setFont(new Font("Console", Font.BOLD, 80));
        simbolo2L.setBounds(320, 360, 120, 120);
        add(simbolo2L);
        
        numero2L = new JLabel("");
        numero2L.setFont(new Font("Console", Font.BOLD, 30));
        numero2L.setBounds(290, 320, 100, 120);
        add(numero2L);
        
        simboloT = new JTextField();
        simboloT.setBounds(350, 80, 100, 30);
        add(simboloT);
        
        numeroT = new JTextField();
        numeroT.setBounds(350, 140, 100, 30);
        add(numeroT);
        
        calcularB = new JButton("Calcular números cuánticos.");
        calcularB.setFont(new Font("Console", Font.BOLD, 16));
        calcularB.setBounds(130, 205, 300,30);
        add(calcularB);
        calcularB.addActionListener(this);
        
        regresarB = new JButton("Regresar");
        regresarB.setFont(new Font("Console", Font.BOLD, 14));
        regresarB.setBounds(20, 15, 120,25);
        add(regresarB);
        regresarB.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(calcularB) ) {
            cCal oCal = new cCal();
            String dato1 = simboloT.getText();
            oCal.setElemento(dato1);
            simbolo2L.setText(dato1);
            String dato2 = numeroT.getText();
            oCal.setElectrones(Integer.parseInt(dato2));
            numero2L.setText(dato2);
            oCal.datos();
            oCal.Calcular();
            String n = String.valueOf(oCal.getN());
            String l = String.valueOf(oCal.getL());
            String ml = String.valueOf(oCal.getM());
            String s = String.valueOf(oCal.getSpin());
            guionL.setText(oCal.getConfiguracionE());
            nRL.setText(n);
            lRL.setText(l);
            mlRL.setText(ml);
            msRL.setText(s);
        }
        else if (e.getSource().equals(regresarB) ){
            dispose();
            Index obj = new Index();
        }
    }
}