package com.edsonmoreirajr.kotlinquarkusdemo.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.Size

@Entity
@Table(name = "MediaType")
class MediaType(
    @Id
    @Column(name = "MediaTypeId", nullable = false)
    val id: Int? = null,

    @Size(max = 120)
    @Column(name = "Name", length = 120)
    val name: String? = null
) {
    override fun toString(): String {
        return "MediaType(id=$id, name=$name)"
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this.javaClass != other.javaClass) return false
        other as MediaType
        if (id != other.id) return false
        if (name != other.name) return false
        return true
    }
}