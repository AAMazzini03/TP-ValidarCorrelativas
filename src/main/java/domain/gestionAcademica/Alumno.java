package domain.gestionAcademica;

import java.util.Collections;
import java.util.HashSet;

public class Alumno {
    private String nombre;
    private String apellido;
    private String legajo;
    private HashSet<Materia> materiasAprobadas;

    public Alumno(String nombre, String apellido, String legajo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.materiasAprobadas = new HashSet<>();
    }
    public void aprobar(Materia ... materias){
        Collections.addAll(this.materiasAprobadas, materias);
    }

    public boolean aproboLasSigCorrelativas(HashSet<Materia> materiasCorrelativas) {
        return this.materiasAprobadas.containsAll(materiasCorrelativas);
    }
}
