package local.poc.blockchain.customers.management.registration.interceptors;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggerInterceptor implements HandlerInterceptor {
	
	private static final Logger LOGGER = LogManager.getLogger(LoggerInterceptor.class);
	
	private String quote(String str) {
		return "\"" + str + "\"";
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
		LOGGER.info("{\"user\": " + quote(name)
					+ ", \"method\": " + quote(request.getMethod())
					+ ", \"uri\": " + quote(request.getRequestURI())
					+ ", \"parameters\": " + quote(getParameters(request))
					+ ", \"handler\": " + quote(handler.toString())
					+ ", \"action\": 0"
					+ ", \"timereg\": " + new Date().getTime()
					+ "}");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
		LOGGER.info("{\"user\": " + quote(name)
					+ ", \"method\": " + quote(request.getMethod())
					+ ", \"uri\": " + quote(request.getRequestURI())
					+ ", \"parameters\": " + quote(getParameters(request))
					+ ", \"handler\": " + quote(handler.toString())
					+ ", \"action\": 1"
					+ ", \"timereg\": " + new Date().getTime()
					+ "}");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	private String getParameters(HttpServletRequest request) {
		StringBuffer posted = new StringBuffer();
		Enumeration<?> e = request.getParameterNames();
		if (e != null) {
			posted.append("?");
		}
		while (e.hasMoreElements()) {
			if (posted.length() > 1) {
				posted.append("&");
			}
			String curr = (String) e.nextElement();
			posted.append(curr + "=");
			if (curr.contains("password") || curr.contains("pass") || curr.contains("pwd")) {
				posted.append("*****");
			} else {
				posted.append(request.getParameter(curr));
			}
		}
		String ip = request.getHeader("X-FORWARDED-FOR");
		String ipAddr = (ip == null) ? getRemoteAddr(request) : ip;
		if (ipAddr != null && !ipAddr.equals("")) {
			posted.append("&_psip=" + ipAddr);
		}
		return posted.toString();
	}

	private String getRemoteAddr(HttpServletRequest request) {
		String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
		if (ipFromHeader != null && ipFromHeader.length() > 0) {
			LOGGER.debug("ip from proxy - X-FORWARDED-FOR : " + ipFromHeader);
			return ipFromHeader;
		}
		return request.getRemoteAddr();
	}

}
