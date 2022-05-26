
package proyecto1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class txt {
    
//   public static void writeTxt(List clientes){
//        String clientesActuales = "";
//        if(!clientes.vacia()){
//            Nodo pointer = clientes.getCabeza();
//            for (int i = 0; i < clientes.getLen(); i++){
//                clientesActuales += pointer.getElemento() + "," + pointer.getDni();
//                pointer = pointer.getSiguiente();
//            }
//        }
//        
//        try{
//            PrintWriter pw = new PrintWriter("test\\clientes.txt");
//            pw.print(clientesActuales); // escribe
//            pw.append("Samuel,213213\n"); //Agregando
//            pw.close();
//             JOptionPane.showMessageDialog(null,"Guardador realizado Exitosamente");
//        }catch(Exception err){
//            JOptionPane.showMessageDialog(null,"Error");
//        }
//        
//    } 
   
   public static void leerTxt(){
        String line;
        String infoTxt = "";
        String path = "test\\txt.txt";
        File file = new File(path);
        
        try{
            if(!file.exists()){
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine()) != null){
                    if(!line.isEmpty()){
                        infoTxt += line + "\n";
                    }
                }
                if(!"".equals(infoTxt)){
                    String[] infoSplit = infoTxt.split(";");
                     if (infoSplit[0].equals("Almacenes")){
                            for (int i=1; i < (infoSplit.length - 1); i++){
                                if (!infoSplit[i].equals("\nRutas")){
                                    System.out.println(infoSplit[i]);
                                }else{
                                    System.out.println(infoSplit[i]);
                                    System.out.println(infoSplit[i+1]);
                                    break;
                                }
                            }
                        }
                    }
                    br.close();
                  JOptionPane.showMessageDialog(null,"Lectura Exitosa");
                }
                
                
                           
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null,"Error!");
        }
        
//        return clientes;
   }
}

