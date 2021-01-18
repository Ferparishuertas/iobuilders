package local.poc.blockchain.customers.management.registration.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class DBReg {

	@Column(name = "creator", nullable = false, unique = false, length = 250)
	private String creator;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, unique = false)
	private Date createdDate;
	
	@Column(name = "last_modificator", nullable = true, unique = false, length = 250)
	private String lastModificator;
	
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date", nullable = true, unique = false)
	private Date lastModifiedDate;
	
}
