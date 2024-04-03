package domain;

import domain.gestionAcademica.Alumno;
import domain.gestionAcademica.Inscripcion;
import domain.gestionAcademica.Materia;
import org.junit.Assert;
import org.junit.Test;

public class IncripcionTest {

    Materia discreta = new Materia("Matematica Discreta");
    Materia algoritmos = new Materia("Algoritmos Y Estructura de Datos");
    Materia analisisI = new Materia("Analisis Matematico I");
    Materia analisisII = new Materia("Analisis Matematico II");

    @Test
    public void alumnoSeInscribeAMateriasSinCorrelativas(){
        Alumno alumnoDePrimero = new Alumno("Chiara", "Dominguez", "225.261-1");

        Inscripcion inscripcionDeChiara = new Inscripcion(alumnoDePrimero);
        inscripcionDeChiara.agregarMaterias(discreta,analisisI,algoritmos);

        Assert.assertTrue(inscripcionDeChiara.aprobada());
    }

    @Test
    public void alumnoSeInscribeCumpliendoConCorrelativas(){
        analisisII.agregarCorrelativa(analisisI);
        Alumno alumnoDeSegundo = new Alumno("Lucas", "Janson", "205.245-4");
        alumnoDeSegundo.aprobar(analisisI);

        Inscripcion inscripcionDeLucas = new Inscripcion(alumnoDeSegundo);
        inscripcionDeLucas.agregarMaterias(discreta,analisisII);

        Assert.assertTrue(inscripcionDeLucas.aprobada());
    }

    @Test
    public void alumnoSeInscribeIncumpliendoConCorrelativas(){
        analisisII.agregarCorrelativa(analisisI);
        Alumno alumnoDePrimero = new Alumno("Juan", "Ibarra", "305.128-7");

        Inscripcion inscripcionDeJuan = new Inscripcion(alumnoDePrimero);
        inscripcionDeJuan.agregarMaterias(algoritmos,analisisII);

        Assert.assertFalse(inscripcionDeJuan.aprobada());
    }
}
