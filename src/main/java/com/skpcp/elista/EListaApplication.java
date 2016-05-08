package com.skpcp.elista;


import com.skpcp.elista.grupa.ob.GrupaOB;
import com.skpcp.elista.grupa.repository.IGrupaRepository;
import com.skpcp.elista.rola.ob.RolaOB;
import com.skpcp.elista.rola.respository.IRolaRepository;
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
import java.util.List;


@SpringBootApplication
public class EListaApplication {


	public static void main(String[] args) {

		SpringApplication.run(EListaApplication.class, args);



}

	@Bean
	public CommandLineRunner demoUzytkownik(IUzytkownikRepository uzytkownikRepository, IRolaRepository rolaRepository, IUprawnienieRepository uprawnienieRepository, IGrupaRepository grupaRepository)  {
		List<UprawnienieOB> listaUprawnien = new ArrayList<>();
		UprawnienieOB uprawnienieAdmina =new UprawnienieOB("ADMIN");
		UprawnienieOB uprawnienieLidera = new UprawnienieOB("LIDER");
		UprawnienieOB uprawnieniePracownika = new UprawnienieOB("PRACOWNIK");
		listaUprawnien.add(uprawnienieAdmina);
		listaUprawnien.add(uprawnienieLidera);
		listaUprawnien.add(uprawnieniePracownika);
		if(uprawnienieRepository.count()==0) uprawnienieRepository.save(listaUprawnien);
		else return null;
		RolaOB rolaOB = new RolaOB();
		List<UprawnienieOB> listaUprawnienDlaRoli = new ArrayList<>();
		listaUprawnienDlaRoli.add(uprawnienieAdmina);
		listaUprawnienDlaRoli.add(uprawnienieLidera);
		listaUprawnienDlaRoli.add(uprawnieniePracownika);
		rolaOB.setNazwa("Szef");
		rolaOB.setUprawnienia(listaUprawnienDlaRoli);

		List<UprawnienieOB> listaUprawnienDlaLidera = new ArrayList<>();
		listaUprawnienDlaLidera.add(uprawnienieLidera);
		listaUprawnienDlaLidera.add(uprawnieniePracownika);
		RolaOB rolaDlaLidera = new RolaOB("Kierownik działu Programistów",listaUprawnienDlaLidera);


		RolaOB pgrupaOB = new RolaOB();
		pgrupaOB.setNazwa("Pracownik");
		List<UprawnienieOB> listaPracownicza = new ArrayList<>();
		listaPracownicza.add(uprawnieniePracownika);
		pgrupaOB.setUprawnienia(listaPracownicza);

		List<RolaOB> listaRol = new ArrayList<>();
		listaRol.add(rolaOB);
		listaRol.add(pgrupaOB);
		listaRol.add(rolaDlaLidera);
		if(rolaRepository.count()==0) rolaRepository.save(listaRol);
		else return null;
		UzytkownikOB uzytkownikOB = new UzytkownikOB();
		uzytkownikOB.setAktywnosc(EStan.AKTYWNY);
		uzytkownikOB.setRola(rolaOB);
		uzytkownikOB.setImie("Polak");
		uzytkownikOB.setNazwisko("Mały");
		uzytkownikOB.setEmail("admin");
		uzytkownikOB.setHaslo("123");
		uzytkownikOB.setTelefon("444-444-444");
		if(uzytkownikRepository.count()==0) uzytkownikRepository.save(uzytkownikOB);
		GrupaOB grupaPracownicza = new GrupaOB();
		grupaPracownicza.setNazwa("Pracownicy Firmy");
		grupaPracownicza.setLider(uzytkownikOB);
		if(grupaRepository.count()==0) grupaRepository.save(grupaPracownicza);
		return null;
	}

}
