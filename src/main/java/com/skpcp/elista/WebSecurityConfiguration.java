package com.skpcp.elista;

import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;
import com.skpcp.elista.uzytkownik.repository.IUzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Tomasz Komoszeski on 2016-04-23.
 */
@Configuration
public class WebSecurityConfiguration  extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    IUzytkownikRepository uzytkownikRepository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsService(){

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
                UzytkownikOB uzytkownikOB = uzytkownikRepository.znajdzPoEmailu(username);
                        if(uzytkownikOB!= null){
                            return new User(uzytkownikOB.getEmail(),uzytkownikOB.getHaslo(),true,true,true,true,   AuthorityUtils.createAuthorityList("SZEF"));
                        }
                        else {
                            throw new  UsernameNotFoundException("Nie znalazlo uzytkownika '"
                                    + username + "'");
                        }

            }
        };
    }
}
