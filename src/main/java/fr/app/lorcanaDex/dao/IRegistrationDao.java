package fr.app.lorcanaDex.dao;

import java.util.Map;

public interface IRegistrationDao {
    public Map<String, String> saveUser(String illumineerName, String username, String password);
}
