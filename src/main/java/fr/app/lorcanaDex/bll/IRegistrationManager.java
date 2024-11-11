package fr.app.lorcanaDex.bll;

import java.util.Map;

public interface IRegistrationManager {

    public Map<String, String> saveUser(String illumineerName, String username, String password);

}
