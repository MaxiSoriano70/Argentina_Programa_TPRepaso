package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
	private String nombre;
	private int legajo;
	
	private List<Materia>aprobadas;

	public Alumno(String nombre, int legajo) {
		super();
		this.nombre = nombre;
		this.legajo = legajo;
		this.aprobadas = new ArrayList<Materia>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public List<Materia> getAprobadas() {
		return aprobadas;
	}

	public void setAprobadas(List<Materia> aprobadas) {
		this.aprobadas = aprobadas;
	}
	
}
