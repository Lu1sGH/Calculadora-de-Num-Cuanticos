package calculadorag;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImgFondo extends JPanel{
    private Image imagen;
     ImageIcon iconobtnconsulta = new ImageIcon("/recursos/Fondo.png");
    
    @Override
    public void paint (Graphics g){
    imagen = new ImageIcon(getClass().getResource("/recursos/Fondo.png")).getImage();
    
    g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    
    setOpaque(false);
    super.paint(g);
      
}
}