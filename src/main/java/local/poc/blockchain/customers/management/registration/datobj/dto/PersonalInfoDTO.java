package local.poc.blockchain.customers.management.registration.datobj.dto;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import local.poc.blockchain.customers.management.registration.datobj.jsonaux.DateYYYYMMDDJsonDeserializer;
import local.poc.blockchain.customers.management.registration.datobj.jsonaux.DateYYYYMMDDJsonSerializer;
import local.poc.blockchain.customers.management.registration.datobj.validator.CountryIsSuitable;
import local.poc.blockchain.customers.management.registration.datobj.validator.CountryListIsSuitable;
import local.poc.blockchain.customers.management.registration.datobj.validator.Over18;
import local.poc.blockchain.customers.management.registration.datobj.validator.PersonSexIsSuitable;
import local.poc.blockchain.customers.management.registration.datobj.validator.UserPersonContactChannelsConstraint;
import lombok.Data;

@Data
public class PersonalInfoDTO {

	@NotBlank(message = "Name is mandatory.")
	@Size(min = 3, max = 250, message = "The name must be grater than 2 characters long and less than 250.")
	@JsonProperty("name")
	private String name;

	@Nullable
	@Size(min = 0, max = 250, message = "The middle name/s must be shorter or equals to 250 characters.")
	@JsonProperty("middleName")
	private String middleName;
	
	@NotBlank(message = "First surname is mandatory.")
	@Size(min = 3, max = 250, message = "The first surname must be grater than 2 characters long and less than 250.")
	@JsonProperty("surname1")
	private String surname1;

	@Nullable
	@Size(min = 0, max = 250, message = "The second surname must be shorter or equals to 250 characters.")
	@JsonProperty("surname2")
	private String surname2;

	@NotNull(message = "Sex is mandatory.")
	@PersonSexIsSuitable(message = "Sex is not valid.")
	@JsonProperty("sex")
	private Long sex;
	
	@NotNull(message = "Birthdate is mandatory.")
	// @DateTimeFormat(pattern = "yyyy-MM-dd")
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Over18(message = "Under the legal age (18)")
	@JsonDeserialize(using = DateYYYYMMDDJsonDeserializer.class)
	@JsonSerialize(using = DateYYYYMMDDJsonSerializer.class)
	@JsonProperty("birthdate")
	private Date birthdate;
	
	@NotNull(message = "Default/main nationality is mandatory.")
	@CountryIsSuitable(message = "The default/main nationality is not valid.")
	@JsonProperty("mainNationality")
	private Long mainNationality;
	
	@CountryListIsSuitable(message = "The list of nationalities is not valid.")
	@JsonProperty("otherNationalities")
	private List<Long> otherNationalities;

	@UserPersonContactChannelsConstraint
	@JsonProperty("contactChannels")
	private List<ContactChannelDTO> contactChannels;
	
	@NotEmpty(message = "One official personal document is mandatory.")
	@JsonProperty("officialDocuments")
	private List<@Valid PersonOfficialDocumentDTO> personOfficialDocuments;

}
