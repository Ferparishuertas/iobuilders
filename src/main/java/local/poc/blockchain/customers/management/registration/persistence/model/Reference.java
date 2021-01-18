package local.poc.blockchain.customers.management.registration.persistence.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public abstract class Reference {
	
	public static interface RefVal {
		public Long getValue();
	}
	
	@Id
	@NotNull(message="The code/id for this reference must be indicated.")
	@Column(name="id", nullable = false, unique = true)
	private Long id;
	
	@NotBlank(message="The name for this reference must be indicated.")
	@Column(name="name", nullable = true, unique = false, length = 250)
	private String name;
	
	@Column(name="description", nullable = true, unique = false, length = 2000)
	private String description;
	
	@Embedded
	private DBReg dbReg;
	
}
