
package Negocio;

public class GenerarCodigo {
    private int dato;
    private int cont=1;
    private String num = "";//EJM: M... CM...
//MÉTODO PARA GENERAR ID AUTO INCREMENTABLES PARA CITAS MÉDICAS Y MÉDICOS
    public void generar(int dato){
        this.dato = dato;
       if((this.dato>=1000) || (this.dato<10000)){
           int can=cont+this.dato;
           num = "" + can; 
       }
       if((this.dato>=100) || (this.dato<1000)){
           int can=cont+this.dato;
           num = "0" + can; 
       }
       if((this.dato>=9) || (this.dato<100)){
           int can=cont+this.dato;
           num = "00" + can; 
       }
       if (this.dato<9){
           int can = cont+this.dato;
           num = "000" + can; 
       }
    }
//MÉTODO PARA RETORNAR EL ID: EJM CM0010
    public String serie(){
        return this.num;
    }
}