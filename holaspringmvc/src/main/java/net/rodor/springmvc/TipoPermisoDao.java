package net.rodor.springmvc;

import java.util.List;

public interface TipoPermisoDao {

	TipoPermiso find(int id);

	int create(TipoPermiso entidad);
	
	void update(TipoPermiso entidad);
	
	List<TipoPermiso> listadoPermisos();
}
