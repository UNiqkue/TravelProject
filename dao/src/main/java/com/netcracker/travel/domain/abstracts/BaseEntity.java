package com.netcracker.travel.domain.abstracts;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity {

    private String id;

    public BaseEntity() {
    }

    public BaseEntity(String id) {
        this.id = id;
    }

   /* @Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
