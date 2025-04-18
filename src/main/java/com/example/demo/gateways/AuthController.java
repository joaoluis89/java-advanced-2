package com.example.demo.gateways;

import com.example.demo.usecases.GetJwtToken;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final GetJwtToken getJwtToken;
    //true -> 200
    //false -> 429
    private final ValidateUuid validateUuid;

    @PostMapping("/auth")
    public String auth(Authentication authentication) {
        return getJwtToken.execute(authentication);
    }


    @GetMapping("/auth")
    public String validate(Authentication authentication) {
        return "Olá, jwt valido" + authentication.getName();
    }

    @GetMapping("/uuid")
    public ResponseEntity<?> uuid(String uuid) {
        return validateUuid.validate(UUID.fromString(uuid))
            ? ResponseEntity.ok().build()
            : ResponseEntity.status(429).build();

    }


    public interface ValidateUuid {
        boolean validate(UUID uuid);
    }
}
