package fr.app.lorcanaDex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.app.lorcanaDex.bo.User;

@Repository
public class RegistrationDao implements IRegistrationDao {

    private final PasswordEncoder passwordEncoder;
    private final JdbcTemplate jdbcTemplate;

    public RegistrationDao(PasswordEncoder passwordEncoder, JdbcTemplate jdbcTemplate) {
        this.passwordEncoder = passwordEncoder;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    @Override
    public Map<String, String> saveUser(String illumineerName, String username, String password) {

        System.out.println(illumineerName);
        System.out.println(username);
        System.out.println(password);

        Map<String, String> response = new HashMap<String, String>();

        if (!findUser(username)) {

            try {

                String bcryptPassword = passwordEncoder.encode(password);
                System.out.println(bcryptPassword);

                jdbcTemplate.update("INSERT INTO users(username,password,enabled) VALUES (?,?,1)", username,
                        bcryptPassword);
                jdbcTemplate.update("INSERT INTO userDetails(username,illumineerName) VALUES (?,?)",
                        username, illumineerName);
                jdbcTemplate.update("INSERT INTO authorities(username,authority) VALUES (?,'ROLE_USER')",
                        username);

                response.put("success", "User added to BDD");

            } catch (DataAccessException e) {
                throw new RuntimeException("Erreur avec la requête SQL" + e.getMessage() + e);
            }

        } else {
            response.put("error", "Username Already taken");
        }

        System.out.println(response);
        return response;

    }

    public boolean findUser(String username) {

        List<User> user = jdbcTemplate.query("Select * FROM users WHERE username=?",
                new BeanPropertyRowMapper<>(User.class), username);
        System.out.println(user);
        return !user.isEmpty();

    }

}
