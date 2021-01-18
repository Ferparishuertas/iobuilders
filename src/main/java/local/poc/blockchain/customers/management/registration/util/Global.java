package local.poc.blockchain.customers.management.registration.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Global {
	
	public static class ContactChannelType {
		
		public static final String CHANNEL_UNKNOWN = "unkown";
		
		public static final String CHANNEL_ADDRESS = "address";
		
		public static final String CHANNEL_EMAIL = "email";
		
		public static final String CHANNEL_MESSENGER = "messenger";
		
		public static final String CHANNEL_TELEPHONE = "telephone";
		
	}
	
	public static class UserGrants {
		public static final String USER_PLAIN = "USER";
		public static final String USER_NATURAL_PERSON = "USER_NATURAL_PERSON";
		public static final String USER_CORPORATION = "USER_CORPORATION";
	}
	
	private static final ZoneId DEFAULT_ZONE_ID = ZoneId.systemDefault();
	
	public static final DateTimeFormatter DATE_TIME_FORMATTER =
		DateTimeFormatter.ISO_OFFSET_DATE_TIME
            			 .withLocale( Locale.UK )
            			 .withZone(DEFAULT_ZONE_ID);
	
	public static String getTimestampNowTxt() {
		return DATE_TIME_FORMATTER.format(Instant.now());
	}
	
	public static Date currentDate() {
		return new Date();
	}
	
	public static Date longDistantFutureDate() {
		LocalDate localDate = LocalDate.of(9999, 1, 1);
		Date date = Date.from(localDate.atStartOfDay(DEFAULT_ZONE_ID).toInstant());
		return date;
	}

}
