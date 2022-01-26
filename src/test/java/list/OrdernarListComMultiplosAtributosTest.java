package list;

import static org.junit.Assert.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class OrdernarListComMultiplosAtributosTest {

	private List<Empresa> empresas;

	@Before
	public void setUp() throws Exception {
		Empresa empresa = new Empresa();
		empresa.setNome("HIIT");
		empresa.setDataDeCadastro(LocalDate.parse("2022-01-01"));
		
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Carros");
		empresa2.setDataDeCadastro(LocalDate.parse("2022-01-04"));
		
		Empresa empresa3 = new Empresa();
		empresa3.setNome("RunMaverick");
		empresa3.setDataDeCadastro(LocalDate.parse("2000-01-04"));
		
		
		empresas = new ArrayList<>();
		empresas.add(empresa2);
		empresas.add(empresa);
		empresas.add(empresa3);
	}

	@Test
	public void test() {
		 Comparator<Empresa> compareDataDeCadastroENome = Comparator.comparing(Empresa::getDataDeCadastro)
                 										.thenComparing(Empresa::getNome);
		 List<Empresa> empresasOrdenadas = empresas.stream()
                 .sorted(compareDataDeCadastroENome)
                 .collect(Collectors.toList());

		empresas.forEach(e -> {
			System.out.println("Empresa:"+ e.getNome() + "\n"+ "Data de Cadastro:" +e.getDataDeCadastro()+"\n");
		});
		
		empresasOrdenadas.forEach(e -> {
			System.out.println("Empresa:"+ e.getNome() + "\n"+ "Data de Cadastro:" +e.getDataDeCadastro()+"\n");
		});
		
		assertEquals("2000-01-04", empresasOrdenadas.get(0).getDataDeCadastro().toString());
		assertEquals("RunMaverick", empresasOrdenadas.get(0).getNome());
		assertEquals("2022-01-01", empresasOrdenadas.get(1).getDataDeCadastro().toString());
		assertEquals("HIIT", empresasOrdenadas.get(1).getNome());
		assertEquals("2022-01-04", empresasOrdenadas.get(2).getDataDeCadastro().toString());
		assertEquals("Carros", empresasOrdenadas.get(2).getNome());
	}

}
