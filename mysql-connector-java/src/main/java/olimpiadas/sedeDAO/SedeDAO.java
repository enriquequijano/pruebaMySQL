package olimpiadas.sedeDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import olimpiadas.connection.Connect;

public class SedeDAO implements ISedeDAO{

	static Connection con=null;
	
	@Override
	public boolean registrar(SedeVO sede) {
		boolean registrar = false;
		
		Statement stm= null;
		//Connection con=null;
		
		String sql="INSERT INTO SEDE_JJOO values ("+sede.getAnho()+"','"+sede.getTipoJJOO()+"','"+sede.getSede()+"')";
		
		try {			
			con= Connect.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			registrar=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase SedeDAO, metodo registrar");
			e.printStackTrace();
		} catch(IOException w){
			System.out.println("Error: Clase SedeDAO, IOException al conectar");
			w.printStackTrace();
		}
		return registrar;
	}

	@Override
	public List<SedeVO> obtener() {
		//Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM SEDE_JJOO ORDER BY ID";
		
		List<SedeVO> lSede= new ArrayList<SedeVO>();
		
		try {			
			con= Connect.conectar();
			stm=con.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				SedeVO s=new SedeVO();
				s.setAnho(rs.getInt(1));
				s.setTipoJJOO(rs.getInt(2));
				s.setSede(rs.getInt(3));
				
				lSede.add(s);
			}
			stm.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase SedeDAO, metodo obtener");
			e.printStackTrace();
		} catch(IOException w){
			System.out.println("Error: Clase SedeDAO, IOException al conectar");
			w.printStackTrace();
		}
		
		return lSede;
	}

	@Override
	public boolean actualizar(SedeVO sede) {
		//Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE SEDE_JJOO SET SEDE='"+sede.getSede()+"'" +
				" WHERE ID="+sede.getAnho() +" AND ID_TIPO_JJOO='"+sede.getTipoJJOO();
		try {
			con = Connect.conectar();
			stm=con.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase SedeDAO, metodo actualizar");
			e.printStackTrace();
		} catch(IOException w){
			System.out.println("Error: Clase SedeDAO, IOException al conectar");
			w.printStackTrace();
		}
		return actualizar;
	}

	@Override
	public boolean eliminar(SedeVO sede) {
		
		//Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM SEDE_JJOO WHERE ID="+sede.getAnho() +" AND ID_TIPO_JJOO='"+sede.getTipoJJOO();
		try {
			con = Connect.conectar();
			stm=con.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase SedeDAO, metodo eliminar");
			e.printStackTrace();
		} catch(IOException w){
			System.out.println("Error: Clase SedeDAO, IOException");
			w.printStackTrace();
		}	
		return eliminar;
	}

}
