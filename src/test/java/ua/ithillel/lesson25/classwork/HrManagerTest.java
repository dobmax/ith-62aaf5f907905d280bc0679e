package ua.ithillel.lesson25.classwork;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Red - test failed with unknown reason. Not yet evaluated
 * Yellow - test failed with known reason. Was evaluated. Actual result is not equal to expected
 * Green - test passed and evaluated. Actual result is equal to expected
 */
class HrManagerTest {

//    @BeforeEach
//    @AfterEach
//    @BeforeAll
//    @AfterAll

    @Test
    void shouldRetrieveTwoEmployees_byTheirIds_whenTwoIdsPassedThrough() {
        var actualAssignees = new HrManager().findAssigned(1, 2);
        var expectedAssignees = List.of(
                new Employee(1L, "En1", "Es1", 10),
                new Employee(2L, "En2", "Es2", 10)
        );

        Assertions.assertAll(
                () -> Assertions.assertEquals(2, actualAssignees.size()),
                () -> Assertions.assertIterableEquals(expectedAssignees, actualAssignees)
        );
    }

    @Test
    void shouldRetrieveOnlyTwoEmployees_byTheirIds_whenThreeIdsPassedThrough() {
        var actualAssignees = new HrManager().findAssigned(1, 2, 4);
        var expectedAssignees = List.of(
                new Employee(1L, "En1", "Es1", 10),
                new Employee(2L, "En2", "Es2", 10)
        );

        Assertions.assertEquals(2, actualAssignees.size());
        Assertions.assertIterableEquals(expectedAssignees, actualAssignees);
    }

    @Test
    void shouldRetrieveNothing_whenPassedThroughIds_doNotMatchAnyEmployee() {
        var actualAssignees = new HrManager().findAssigned(4, 5, 6);
        Assertions.assertTrue(actualAssignees.isEmpty());
    }


}