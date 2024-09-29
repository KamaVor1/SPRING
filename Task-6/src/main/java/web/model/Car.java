package web.model;

public class Car {
    private String mark;
    private String body;
    private int price;

    public Car(String mark, String body, int price) {
        this.mark = mark;
        this.body = body;
        this.price = price;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
