package isi.died.parcial01.ejercicio02.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import isi.died.parcial01.ejercicio02.db.BaseDeDatos;
import isi.died.parcial01.ejercicio02.db.BaseDeDatosExcepcion;
import isi.died.parcial01.ejercicio02.dominio.*;


public class MySysAcadImpl implements MySysAcad {
	private static final BaseDeDatos DB = new BaseDeDatos();


	private List<Materia> materia = new ArrayList<Materia>();
	
	@Override
	public void registrarMateria(Materia d) {
		this.materia.add(d);
	}
	
	private List<Docente> docentes = new ArrayList<Docente>();
	
	@Override
	public void registrarDocente(Docente d) {
		this.docentes.add(d);
	}
	
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@Override
	public void registrarAlumnos(Alumno d) {
		this.alumnos.add(d);
	}
	

	@Override
	// Federico: 
	public void inscribirAlumnoCursada(Docente d, Alumno a, Materia m, Integer cicloLectivo) throws InscripcionNoPudoRealizarseException, LimiteDeInscriptosAlcanzadoException {
		
		if (m.getInscripciones().size() + 1 <= m.getLimiteInscripciones())
		{
			Inscripcion insc = new Inscripcion(cicloLectivo,Inscripcion.Estado.CURSANDO);
			d.agregarInscripcion(insc);
			a.addCursada(insc);
			m.addInscripcion(insc);
		
			try {
				DB.guardar(insc);
			} catch (BaseDeDatosExcepcion e) {
				throw new InscripcionNoPudoRealizarseException();
			}
		}
		else
			throw new LimiteDeInscriptosAlcanzadoException();
	}
	
	// Federico: 
	static final Integer NOTA_PARA_APROBAR = 6;
	public void registrarNota(Integer notaAlumno, Examen examen) 
	{
		examen.setNota(notaAlumno);
		
		if (notaAlumno >= NOTA_PARA_APROBAR)
		{
			// Cuando la querés complicar:
			Collections.max
			(
				examen
				.getAlumno()
				.getMateriasCursadas()
				.stream()
				.filter(i -> i.getMateria().equals(examen.getMateria()))
				.collect(Collectors.toList()), 
				// Quedarse con la misma materia cuya inscripción se dio en distintos ciclos lectivos.
				(i1, i2) -> i1.getCicloLectivo().compareTo(i2.getCicloLectivo())  // Comparator.
			) // Obtener la inscripción más reciente.
			.setEstado(Inscripcion.Estado.PROMOCIONADO);
		}
	}
	
	@Override
	// Federico: 
	public OptionalDouble promedio(Docente docente, Materia materia) 
	{
		return
			 materia
			.getExamenes()
			.stream()
			.filter(e -> e.getDocente().equals(docente))
			.mapToInt(e -> e.getNota())
			.average(); // No estoy tan seguro de esto.
	}
	
	// Federico:
	public List<Examen> buscarExamenesReprobados(Alumno alumno, Materia materia)
	{
		return
			materia
			.getExamenes()
			.stream()
			.filter(e -> e.getAlumno().equals(alumno))
			.filter(e -> e.getNota() < NOTA_PARA_APROBAR)
			.sorted((e1, e2) -> e2.getFecha().compareTo(e1.getFecha()))
			.collect(Collectors.toList());	
	}

	
	@Override
	public void inscribirAlumnoExamen(Docente d, Alumno a, Materia m) {
		Examen e = new Examen();
		a.addExamen(e);
		d.agregarExamen(e);
		m.addExamen(e);
		// DESCOMENTAR Y gestionar excepcion
		// DB.guardar(e);
	}

}
