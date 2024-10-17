package com.movies.imdb_API.Infra;

public class StandardError {
private String timeStamp;
private String error;
private String message;
private String path;
private String status;

    public StandardError(String timeStamp, String error, String message, String path, String status) {
        this.timeStamp = timeStamp;
        this.error = error;
        this.message = message;
        this.path = path;
        this.status = status;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
