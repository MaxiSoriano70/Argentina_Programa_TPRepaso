package Modelo;

import java.util.Iterator;

public class Inscripcion {
	private Alumno alumno;
	private Materia materia;
	
	public Inscripcion(Alumno alumno, Materia materia) {
		super();
		this.alumno = alumno;
		this.materia = materia;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	public boolean apobada() {
		Iterator<Materia> ite=this.getMateria().getCorrelativas().iterator();
		while(ite.hasNext()) {
			Materia materia=ite.next();
			if(!this.getAlumno().getAprobadas().contains(materia)) {
				return false;
			}
		}
		return true;
	}
}
