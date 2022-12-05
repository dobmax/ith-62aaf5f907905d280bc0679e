package ua.ithillel.lesson28.homework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThat;

class SortingsTest {

    @ParameterizedTest
    @NullAndEmptySource
    void shouldRetrieveNothing_whenEmptyArrayPassed(int[] emptyValues) {
        assertThat(Sortings.shake(emptyValues)).isNullOrEmpty();
    }

    @Test
    void shouldSort_againstPassedArray() {
        assertThat(Sortings.shake(new int[]{2, 1, 3}))
                .containsExactly(1, 2, 3);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldDoNothing_whenEmptyArrayPassed(int[] emptyValues) {
        assertThatCode(
                () -> {
                    Sortings.shakeSilent(emptyValues);
                    assertThat(emptyValues).isNullOrEmpty();
                }
        ).doesNotThrowAnyException();
    }

    @Test
    void shouldSortSilently_againstPassedArray() {
        assertThatCode(
                () -> {
                    var values = new int[]{2, 1, 3};
                    Sortings.shakeSilent(values);
                    assertThat(values).containsExactly(1, 2, 3);
                }
        ).doesNotThrowAnyException();
    }
}