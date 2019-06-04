package com.apap.TA.security;

import java.util.HashSet;
import java.util.Set;
import com.apap.TA.repository.UserRoleDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.TA.model.UserRoleModel;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserRoleDb userRoleDb;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		UserRoleModel user = userRoleDb.findByUsername(username);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();

		grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));

		return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}
}

