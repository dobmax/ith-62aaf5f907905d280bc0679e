package ua.ithillel.lesson10.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FileNavigator {

    private final Map<String, List<FileData>> files = new HashMap<>();

    public boolean add(String path, FileData data) {
        if (!Objects.equals(path, data.path())) return false;

        files.computeIfAbsent(path, key -> new ArrayList<>()).add(data);
        return true;
    }

    public List<FileData> find(String name) {
        return files.getOrDefault(name, Collections.emptyList());
    }

    public List<FileData> filterBySize(int size) {
        List<FileData> allFiles = new ArrayList<>();

        for (List<FileData> value : files.values()) {
            allFiles.addAll(value);
        }

        List<FileData> filteredFiles = new ArrayList<>();
        for (FileData file : allFiles) {
            if (file.size() <= size) {
                filteredFiles.add(file);
            }
        }

        return filteredFiles;
    }

    public void remove(String path) {
        files.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> filteredFiles = new ArrayList<>();

        for (List<FileData> value : files.values()) {
            filteredFiles.addAll(value);
        }

        filteredFiles.sort(Comparator.comparingInt(FileData::size));

        return filteredFiles;
    }

}
