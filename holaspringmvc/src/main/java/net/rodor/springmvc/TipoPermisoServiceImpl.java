package net.rodor.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoPermisoServiceImpl implements TipoPermisoService {

	@Autowired
	private  TipoPermisoDao dao;

	public TipoPermisoDao getDao() {
		return dao;
	}

	public void setDao(TipoPermisoDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional 
	public int save(TipoPermiso entidad) {
		//Aqui toda tu logica de negocio
		
		
		return dao.create(entidad);
	}

	@Override
	public TipoPermiso findById(int id) {
		return dao.find(id);
	}

	@Override
	public List<TipoPermiso> listar() {
		return dao.listadoPermisos();
	}
	
	
	
}
