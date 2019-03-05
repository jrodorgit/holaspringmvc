package net.rodor.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TipoPermisoDaoImpl implements TipoPermisoDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	@Override
	public TipoPermiso find(int id) {
		TipoPermiso entidad = hibernateTemplate.get(TipoPermiso.class, id);
		return entidad;
	}

	//@Transactional
	@Override
	public int create(TipoPermiso entidad) {
		int result =  (int) hibernateTemplate.save(entidad);
		return result;
	}

	//@Transactional
	@Override
	public void update(TipoPermiso entidad) {
		hibernateTemplate.update(entidad);

	}
	
	
}
