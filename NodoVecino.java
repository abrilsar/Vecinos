
package asociasiovecinos;


class NodoVecino {
    private String name;
    private int cedula;
    private int phone;
    private NodoApartamento apartamento;
    private NodoVecino siguiente;
    private NodoVecino siguienteHabitante;
    
    
    //Constructor
    public NodoVecino(String name, int cedula, int phone){
        this.name = name;
        this.cedula = cedula;
        this.phone = phone;
        this.siguiente = null;
        this.siguienteHabitante = null;
        this.apartamento = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public NodoApartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(NodoApartamento apartamento) {
        this.apartamento = apartamento;
    }

    public NodoVecino getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoVecino siguiente) {
        this.siguiente = siguiente;
    }

    public NodoVecino getSiguienteHabitante() {
        return siguienteHabitante;
    }

    public void setSiguienteHabitante(NodoVecino siguienteHabitante) {
        this.siguienteHabitante = siguienteHabitante;
    }

    
    
}
