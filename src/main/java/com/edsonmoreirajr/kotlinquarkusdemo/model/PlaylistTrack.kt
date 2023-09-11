package com.edsonmoreirajr.kotlinquarkusdemo.model

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.Table

@Entity
@Table(name = "\"PlaylistTrack\"")
open class PlaylistTrack {
    @EmbeddedId
    open var id: PlaylistTrackId? = null

    @MapsId("playlistId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"PlaylistId\"", nullable = false)
    open var playlist: Playlist? = null

    @MapsId("trackId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"TrackId\"", nullable = false)
    open var track: Track? = null

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