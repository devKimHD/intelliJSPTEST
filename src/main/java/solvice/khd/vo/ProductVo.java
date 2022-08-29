package solvice.khd.vo;

public class ProductVo {
    private int id;
    private String name;
    private int cost;
    private int year;
    private String city;

    public ProductVo() {
    }

    public ProductVo(int id, String name, int cost, int year, String city) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.year = year;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "ProductVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", year=" + year +
                ", city='" + city + '\'' +
                '}';
    }
}
