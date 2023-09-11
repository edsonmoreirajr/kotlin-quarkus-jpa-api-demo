package com.edsonmoreirajr.kotlinquarkusdemo.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "\"Invoice\"")
open class Invoice {
    @Id
    @Column(name = "\"InvoiceId\"", nullable = false)
    open var id: Int? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"CustomerId\"", nullable = false)
    open var customer: Customer? = null

    @NotNull
    @Column(name = "\"InvoiceDate\"", nullable = false)
    open var invoiceDate: Instant? = null

    @Size(max = 70)
    @Column(name = "\"BillingAddress\"", length = 70)
    open var billingAddress: String? = null

    @Size(max = 40)
    @Column(name = "\"BillingCity\"", length = 40)
    open var billingCity: String? = null

    @Size(max = 40)
    @Column(name = "\"BillingState\"", length = 40)
    open var billingState: String? = null

    @Size(max = 40)
    @Column(name = "\"BillingCountry\"", length = 40)
    open var billingCountry: String? = null

    @Size(max = 10)
    @Column(name = "\"BillingPostalCode\"", length = 10)
    open var billingPostalCode: String? = null

    @NotNull
    @Column(name = "\"Total\"", nullable = false, precision = 10, scale = 2)
    open var total: BigDecimal? = null

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