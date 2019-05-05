package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "comment")
    private String comment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order")
    private Order order;

    public Customer() {
    }

    public Customer(int id, String name, String surname, String comment) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", Name=" + name + ", Surname=" + surname + ", Comment=" + comment + "]";
    }
}
