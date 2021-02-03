package local.poc.blockchain.customers.management.registration.datobj.common;

public interface ContactChannelWithUser {
	
	public String getChannel();
	
	
	// No all the channels need this field. Only those for which, due to their nature,
	// we are forced to have distinct interfaces for establishing a connection with the
	// customer. For example, in the case of the messenger channels, the provider of the 
	// channel usually implements its own specific API distinct to the API of the other
	// providers. On the other hand, the email channel uses a unique protocol of
	// connection, and it is the same for any email address. In the case of the telephone,
	// a mobile telephone can be used to send sms texts while a land telephone is not
	// usually eligible for this propose. For an IP telephone, we need a different
	// procedure to make a call than when we use a mobile phone or a land telephone.
	// Even if the steps we must follows are quite similar, we need an specific protocol
	// and terminal in each case. Then, these are the reason why the email channel does
	// not have type while messenger and telephone channels do.
	//
	// public Long getType();
	//
	
	public String getValue();
	
	public Integer getLevel();
	
}
