package olimpiadas.consultaDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import olimpiadas.connection.Connect;
import olimpiadas.sedeDAO.ISedeDAO;


public class ConsultaDAO implements IConsultaDAO{
	
	
	public ConsultaDAO() {
	}
	
	public List< ConsultaVO> consultarSedes() {
		 
		List<ConsultaVO> lSedeVO= new ArrayList<ConsultaVO>();
		
		//Objeto de conexión a base de datos tipo Connection
		Connection conn = null;
		  
		//Resultset donde vamos a buscar el resultado que genera el query
		ResultSet rs = null;
		
		//Objeto que utilizaremos para lanzar un query a la base de datos
		PreparedStatement ps = null;
		  
		try {
			  
		   Connection con=null;
		   con= Connect.conectar();		  
		   
		   ps = con.prepareStatement("select p.id_pais, p.nombre_pais, c.id_ciudad, c.nombre_ciudad, " +
		     		" ifnull(c.valor_ciudad, p.VALOR_PAIS) as valor, t.DESCRIPCION_TIPO, " +
		     		" count(s.sede) as Numero_veces_sede" +
		     	" from ciudad c " +
		     	" join pais p on p.id_pais = c.id_pais" +
		     	" left join SEDE_JJOO s on c.id_ciudad = s.sede" +
		     	" left join TIPO_JJOO t on t.ID_TIPO_JJOO = s.ID_TIPO_JJOO " +
		     	//" where p.id_pais = 99" +
		     	" group by c.id_ciudad" +
		     	" order by c.id_ciudad desc");
		      
		   //Ejecutamos el query
		   rs = ps.executeQuery();
		     
		   //si hay resultados
		   if (rs.next()){
			    do {
				    lSedeVO.add(new ConsultaVO(rs.getInt("id_pais"),
				    		rs.getString("nombre_pais"),
				    		rs.getInt("ID_CIUDAD"),
				    		rs.getString("nombre_ciudad"),
				    		rs.getInt("valor"),
				    		 null != rs.getString("DESCRIPCION_TIPO") ? rs.getString("DESCRIPCION_TIPO") : "",
				    		rs.getInt("Numero_veces_sede")));

			       } while (rs.next());
			   
		   }else{
			   System.out.println("Consulta sin resultados");
		   }
		   
		  //Catch para atrapar alguna excepción de SQL
		  } catch (SQLException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  } catch (IOException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  
		  //Bloque finally para cerrar la conexión
		  }finally{
			Connect.cerrarConexion(conn);
		  }
		  
		  return lSedeVO;
	}
}
