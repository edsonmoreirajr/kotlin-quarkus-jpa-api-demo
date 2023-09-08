package com.edsonmoreirajr.kotlinquarkusdemo.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@Table(name = "Album")
class Album(
    @Id
    @NotNull
    @Column(name = "AlbumId", nullable = false)
    var id: Int? = null,

    @Size(max = 160)
    @NotNull
    @Column(name = "Title", nullable = false, length = 160)
    var title: String? = null,

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ArtistId", nullable = false)
    var artist: Artist? = null
) {
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