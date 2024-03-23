package tn.ommp.pfe.models;


import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static java.util.List.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "all_user")
public class User implements java.io.Serializable, UserDetails{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "user_sequence")
	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
	@Column(name = "ID", unique = false, nullable = false, precision = 22, scale = 0)
	private Long id;

	@Column(name = "matricule",nullable = true, length = 100)
	private String  matricule ;
	private String password ;
	
	@Column(name="role",nullable = true)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(fetch = FetchType.EAGER ,mappedBy = "user",  cascade = CascadeType.ALL )
	  private List<Token> tokens;
	
	
	//**************************
	//implementes UserDetails Class  
	//*****************************
	
	
	/*@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return List.of(new SimpleGrantedAuthority(role.name()));
		}
*/
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return matricule;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	public String getPassword() {
		return password ;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true ;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
