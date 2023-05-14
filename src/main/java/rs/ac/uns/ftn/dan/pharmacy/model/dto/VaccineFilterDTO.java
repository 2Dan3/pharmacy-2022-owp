package rs.ac.uns.ftn.dan.pharmacy.model.dto;

public class VaccineFilterDTO {
    private String country;
    private String makerName;
    private String vaccineName;
    private Integer amountMin;
    private Integer amountMax;

    public VaccineFilterDTO(){}

    public VaccineFilterDTO(String country, String makerName, String vaccineName, Integer amountMin, Integer amountMax) {
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

    public Integer getAmountMin() {
        return amountMin;
    }

    public Integer getAmountMax() {
        return amountMax;
    }
}
