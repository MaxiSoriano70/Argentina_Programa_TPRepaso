package Ejercicio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Modelo.Alumno;
import Modelo.Inscripcion;
import Modelo.Materia;

public class Inertmedio {
	static List<Materia> materiasCargadas=new ArrayList<Materia>();
	static List<Alumno> alumnosCargados=new ArrayList<Alumno>();
	static Materia materia;
	static Alumno alumno;
	
	public static void cargarMaterias() {
		Materia materia1=new Materia("Programación I",1);
		materiasCargadas.add(materia1);
		
		Materia materia2=new Materia("Programación II",2);
		materia2.getCorrelativas().add(materia1);
		materiasCargadas.add(materia2);
		
		Materia materia3=new Materia("Programación III",3);
		materia3.getCorrelativas().add(materia2);
		materiasCargadas.add(materia3);
	}
	public static void cargarAlumnos() {
		Alumno alumno2=new Alumno("Celeste, Severich",1615);
		alumnosCargados.add(alumno2);
		Alumno alumno1=new Alumno("Sulca, Yesica",2165);
		try {
			Iterator<Materia> ite=materiasCargadas.iterator();
			while(ite.hasNext()){
				Materia mat=(Materia) ite.next();
				if(mat.getCodigo()==1) {
					alumno1.getAprobadas().add(mat);
				}
			}
			alumnosCargados.add(alumno1);
		}catch(Exception e){
			e.printStackTrace();
		}
		Alumno alumno3=new Alumno("Karen, Dominguez",1000);
		alumnosCargados.add(alumno3);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cargarMaterias();
		cargarAlumnos();
		try {
			for(String linea:Files.readAllLines(Paths.get("src\\main\\java\\Archivo\\inscripciones.txt"))) {
				int legajo=Integer.parseInt(linea.split(";")[0]);
				int codMateria=Integer.parseInt(linea.split(";")[2]);
				Alumno alumnoSeleccionado=null;
				Materia materiaSeleccionada=null;
				
				//BUSCAMOS ALUMNO
				Iterator<Alumno> ite=alumnosCargados.iterator();
				while(ite.hasNext()) {
					Alumno alum=(Alumno) ite.next();
					if(alum.getLegajo()==legajo) {
						alumnoSeleccionado=alum;
					}
				}
				
				//BUSCAMOS MATERIA
				Iterator<Materia> m=materiasCargadas.iterator();
				while(m.hasNext()){
					Materia mat=(Materia) m.next();
					if(mat.getCodigo()==codMateria) {
						materiaSeleccionada=mat ;
					}
				}
				
				Inscripcion inc=new Inscripcion(alumnoSeleccionado,materiaSeleccionada);
				if(inc.apobada()){
					System.out.println(alumnoSeleccionado.getNombre()+" se inscribio");
				}
				else {
					System.out.println(alumnoSeleccionado.getNombre()+" no se inscribio");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error en el archivo");
		}
	}

}
