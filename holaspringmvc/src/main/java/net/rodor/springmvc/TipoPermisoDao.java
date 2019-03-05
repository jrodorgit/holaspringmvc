package net.rodor.springmvc;

public interface TipoPermisoDao {

	TipoPermiso find(int id);

	int create(TipoPermiso entidad);
	
	void update(TipoPermiso entidad);
}
