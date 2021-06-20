package pavel.chobotov.stocks.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "STOCK")
public class Stock{

    @Id
    @SequenceGenerator(name = "stockIdSeq", sequenceName = "stock_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stockIdSeq")
    private Integer id;

    @Column
    private LocalDate date;

    @Column
    private String name;

    @Column
    private Integer cost;

    public Stock(Integer id, LocalDate date, String name, Integer cost) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.cost = cost;
    }

    public Stock() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(id, stock.id) && Objects.equals(date, stock.date) && Objects.equals(name, stock.name) && Objects.equals(cost, stock.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, name, cost);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

}
