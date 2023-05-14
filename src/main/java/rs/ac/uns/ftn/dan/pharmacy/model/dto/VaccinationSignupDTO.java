package rs.ac.uns.ftn.dan.pharmacy.model.dto;

public class VaccinationSignupDTO {
    private String vaccineName;
    private int doseNum;

    public String getVaccineName() {
        return vaccineName;
    }

    public int getDoseNum() {
        return doseNum;
    }

    public VaccinationSignupDTO() {
    }

    public VaccinationSignupDTO(String vaccineName, int doseNum) {
        this.vaccineName = vaccineName;
        this.doseNum = doseNum;
    }
}
