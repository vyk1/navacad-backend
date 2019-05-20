package com.pbi.map;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pbi.map.dao.MarkersDAO;
import com.pbi.map.dao.SalaDAO;
import com.pbi.map.dao.ServidorDAO;
import com.pbi.map.entity.MarkersEntity;
import com.pbi.map.entity.SalaEntity;
import com.pbi.map.entity.ServidorEntity;

@SpringBootApplication
public class Sismapgeo2Application implements CommandLineRunner {

	@Autowired
	private SalaDAO saladao;

	@Autowired
	private ServidorDAO fundao;
	
	@Autowired
	private MarkersDAO markdao;

	public static void main(String[] args) {
		SpringApplication.run(Sismapgeo2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MarkersEntity m1 = new MarkersEntity(null, "-28.280818", "-53.515310", "Prédio A", "Descrição do Prédio A");
		MarkersEntity m2 = new MarkersEntity(null, "-28.280579", "-53.515269", "Prédio B", "Descrição do Prédio B");
		MarkersEntity m3 = new MarkersEntity(null, "-28.280323", "-53.515241", "Prédio C", "Descrição do Prédio C");
		MarkersEntity m4 = new MarkersEntity(null, "-28.279366", "-53.516667", "Aquele prédio lá",
				"Descrição do Prédio lá");
		MarkersEntity m5 = new MarkersEntity(null, "-28.279357", "-53.514969", "Ginásio", "Descrição do Ginásio");

		markdao.saveAll(Arrays.asList(m1, m2, m3, m4, m5));

		SalaEntity s1 = new SalaEntity(null, "Library", "55 3698 7415", "comitedasala@hotmail.com", true);

		ServidorEntity f1 = new ServidorEntity(null, "Jorge Capanema", "jorge.capa@iffar.edu.br", s1);
		ServidorEntity f2 = new ServidorEntity(null, "Bernatete EscritoErrado", "brenadetede@iffar.br", s1);

		SalaEntity s2 = new SalaEntity(null, "Coordenação", "55 3265 7701", "coord@hotmail.com", true);

//		s1.setFuncionarios(Arrays.asList(f1,f2));
		s1.getFuncionarios().addAll(Arrays.asList(f1, f2));
//		s1.getFuncionarios().add(f1);
//		s1.getFuncionarios().add(f2);
		saladao.saveAll(Arrays.asList(s1, s2));

//		não consigo inserir o id da sala no funcionario
//		quando tento utilizar o DTO, já que não consegue achar o id da sala
//		ele dá null pointer exception
//		não relaciona no banco porém o spring parece entender que estão relacionados
//		o que fazer?
		fundao.saveAll(Arrays.asList(f1, f2));
//		System.out.println(f1.toString());
//		System.out.println(s2.toString());
//		System.out.println(s1.toString());

	}

}
