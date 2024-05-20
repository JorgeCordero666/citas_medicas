
package Negocio;

public class Horario {
    private String horario;
    private String fechacita;

    public Horario() {
        
    }

    public Horario(String horario, String fechacita) {
        this.horario = horario;
        this.fechacita = fechacita;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getFechacita() {
        return fechacita;
    }

    public void setFechacita(String fechacita) {
        this.fechacita = fechacita;
    }

    @Override
    public String toString() {
        return "Horario: " + "Horario: " + horario + " Fecha Cita: " + fechacita;
    }
    

    
    
}
