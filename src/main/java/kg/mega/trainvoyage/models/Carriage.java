package kg.mega.trainvoyage.models;

import jakarta.persistence.*;

@Entity
@Table(name = "carriages")
public class Carriage {
    @Id
    @GeneratedValue
    private Long id;
    private int carriageNumber;
    @ManyToOne
    @JoinColumn(name = "carriage_type_id")
    private CarriageType carriageType;
    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public CarriageType getCarriageType() {
        return carriageType;
    }

    public void setCarriageType(CarriageType carriageType) {
        this.carriageType = carriageType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCarriageNumber() {
        return carriageNumber;
    }

    public void setCarriageNumber(int carriageNumber) {
        this.carriageNumber = carriageNumber;
    }
}
