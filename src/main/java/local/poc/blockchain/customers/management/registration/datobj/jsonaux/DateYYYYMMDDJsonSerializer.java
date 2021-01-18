package local.poc.blockchain.customers.management.registration.datobj.jsonaux;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DateYYYYMMDDJsonSerializer extends StdSerializer<Date> {

	private static final long serialVersionUID = 7500465346367479945L;
	
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	public DateYYYYMMDDJsonSerializer() {
		this(null);
	}

	public DateYYYYMMDDJsonSerializer(Class<Date> t) {
		super(t);
	}

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		if(value != null) {
			gen.writeString(formatter.format(value)); 
		} else {
			gen.writeNull();
		}
	}

}
