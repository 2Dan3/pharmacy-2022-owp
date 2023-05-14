package rs.ac.uns.ftn.dan.pharmacy.model.entity;

public class Manufacturer {
    private Long code;
    private String name;
    private String country;

    public Manufacturer() {}

    public Manufacturer(Long code, String name, String country){
        this.code = code;
        this.name = name;
        this.country = country;
    }

    public Long getCode() { return code; }

    public void setCode(Long code) { this.code = code; }

    public String getName() {return name;}

    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
