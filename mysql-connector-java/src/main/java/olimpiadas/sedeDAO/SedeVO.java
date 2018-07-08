package olimpiadas.sedeDAO;

public class SedeVO {

	private int anho;
	private int tipoJJOO;
	private int sede;

	public SedeVO() {
	}
	
	public SedeVO(int anho, int tipoJJOO, int sede) {
		this.anho = anho;
		this.tipoJJOO = tipoJJOO;
		this.sede = sede;
	}
	
	public int getAnho() {
		return anho;
	}
	
	public void setAnho(int anho) {
		this.anho = anho;
	}
	
	public int getTipoJJOO() {
		return tipoJJOO;
	}
	
	public void setTipoJJOO(int tipoJJOO) {
		this.tipoJJOO = tipoJJOO;
	}
	
	public int getSede() {
		return sede;
	}
	
	public void setSede(int sede) {
		this.sede = sede;
	}
}
