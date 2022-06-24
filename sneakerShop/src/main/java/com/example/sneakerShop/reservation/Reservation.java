package com.example.sneakerShop.reservation;

import com.example.sneakerShop.client.Client;
import com.example.sneakerShop.sneaker.Sneaker;
import javax.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private long count;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    @ManyToOne
    @JoinColumn(name = "sneaker_id")
    private Sneaker sneaker;

    public Reservation(Long id, long count, Client client, Sneaker sneaker) {
        this.id = id;
        this.count = count;
        this.client = client;
        this.sneaker = sneaker;
    }

    public Reservation() {

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Sneaker getSneaker() {
        return sneaker;
    }

    public void setSneaker(Sneaker sneaker) {
        this.sneaker = sneaker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}


