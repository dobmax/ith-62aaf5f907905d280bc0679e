package ua.ithillel.lesson25.classwork;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class HrManager implements CompanyManager<Employee> {

    private final List<Employee> assignees = List.of(
            new Employee(1L, "En1", "Es1", 10),
            new Employee(2L, "En2", "Es2", 10),
            new Employee(3L, "En3", "Es3", 10)
    );

    @Override
    public List<Employee> findAllAssigned() {
        throw new Error("Not yet implemented");
    }

    @Override
    public List<Employee> findAssigned(long... ids) {
        var iterableIds = Arrays
                .stream(ids)
                .boxed()
                .toList();

        return assignees.stream()
                .filter(employee -> iterableIds.contains(employee.id()))
                .toList();
    }

    @Override
    public Optional<Employee> findAssigned(long id) {
        throw new Error("Not yet implemented");
    }
}
