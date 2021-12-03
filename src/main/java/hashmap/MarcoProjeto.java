package hashmap;

public class MarcoProjeto {

	private TrimestrePrevisto trimestre;
	private String status;

	public void setStatus(String string) {
		this.status = string;		
	}

	public void setTrimestrePrevisto(TrimestrePrevisto trimestre) {
		this.trimestre = trimestre;
		
	}

	public TrimestrePrevisto getTrimestrePrevisto() {
		return trimestre;
	}

}
