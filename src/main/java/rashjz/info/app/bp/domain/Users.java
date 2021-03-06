package rashjz.info.app.bp.domain;
// Generated Aug 19, 2016 3:16:01 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

public class Users implements java.io.Serializable {

    private String username;
    private String password;
    private byte enabled;
    private String firstname;
    private String lastname;
    private String note;
    private Set userRoleses = new HashSet(0);

    public Users() {
    }

    public Users(String username, String password, byte enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public Users(String username, String password, byte enabled, String firstname, String lastname, String note, Set userRoleses) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.firstname = firstname;
        this.lastname = lastname;
        this.note = note;
        this.userRoleses = userRoleses;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getEnabled() {
        return this.enabled;
    }

    public void setEnabled(byte enabled) {
        this.enabled = enabled;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set getUserRoleses() {
        return this.userRoleses;
    }

    public void setUserRoleses(Set userRoleses) {
        this.userRoleses = userRoleses;
    }

    @Override
    public String toString() {
        return "Users{" + "username=" + username + ", password=" + password + ", enabled=" + enabled + ", firstname=" + firstname + ", lastname=" + lastname + ", note=" + note  + '}';
    }

}
