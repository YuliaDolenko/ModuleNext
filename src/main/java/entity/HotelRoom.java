package entity;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
public class HotelRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "state")
    private String state;

    @Column(name = "arrival_date")
    private String arrival_date;

    @Column(name = "release_date")
    private String release_date;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "comfort")
    private String comfort;

    @Column(name = "price")
    private int price;


    public HotelRoom() {
    }

    public HotelRoom(int id, String state, String arrival_date, String release_date, int capacity, String comfort, int price) {
        this.id = id;
        this.state = state;
        this.arrival_date = arrival_date;
        this.release_date = release_date;
        this.capacity = capacity;
        this.comfort = comfort;
        this.price = price;
    }

    //    @Override
//    public String toString() {
//        return "Hotel [id=" + id + ", Name=" + name + ", Surname=" + surname + ", Comment=" + comment + "]";
//    }
}
