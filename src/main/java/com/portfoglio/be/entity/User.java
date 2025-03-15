package com.portfoglio.be.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "USERS") // Nome tabella in maiuscolo e plurale
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment per PostgreSQL
	@Column(name = "ID")
	private Long id;

	@Column(name = "FIRST_NAME", nullable = false, length = 100)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false, length = 100)
	private String lastName;

	@Column(name = "USERNAME", unique = true, nullable = false, length = 50)
	private String username;

	@Column(name = "EMAIL", unique = true, nullable = false, length = 150)
	private String email;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "BIRTH_DATE", nullable = false)
	private LocalDate birthDate;

	@Column(name = "CREATED_AT", updatable = false)
	private LocalDate createdAt;

	@Column(name = "UPDATED_AT")
	private LocalDate updatedAt;

	// Costruttore vuoto richiesto da JPA
	public User() {
	}

	// Costruttore con parametri
	public User(String firstName, String lastName, String username, String email, String password,
			LocalDate birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.setPassword(password); // Usa il setter per criptare la password
		this.birthDate = birthDate;
		this.createdAt = LocalDate.now();
	}

	// Getter e Setter
	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	// Crittografia della password prima di salvarla
	public void setPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.password = encoder.encode(password);
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}
}
