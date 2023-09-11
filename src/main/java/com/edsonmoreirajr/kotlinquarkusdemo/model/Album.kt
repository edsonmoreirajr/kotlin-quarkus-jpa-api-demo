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

@Entity
@Table(name = "\"Album\"")
open class Album {
    @Id
    @Column(name = "\"AlbumId\"", nullable = false)
    open var id: Int? = null

    @Size(max = 160)
    @NotNull
    @Column(name = "\"Title\"", nullable = false, length = 160)
    open var title: String? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"ArtistId\"", nullable = false)
    open var artist: Artist? = null

    override fun toString(): String {
        return "Album(id=$id, title=$title, artist=${artist?.name})"
    }

    override fun hashCode(): Int {
        return id ?: 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this.javaClass != other.javaClass) return false
        other as Album
        return id == other.id
    }
}