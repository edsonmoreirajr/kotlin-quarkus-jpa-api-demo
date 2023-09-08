package com.edsonmoreirajr.kotlinquarkusdemo.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.validation.constraints.NotNull
import java.io.Serializable

@Embeddable
class PlaylistTrackId(
    @NotNull
    @Column(name = "PlaylistId", nullable = false)
    val playlistId: Int? = null,

    @NotNull
    @Column(name = "TrackId", nullable = false)
    val trackId: Int? = null
) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this.javaClass != other.javaClass) return false
        other as PlaylistTrackId
        if (playlistId != other.playlistId) return false
        if (trackId != other.trackId) return false
        return true
    }

    override fun hashCode(): Int {
        var result = playlistId ?: 0
        result = 31 * result + (trackId ?: 0)
        return result
    }
}