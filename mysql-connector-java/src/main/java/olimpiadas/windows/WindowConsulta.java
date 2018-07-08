package olimpiadas.windows;
import java.util.List;

import olimpiadas.consultaDAO.ConsultaVO;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.graphics.Point;


public class WindowConsulta {

	protected Shell shell;
	private Table table;

	/**
	 * Open the window.
	 * @throws Exception 
	 * @wbp.parser.entryPoint
	 */
	public void open(List< ConsultaVO> lSedeVO) throws Exception {
		
		Display display = Display.getDefault();
		createContents();	
		        
		shell.open();
		shell.layout();
		shell.setText("Listado Sedes");
		
		configuraTable();

	    // tratar igual los tcx y el indice del setText ???
	    
		// añadir todos los items del list de sedesVO
	    for (ConsultaVO s : lSedeVO){
	    	int i = 0;
	    	 TableItem item = new TableItem(table, SWT.NONE, i);
	    	 System.out.println(s.getNombreCiudad());

	    	item.setText(0, String.valueOf(s.getIdPais()));
	        item.setText(1, s.getNombrePais());
	        item.setText(2, String.valueOf(s.getIdCiudad()));
	        item.setText(3, s.getNombreCiudad());
	        item.setText(4, String.valueOf(s.getValor()));
	        item.setText(5, s.getDescripcion());
	        item.setText(6, String.valueOf(s.getNumero()));
	           
	    }
		
		while (!shell.isDisposed()) {
			
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setMinimumSize(new Point(600, 50));
		shell.setSize(650, 400);
		shell.setText("SWT Application");
		shell.setLayout(null);

	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	private void configuraTable(){
		table = new Table(shell, SWT.MULTI | SWT.BORDER
		        | SWT.FULL_SELECTION);
		table.setBounds(10, 20, 600, 330);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tc1 = new TableColumn(table, SWT.CENTER);
	    tc1.setText("Id_Pais");
	    TableColumn tc2 = new TableColumn(table, SWT.CENTER);
	    tc2.setText("Nombre_Pais");
	    TableColumn tc3 = new TableColumn(table, SWT.CENTER);
	    tc3.setText("Id_Ciudad");
	    TableColumn tc4 = new TableColumn(table, SWT.CENTER);
	    tc4.setText("Nombre_Ciudad");
	    TableColumn tc5 = new TableColumn(table, SWT.CENTER);
	    tc5.setText("Valor");
	    TableColumn tc6 = new TableColumn(table, SWT.CENTER);
	    tc6.setText("Descripcion");
	    TableColumn tc7 = new TableColumn(table, SWT.CENTER);
	    tc7.setText("Nº veces");
	    tc1.setWidth(50);
	    tc2.setWidth(100);
	    tc3.setWidth(100);
	    tc4.setWidth(100);
	    tc5.setWidth(50);
	    tc6.setWidth(100);
	    tc7.setWidth(100);
	    table.setHeaderVisible(true);

	}
}
