public interface Isistema {
	public void cargarUsuarios(String[] partes, String rol);
	public void cargarEstudiantes(String[] partes, String rol);
	public Usuario buscarUsuarioNombre(String nombre);
	public void mostrarUsuarios();
	public void cargarCursos(String[] partes);
	public void mostrarCursos();
	public void cargarNotas(String[] partes);
	public Usuario buscarUserRut(String rut);
	public void cargarCertficaciones(String[] partes);
	public void mostrarCertficaciones();
	public void cargarRegistros(String[] partes);
	public void cargarMateriasCertificaciones(String[] partes);
	public Curso buscarCurso(String codigo);
	public Certificaciones buscarCertificaciones(String id);
	public void crearUsuarioManual();
	public void modificarCuenta(String nombre,int tipo);
	public void eliminarCuenta(String nombre,int tipo);
	public void rrestablecerContraseña(String nombre, int tipo,String pass);
	public Estudiante buscarE(String n);
	public Cordinador buscarC(String n);
	public void aplicarEstrategia(int i);
	
}
