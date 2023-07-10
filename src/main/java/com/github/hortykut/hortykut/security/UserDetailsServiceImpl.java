package com.github.hortykut.hortykut.security;

import com.github.hortykut.hortykut.model.Usuario;
import com.github.hortykut.hortykut.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		
		Optional<Usuario> usuario1 = usuarioRepository.findByUsuario(usuario);
		
		if(usuario1.isPresent())
			return new UserDetailsImpl(usuario1.get());
		else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}
}