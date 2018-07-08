package olimpiadas.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import olimpiadas.consultaDAO.ConsultaDAO;

public class Connect {
	public static Connection conectar() throws IOException {
		
		Connection con=null;
		
		//Objeto de propiedades donde vamos a cargar las propiedades del archivo
		Properties props = new Properties();
		//Input Stream donde leemos el recurso donde está el archivo de propiedades
		InputStream is = ConsultaDAO.class.getClassLoader().getResourceAsStream("app.properties");
		try {
			
			//Cargamos las propiedades que vienene del archivo
			 props.load(is);
			 
			  //Cerramos el recurso
			  is.close();
			  
			  con = DriverManager.getConnection(props.getProperty("url"), props);
		} catch (SQLException e) {
			System.out.println("No se pudo conectar a la base de datos");
			e.printStackTrace();
		}
		
		return con;

	}
	
	
	public static void cerrarConexion(Connection conn) {
		
		if (conn!=null){
			  try {
				  conn.close();
			  } catch (SQLException e) {
				  // TODO Auto-generated catch block
				  e.printStackTrace();
			  }
		  }
		
	}
}
