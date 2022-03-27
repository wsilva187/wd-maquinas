package br.com.tcc.wdmservicosint.security;

import org.springframework.security.core.context.SecurityContextHolder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserService {
	
	public static UserSS authenticated() {
		log.info("[UserService]-[authenticated]");
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
