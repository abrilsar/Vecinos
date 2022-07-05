/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

public class Txt {
    public static void readTxt(){
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
                br.close();
                JOptionPane.showMessageDialog(null,"Lectura Exitosa");
                Grafo grafo = txt.checkFile(infoTxt);
                return grafo;
                }              
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex);
        }
        
        return null;
   }
}
