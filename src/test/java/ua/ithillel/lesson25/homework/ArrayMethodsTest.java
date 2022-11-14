package ua.ithillel.lesson25.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

class ArrayMethodsTest {

    /**
     * Given, When, Then
     */
    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("invalidValuesProvider")
    void shouldThrowRuntimeException_whenInvalidArrayPassed_asAgrument(int[] invalidValues) {
        Assertions.assertThrowsExactly(
                RuntimeException.class,
                () -> ArrayMethods.subarrayAfterFour(invalidValues)
        );
    }

    private static Stream<Arguments> invalidValuesProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{1})
        );
    }

    @ParameterizedTest
    @MethodSource("validValuesProvider")
    void shouldRetrieveSubarray_whenValidArrayPassedWithFourInside_asAgrument(int[] param, int[] expected) { // Given
        // When
        var actual = ArrayMethods.subarrayAfterFour(param);
        // Then
        Assertions.assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> validValuesProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{4}, new int[0]),
                Arguments.arguments(new int[]{1, 4, 1}, new int[] {1}),
                Arguments.arguments(new int[]{1, 4, 1, 4, 1, 2}, new int[] {1, 2})
        );
    }


}