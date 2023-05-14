package rs.ac.uns.ftn.dan.pharmacy.model.dto;

public class VaccinatePatientDTO {
    private Long patientId;
    private int doseNumBeingGiven;
    private String vaccineName;

    public VaccinatePatientDTO() {}

    public VaccinatePatientDTO(Long patientId, int doseNumBeingGiven, String vaccineName) {
        this.patientId = patientId;
        this.doseNumBeingGiven = doseNumBeingGiven;
        this.vaccineName = vaccineName;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public int getDoseNumBeingGiven() {
        return doseNumBeingGiven;
    }

    public void setDoseNumBeingGiven(int doseNumBeingGiven) {
        this.doseNumBeingGiven = doseNumBeingGiven;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }
}
