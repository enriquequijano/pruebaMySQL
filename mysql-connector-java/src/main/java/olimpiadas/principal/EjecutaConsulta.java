package olimpiadas.principal;

import java.io.IOException;
import java.util.List;

import olimpiadas.consultaDAO.ConsultaDAO;
import olimpiadas.consultaDAO.ConsultaVO;
import olimpiadas.consultaDAO.IConsultaDAO;
import olimpiadas.windows.WindowConsulta;

/**
 *
 */
public class EjecutaConsulta 
{
    public static void main( String[] args ) throws IOException
    {
        
		try {
			//WindowConsulta window = new WindowConsulta();
			// consulta
		    IConsultaDAO consulta = new ConsultaDAO();
		    List< ConsultaVO> lSedeVO = consulta.consultarSedes();
		    
			//window.open(lSedeVO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
