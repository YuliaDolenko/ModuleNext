package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order")
public class Order extends Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private int id;

    @Column(name = "arrival_date")
    private String arrival_date;

    @Column(name = "release_date")
    private String release_date;

    public Order() {
    }

    public Order(int id, String arrival_date, String release_date) {
        this.id = id;
        this.arrival_date = arrival_date;
        this.release_date = release_date;
    }

    public int getId() {
        return id;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @OneToMany(mappedBy = "hotel_room",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<HotelRoom> hotelRooms;
}
