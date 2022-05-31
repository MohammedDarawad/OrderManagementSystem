package com.webservices.oms.ordermanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProductOrderId implements Serializable {
    private static final long serialVersionUID = 476151177562655457L;

    private int productId;

    private int orderId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductOrderId)) return false;
        ProductOrderId saleId = (ProductOrderId) o;
        return Objects.equals(getOrderId(), saleId.getOrderId()) &&
                Objects.equals(getProductId(), saleId.getProductId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getOrderId(), getProductId());
    }

}
