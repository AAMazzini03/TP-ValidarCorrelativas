package domain.gestionAcademica;

import java.util.Collections;
import java.util.HashSet;

public class Materia {
    private String nombre;
    HashSet<Materia> materiasCorrelativas;

    public Materia(String nombre){
        this.nombre = nombre;
        this.materiasCorrelativas = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public HashSet<Materia> getMateriasCorrelativas() {
        return materiasCorrelativas;
    }

    public void agregarCorrelativa(Materia ... materias){
        Collections.addAll(this.materiasCorrelativas, materias);
    }

    public boolean puedeInscribirse(Alumno unAlumno) {
        return unAlumno.aproboLasSigCorrelativas(this.materiasCorrelativas);
    }
}
