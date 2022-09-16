package dev.ifrs;

import java.util.Arrays;
import java.util.HashSet;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;

@Path("/Jwt")
public class GreetingResource {

    @GET
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String generate(@Context SecurityContext ctx) {
        return Jwt.issuer("http://localhost:8080")
                .upn("paulo.oliveira@dominio.com")
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .claim(Claims.full_name, "Paulo Oliveira")
                .sign();
    }

}