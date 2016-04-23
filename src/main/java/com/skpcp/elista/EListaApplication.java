package com.skpcp.elista;


import com.skpcp.elista.grupa.ob.GrupaOB;
import com.skpcp.elista.grupa.respository.IGrupaRespository;
import com.skpcp.elista.uprawnienia.ob.UprawnienieOB;
import com.skpcp.elista.uprawnienia.repository.IUprawnienieRepository;
import com.skpcp.elista.uzytkownik.EStan;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;
import com.skpcp.elista.uzytkownik.repository.IUzytkownikRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class EListaApplication {


	public static void main(String[] args) {

		SpringApplication.run(EListaApplication.class, args);



}

	@Bean
	public CommandLineRunner demoUzytkownik(IUzytkownikRepository uzytkownikRepository, IGrupaRespository grupaRespository, IUprawnienieRepository uprawnienieRepository)  {
		UprawnienieOB pUprawnienie = new UprawnienieOB();
		pUprawnienie.setNazwa("Możesz wszystko");
		if(uprawnienieRepository.count()==0) uprawnienieRepository.save(pUprawnienie);
		else return null;
		GrupaOB grupaOB = new GrupaOB();
		List<UprawnienieOB> ListaUprawnien = new ArrayList<>();
		ListaUprawnien.add(pUprawnienie);
		grupaOB.setNazwa("Szef");
		grupaOB.setUprawnienia(ListaUprawnien);
		if(grupaRespository.count()==0) grupaRespository.save(grupaOB);
		else return null;
		UzytkownikOB uzytkownikOB = new UzytkownikOB();
		uzytkownikOB.setAktywnosc(EStan.AKTYWNY);
		uzytkownikOB.setGrupa(grupaOB);
		uzytkownikOB.setImie("Pan Administrator");
		uzytkownikOB.setNazwisko("Pan i Władca");
		uzytkownikOB.setEmail("admin@elista.pl");
		uzytkownikOB.setHaslo("babajagapatrzy");
		uzytkownikOB.setTelefon("444-444-444");
		if(uzytkownikRepository.count()==0) uzytkownikRepository.save(uzytkownikOB);
		return null;
	}

}
