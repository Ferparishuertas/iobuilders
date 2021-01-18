package local.poc.blockchain.customers.management.registration.datobj.dto;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import local.poc.blockchain.customers.management.registration.datobj.jsonaux.DateYYYYMMDDJsonDeserializer;
import local.poc.blockchain.customers.management.registration.datobj.jsonaux.DateYYYYMMDDJsonSerializer;
import local.poc.blockchain.customers.management.registration.datobj.validator.CountryIsSuitable;
import local.poc.blockchain.customers.management.registration.datobj.validator.PersonOfficialDocumentTypeIsSuitable;
import lombok.Data;

@Data
public class PersonOfficialDocumentDTO {
	
	@NotNull(message = "The type of personal document is mandatory.")
	@PersonOfficialDocumentTypeIsSuitable(message = "The type of personal document is not valid.")
	@JsonProperty("type")
	private Long type;
	
	@NotNull(message = "The country for the personal document is mandatory.")
	@CountryIsSuitable(message = "The country for the personal document is not valid.")
	@JsonProperty("country")
	private Long country;
	
	@NotBlank(message = "The value of the official document is mandatory.")
	@Size(min = 5, max = 250, message = "The value of the official document must be between 5 and 250 characters long.")
	@JsonProperty("value")
	private String value;
	
	@NotNull(message = "The expiration date is mandatory.")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonDeserialize(using = DateYYYYMMDDJsonDeserializer.class)
	@JsonSerialize(using = DateYYYYMMDDJsonSerializer.class)
	@Future(message = "The document is outdated.")
	@JsonProperty("validUntil")
	private Date validUntil;
	
	@JsonProperty("level")
	private Integer level;
	
	@Nullable
	@Size(max = 250, message = "The description of this document must be shorter than 250 characters long.")
	@JsonProperty("description")
	private String description;
	
}
