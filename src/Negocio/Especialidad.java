
package Negocio;

public class Especialidad {
    private String especialidades;

    public Especialidad(String especialidades) {
        this.especialidades = especialidades;
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }

    @Override
    public String toString() {
        return "Especialidad: "+ especialidades;
    }
}
