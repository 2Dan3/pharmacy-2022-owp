package rs.ac.uns.ftn.dan.pharmacy.model;

public class Vaccine {
    private Long id;
    private String name;
    private int amountAvailable;
    private Manufacturer manufacturer;

    public Vaccine() {}


    public Vaccine(Long id, int amountAvailable, Manufacturer manufacturer) {
        this.id = id;
        this.amountAvailable = amountAvailable;
        this.manufacturer = manufacturer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Long getId() {
        return id;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "id=" + id +
                ", amountAvailable=" + amountAvailable +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
