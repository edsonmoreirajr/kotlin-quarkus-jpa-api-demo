package com.edsonmoreirajr.kotlinquarkusdemo.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

@Entity
@Table(name = "\"InvoiceLine\"")
open class InvoiceLine {
    @Id
    @Column(name = "\"InvoiceLineId\"", nullable = false)
    open var id: Int? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"InvoiceId\"", nullable = false)
    open var invoice: Invoice? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"TrackId\"", nullable = false)
    open var track: Track? = null

    @NotNull
    @Column(name = "\"UnitPrice\"", nullable = false, precision = 10, scale = 2)
    open var unitPrice: BigDecimal? = null

    @NotNull
    @Column(name = "\"Quantity\"", nullable = false)
    open var quantity: Int? = null

    override fun toString(): String {
        return "InvoiceLine(id=$id, invoice=${invoice?.id}, track=${track?.name}, unitPrice=$unitPrice, quantity=$quantity)"
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (invoice?.hashCode() ?: 0)
        result = 31 * result + (track?.hashCode() ?: 0)
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this.javaClass != other.javaClass) return false
        other as InvoiceLine
        if (id != other.id) return false
        if (invoice != other.invoice) return false
        if (track != other.track) return false
        return true
    }
}