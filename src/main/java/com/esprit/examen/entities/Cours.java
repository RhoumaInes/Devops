package com.esprit.examen.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cours implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	@Enumerated(EnumType.STRING)
	private TypeCours typeCours;
	private String intitule;
	@ManyToMany(mappedBy="cours")
	private Set<Session> sessions;
	
	
	public Set<Session> getSessions() {
		return sessions;
	}
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
	@Override
	public String toString() {
		return "Cours [id=" + id + ", description=" + description + ", typeCours=" + typeCours + ", intitule="
				+ intitule + "]";
	}
	public Cours(String description, TypeCours typeCours, String intitule) {
		super();
		this.description = description;
		this.typeCours = typeCours;
		this.intitule = intitule;
	}
	
	
}
