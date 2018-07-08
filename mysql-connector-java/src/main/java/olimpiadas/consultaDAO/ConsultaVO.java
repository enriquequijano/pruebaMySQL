package olimpiadas.consultaDAO;

public class ConsultaVO {

	private int idPais;
	private String nombrePais;
	private int idCiudad;
	private String nombreCiudad;
	private int valor;
	private String descripcion;
	private int numero;
	
	
	public ConsultaVO() {
	}

	public ConsultaVO(int idPais, String nombrePais, int idCiudad, String nombreCiudad,
			int valor, String descripcion, int numero) {
		this.idPais = idPais;
		this.nombrePais = nombrePais;
		this.idCiudad = idCiudad;
		this.nombreCiudad = nombreCiudad;
		this.valor = valor;
		this.descripcion = descripcion;
		this.numero = numero;
	}

	
	public int getIdPais() {
		return idPais;
	}
	
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getNombrePais() {
		return nombrePais;
	}
	
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public int getIdCiudad() {
		return idCiudad;
	}
	
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	
	public String getNombreCiudad() {
		return nombreCiudad;
	}
	
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
}