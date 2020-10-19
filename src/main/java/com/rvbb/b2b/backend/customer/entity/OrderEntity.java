package com.rvbb.b2b.backend.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Timestamp orderDate;

    private Double total;

    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }
}
