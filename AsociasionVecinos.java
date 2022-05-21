
package asociasiovecinos;

import javax.swing.JOptionPane;

public class AsociasionVecinos {

    private ListaVecinos lVecinos;
    private ListaEdificio edificios;
    
    public AsociasionVecinos(){
        this.lVecinos = new ListaVecinos();
        this. edificios = new ListaEdificio();
    }
  
    public NodoVecino buscarCedula(int cedula){
        NodoVecino vecino = null;
        NodoVecino pointer = lVecinos.getCabeza();
        boolean encontrado = false;
        while(pointer != null && !encontrado){
            if(pointer.getCedula() == cedula){
                encontrado = true;
            }else{
                pointer = pointer.getSiguiente();
            }
        }
        
        if(encontrado){
            return pointer;
        }else{
            return vecino;
        }
    }
    
    public NodoApartamento buscarApartamento(NodoVecino vecino){
        NodoApartamento apartamenro = null;
        boolean encontrado = false;
        while(vecino != null && !encontrado){
            if(vecino.getApartamento() != null){
                encontrado = true;
            }else{
                vecino = vecino.getSiguienteHabitante();
            }
        }
        
        if(encontrado){
            return vecino.getApartamento();
        }else{
            return null;
        }
    }
    
    
    public NodoEdificio buscarEdificio(NodoApartamento apartamento){
        NodoEdificio edificio = null;
        boolean encontrado = false;
        while(apartamento != null && !encontrado){
            if(apartamento.getEdificio() != null){ ///Esto lo recorre po que el ejer lo pusieron como que es el ultimo quien tiene la info
                encontrado = true;
            }else{
                apartamento = apartamento.getSiguiente();
            }
        }
        
        if(encontrado){
            return apartamento.getEdificio();
        }else{
            return edificio;
        }
    }
    
    public void direccionVecino(int cedula){
        String message = "";
        NodoVecino vecino = this.buscarCedula(cedula);
        if(vecino != null){
            NodoApartamento apartamento = this.buscarApartamento(vecino);
            NodoEdificio edificio = this.buscarEdificio(apartamento);
            message = "Vecino: " + vecino.getName() + "\n"+
                      "Cedula: " + vecino.getCedula() + "\n"+
                      "Telefono: " + vecino.getPhone() + "\n"+
                      "Numero de Apartamento: " + apartamento.getNumero() + "\n"+
                      "Edificio: " + edificio.getName() + "\n";  
            JOptionPane.showMessageDialog(null,message);
        }else{
            JOptionPane.showMessageDialog(null,"Lista Vacia");
        }
    }
}
