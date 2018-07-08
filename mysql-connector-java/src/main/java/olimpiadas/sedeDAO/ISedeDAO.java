package olimpiadas.sedeDAO;

import java.util.List;

public interface ISedeDAO {
	
	public boolean registrar(SedeVO sede);
	public List<SedeVO> obtener();
	public boolean actualizar(SedeVO sede);
	public boolean eliminar(SedeVO sede);
	
}
