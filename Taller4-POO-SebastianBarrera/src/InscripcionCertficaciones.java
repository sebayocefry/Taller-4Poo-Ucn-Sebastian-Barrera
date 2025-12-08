import java.time.LocalDate;
import java.util.ArrayList;

public class InscripcionCertficaciones {
	public void ofertaCertificaciones(ArrayList<Certificaciones> lista) {
		System.out.println("---CERTIFICACIONES---");
		for (Certificaciones c : lista) {
			System.out.println();
			System.out.println("ID:           " + c.getId());
            System.out.println("Nombre:       " + c.getNombre());
            System.out.println("Descripcion:  " + c.getDescripcion());
            System.out.println("----REQUISITOS:----");
            System.out.println("Creditos Requeridos: " + c.getMinCreditos()); 
            System.out.println("Validez del minor:      " + c.getYearsValides() + " años");
            System.out.println();
		}
		
	}
	
	public void incribirRamo(Estudiante e, String idCert,ArrayList<Certificaciones> listacert,ArrayList<Curso> listaCurso) {
		Certificaciones certificacionesSeleccionada = null;
		for (Certificaciones c :listacert) {
			if(c.getId().equalsIgnoreCase(idCert)) {
				certificacionesSeleccionada = c;
				break;
			}
		}
		
		if(certificacionesSeleccionada==null) {
			System.out.println("Certificacion no existente");
			return;
		}
		
		//validamos que no este inscrito 
		for (Registros curso : e.getListCertificaciones()) {
			if(curso.getIdCerftificacion().equalsIgnoreCase(idCert)) {
				System.out.println("La certificacion ya esta inscrita en la linea del estudiante");
				return;
			}
		}
		
		int creditosAlumno = calcularCreditos(e, listaCurso);
		int creditosNecesarios = certificacionesSeleccionada.getMinCreditos();
		//sino nos alcanzan los creditos
		if(creditosAlumno< creditosNecesarios) {
			System.out.println("----RECHAZADO:---\nNo cumples con los requisitos academicos.");
            System.out.println("   Tus Creditos: " + creditosAlumno);
            System.out.println("   Requeridos:   " + creditosNecesarios);
            return;
		}
		// localDate.now para que se ponga la fecha del pc 
		Registros nR = new Registros(e.getRut(), certificacionesSeleccionada.getId(), LocalDate.now(), "Activa", 0);
		e.agregarCertificacion(nR);
		System.out.println("-----------------------------");
		System.out.println("INSCRIPCION EXITOSA!");
        System.out.println("Has sido matriculado en: " + certificacionesSeleccionada.getNombre());
        System.out.println("Fecha: " + LocalDate.now());
        System.out.println();
		
	}
	/**
	 * como nos dice que el alumno necesita tener una cantidad x de creditos aporbados en el total 
	 * de la carrera para poder tomar una linea de minor, entonces aqui es como un sumador que suma un credito por ramo con situacion aprobada
	 * @param e estudiante 
	 * @param listaCursos lista de los cursos,como un catalogo por decir asi
	 * @return
	 */
	private int calcularCreditos(Estudiante e, ArrayList<Curso> listaCursos) {
		int base = 0;
		for (Notas n : e.getListaNotasMaterias()) {
			 if(n.getEstado().equalsIgnoreCase("Aprobada")) {
				 for (Curso curso : listaCursos) {
					if(curso.getCodigo().equalsIgnoreCase(n.getCodigoAsignatura())) {
						base += curso.getCreditos();
						break;
					}
				}
			 }
		}
		
		return base;
	}
}
