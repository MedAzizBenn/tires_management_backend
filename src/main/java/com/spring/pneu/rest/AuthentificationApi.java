package com.spring.pneu.rest;

import com.spring.pneu.entity.AuthenticationRequest;
import com.spring.pneu.entity.AuthenticationResponse;
import com.spring.pneu.entity.User;
import com.spring.pneu.services.MyUserDetailsService;
import com.spring.pneu.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class AuthentificationApi {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;

    @RequestMapping(value="/home",method=RequestMethod.GET)
    public String hello()
    {

        return "hello world";
    }
   @RequestMapping(value="/authenticate",method= RequestMethod.POST)
    public ResponseEntity<?> createAuthenticateToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
      try {
              authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
      }
      catch (BadCredentialsException e)
      {
          throw new Exception("Incorrect Username or password ",e);

      }
        catch (AuthenticationException er)
       {
           throw new Exception("Incorrect Username or password ",er);

       }
       final UserDetails userDetails=userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//      System.out.println(JSON.parse(userDetails));

      final String jwt=jwtTokenUtil.generateToken(userDetails);
      return ResponseEntity.ok(new AuthenticationResponse(jwt
              ,userDetails.getUsername()
              ,userDetails.getAuthorities()

             ));
    }
}
