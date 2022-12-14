package rs.ac.uns.ftn.dan.pharmacy.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manufacturers {
    private Map<Long, Manufacturer> manufacturers = new HashMap<>();
    private long nextId = 1L;
    private static final String MANUFACTURERS_FILE_NAME = "manufacturers.txt";

    public Manufacturers() {

        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(MANUFACTURERS_FILE_NAME).toURI());
            System.out.println(path.toFile().getAbsolutePath());
            List<String> lines = Files.readAllLines(path, Charset.forName("UTF-8"));

            for (String line : lines) {
                line = line.trim();
                if (line.equals("") || line.indexOf('#') == 0)
                    continue;

                String[] tokens = line.split(";");
                Long code = Long.parseLong(tokens[0]);
                String name = (tokens[1]);
                String country = (tokens[2]);

                if(nextId<code)
                    nextId=code;

                Manufacturer newManufacturer = new Manufacturer(code, name, country);
                manufacturers.put(code, newManufacturer);
                System.out.println("\n\n" + newManufacturer.toString() + "\n\n");

//                TEST DATA:
//            manufacturers.put(123L, new Manufacturer(123L, "naziv", "SRB"));
//            manufacturers.put(124L, new Manufacturer(124L, "Neki naziv", "USA"));
//            manufacturers.put(125L, new Manufacturer(125L, "Naziv Novi", "GER"));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("\n-----------\nError! Couldn't load Manufacturers!\n------------\n");
        }
    }

    public Manufacturer findOne(Long id) {
        return manufacturers.get(id);
    }

    public List<Manufacturer> findAll() {
        return new ArrayList<Manufacturer>(manufacturers.values());
    }

    public Manufacturer save(Manufacturer manufacturer) {
        if (manufacturer.getCode() == null) {
            manufacturer.setCode(++nextId);
        }
        manufacturers.put(manufacturer.getCode(), manufacturer);
        System.out.println("From memory saver: " + manufacturers.values());
        try {
            saveToFile(manufacturer);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            System.out.println("Error! Couldn't write Manufacturers!");
        }
        System.out.println("Manufacturers saved successfully!");
        return manufacturer;
    }

    public void saveToFile(Manufacturer manufacturer) throws IOException, URISyntaxException {
        Path path = Paths.get(getClass().getClassLoader().getResource(MANUFACTURERS_FILE_NAME).toURI());
        System.out.println(path.toFile().getAbsolutePath());
//        PrintWriter writer = new PrintWriter(new FileWriter(path));
        BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(path), true));
        String row;
        for (Manufacturer u : manufacturers.values() ) {
            System.out.println("From manuf. file saver: " + u.toString());

            row = u.getCode()+";"+u.getName()+";"+u.getCountry()+";\n";
//            Files.write(path, row.getBytes());
            writer.append(row);
//            writer.write(row);
        }
        writer.close();
    }

    public List<Manufacturer> save(List<Manufacturer> manufacturers) {
        List<Manufacturer> ret = new ArrayList<>();

        for (Manufacturer k : manufacturers) {
            Manufacturer saved = save(k);

            if (saved != null) {
                ret.add(saved);
            }
        }
        return ret;
    }

    public Manufacturer delete(Long id) throws IOException, URISyntaxException {
        if (!manufacturers.containsKey(id)) {
            throw new IllegalArgumentException("tried to remove a non existing Manufacturer");
        }
        Manufacturer manufacturer = manufacturers.get(id);
        if (manufacturer != null) {
            manufacturers.remove(id);
        }
        saveToFile(manufacturer);
        return manufacturer;
    }

//    public void delete(List<Long> ids) {
//        for (Long id : ids) {
//            delete(id);
//        }
//    }

    public List<Manufacturer> findByName(String name) {
        List<Manufacturer> ret = new ArrayList<>();

        for (Manufacturer k : manufacturers.values()) {
            if (name.startsWith(k.getName())) {
                ret.add(k);
            }
        }

        return ret;
    }
}
