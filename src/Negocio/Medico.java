
package Negocio;

public class Medico {
    private String idmedico;
    private String apellidoMdco;
    private String nombreMdco;
    private Especialidad especialidad;
    private String numeroTelefonicoMdco;

    public Medico(String idmedico, String apellidoMdco, String nombreMdco, Especialidad especialidad, String numeroTelefonicoMdco) {
        this.idmedico = idmedico;
        this.apellidoMdco = apellidoMdco;
        this.nombreMdco = nombreMdco;
        this.especialidad = especialidad;
        this.numeroTelefonicoMdco = numeroTelefonicoMdco;
    }

    public Medico() {
    
    }

    public String getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(String idmedico) {
        this.idmedico = idmedico;
    }

    public String getApellidoMdco() {
        return apellidoMdco;
    }

    public void setApellidoMdco(String apellidoMdco) {
        this.apellidoMdco = apellidoMdco;
    }

    public String getNombreMdco() {
        return nombreMdco;
    }

    public void setNombreMdco(String nombreMdco) {
        this.nombreMdco = nombreMdco;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public String getNumeroTelefonicoMdco() {
        return numeroTelefonicoMdco;
    }

    public void setNumeroTelefonicoMdco(String numeroTelefonicoMdco) {
        this.numeroTelefonicoMdco = numeroTelefonicoMdco;
    }

    @Override
    public String toString() {
        return "Medico \n" + "ID Médico: " + idmedico + " Apellido: " + 
                apellidoMdco + " Nombre: " + nombreMdco + " Especialidad: " + especialidad +
                " Numero telefónico: " + numeroTelefonicoMdco;
    }
}
