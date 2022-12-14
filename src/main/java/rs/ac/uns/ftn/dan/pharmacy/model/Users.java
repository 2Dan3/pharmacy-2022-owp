package rs.ac.uns.ftn.dan.pharmacy.model;

import rs.ac.uns.ftn.dan.pharmacy.model.enums.Role;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Users {

    private Map<Long, User> users = new HashMap<>();
    private long nextId = 1L;
    private static final String USERS_FILE_NAME = "users.txt";

    public Users() {

        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(USERS_FILE_NAME).toURI());
            System.out.println(path.toFile().getAbsolutePath());
            List<String> lines = Files.readAllLines(path, Charset.forName("UTF-8"));

            for (String line : lines) {
                line = line.trim();
                if (line.equals("") || line.indexOf('#') == 0)
                    continue;

                String[] tokens = line.split(";");
                Long id = Long.parseLong(tokens[0]);
                String username = (tokens[1]);
                String password = (tokens[2]);
                String email = (tokens[3]);
                String name = (tokens[4]);
                String surname = (tokens[5]);
                System.out.println(tokens[6]);
                Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(tokens[6]);
//                Date dateOfBirth = DateFormat.getDateInstance().parse(tokens[6]);
                String address = (tokens[7]);
                String phoneNum = (tokens[8]);
                Date registrationTimestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(tokens[9]);
//                Date dateOfBirth = DateFormat.getDateInstance().parse(tokens[9]);

                Role role = Role.valueOf(tokens[10]);

                if (nextId < id)
                    nextId = id;

                User newUser = new User(id, username, password, email, name, surname, dateOfBirth, address, phoneNum, registrationTimestamp, role);
                users.put(id, newUser);
                System.out.println("\n\n" + newUser.toString() + "\n\n");
//                TEST DATA:
//            manufacturers.put(123L, new Manufacturer(123L, "naziv", "SRB"));
//            manufacturers.put(124L, new Manufacturer(124L, "Neki naziv", "USA"));
//            manufacturers.put(125L, new Manufacturer(125L, "Naziv Novi", "GER"));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("\n-----------\nError! Couldn't load Users!\n------------\n");
        }
    }

    public User findOne(Long id) {
        return users.get(id);
    }

    public List<User> findAll() {
        return new ArrayList<User>(users.values());
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++nextId);
        }
        users.put(user.getId(), user);
        System.out.println("From memory saver: " + users.values());
        try {
            saveToFile(user);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            System.out.println("Error! Couldn't write Users!");
        }
        System.out.println("Users saved successfully!");
        return user;
    }

    private void saveToFile(User user) throws IOException, URISyntaxException {
        Path path = Paths.get(getClass().getClassLoader().getResource(USERS_FILE_NAME).toURI());
        System.out.println(path.toFile().getAbsolutePath());
//        PrintWriter writer = new PrintWriter(new FileWriter(path));
        BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(path), true));
        String row;
        for (User u : users.values() ) {
            System.out.println("From file saver: " + u.toString());

            row = u.getId()+";"+u.getUsername()+";"+u.getPassword()+";"+u.getEmail()+";"+u.getName()+";"+u.getSurname()+";"+new SimpleDateFormat("yyyy-MM-dd").format(u.getDateOfBirth())+";"+u.getAddress()+";"+u.getPhoneNum()+";"+new SimpleDateFormat("yyyy-MM-dd HH:mm").format(u.getRegistrationTimestamp())+";"+u.getRole().toString()+";\n";
//            Files.write(path, row.getBytes());
            writer.append(row);
//            writer.write(row);
        }
        writer.close();
    }

//    public List<User> save(List<User> users) {
//        List<User> ret = new ArrayList<>();
//
//        for (User u : users) {
//            User saved = save(u);
//
//            if (saved != null) {
//                ret.add(saved);
//            }
//        }
//        return ret;
//    }

    public User delete(Long id) {
        if (!users.containsKey(id)) {
            throw new IllegalArgumentException("tried to remove a non existing User");
        }
        User user = users.get(id);
        if (user != null) {
            users.remove(id);
        }
        return user;
    }

    public void delete(List<Long> ids) {
        for (Long id : ids) {
            delete(id);
        }
    }

    public List<User> findByName(String name) {
        List<User> ret = new ArrayList<>();

        for (User u : users.values()) {
            if (name.startsWith(u.getName())) {
                ret.add(u);
            }
        }

        return ret;
    }
}
