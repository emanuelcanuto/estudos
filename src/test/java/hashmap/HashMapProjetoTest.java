package hashmap;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class HashMapProjetoTest {

	private HashMap<String, Projeto> projetos;

	@Before
	public void setUp() throws Exception {
		TrimestrePrevisto trimestre = new TrimestrePrevisto();
		trimestre.setAno(2020);
		trimestre.setTrimestre(2);

		MarcoProjeto marcoProjeto = new MarcoProjeto();
		marcoProjeto.setStatus("a_realizar");
		marcoProjeto.setTrimestrePrevisto(trimestre);

		Projeto projeto = new Projeto();
		projeto.setNome("T0");
		projeto.setLeilao(marcoProjeto);

		// ------------------------
		TrimestrePrevisto trimestre1 = new TrimestrePrevisto();
		trimestre1.setAno(2021);
		trimestre1.setTrimestre(1);

		MarcoProjeto marcoProjeto1 = new MarcoProjeto();
		marcoProjeto1.setStatus("a_realizar");
		marcoProjeto1.setTrimestrePrevisto(trimestre1);

		Projeto projeto1 = new Projeto();
		projeto1.setNome("T1");
		projeto1.setLeilao(marcoProjeto1);

		// ------------------------
		TrimestrePrevisto trimestre2 = new TrimestrePrevisto();
		trimestre2.setAno(2021);
		trimestre2.setTrimestre(2);

		MarcoProjeto marcoProjeto2 = new MarcoProjeto();
		marcoProjeto2.setStatus("a_realizar");
		marcoProjeto2.setTrimestrePrevisto(trimestre2);

		Projeto projeto2 = new Projeto();
		projeto2.setNome("T2");
		projeto2.setLeilao(marcoProjeto2);

		// ------------------------
		TrimestrePrevisto trimestre3 = new TrimestrePrevisto();
		trimestre3.setAno(2020);
		trimestre3.setTrimestre(1);

		MarcoProjeto marcoProjeto3 = new MarcoProjeto();
		marcoProjeto3.setStatus("a_realizar");
		marcoProjeto3.setTrimestrePrevisto(trimestre3);

		Projeto projeto3 = new Projeto();
		projeto3.setNome("T3");
		projeto3.setLeilao(marcoProjeto3);

		this.projetos = new HashMap<String, Projeto>();
		this.projetos.put("T2", projeto2);
		this.projetos.put("T1", projeto1);
		this.projetos.put("T0", projeto);
		this.projetos.put("T3", projeto3);

	}

	@Test
	public void oUltimoProjetoDeveRetornarTrimesterMaisRecente() {

		Map<String, Projeto> collect = Projeto.ordernaPorTrimestre(this.projetos);

		long count = collect.size();
		Projeto projetoRecente = collect.entrySet().stream().skip(count - 1).findFirst().get().getValue();
		int ano = projetoRecente.getLeilao().getTrimestrePrevisto().getAno();
		int trimestre = projetoRecente.getLeilao().getTrimestrePrevisto().getTrimestre();

		assertEquals(2021, ano);
		assertEquals(2, trimestre);
	}

}
