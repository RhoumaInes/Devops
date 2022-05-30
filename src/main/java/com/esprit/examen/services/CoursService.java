package com.esprit.examen.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.repositories.SessionRepository;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class CoursService implements ICoursService {

	@Autowired
	CoursRepository coursRepository;
	@Autowired
	SessionRepository sessionRepository;
	@Override
	public Long addCours(Cours cours) {
		Cours cr = coursRepository.save(cours);
		return cr.getId();
	}

	@Override
	public Long modifierCours(Cours cours) {
		coursRepository.save(cours);
		return cours.getId();
	}

	@Override
	public void supprimerCours(Long coursId) {
		coursRepository.deleteById(coursId);
		
	}

	@Override
	public List<Cours> getCours() {
		
		List<Cours> cours = coursRepository.findAll();
		return cours;
	}
	
	@Override
	public void affecterCoursASession(Long coursId, Long sessionId)
	{
		Cours cours= coursRepository.findById(coursId).get();
		log.info("Cours "+cours);
		Session s = sessionRepository.findById(sessionId).get();
		log.info("Session "+s);
		Set<Cours> coursList= s.getCours();
		log.info("List "+coursList);
		coursList.add(cours);
		s.setCours(coursList);
		sessionRepository.save(s);
        
	}

}
