package entity;

import javax.persistence.*;

@Entity
@Table(name = "hotel_room")
public class HotelRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel_room")
    private int id;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "comfort")
    private String comfort;

    @Column(name = "price")
    private int price;

    @Column(name = "booking")
    private String booking;

    public HotelRoom() {
    }

    public HotelRoom(int id, String booking, int capacity, String comfort, int price) {
        this.id = id;
        this.booking = booking;
        this.capacity = capacity;
        this.comfort = comfort;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getComfort() {
        return comfort;
    }

    public int getPrice() {
        return price;
    }

    public String getBooking() {
        return booking;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setComfort(String comfort) {
        this.comfort = comfort;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Hotel [id = " + id + ", capacity = " + capacity + ", comfort = " + comfort + ", price = " + price + ", booking = " + booking + "]";
    }
}
