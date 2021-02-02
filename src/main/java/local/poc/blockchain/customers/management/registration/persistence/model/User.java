package local.poc.blockchain.customers.management.registration.persistence.model;

import static local.poc.blockchain.customers.management.registration.util.Global.currentDate;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(
	name = "plain_user",
	uniqueConstraints = @UniqueConstraint(columnNames = {"login_email_address"})
)
public class User implements UserDetails {
	
	private static final long serialVersionUID = 9184734661246827741L;
	
	@AllArgsConstructor
	@Getter
	private class GrantedAuthorityAux implements GrantedAuthority {
		private static final long serialVersionUID = 1L;
		private String authority;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id", nullable = false, unique = true)
	private Long id;
	
	@NotBlank
	@Column(name="login_alias", nullable = false, unique = true, length = 50)
	private String loginAlias;
	
	@Email
	@NotBlank
	@Column(name="login_email_address", nullable = false, unique = true, length = 250)
	private String loginEmail;
	
	@Column(name="login_mobile", nullable = true, unique = false)
	private String mobile;
	
	@NotBlank
	private String password;
	
	@Column(name="description", nullable = true, unique = false, length = 500)
	private String description;
	
	@ElementCollection(targetClass = String.class, fetch=FetchType.EAGER)
	@CollectionTable(name = "plain_user_authority",
					 joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "authority")
	@OrderColumn(name = "index")
	private List<String> authorities = null;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="expiration_date", nullable = false, unique = false)
	private Date expirationDate;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="credential_expiration_date", nullable = false, unique = false)
	private Date credentialExpirationDate;
	
	@NotNull
	@Column(name="locked", nullable = false, unique = false)
	private Boolean locked;
	
	@NotNull
	@Column(name="enabled", nullable = false, unique = false)
	private Boolean enabled;
	
	@Embedded
	private DBReg dbReg;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities.stream().map(GrantedAuthorityAux::new).collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return loginAlias;
	}

	@Override
	public boolean isAccountNonExpired() {
		return expirationDate.getTime() - currentDate().getTime() > 0;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialExpirationDate.getTime() - currentDate().getTime() > 0;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
}
