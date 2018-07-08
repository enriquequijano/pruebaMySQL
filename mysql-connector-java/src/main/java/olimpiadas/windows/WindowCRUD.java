package olimpiadas.windows;
import java.io.IOException;
import java.util.List;

import olimpiadas.consultaDAO.ConsultaDAO;
import olimpiadas.consultaDAO.ConsultaVO;
import olimpiadas.consultaDAO.IConsultaDAO;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CLabel;


public class WindowCRUD {

	protected Shell shell;
	private Table table_1;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	/*public static void main(String[] args) {
		try {
			WindowCRUD window = new WindowCRUD();
			window.open();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Open the window.
	 * @throws IOException 
	 */
	public void open() throws IOException {
		
		Display display = Display.getDefault();
		createContents();	
		        
		shell.open();
		shell.layout();
		shell.setText("Mantemiento Sedes");
		
		while (!shell.isDisposed()) {
			
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setMinimumSize(new Point(600, 50));
		shell.setSize(650, 400);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		SashForm sashForm = new SashForm(shell, SWT.NONE);
		sashForm.setBounds(10, 119, 109, -92);
		
		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		table_1.setLinesVisible(true);
		table_1.setHeaderVisible(true);
		table_1.setBounds(10, 50, 600, 150);
		
		TableColumn tableColumn = new TableColumn(table_1, SWT.CENTER);
		tableColumn.setWidth(50);
		tableColumn.setText("Id_Pais");
		
		TableColumn tableColumn_1 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("Nombre_Pais");
		
		TableColumn tableColumn_2 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("Id_Ciudad");
		
		TableColumn tableColumn_3 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("Nombre_Ciudad");
		
		TableColumn tableColumn_4 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_4.setWidth(50);
		tableColumn_4.setText("Valor");
		
		TableColumn tableColumn_5 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_5.setWidth(100);
		tableColumn_5.setText("Descripcion");
		
		TableColumn tableColumn_6 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_6.setWidth(100);
		tableColumn_6.setText("Nº veces");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 10, 75, 25);
		btnNewButton.setText("Nueva Sede");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_1.setBounds(110, 10, 90, 25);
		btnNewButton_1.setText("Eliminar Sede");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.setBounds(225, 10, 100, 25);
		btnNewButton_2.setText("Actualizar Sede");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(100, 271, 91, 23);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(100, 234, 76, 21);
		
		Combo combo_1 = new Combo(shell, SWT.NONE);
		combo_1.setBounds(100, 300, 91, 23);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 226, 55, 15);
		lblNewLabel.setText("Año");
		
		CLabel lblNewLabel_1 = new CLabel(shell, SWT.NONE);
		lblNewLabel_1.setBounds(4, 273, 61, 21);
		lblNewLabel_1.setText("Tipo JJOO");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(10, 300, 55, 15);
		lblNewLabel_2.setText("Sede");
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(272, 295, 75, 25);
		button.setText("New Button");

	}
	
	
	// refrescar
	protected void refrescar(){
		
		IConsultaDAO consulta = new ConsultaDAO();
	    List< ConsultaVO> lSedeVO = consulta.consultarSedes();
	    for (ConsultaVO s : lSedeVO){
	    	int i = 0;
	    	 TableItem item = new TableItem(table_1, SWT.NONE, i);
	    	 System.out.println(s.getNombreCiudad());

	    	 //tem.setData("Id_Pais", String.valueOf(s.getIdPais()));
	    	 
	    	item.setText(0, String.valueOf(s.getIdPais()));
	        item.setText(1, s.getNombrePais());
	        item.setText(2, String.valueOf(s.getIdCiudad()));
	        item.setText(3, s.getNombreCiudad());
	        item.setText(4, String.valueOf(s.getValor()));
	        item.setText(5, s.getDescripcion());
	        item.setText(6, String.valueOf(s.getNumero()));
	           
	    }
	}
	
}
