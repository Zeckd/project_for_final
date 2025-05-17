package kg.mega.trainvoyage.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import kg.mega.trainvoyage.enums.Delete;

@Entity
@Table(name = "passengers")
public class Passenger {
    @Id
    @GeneratedValue

    private Long id;
    @NotBlank(message = "Строка не должна быть пустой или состоять только из пробелов")
    @NotEmpty(message = "Строка или коллекция не должна быть пустой и не null")
    @NotNull(message = "Значение не должно быть null")
    private String lastName;
    @NotBlank(message = "Строка не должна быть пустой или состоять только из пробелов")
    @NotEmpty(message = "Строка или коллекция не должна быть пустой и не null")
    @NotNull(message = "Значение не должно быть null")
    private String firstName;
    @NotBlank(message = "Строка не должна быть пустой или состоять только из пробелов")
    @NotEmpty(message = "Строка или коллекция не должна быть пустой и не null")
    @NotNull(message = "Значение не должно быть null")
    private String patronymic;
    @NotBlank(message = "Строка не должна быть пустой или состоять только из пробелов")
    @NotEmpty(message = "Строка или коллекция не должна быть пустой и не null")
    @NotNull(message = "Значение не должно быть null")
    private String address;
    @JsonIgnore
    private Delete delete = Delete.ACTIVE;

    public Delete getDelete() {
        return delete;
    }

    public void setDelete(Delete delete) {
        this.delete = delete;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
