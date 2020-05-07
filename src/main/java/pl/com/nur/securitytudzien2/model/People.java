package pl.com.nur.securitytudzien2.model;


public class People {
    String nick;
    String password;
    String role;
    Integer countLog;

    public People(String nick, String password, String role) {
        this.nick = nick;
        this.password = password;
        this.role = role;
        this.countLog = 0;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getCountLog() {
        return countLog;
    }

    public void setCountLog() {
        countLog++;
    }

    @Override
    public String toString() {
        return "People{" +
                "nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", countLog=" + countLog +
                '}';
    }
}
