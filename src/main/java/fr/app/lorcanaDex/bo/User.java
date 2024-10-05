package fr.app.lorcanaDex.bo;

public class User {

    private Long id_account;
    private String login;
    private String password;

    public User(Long id_account, String login, String password) {
        this.id_account = id_account;
        this.login = login;
        this.password = password;
    }

    public Long getIdAccount() {
        return id_account;
    }

    public void setIdAccount(Long idAccount) {
        this.id_account = idAccount;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
