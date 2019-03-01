package net.rodor.springmvc;

public class TipoPermiso {

	private int id;
	private String nombre;
	private String descripcion;

	@Override
	public String toString() {
		return "TipoPermiso [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
