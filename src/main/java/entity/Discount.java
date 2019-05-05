package entity;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
public class Discount extends Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_discount")
    private int id;

    @Column(name = "discount_percentage")
    private int discount_percentage;

    @Column(name = "count_discount")
    private int count_discount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer")
    private Customer customer;

    public Discount() {
    }

    public Discount(int id, int discount_percentage, int count_discount) {
        this.id = id;
        this.discount_percentage = discount_percentage;
        this.count_discount = count_discount;
    }

    public int getId() {
        return id;
    }

    public int getDiscount_percentage() {
        return discount_percentage;
    }

    public int getCount_discount() {
        return count_discount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDiscount_percentage(int discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    public void setCount_discount(int count_discount) {
        this.count_discount = count_discount;
    }
}
