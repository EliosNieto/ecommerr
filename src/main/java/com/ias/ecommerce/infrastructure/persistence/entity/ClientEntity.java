package com.ias.ecommerce.infrastructure.persistence.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "TBL_CLIENTS")
public class ClientEntity {

    @Id
    @Column(name = "client_id", length = 20)
    private Long id;

    @Column(nullable = false, length = 100)
    private String names;

    @Column(name = "last_names", nullable = false, length = 100)
    private String lastNames;

    @OneToMany(mappedBy = "clientEntity")
    private Collection<OrderEntity> orderEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id=" + id +
                ", names='" + names + '\'' +
                ", lastNames='" + lastNames + '\'' +
                '}';
    }
}
