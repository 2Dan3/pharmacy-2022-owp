package rs.ac.uns.ftn.dan.pharmacy.model.entity;

import java.sql.Timestamp;

public class VirusReport {
    private Long id;
    private int sickInLast24h;
    private int testedInLast24h;
    private int sickInTotal;
    private int hospitalized;
    private int onRespirators;
    private Timestamp timestamp;

    public VirusReport(Long id, int sickInLast24h, int testedInLast24h, int sickInTotal, int hospitalized, int onRespirators, Timestamp timestamp) {
        this.id = id;
        this.sickInLast24h = sickInLast24h;
        this.testedInLast24h = testedInLast24h;
        this.sickInTotal = sickInTotal;
        this.hospitalized = hospitalized;
        this.onRespirators = onRespirators;
        this.timestamp = timestamp;
    }

    public VirusReport() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSickInLast24h() {
        return sickInLast24h;
    }

    public void setSickInLast24h(int sickInLast24h) {
        this.sickInLast24h = sickInLast24h;
    }

    public int getTestedInLast24h() {
        return testedInLast24h;
    }

    public void setTestedInLast24h(int testedInLast24h) {
        this.testedInLast24h = testedInLast24h;
    }

    public int getSickInTotal() {
        return sickInTotal;
    }

    public void setSickInTotal(int sickInTotal) {
        this.sickInTotal = sickInTotal;
    }

    public int getHospitalized() {
        return hospitalized;
    }

    public void setHospitalized(int hospitalized) {
        this.hospitalized = hospitalized;
    }

    public int getOnRespirators() {
        return onRespirators;
    }

    public void setOnRespirators(int onRespirators) {
        this.onRespirators = onRespirators;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
