package net.rodor.springmvc;

public interface TipoPermisoService {

	int save(TipoPermiso entidad);
	
	TipoPermiso findById(int id);
}
