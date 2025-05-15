package logfileanalyzer.pojo;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserLogEntry {

    private Timestamp localDateTime;
    private String userName;
    private String action;

    public UserLogEntry(Timestamp localDateTime, String userName, String action) {
        this.localDateTime = localDateTime;
        this.userName = userName;
        this.action = action;
    }

    public Timestamp getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(Timestamp localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }



    @Override
    public String toString() {
        return "UserLogEntry{" +
                "localDateTime=" + localDateTime +
                ", userName='" + userName + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
