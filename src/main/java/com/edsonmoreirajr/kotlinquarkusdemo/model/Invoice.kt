package com.edsonmoreirajr.kotlinquarkusdemo.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "Invoice")
class Invoice(
    @Id
    @Column(name = "InvoiceId", nullable = false)
    val id: Int? = null,

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CustomerId", nullable = false)
    val customer: Customer? = null,

    @NotNull
    @Column(name = "InvoiceDate", nullable = false)
    val invoiceDate: Instant? = null,

    @Size(max = 70)
    @Column(name = "BillingAddress", length = 70)
    val billingAddress: String? = null,

    @Size(max = 40)
    @Column(name = "BillingCity", length = 40)
    val billingCity: String? = null,

    @Size(max = 40)
    @Column(name = "BillingState", length = 40)
    val billingState: String? = null,

    @Size(max = 40)
    @Column(name = "BillingCountry", length = 40)
    val billingCountry: String? = null,

    @Size(max = 10)
    @Column(name = "BillingPostalCode", length = 10)
    val billingPostalCode: String? = null,

    @NotNull
    @Column(name = "Total", nullable = false, precision = 10, scale = 2)
    val total: BigDecimal? = null
) {
    override fun toString(): String {
        return "Invoice(id=$id, customer=${customer?.firstName} ${customer?.lastName}, invoiceDate=$invoiceDate, total=$total)"
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (customer?.hashCode() ?: 0)
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this.javaClass != other.javaClass) return false
        other as Invoice
        if (id != other.id) return false
        if (customer != other.customer) return false
        return true
    }
}