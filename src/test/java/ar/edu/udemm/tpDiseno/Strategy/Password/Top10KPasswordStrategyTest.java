package ar.edu.udemm.tpDiseno.Strategy.Password;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ar.edu.udemm.tpDiseno.dto.UserPasswordDTO;

public class Top10KPasswordStrategyTest {
    private static Top10KPasswordStrategy passwordStrategy;

    @BeforeAll
    public static void setUp() throws Exception {
        passwordStrategy = new Top10KPasswordStrategy();
    }

    @Test
    public void testValidate_WithTop10KPassword_ShouldReturnFalse() {
        UserPasswordDTO userPassword = new UserPasswordDTO("123456");
        assertFalse(passwordStrategy.validate(userPassword));
    }

    @Test
    public void testValidate_WithNonTop10KPassword_ShouldReturnTrue() {
        UserPasswordDTO userPassword = new UserPasswordDTO("unique_password_123");
        assertTrue(passwordStrategy.validate(userPassword));
    }

    @Test
    public void testValidate_WithAnotherTop10KPassword_ShouldReturnFalse() {
        UserPasswordDTO userPassword = new UserPasswordDTO("password");
        assertFalse(passwordStrategy.validate(userPassword));
    }
}
