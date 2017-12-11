package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class productoDAO {
	public  ResultSet cargaRegistro() throws SQLException

	{
		conectarse cc =new conectarse();
		Connection cn =cc.conexion();
		
		String sql ="select * from producto";
		
		PreparedStatement pst  =cn.prepareCall(sql);
		ResultSet rs =pst.executeQuery();
		
		
		return rs;
	}



	public void insert(productoVO objproductoVO)throws SQLException
	{
		conectarse cc =new conectarse();
		Connection cn =cc.conexion();
		
		
		String sql ="call paInsertar(?,?,?,?)";
		CallableStatement  cs= cn.prepareCall(sql);
		
		cs.setString(1,objproductoVO.getCodigo());
		cs.setString(2,objproductoVO.getNombre());
		cs.setString(3,objproductoVO.getCatego());
		cs.setString(4,objproductoVO.getProvee());
	

		cs.execute();
		
	}		

	public void actual(productoVO objproductoVO)throws SQLException
	{
		
		conectarse cc =new conectarse();
		Connection cn =cc.conexion();
		
		
		String sql ="call paActualizar(?,?,?,?)";
		CallableStatement  cs= cn.prepareCall(sql);
		
		cs.setString(1,objproductoVO.getCodigo());
		cs.setString(2,objproductoVO.getNombre());
		cs.setString(3,objproductoVO.getCatego());
		cs.setString(4,objproductoVO.getProvee());
		cs.execute();
		
	}


	public void elimina(productoVO objproductoVO)throws SQLException
	{
		
		conectarse cc =new conectarse();
		Connection cn =cc.conexion();
		
		
		String sql ="call paEliminar(?)";
		CallableStatement  cs= cn.prepareCall(sql);
		
		cs.setString(1,objproductoVO.getCodigo());
	

		cs.execute();
		
	}





}
