package ua.ithille.lesson35.classwork;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public List<Student> findAll() {
        try (var conn = ConnectionUtils.connect()) {

            var statement = conn.createStatement();
            var rs = statement.executeQuery("SELECT id, name, surname, email FROM student");

            var students = new ArrayList<Student>();
            while (rs.next()) {
                students.add(
                        new Student(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("surname"),
                                rs.getString("email")
                        )

                );
            }

            return students;
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEmail(long id, String email) {
        var conn = ConnectionUtils.connect();
        try {
            conn.setAutoCommit(false);

            var statement = conn.prepareStatement("UPDATE student SET email = ? WHERE id = ?");
            statement.setString(1, email);
            statement.setLong(2, id);

            statement.execute();
            conn.commit();
        }  catch (SQLException e) {
            ConnectionUtils.rollback(conn);
            throw new RuntimeException(e);
        } finally {
            ConnectionUtils.close(conn);
        }
    }


}
