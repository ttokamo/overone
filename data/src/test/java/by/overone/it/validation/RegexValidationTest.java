package by.overone.it.validation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RegexValidationTest {

    static Stream<Arguments> argsForEmailValidation() {
        return Stream.of(
                arguments(true, "worcers@gmail.com"),
                arguments(true, "   worcers@gmail.com    "),
                arguments(false, "worcers@"),
                arguments(false, "@gmail.com"),
                arguments(false, ".com"),
                arguments(false, "@"),
                arguments(false, "adawdawdawdawaweqweqwesasae"),
                arguments(false, "worcers @gmail.com"),
                arguments(false, ""),
                arguments(false, " "),
                arguments(false, null)
        );
    }

    @ParameterizedTest
    @MethodSource("argsForEmailValidation")
    void checkEmailFormat(boolean expected, String email) {
        assertEquals(expected, RegexValidation.checkEmailFormat(email));
    }

    static Stream<Arguments> argsForTelephoneValidation() {
        return Stream.of(
                arguments(true, "+375251234567"),
                arguments(true, "+375331234567"),
                arguments(true, "+375291234567"),
                arguments(true, "+375441234567"),
                arguments(true, null),
                arguments(false, "-375331111111"),
                arguments(false, "+37533123456"),
                arguments(false, "375331234567"),
                arguments(false, "+808111231"),
                arguments(false, "123"),
                arguments(false, "+123456789")
        );
    }

    @ParameterizedTest
    @MethodSource("argsForTelephoneValidation")
    void checkTelephoneFormat(boolean expected, String telephone) {
        assertEquals(expected, RegexValidation.checkTelephoneFormat(telephone));
    }

    static Stream<Arguments> argsForPasswordValidation() {
        return Stream.of(
                arguments(true, "6641782a"),
                arguments(true, "6641$902Ff"),
                arguments(false, "664178288964"),
                arguments(false, "helloworld"),
                arguments(false, "889a"),
                arguments(false, "8896325s8awewe4128938wa6s58rsae"),
                arguments(false, "66417 82a"),
                arguments(false, "    6641782a    "),
                arguments(false, ""),
                arguments(false, " "),
                arguments(false, null)
        );
    }

    @ParameterizedTest
    @MethodSource("argsForPasswordValidation")
    void checkPasswordFormat(boolean expected, String password) {
        assertEquals(expected, RegexValidation.checkPasswordFormat(password));
    }
}