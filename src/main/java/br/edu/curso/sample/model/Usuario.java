package br.edu.curso.sample.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity(name="usuarios")
public class Usuario {
	
	@Id
	public int id;
	
	public String nome;
	
	@Temporal(TemporalType.DATE)
	public Date nascimento;

}