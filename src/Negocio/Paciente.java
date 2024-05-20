
package Negocio;

public class Paciente {
    private int cedula;
    private String apellidoPte;
    private String nombrePte;
    private int edad;
    private String numeroTelefonicoPte;
    private String sintomas;

    public Paciente(int cedula, String apellidoPte, String nombrePte, int edad, String numeroTelefonicoPte, String sintomas) {
        this.cedula = cedula;
        this.apellidoPte = apellidoPte;
        this.nombrePte = nombrePte;
        this.edad = edad;
        this.numeroTelefonicoPte = numeroTelefonicoPte;
        this.sintomas = sintomas;
    }

    public Paciente() {
    
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getApellidoPte() {
        return apellidoPte;
    }

    public void setApellidoPte(String apellidoPte) {
        this.apellidoPte = apellidoPte;
    }

    public String getNombrePte() {
        return nombrePte;
    }

    public void setNombrePte(String nombrePte) {
        this.nombrePte = nombrePte;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNumeroTelefonicoPte() {
        return numeroTelefonicoPte;
    }

    public void setNumeroTelefonicoPte(String numeroTelefonicoPte) {
        this.numeroTelefonicoPte = numeroTelefonicoPte;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    @Override
    public String toString() {
        return "Paciente\n " + "Cedula: " + cedula + " Apellido: " + apellidoPte + " Nombre: " 
                + nombrePte + " Edad: " + edad + " Numero Telefonico:" + numeroTelefonicoPte 
                + " Diagnostico" + sintomas;
    }
}
