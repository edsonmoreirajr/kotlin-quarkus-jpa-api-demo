package com.edsonmoreirajr.kotlinquarkusdemo.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.Size

@Entity
@Table(name = "\"Playlist\"")
open class Playlist {
    @Id
    @Column(name = "\"PlaylistId\"", nullable = false)
    open var id: Int? = null

    @Size(max = 120)
    @Column(name = "\"Name\"", length = 120)
    open var name: String? = null

    override fun toString(): String {
        return "Playlist(id=$id, name=$name)"
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this.javaClass != other.javaClass) return false
        other as Playlist
        if (id != other.id) return false
        if (name != other.name) return false
        return true
    }
}