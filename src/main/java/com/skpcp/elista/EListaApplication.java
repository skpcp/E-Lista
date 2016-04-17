package com.skpcp.elista;

import com.skpcp.elista.uprawnienia.dto.UprawnienieDTO;
import com.skpcp.elista.uprawnienia.ob.UprawnienieOB;
import com.skpcp.elista.uprawnienia.repository.IUprawnienieRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class EListaApplication {

	public static void main(String[] args) {SpringApplication.run(EListaApplication.class, args);
	}
}
