package ar.edu.udemm.tpDiseno.Strategy.Password;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.udemm.tpDiseno.dto.UserPasswordDTO;

public class LenPasswordStrategyTest {
    private LenPasswordStrategy passwordStrategy;

    @BeforeEach
    public void setUp() {
        // Inicializar la estrategia de longitud de contraseña
        passwordStrategy = new LenPasswordStrategy();
    }

    @Test
    public void testValidate_WithShortPassword_ShouldReturnFalse() {
        UserPasswordDTO userPassword = new UserPasswordDTO("short");
        assertFalse(passwordStrategy.validate(userPassword));
    }

    @Test
    public void testValidate_WithExactlyEightCharacters_ShouldReturnTrue() {
        UserPasswordDTO userPassword = new UserPasswordDTO("eightchr");
        assertTrue(passwordStrategy.validate(userPassword));
    }

    @Test
    public void testValidate_WithLongPassword_ShouldReturnTrue() {
        UserPasswordDTO userPassword = new UserPasswordDTO("thisIsALongPassword");
        assertTrue(passwordStrategy.validate(userPassword));
    }

    @Test
    public void testValidate_WithEmptyPassword_ShouldReturnFalse() {
        UserPasswordDTO userPassword = new UserPasswordDTO("");
        assertFalse(passwordStrategy.validate(userPassword));
    }

    @Test
    public void testValidate_WithEightSpaces_ShouldReturnTrue() {
        UserPasswordDTO userPassword = new UserPasswordDTO("        "); // 8 spaces
        assertTrue(passwordStrategy.validate(userPassword));
    }
}
