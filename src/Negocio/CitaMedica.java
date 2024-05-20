
package Negocio;

public class CitaMedica {
    private String idcita;
    private int consultorio;
    private int cedulapaciente;
    private String idmedico;
    private Especialidad esp;
    private Horario horario;
    private String estado;

    public CitaMedica() {
        
    }

    public CitaMedica(String idcita, int consultorio, int cedulapaciente, String idmedico, Especialidad esp, Horario horario, String estado) {
        this.idcita = idcita;
        this.consultorio = consultorio;
        this.cedulapaciente = cedulapaciente;
        this.idmedico = idmedico;
        this.esp = esp;
        this.horario = horario;
        this.estado = estado;
    }

    public String getIdcita() {
        return idcita;
    }

    public void setIdcita(String idcita) {
        this.idcita = idcita;
    }

    public int getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(int consultorio) {
        this.consultorio = consultorio;
    }

    public int getCedulapaciente() {
        return cedulapaciente;
    }

    public void setCedulapaciente(int cedulapaciente) {
        this.cedulapaciente = cedulapaciente;
    }

    public String getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(String idmedico) {
        this.idmedico = idmedico;
    }

    public Especialidad getEsp() {
        return esp;
    }

    public void setEsp(Especialidad esp) {
        this.esp = esp;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
