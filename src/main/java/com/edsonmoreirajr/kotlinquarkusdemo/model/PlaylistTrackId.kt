package com.edsonmoreirajr.kotlinquarkusdemo.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.validation.constraints.NotNull
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*

@Embeddable
open class PlaylistTrackId : Serializable {
    @NotNull
    @Column(name = "PlaylistId", nullable = false)
    open var playlistId: Int? = null

    @NotNull
    @Column(name = "TrackId", nullable = false)
    open var trackId: Int? = null
    override fun hashCode(): Int = Objects.hash(playlistId, trackId)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as PlaylistTrackId

        return playlistId == other.playlistId &&
                trackId == other.trackId
    }

    companion object {
        private const val serialVersionUID = -4049563190718303187L
    }
}