package com.netcracker.travel.entity.abstracts;

import java.util.UUID;

public abstract class BaseEntity {

    private UUID id;

<<<<<<< HEAD
    public BaseEntity() {
=======
    public BaseEntity(){
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
    }

    public BaseEntity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
