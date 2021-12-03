package hashmap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Projeto {

	private MarcoProjeto leilao;
	private String nome;

	public void setNome(String string) {
		this.nome = string;
	}
	

	public void setLeilao(MarcoProjeto marcoProjeto) {
		this.leilao = marcoProjeto;
	}

	public MarcoProjeto getLeilao() {
		return leilao;
	}
	
	public static Map<String, Projeto> ordernaPorTrimestre(Map<String, Projeto> projetos){
		Map<String, Projeto> collect = projetos.entrySet().stream()
				.collect(Collectors.toMap(k -> (String) k.getKey(), e -> (Projeto) e.getValue())).entrySet().stream()
				// .sorted(Map.Entry.comparingByKey())
				.sorted((p1, p2) -> Integer.compare(p1.getValue().getLeilao().getTrimestrePrevisto().getTrimestre(),
						p2.getValue().getLeilao().getTrimestrePrevisto().getTrimestre()))
				.sorted((p1, p2) -> Integer.compare(p1.getValue().getLeilao().getTrimestrePrevisto().getAno(),
						p2.getValue().getLeilao().getTrimestrePrevisto().getAno()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));
		return collect;
//		collect.forEach((k, v) -> System.out.println(k + ":" + v.getLeilao().getTrimestrePrevisto().getAno() + " - "
//				+ v.getLeilao().getTrimestrePrevisto().getTrimestre()));
	}

}
