package com.grs.wms.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.grs.wms.dao.UsuarioDao;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	@Autowired
	private UsuarioDao usuarioDao;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub

		String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        
        UserDetails usuario=new UserDetailService(usuarioDao).loadUserByUsername(username);
        if(usuario==null){
        	throw new BadCredentialsException("El usuario no fue encontrado.");
        }
        if(!password.equals(usuario.getPassword())){
        	throw new BadCredentialsException("Contraseña incorrecta.");
        }
               
        Collection<? extends GrantedAuthority> authorities=usuario.getAuthorities();
        
		return new UsernamePasswordAuthenticationToken(usuario, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
}
