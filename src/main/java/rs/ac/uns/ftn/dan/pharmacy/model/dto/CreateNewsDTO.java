package rs.ac.uns.ftn.dan.pharmacy.model.dto;

public class CreateNewsDTO {
    private String name;
    private String content;

    public CreateNewsDTO(){}

    public CreateNewsDTO(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
