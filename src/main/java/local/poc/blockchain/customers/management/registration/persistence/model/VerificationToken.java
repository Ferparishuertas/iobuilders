package local.poc.blockchain.customers.management.registration.persistence.model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "verfication_token")
@Data
public class VerificationToken {
	
    public static final int EXPIRATION_TIME_IN_MINUTES = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "token", nullable = false, unique = true)
    private String token;
  
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expiryDate", nullable = false, unique = false)
    private Date expiryDate;
    
    public static Date calculateExpiryDate() {
    	return calculateExpiryDate(null);
    }
   
    public static Date calculateExpiryDate(Integer expiryTimeInMinutes) {
    	if (expiryTimeInMinutes == null) {
    		expiryTimeInMinutes = EXPIRATION_TIME_IN_MINUTES;
    	}
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }
    
}
