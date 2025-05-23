package src.pojo;

import java.sql.Timestamp;

public class Log {

    private Timestamp timestamp;
    private long errorCode;
    private String type;
    private String message;

    public Log(Timestamp timestamp, long errorCode, String type, String message) {
        this.timestamp = timestamp;
        this.errorCode = errorCode;
        this.type = type;
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(long errorCode) {
        this.errorCode = errorCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return
                "timestamp=" + timestamp +
                ", errorCode=" + errorCode +
                ", type='" + type + '\'' +
                ", message='" + message ;
    }
}
