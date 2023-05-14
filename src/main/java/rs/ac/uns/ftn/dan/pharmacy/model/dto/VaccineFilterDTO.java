package rs.ac.uns.ftn.dan.pharmacy.model.dto;

public class VaccineFilterDTO {
    private String country;
    private String makerName;
    private String vaccineName;
    private int amountMin;
    private int amountMax;

    public VaccineFilterDTO(){}

    public VaccineFilterDTO(String country, String makerName, String vaccineName, int amountMin, int amountMax) {
        this.country = country;
        this.makerName = makerName;
        this.vaccineName = vaccineName;
        this.amountMin = amountMin;
        this.amountMax = amountMax;
    }

    public String getCountry() {
        return country;
    }

    public String getMakerName() {
        return makerName;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public int getAmountMin() {
        return amountMin;
    }

    public int getAmountMax() {
        return amountMax;
    }
}
