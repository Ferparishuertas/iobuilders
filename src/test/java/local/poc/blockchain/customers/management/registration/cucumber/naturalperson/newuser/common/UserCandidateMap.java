package local.poc.blockchain.customers.management.registration.cucumber.naturalperson.newuser.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
// @Scope(SCOPE_CUCUMBER_GLUE)
public class UserCandidateMap
extends HashMap<String, UserCandidate> {

	private static final long serialVersionUID = 8587796920639100683L;

	public UserCandidateMap() {
		super();
	}

	public UserCandidateMap(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	public UserCandidateMap(int initialCapacity) {
		super(initialCapacity);
	}

	public UserCandidateMap(Map<? extends String, ? extends UserCandidate> m) {
		super(m);
	}
	
}
