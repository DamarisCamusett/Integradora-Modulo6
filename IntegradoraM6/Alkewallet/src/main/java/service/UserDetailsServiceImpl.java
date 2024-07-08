package service;

import jakarta.servlet.http.HttpSession;
import modelEntity.UserEntity;
import serviceInterface.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Autowired
    private HttpSession session;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.getUserByUsername(username);
        if (user != null) {
            session.setAttribute("userId", user.getId());
            return User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles()
                    .build();
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

}
