package com.glchallenge.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @Size(max = 100)
	private String name;
	
    @NotBlank
    @Size(max = 50)
    @Email
	private String email;
    
    @NotBlank
    @Size(max = 100)
    @Pattern(
    	    regexp = "^(?=[a-zA-Z\\d]{8,12}$)(?=[^A-Z]*[A-Z][^A-Z]*$)(?=[^\\d]*\\d[^\\d]*\\d[^\\d]*$)[a-zA-Z\\d]*$",
    	    message = "La contraseña debe tener solo una mayúscula, solo dos números, y el resto letras minúsculas, con longitud entre 8 y 12 caracteres\n"
    	)
	private String password;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id")
	private Set<Phone> phones = new LinkedHashSet<>();
}
