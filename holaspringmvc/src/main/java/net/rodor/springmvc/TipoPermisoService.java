package net.rodor.springmvc;

import java.util.List;

public interface TipoPermisoService {

	int save(TipoPermiso entidad);
	
	TipoPermiso findById(int id);
	
	List<TipoPermiso> listar();
}
