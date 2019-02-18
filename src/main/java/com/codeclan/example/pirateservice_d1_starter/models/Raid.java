package com.codeclan.example.pirateservice_d1_starter.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="raids")

public class Raid {


    @JsonIgnore


    @ManyToOne
    @JoinColumn(name="pirate_id", nullable=false)
    private Pirate pirate;

    @ManyToMany
    @JoinTable(
            name = "pirate_raid",
            joinColumns = { @JoinColumn(
                    name = "raid_id",
                    nullable = false,
                    updatable = false)
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "pirate_id",
                    nullable = false,
                    updatable = false)
            })

    @Column(name="location")
    private String location;
    @Column(name="loot")
    private int loot;
    private List<Pirate> pirates;

    public Raid(String location, int loot) {
        this.location = location;
        this.loot = loot;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }
}
