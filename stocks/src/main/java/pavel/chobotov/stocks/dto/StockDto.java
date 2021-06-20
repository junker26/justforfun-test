package pavel.chobotov.stocks.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;


public class StockDto{

    private Integer id;
    private LocalDate date;
    private String name;
    private Integer cost;

    public StockDto(Integer id, LocalDate date, String name, Integer cost) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.cost = cost;
    }

    public StockDto() {
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
        StockDto stockDto = (StockDto) o;
        return Objects.equals(id, stockDto.id) && Objects.equals(date, stockDto.date) && Objects.equals(name, stockDto.name) && Objects.equals(cost, stockDto.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, name, cost);
    }

    @Override
    public String toString() {
        return "StockDto{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

}
