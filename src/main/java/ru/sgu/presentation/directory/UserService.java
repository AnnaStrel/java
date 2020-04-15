package ru.sgu.presentation.directory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserService {

    private Map<Integer, User> users;

    private int usersCount;

    public UserService() {
        users = new HashMap<>();
        usersCount = 0;
    }

    public User getUserById(int id) {
        return users.get(id);
    }

    public List<User> getAllUsers() {
        return new LinkedList<>(users.values());
    }

    public void addUser(User user) {
        user.setId(usersCount);
        users.put(user.getId(), user);
        usersCount++;
    }

    public boolean existUser(int id) {
        return users.containsKey(id);
    }

    public void updateUser(int id, User user) throws Exception {
        if (!users.containsKey(id)) {
            throw new Exception("Абонент с указанным ID не существует");
        }
        users.put(id, user);
    }

    public void deleteUserById(int id) throws Exception {
        if (!users.containsKey(id)) {
            throw new Exception("Абонент с указанным ID не существует");
        }
        users.remove(id);
    }

}
