package logic;

import fileinteraction.CsvTools;
import fileinteraction.FileInteractor;
import henchmen.PropertiesGetter;
import source.LabWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Editor {

    HashMap<String, LabWork> collection;

    public Editor() {
        readCollectionFromFile("collection.json");
    }
    public Editor(String filename) {
        readCollectionFromFile(filename);
    }

    private void readCollectionFromFile(String filename) {
        try {
            //FileInteractor fileInteractor = new FileInteractor();
            File file = Paths.get(filename).toFile();
            file.setReadable(true);
            //collection = fileInteractor.readData();

       /* } catch (FileNotFoundException e) {
            System.out.println("Invalid filename.");
            System.exit(0);*/
       /* } catch (MismatchedInputException e) {
            System.out.println("Invalid json.");
            System.exit(0);*/
        } catch (Exception ex) {
            //System.out.println("...");
            //System.out.println(PropertiesGetter.getInputFileName());
            readCollectionFromConfig();
        }
    }

    private void readCollectionFromConfig() {
//        PropertiesGetter propertiesGetter = new PropertiesGetter();
//        readCollectionFromFile(propertiesGetter.getInputFileName());
        //FabricLabWorks fabricLabWorks = new FabricLabWorks();
        //collection = fabricLabWorks.getTestingMaterial();
    }

    public HashMap<String, LabWork> getCollection() {
        return collection;
    }

    public void setCollection(HashMap<String, LabWork> collection) {
        this.collection = collection;
    }

    public String getStringCollection() {
        return collection.toString();
    }

    public void removeElementByKey(String key) {
        collection.remove(key);
    }

    public void clear() {
        collection.clear();
    }

    public void removeAllLowerByLabwork(LabWork labWork) {
//        LinkedList<String> toDeleteKeys = new LinkedList<>();
//        for (String key: collection.keySet()) {
//            if (collection.get(key).compareTo(labWork) < 0) toDeleteKeys.add(key);
//        }
//        for (String key3: toDeleteKeys) collection.remove(key3);
        //collection.keySet().stream().filter(key->collection.get(key).compareTo(labWork) < 0).forEach(key->collection.remove(key));
        collection.keySet().stream().filter(key->collection.get(key).compareTo(labWork) < 0).collect(Collectors.toList()).forEach(key->collection.remove(key));
    }

    public String getAverageMinimalPoint() {
        long result = 0;
        if (collection.size() == 0) return String.valueOf(result);
        result = collection.values().stream().mapToLong(LabWork::getMinimalPoint).sum();
        return String.valueOf(result / collection.size());
    }

    public String getDescendingDifficulty() {
        //collection.values().stream().collect(Collectors.toList());
        //LinkedList<Difficulty> difficulties = new LinkedList<>();
        //collection.values().forEach(s -> difficulties.add(s.getDifficulty()));
        //difficulties.sort(new DifficultyComparator());
        StringBuilder result = new StringBuilder();
        //collection.values().stream().map(LabWork::getDifficulty).sorted(new DifficultyComparator()).forEach(s->result.append(s.toString()).append(" "));
        //difficulties.forEach(difficulty -> result.append(difficulty.toString()).append(" "));
        return result.toString();
    }
/*
    public String removeByDiscipline(Discipline discipline) {
        Stream<String> stream = collection.keySet().stream().filter(
                s -> collection.get(s).getDiscipline().equals(discipline));
        Optional<String> optional = stream.findFirst();
        if (optional.isPresent()) {
            collection.remove(optional.get());
            return "Successfully removed element.";
        };
        return "No matches.";
    }
*/
    public void update(int id, LabWork labWork) {
//        boolean notFound = true;
//        for (String key: collection.keySet()) {
//            LabWork labWork1 = collection.get(key);
//            if (labWork1.getId() == id) {
//                labWork1.copyFromLabwork(labWork);
//                notFound = false;
//            }
//        }
//        if (notFound) throw new NoSuchElementException();
       Optional<String> optional = collection.keySet().stream().filter(s->collection.get(s).getId() == id).findFirst();
       if (!optional.isPresent()) throw new NoSuchElementException();
       collection.replace(optional.get(), labWork);

    }

    public void insert(String key, LabWork labwork) {
        collection.put(key, labwork);
    }
/*
    public void save(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        File file = Paths.get(filename).toFile();
        file.setWritable(true);
        writer.writeValue(new FileOutputStream(file), collection);
    }
*/
    public void removeIfLower(String key, LabWork labWork) {
        if (collection.get(key).compareTo(labWork) < 0) collection.remove(key);
    }
}
