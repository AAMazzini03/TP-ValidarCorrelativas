package domain.gestionAcademica;

import java.util.Collections;
import java.util.HashSet;

public class Inscripcion {
    private Alumno alumno;
    private HashSet<Materia> materiasAInscribirse;

    public Inscripcion(Alumno alumno){
        this.alumno = alumno;
        this.materiasAInscribirse = new HashSet<>();
    }

    public void agregarMaterias(Materia ... materias){
        Collections.addAll(this.materiasAInscribirse, materias);
    }

    public boolean aprobada(){
        return this.materiasAInscribirse.stream().allMatch(m -> m.puedeInscribirse(this.alumno));
    }
}
