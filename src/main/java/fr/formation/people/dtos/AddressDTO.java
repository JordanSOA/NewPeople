package fr.formation.people.dtos;

public class AddressDTO {

    private String country;

    private String street;

    private String city;

    private String zipCode;

    private Long idFromDb;

    public AddressDTO() {
        // Default no-args constructor
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Long getIdFromDb() {
        return idFromDb;
    }

    public void setIdFromDb(Long idFromDb) {
        this.idFromDb = idFromDb;
    }

    @Override
    public String toString() {
        return "{country=" + country + ", street=" + street + ", city=" + city + ", zipCode=" + zipCode
                + "}";
    }
}
