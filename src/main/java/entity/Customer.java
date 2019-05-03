package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cust")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "comment")
    private String comment;

    @Column(name = "discount")
    private String discount;

    @Column(name = "countBookings")
    private String countBookings;


    @OneToMany(mappedBy = "customer",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<HotelRoom> hotelRooms;

    public Customer() {
    }

    public Customer(int id, String name, String surname, String comment, String discount, String countBookings, List<HotelRoom> hotelRooms) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.comment = comment;
        this.discount = discount;
        this.countBookings = countBookings;
        this.hotelRooms = hotelRooms;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", Name=" + name + ", Surname=" + surname + ", Comment=" + comment + "]";
    }
}
