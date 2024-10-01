package calculadorag;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Archivo {
    ArrayList<aUsuario> uRecuperados = new ArrayList<>();
    
    ArrayList<aUsuario> leer(){
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("usuarios.dat"));
            uRecuperados = (ArrayList<aUsuario>)in.readObject();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Aún no hay usuarios registrados.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        
        return uRecuperados;
    }
    
    void serializar(ArrayList<aUsuario> aSeriar){
        try{
            ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
            objOut.writeObject(aSeriar);
            objOut.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error al guardar los datos ingresador.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }
}