package com.bd.tours.dto;

public class HotelAccommodationDTO {

    private Long id;
    private Long hotelId;
    private String date;
    private int number;
    private int price;
    private int countPlaces;

    public HotelAccommodationDTO(Long id, Long hotelId, String date, int number, int price, int countPlaces) {
        this.id = id;
        this.hotelId = hotelId;
        this.date = date;
        this.number = number;
        this.price = price;
        this.countPlaces = countPlaces;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCountPlaces() {
        return countPlaces;
    }

    public void setCountPlaces(int countPlaces) {
        this.countPlaces = countPlaces;
    }

    @Override
    public String toString() {
        return "HotelAccommodationDTO{" +
                "hotelId=" + hotelId +
                ", date='" + date + '\'' +
                ", number='" + number + '\'' +
                ", price=" + price +
                ", countPlaces=" + countPlaces +
                '}';
    }
}
