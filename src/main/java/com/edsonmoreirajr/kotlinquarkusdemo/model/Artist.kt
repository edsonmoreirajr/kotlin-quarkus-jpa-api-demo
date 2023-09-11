package com.edsonmoreirajr.kotlinquarkusdemo.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.Size

@Entity
@Table(name = "\"Artist\"")
open class Artist {
    @Id
    @Column(name = "\"ArtistId\"", nullable = false)
    open var id: Int? = null

    @Size(max = 120)
    @Column(name = "\"Name\"", length = 120)
    open var name: String? = null

    override fun toString(): String {
        return "Artist(id=$id, name=$name)"
    }

    override fun hashCode(): Int {
        return id ?: 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this.javaClass != other.javaClass) return false
        other as Artist
        return id == other.id
    }
}