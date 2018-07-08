package olimpiadas.principal;

import java.io.IOException;

import olimpiadas.windows.WindowCRUD;

public class EjecutaCRUD {

    public static void main( String[] args ) throws IOException
    {
        
		try {
			WindowCRUD window = new WindowCRUD();

		    
			window.open();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
