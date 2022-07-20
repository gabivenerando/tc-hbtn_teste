package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonTest {
    Person person;

    @BeforeAll
    public void setup() {
        person = new Person();
    }

    @ParameterizedTest(name = "Username válido")
    @ValueSource(strings = { "PaulMcCartney2", "NeilArms2" })
    public void check_user_valid(String username) {
        assertTrue(person.checkUser(username));
    }

    @ParameterizedTest(name = "Username não válido")
    @ValueSource(strings = { "Paul#McCartney", "Neil@Arms" })
    public void check_user_not_valid(String username) {
        assertTrue(person.checkUser(username));
    }

    @ParameterizedTest(name = "Password não possui letras")
    @ValueSource(strings = { "123456789", "#$%1234" })
    public void does_not_have_letters(String password) {
        assertFalse(person.checkPassword(password));
    }

    @ParameterizedTest(name = "Username não válido")
    @ValueSource(strings = { "Abcabcdefgh@", "#hbtn@%tc" })
    public void does_not_have_numbers(String password) {
        assertFalse(person.checkPassword(password));
    }

    @ParameterizedTest(name = "Password não possui 8 caracteres")
    @ValueSource(strings = { "Abc@123", "12$@hbt" })
    public void does_not_have_eight_chars(String password) {
        assertFalse(person.checkPassword(password));
    }

    @ParameterizedTest(name = "Password válido")
    @ValueSource(strings = { "abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123" })
    public void check_password_valid(String password) {
        assertFalse( person.checkPassword(password));
    }


}
