package net.rodor.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TipoPermisoDaoImpl implements TipoPermisoDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
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

	@Override
	public int create(TipoPermiso entidad) {
		int result =  (int) hibernateTemplate.save(entidad);
		return result;
	}

	@Override
	public void update(TipoPermiso entidad) {
		hibernateTemplate.update(entidad);

	}

	@Override
	public List<TipoPermiso> listadoPermisos() {
		String sql = "select per.id_t_permiso, per.nombre, per.descripcion from T_PERMISO per";
		TipoPermisoRowMapper rowmapper = new TipoPermisoRowMapper();
		Object[] args=null;
		List<TipoPermiso> result =jdbcTemplate.query(sql, args, rowmapper);
		return result;
	}
	
	
}
