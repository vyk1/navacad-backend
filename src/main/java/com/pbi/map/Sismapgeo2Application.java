package com.pbi.map;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pbi.map.dao.HorarioDAO;
import com.pbi.map.dao.MarkersDAO;
import com.pbi.map.dao.SalaDAO;
import com.pbi.map.dao.ServidorDAO;
import com.pbi.map.entity.HorarioEntity;
import com.pbi.map.entity.MarkersEntity;
import com.pbi.map.entity.SalaEntity;
import com.pbi.map.entity.ServidorEntity;
import com.pbi.sismapgeo.enums.DiaSemana;

@SpringBootApplication
public class Sismapgeo2Application implements CommandLineRunner {

	@Autowired
	private SalaDAO saladao;

	@Autowired
	private ServidorDAO fundao;

	@Autowired
	private MarkersDAO markdao;

	@Autowired
	private HorarioDAO hodao;

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

		HorarioEntity h1 = new HorarioEntity(null, "10:40", "18:30");
		h1.addDiaSemana(DiaSemana.SEGUNDA);

		HorarioEntity h2 = new HorarioEntity(null, "08:00", "12:00");
		h2.addDiaSemana(DiaSemana.SEGUNDA);

		HorarioEntity h3 = new HorarioEntity(null, "06:00", "10:00");
		h3.addDiaSemana(DiaSemana.TERÇA);

		HorarioEntity h4 = new HorarioEntity(null, "15:00", "19:00");
		h4.addDiaSemana(DiaSemana.TERÇA);
		hodao.saveAll(Arrays.asList(h1, h2, h3, h4));

		f1.getHorarios().addAll(Arrays.asList(h1, h3, h4));
		f2.getHorarios().addAll(Arrays.asList(h1, h2, h4));
		System.out.println(f1.toString());

		SalaEntity s2 = new SalaEntity(null, "Coordenação", "55 3265 7701", "coord@hotmail.com", true);
		SalaEntity s3 = new SalaEntity(null, "Assistência Estudantil", "55 3362 8255", "assistud@hotmail.com", false);

		s1.getFuncionarios().addAll(Arrays.asList(f1));
		s2.getFuncionarios().addAll(Arrays.asList(f2));
		saladao.saveAll(Arrays.asList(s1, s2, s3));

		fundao.saveAll(Arrays.asList(f1, f2));

//		System.out.println(s2.toString());
//		System.out.println(s1.toString());

	}

}
