package com.rvbb.b2b.backend.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_demo")
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="order_date")
    private Timestamp orderDate;

    @Column(name="total")
    private Double total;

    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }
}
