package com.edsonmoreirajr.kotlinquarkusdemo.model

import jakarta.persistence.*

@Entity
@Table(name = "PlaylistTrack")
class PlaylistTrack(
    @EmbeddedId
    val id: PlaylistTrackId? = null,

    @MapsId("playlistId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PlaylistId", nullable = false)
    val playlist: Playlist? = null,

    @MapsId("trackId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TrackId", nullable = false)
    val track: Track? = null
) {
    override fun toString(): String {
        return "PlaylistTrack(id=$id, playlist=${playlist?.name}, track=${track?.name})"
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (playlist?.hashCode() ?: 0)
        result = 31 * result + (track?.hashCode() ?: 0)
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this.javaClass != other.javaClass) return false
        other as PlaylistTrack
        if (id != other.id) return false
        if (playlist != other.playlist) return false
        if (track != other.track) return false
        return true
    }
}