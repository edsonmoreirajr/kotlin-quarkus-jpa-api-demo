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
import java.time.Instant

@Entity
@Table(name = "\"Employee\"")
open class Employee {
    @Id
    @Column(name = "\"EmployeeId\"", nullable = false)
    open var id: Int? = null

    @Size(max = 20)
    @NotNull
    @Column(name = "\"LastName\"", nullable = false, length = 20)
    open var lastName: String? = null

    @Size(max = 20)
    @NotNull
    @Column(name = "\"FirstName\"", nullable = false, length = 20)
    open var firstName: String? = null

    @Size(max = 30)
    @Column(name = "\"Title\"", length = 30)
    open var title: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"ReportsTo\"")
    open var reportsTo: Employee? = null

    @Column(name = "\"BirthDate\"")
    open var birthDate: Instant? = null

    @Column(name = "\"HireDate\"")
    open var hireDate: Instant? = null

    @Size(max = 70)
    @Column(name = "\"Address\"", length = 70)
    open var address: String? = null

    @Size(max = 40)
    @Column(name = "\"City\"", length = 40)
    open var city: String? = null

    @Size(max = 40)
    @Column(name = "\"State\"", length = 40)
    open var state: String? = null

    @Size(max = 40)
    @Column(name = "\"Country\"", length = 40)
    open var country: String? = null

    @Size(max = 10)
    @Column(name = "\"PostalCode\"", length = 10)
    open var postalCode: String? = null

    @Size(max = 24)
    @Column(name = "\"Phone\"", length = 24)
    open var phone: String? = null

    @Size(max = 24)
    @Column(name = "\"Fax\"", length = 24)
    open var fax: String? = null

    @Size(max = 60)
    @Column(name = "\"Email\"", length = 60)
    open var email: String? = null

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