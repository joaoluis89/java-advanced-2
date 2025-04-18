package com.example.demo.gateways;

import static org.mockito.Mockito.when;

import com.example.demo.usecases.GetJwtToken;
import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private GetJwtToken getJwtToken;

    @Mock
    private AuthController.ValidateUuid validateUuid;

    @Mock
    private Authentication authentication;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Should return a jwt token")
    void shouldReturnJwtToken() {
        //Arrange
        String jwtToken = "a-valid-twt-token";
        when(getJwtToken.execute(authentication)).thenReturn(jwtToken);
        //Act
        String actual = authController.auth(authentication);
        //Assert
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual).isEqualTo(jwtToken);
    }

    @Test
    void validateUuidToReturnTrue() {
        //Arrange
        String uuid = "123e4567-e89b-12d3-a456-426614174000";
        when(validateUuid.validate(Mockito.any(UUID.class))).thenReturn(true);

        //Act
        ResponseEntity<?> actual = authController.uuid(uuid);
        //Assert
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void validateUuidToReturnFalse() {
        //Arrange
        String uuid = "123e4567-e89b-12d3-a456-426614174000";
        when(validateUuid.validate(Mockito.any(UUID.class))).thenReturn(false);
        //Act
        ResponseEntity<?> actual = authController.uuid(uuid);
        //Assert
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.TOO_MANY_REQUESTS);
    }
}