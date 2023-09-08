package com.edsonmoreirajr.kotlinquarkusdemo.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@Table(name = "Customer")
class Customer(
    @Id
    @Column(name = "CustomerId", nullable = false)
    var id: Int? = null,

    @Size(max = 40)
    @NotNull
    @Column(name = "FirstName", nullable = false, length = 40)
    var firstName: String? = null,

    @Size(max = 20)
    @NotNull
    @Column(name = "LastName", nullable = false, length = 20)
    var lastName: String? = null,

    @Size(max = 80)
    @Column(name = "Company", length = 80)
    var company: String? = null,

    @Size(max = 70)
    @Column(name = "Address", length = 70)
    var address: String? = null,

    @Size(max = 40)
    @Column(name = "City", length = 40)
    var city: String? = null,

    @Size(max = 40)
    @Column(name = "State", length = 40)
    var state: String? = null,

    @Size(max = 40)
    @Column(name = "Country", length = 40)
    var country: String? = null,

    @Size(max = 10)
    @Column(name = "PostalCode", length = 10)
    var postalCode: String? = null,

    @Size(max = 24)
    @Column(name = "Phone", length = 24)
    var phone: String? = null,

    @Size(max = 24)
    @Column(name = "Fax", length = 24)
    var fax: String? = null,

    @Size(max = 60)
    @NotNull
    @Column(name = "Email", nullable = false, length = 60)
    var email: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SupportRepId")
    var supportRep: Employee? = null
) {
    override fun toString(): String {
        return "Customer(id=$id, firstName=$firstName, lastName=$lastName, email=$email)"
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (email?.hashCode() ?: 0)
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this.javaClass != other.javaClass) return false
        other as Customer
        if (id != other.id) return false
        if (email != other.email) return false
        return true
    }
}