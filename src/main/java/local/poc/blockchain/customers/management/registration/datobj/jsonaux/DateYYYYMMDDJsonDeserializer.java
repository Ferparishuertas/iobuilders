package local.poc.blockchain.customers.management.registration.datobj.jsonaux;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import local.poc.blockchain.customers.management.registration.exception.DateJsonDeserializerException;

public class DateYYYYMMDDJsonDeserializer extends StdDeserializer<Date> {

    private static final long serialVersionUID = 4194065694060220880L;
	
    private SimpleDateFormat formatter = 
      new SimpleDateFormat("yyyy-MM-dd");

    public DateYYYYMMDDJsonDeserializer() {
        this(null);
    }

    public DateYYYYMMDDJsonDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Date deserialize(JsonParser jsonparser, DeserializationContext context)
      throws IOException, JsonProcessingException {
    	Date result = null;
    	if(jsonparser.hasCurrentToken()) {
	        String date = jsonparser.getText();
	        if(!date.matches("\\d{4}\\-\\d{2}\\-\\d{2}")) {
	        	throw new DateJsonDeserializerException(
	                "Json date format is not compatible with YYYY-MM-DD for value: " + date);
	        }
	        try {
	            result = formatter.parse(date);
	        } catch (ParseException e) {
	            throw new DateJsonDeserializerException(
	            	"Json date cannot be parsed. Format YYYY-MM-DD was expected for value:" + date, e);
	        }
    	}
    	return result;
    }
}
