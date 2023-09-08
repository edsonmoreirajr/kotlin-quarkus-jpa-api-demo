package com.edsonmoreirajr.kotlinquarkusdemo.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.Instant

@Entity
@Table(name = "Employee")
class Employee(
    @Id
    @Column(name = "EmployeeId", nullable = false)
    val id: Int? = null,

    @Size(max = 20)
    @NotNull
    @Column(name = "LastName", nullable = false, length = 20)
    val lastName: String? = null,

    @Size(max = 20)
    @NotNull
    @Column(name = "FirstName", nullable = false, length = 20)
    val firstName: String? = null,

    @Size(max = 30)
    @Column(name = "Title", length = 30)
    val title: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ReportsTo")
    val reportsTo: Employee? = null,

    @Column(name = "BirthDate")
    val birthDate: Instant? = null,

    @Column(name = "HireDate")
    val hireDate: Instant? = null,

    @Size(max = 70)
    @Column(name = "Address", length = 70)
    val address: String? = null,

    @Size(max = 40)
    @Column(name = "City", length = 40)
    val city: String? = null,

    @Size(max = 40)
    @Column(name = "State", length = 40)
    val state: String? = null,

    @Size(max = 40)
    @Column(name = "Country", length = 40)
    val country: String? = null,

    @Size(max = 10)
    @Column(name = "PostalCode", length = 10)
    val postalCode: String? = null,

    @Size(max = 24)
    @Column(name = "Phone", length = 24)
    val phone: String? = null,

    @Size(max = 24)
    @Column(name = "Fax", length = 24)
    val fax: String? = null,

    @Size(max = 60)
    @Column(name = "Email", length = 60)
    val email: String? = null
) {
    override fun toString(): String {
        return "Employee(id=$id, firstName=$firstName, lastName=$lastName, email=$email)"
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (email?.hashCode() ?: 0)
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this.javaClass != other.javaClass) return false
        other as Employee
        if (id != other.id) return false
        if (email != other.email) return false
        return true
    }
}