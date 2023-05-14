package rs.ac.uns.ftn.dan.pharmacy.model.dto;

public class CreateVirusReportDTO {
    private int sick;
    private int tested;
    private int sickTotal;
    private int hospitalized;
    private int onRespirators;

    public CreateVirusReportDTO(){}

    public CreateVirusReportDTO(int sick, int tested, int sickTotal, int hospitalized, int onRespirators) {
        this.sick = sick;
        this.tested = tested;
        this.sickTotal = sickTotal;
        this.hospitalized = hospitalized;
        this.onRespirators = onRespirators;
    }

    public int getSick() {
        return sick;
    }

    public int getTested() {
        return tested;
    }

    public int getSickTotal() {
        return sickTotal;
    }

    public int getHospitalized() {
        return hospitalized;
    }

    public int getOnRespirators() {
        return onRespirators;
    }
}
