package com.bd.tours.dto;

public class HotelDTO {

    private Long id;
    private String name;
    private String city;
    private int countRooms;

    public HotelDTO(Long id, String name, String city, int countRooms) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.countRooms = countRooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountRooms() {
        return countRooms;
    }

    public void setCountRooms(int countRooms) {
        this.countRooms = countRooms;
    }

    @Override
    public String toString() {
        return "HotelDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", countRooms=" + countRooms +
                '}';
    }
}
