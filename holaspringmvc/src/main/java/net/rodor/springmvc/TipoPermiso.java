package net.rodor.springmvc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_PERMISO")
public class TipoPermiso {

	@Id
	@Column(name = "ID_T_PERMISO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permiso_generator")
	@SequenceGenerator(name="permiso_generator", sequenceName = "SEQ_T_PERMISO", allocationSize=1)
	private int id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DESCRIPCION")
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
