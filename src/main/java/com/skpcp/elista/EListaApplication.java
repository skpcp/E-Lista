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
		List<UprawnienieOB> listaUprawnien = new ArrayList<>();
		UprawnienieOB uprawnienieAdmina =new UprawnienieOB("ADMIN");
		UprawnienieOB uprawnienieLidera = new UprawnienieOB("LIDER");
		UprawnienieOB uprawnieniePracownika = new UprawnienieOB("PRACOWNIK");
		listaUprawnien.add(uprawnienieAdmina);
		listaUprawnien.add(uprawnienieLidera);
		listaUprawnien.add(uprawnieniePracownika);
		if(uprawnienieRepository.count()==0) uprawnienieRepository.save(listaUprawnien);
		else return null;
		GrupaOB grupaOB = new GrupaOB();
		List<UprawnienieOB> listaUprawnienDlaGrupy = listaUprawnien;
		grupaOB.setNazwa("Szef");
		grupaOB.setUprawnienia(listaUprawnienDlaGrupy);

		GrupaOB pgrupaOB = new GrupaOB();
		pgrupaOB.setNazwa("Pracownik");
		List<UprawnienieOB> listaPracownicza = new ArrayList<>();
		listaPracownicza.add(uprawnieniePracownika);
		pgrupaOB.setUprawnienia(listaPracownicza);

		List<GrupaOB> listaGrup = new ArrayList<>();
		listaGrup.add(grupaOB);
		listaGrup.add(pgrupaOB);
		if(grupaRespository.count()==0) grupaRespository.save(listaGrup);
		else return null;
		UzytkownikOB uzytkownikOB = new UzytkownikOB();
		uzytkownikOB.setAktywnosc(EStan.AKTYWNY);
		uzytkownikOB.setGrupa(grupaOB);
		uzytkownikOB.setImie("Polak");
		uzytkownikOB.setNazwisko("Mały");
		uzytkownikOB.setEmail("admin");
		uzytkownikOB.setHaslo("123");
		uzytkownikOB.setTelefon("444-444-444");
		if(uzytkownikRepository.count()==0) uzytkownikRepository.save(uzytkownikOB);
		return null;
	}

}
