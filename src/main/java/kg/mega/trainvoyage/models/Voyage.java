package kg.mega.trainvoyage.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import kg.mega.trainvoyage.enums.Delete;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "voyage")
public class Voyage {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate sendDate;
    private LocalTime sendTime;
    @ManyToOne
    @JoinColumn(name = "destination_locality_id")
    private Locality destination;
    @ManyToOne
    @JoinColumn(name = "starting_locality_id")
    private Locality startingPoint;

    private LocalDateTime arrivalTime;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;
    private double distance;
    private double price;
    private Delete delete = Delete.ACTIVE;

    public Delete getDelete() {
        return delete;
    }

    public void setDelete(Delete delete) {
        this.delete = delete;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDate sendDate) {
        this.sendDate = sendDate;
    }

    public LocalTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalTime sendTime) {
        this.sendTime = sendTime;
    }

    public Locality getDestination() {
        return destination;
    }

    public void setDestination(Locality destination) {
        this.destination = destination;
    }

    public Locality getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Locality startingPoint) {
        this.startingPoint = startingPoint;
    }
}
