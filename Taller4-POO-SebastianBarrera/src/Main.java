import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Controlador c = Controlador.getInstance();
		LeerUsuarios(c);
		LeerEstudiantes(c);
		LeerCursos(c);
		LeerNotas(c);
		LeerCertificaciones(c);
		LeerRegistros(c);
		LeerAsignaturasCert(c);
		c.mostrarUsuarios();
		c.mostrarCursos();
		c.mostrarCertficaciones();
 
	}
//lectura de arch
	public static void LeerUsuarios(Controlador c) throws FileNotFoundException {
		File arch = new File("usuarios.txt");
		Scanner lector = new Scanner(arch);
		while(lector.hasNextLine()) {
			String line = lector.nextLine();
			String[] partes = line.split(";");
			String rol = partes[2];
			c.cargarUsuarios(partes,rol);
		}
		lector.close();
	}
	
	public static void LeerEstudiantes(Controlador c) throws FileNotFoundException {
		File arch = new File("estudiantes.txt");
		Scanner lector = new Scanner(arch);
		while(lector.hasNextLine()) {
			String line = lector.nextLine();
			String[] partes = line.split(";");
			String rol = "estudiante";
			c.cargarUsuarios(partes,rol);
		}
		lector.close();
	}
	
	public static void LeerCursos(Controlador c) throws FileNotFoundException {
		File arch = new File("cursos.txt");
		Scanner lector = new Scanner(arch);
		while(lector.hasNextLine()) {
			String line = lector.nextLine();
			String[] partes = line.split(";");
			c.cargarCursos(partes);
		}
		lector.close();
	}
	public static void LeerNotas(Controlador c) throws FileNotFoundException {
		File arch = new File("notas.txt");
		Scanner lector = new Scanner(arch);
		while(lector.hasNextLine()) {
			String line = lector.nextLine();
			String[] partes = line.split(";");
			c.cargarNotas(partes);
		}
		lector.close();
	}
	
	public static void LeerCertificaciones(Controlador c) throws FileNotFoundException {
		File arch = new File("certificaciones.txt");
		Scanner lector = new Scanner(arch);
		while(lector.hasNextLine()) {
			String line = lector.nextLine();
			String[] partes = line.split(";");
			c.cargarCertficaciones(partes);
		}
		lector.close();
	}
	
	public static void LeerRegistros(Controlador c) throws FileNotFoundException {
		File arch = new File("registros.txt");
		Scanner lector = new Scanner(arch);
		while(lector.hasNextLine()) {
			String line = lector.nextLine();
			String[] partes = line.split(";");
			c.cargarRegistros(partes);
		}
		lector.close();
	}
	public static void LeerAsignaturasCert(Controlador c) throws FileNotFoundException {
		File arch = new File("asignaturas_certificaciones.txt");
		Scanner lector = new Scanner(arch);
		while(lector.hasNextLine()) {
			String line = lector.nextLine();
			String[] partes = line.split(";");
			c.cargarMateriasCertificaciones(partes);
		}
		lector.close();
	}
	
}
