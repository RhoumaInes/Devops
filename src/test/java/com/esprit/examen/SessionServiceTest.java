/*package com.esprit.examen;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.FormateurRepository;
import com.esprit.examen.repositories.SessionRepository;
import com.esprit.examen.services.FormateurService;
import com.esprit.examen.services.SessionService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class SessionServiceTest {

	@Autowired
	SessionService service;
	//@Autowired
	//SessionRepository rep;
	@Autowired
	FormateurService fs;
	//@Autowired
	//FormateurRepository repF;
	
	@Test
	public void testAddSession() {
		Long savedSeesion = service.addSession(new Session ("The DevOps Handbook", 50L));
		Session s = service.TrouverSession(savedSeesion);
		log.info(s.getDescription());
		assertThat(savedSeesion).isGreaterThan(0);
		//slog.info("sessione ajoutee!!!"+savedSeesion);
		try {
			service.TrouverSession(savedSeesion);
			log.info("sesion ajoutee");
		} catch (Exception e) {
			log.error(savedSeesion+ "non ajoutee :D");
		}
	}
	
	@Test
	public void testSuppSession() {
		Long savedSession = service.addSession(new Session ("The DevOps", 90L));
		Session s = service.TrouverSession(savedSession);
	    service.supprimerSession(savedSession);
	    assertNull(service.TrouverSession(savedSession));
	    log.info("session with id"+savedSession+"has been deleted");
	}
	
	@Test
	public void testmodifSession() {
		Long savedSession = service.addSession(new Session ("The DevOps", 90L));
		Session s = service.TrouverSession(savedSession);
		s.setDescription("soa");
		s.setDuree(23L);
		Long updatedSession= service.modifierSession(s);
		s = service.TrouverSession(updatedSession);
		if ((s.getDescription().equals("soa")) & (s.getDuree().equals(23L)) ){
			log.info("it was modified"+updatedSession);
		}
		    log.error("it was not modified");
		}
		
		
    @Test
    public void testAffecterFormateurASession() {
    	Long savedSession = service.addSession(new Session ("The DevOps", 90L));
    	Long savedFormateur = fs.addFormateur(new Formateur("marwa", "belheni"));
    	service.affecterFormateurASession(savedFormateur, savedSession);
    	Session s=service.TrouverSession(savedSession);;
    	Formateur f = fs.TrouverFormateur(savedFormateur);
    	assertTrue(s.getFormateur().equals(f));
    	log.info("affectation efectuee avec succes du formateur "+savedFormateur+"a la session"+savedSession);
    	
    }
		
		
		
	
}*/
