package com.esprit.examen;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Session;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.repositories.SessionRepository;
import com.esprit.examen.services.CoursService;
import com.esprit.examen.services.SessionService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class CoursServiceTest {
	@Autowired
	CoursService coursService;
	@Autowired
	CoursRepository coursRepository;
	@Autowired
	SessionService sessionService;
	
	@Autowired
	SessionRepository sessionRepository;
	
	
	@Test
	public void testAddCours() {
		Long savedCourse = coursService.addCours(new Cours ("The DevOps Handbook", TypeCours.Informatique ,"DevOps"));
		assertThat(savedCourse).isGreaterThan(0);
		log.info("Cours added"+savedCourse);
		coursService.supprimerCours(savedCourse);
	}
	
	@Test
	public void testModifierCours() {
		Long savedCourse = coursService.addCours(new Cours ("DevOps Handbook", TypeCours.Informatique ,"DevOps"));
		Cours cr= coursRepository.findById(savedCourse).get();
		cr.setTypeCours(TypeCours.Scrum);
		cr.setDescription("Test description");
		cr.setIntitule("SCRUM");
		long updatedCours = coursService.modifierCours(cr);
		cr= coursRepository.findById(updatedCours).get();
		assertTrue(cr.getTypeCours().equals(TypeCours.Scrum));
		assertTrue(cr.getDescription().equals("Test description"));
		assertTrue(cr.getIntitule().equals("SCRUM"));
		log.debug("Cours modified"+updatedCours);
		coursService.supprimerCours(savedCourse);
	}
	
	@Test
	public void testSupprimerCours() {
		Long savedCourse = coursService.addCours(new Cours ("DevOps Handbook", TypeCours.Informatique ,"DevOps"));
		coursService.supprimerCours(savedCourse);
		try {
			coursRepository.findById(savedCourse).get();
			log.info("Cours deleted");
		} catch (Exception e) {
			log.error("Cours"+savedCourse+" not deleted");
		}		
	}
	
	@Test
	public void testGetCours() {
		try {
			coursService.getCours();
			log.info("List of cours");
		} catch (Exception e) {
			log.error("List not recupered");
		}
	}
	
	/*@Test
	public void testAffecterCoursASession() {
		Long savedCourse = coursService.addCours(new Cours ("DevOps Handbook", TypeCours.Informatique ,"DevOps"));
		Long savedSeesion = sessionService.addSession(new Session("The DevOps Handbook", 50L));
		coursService.affecterCoursASession(savedCourse, savedSeesion);
		Cours cr= coursRepository.findById(savedCourse).get();		
		Session s = sessionRepository.findById(savedSeesion).get();
		assertTrue(cr.getSessions().contains(s));
		log.info("Affectation trur");
		coursService.supprimerCours(savedCourse);
	}*/

}
