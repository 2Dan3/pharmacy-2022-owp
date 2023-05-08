package rs.ac.uns.ftn.dan.pharmacy.model;

import java.util.Date;

public class VaccinationSignup {
    private Long id;
    private Date timestamp;
    private User requester;
    private Vaccine chosenVaccine;
    private int doseNum;
    private boolean vaccineTaken;

    public VaccinationSignup() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public User getRequester() {
        return requester;
    }

    public void setRequester(User requester) {
        this.requester = requester;
    }

    public Vaccine getChosenVaccine() {
        return chosenVaccine;
    }

    public void setChosenVaccine(Vaccine chosenVaccine) {
        this.chosenVaccine = chosenVaccine;
    }

    public int getDoseNum() {
        return doseNum;
    }

    public void setDoseNum(int doseNum) {
        this.doseNum = doseNum;
    }

    public boolean isVaccineTaken() {
        return vaccineTaken;
    }

    public void setVaccineTaken(boolean vaccineTaken) {
        this.vaccineTaken = vaccineTaken;
    }

    public VaccinationSignup(Long id, Date timestamp, User requester, Vaccine chosenVaccine, int doseNum, boolean vaccineTaken) {
        this.id = id;
        this.timestamp = timestamp;
        this.requester = requester;
        this.chosenVaccine = chosenVaccine;
        this.doseNum = doseNum;
        this.vaccineTaken = vaccineTaken;
    }
}
