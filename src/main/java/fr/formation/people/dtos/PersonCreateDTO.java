package fr.formation.people.dtos;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PersonCreateDTO {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    @DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull @Past
    private LocalDate birthdate;

    @Nullable
    private Long addressId;

    public PersonCreateDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Nullable
    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "PersonCreateDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
