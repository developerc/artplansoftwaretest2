package ru.artplansoftwaretest2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Attempts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long timeMsec;
    private long cntAttempts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTimeMsec() {
        return timeMsec;
    }

    public void setTimeMsec(long timeMsec) {
        this.timeMsec = timeMsec;
    }

    public long getCntAttempts() {
        return cntAttempts;
    }

    public void setCntAttempts(long cntAttempts) {
        this.cntAttempts = cntAttempts;
    }
}
