package net.rodor.springmvc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class TipoPermisoRowMapper implements RowMapper<TipoPermiso> {

	@Override
	public TipoPermiso mapRow(ResultSet rs, int rowNum) throws SQLException {
		TipoPermiso obj = new TipoPermiso();
		obj.setId(rs.getInt(1));
		obj.setNombre(rs.getString(2));
		obj.setDescripcion(rs.getString(3));
		return obj;
	}

}
