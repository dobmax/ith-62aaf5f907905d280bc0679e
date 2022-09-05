package ua.ithillel.lesson9.homework;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private final List<Record> records = new ArrayList<>();

    public void add(String name, String number) {
        add(new Record(name, number));
    }

    public void add(Record record) {
        records.add(record);
    }

    public Record find(String name) {
//        for (Record record : records) {
//            if (record.name().equals(name)) {
//                return record;
//            }
//        }
//        return null;
        return records.stream()
                .filter(r -> r.name().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Record> findAll(String name) {
//        List<Record> foundRecords = new ArrayList<>();
//        for (Record record : records) {
//            if (record.name().equals(name)) {
//                foundRecords.add(record);
//            }
//        }
//        return foundRecords;
        return records.stream()
                .filter(r -> r.name().equals(name))
                .toList();
    }

}
