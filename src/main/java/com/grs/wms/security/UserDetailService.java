package com.grs.wms.security;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.grs.wms.bean.Rol;
import com.grs.wms.bean.Usuario;
import com.grs.wms.dao.RolDao;
import com.grs.wms.dao.UsuarioDao;

@Transactional
public class UserDetailService implements UserDetailsService{
	private UsuarioDao usuarioDao;
	private RolDao rolDao;
	public  UserDetailService(UsuarioDao usuarioDao) {
		this.usuarioDao=usuarioDao;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Usuario usuario=usuarioDao.findByUsername(username);
			if(usuario==null){
				//Usuario no existe
				return null;
			}
			return new User(usuario.getUsername(),usuario.getPassword(),getAuthorities(usuario));
		} catch (Exception e) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
	
	}
	public Set<GrantedAuthority> getAuthorities(Usuario usuario){
		Set<GrantedAuthority> authorities=new HashSet<GrantedAuthority>();
		GrantedAuthority grantedAuthority=new SimpleGrantedAuthority(usuario.getRol().getNombre());
		authorities.add(grantedAuthority);
		return authorities;
	}
}
