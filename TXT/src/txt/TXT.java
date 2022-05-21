
package txt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class TXT {

    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static void escribirTxt(Lista clientes){
        String clientesActuales = "";
        if(!clientes.vacia()){
            Nodo pointer = clientes.getCabeza();
            for (int i = 0; i < clientes.getLen(); i++){
                clientesActuales += pointer.getElemento() + "," + pointer.getDni();
                pointer = pointer.getSiguiente();
            }
        }
        
        try{
            PrintWriter pw = new PrintWriter("test\\clientes.txt");
            pw.print(clientesActuales); // escribe
            pw.append("Samuel,213213\n"); //Agregando
            pw.close();
             JOptionPane.showMessageDialog(null,"Guardador realizado Exitosamente");
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error");
        }
        
    }
    
    
    public static Lista leerTxt(){
        Lista clientes = new Lista();
        String line;
        String clienteTxt = "";
        String path = "test\\clientes.txt";
        File file = new File(path);
        
        try{
            if(!file.exists()){
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine()) != null){
                    if(!line.isEmpty()){
                        clienteTxt += line + "\n";
                    }
                }
                
                if(!"".equals(clienteTxt)){ //ver si esta vacio
                    String[] clienteSplit = clienteTxt.split("\n");
                    for (int i=0; i < clienteSplit.length; i++){
                        String[] cliente = clienteSplit[i].split(",");
                        clientes.insertarFinal(cliente[0], cliente[1]); //le pasas(Nombre, cedula)
                    }
                }
                
                br.close();
                  JOptionPane.showMessageDialog(null,"Lectura Exitosa");
            }               
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null,"Error");
        }
        
        return clientes;
    }
}
