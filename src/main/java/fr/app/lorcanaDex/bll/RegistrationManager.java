package fr.app.lorcanaDex.bll;

import java.util.Map;

import org.springframework.stereotype.Service;

import fr.app.lorcanaDex.dao.IRegistrationDao;

@Service
public class RegistrationManager implements IRegistrationManager {

    private IRegistrationDao registrationDao;

    public RegistrationManager(IRegistrationDao registrationDao) {
        this.registrationDao = registrationDao;
    }

    @Override
    public Map<String, String> saveUser(String illumineerName, String username, String password) {
        return registrationDao.saveUser(illumineerName, username, password);
    }

}
