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
import java.math.BigDecimal

@Entity
@Table(name = "\"Track\"")
open class Track {
    @Id
    @Column(name = "\"TrackId\"", nullable = false)
    open var id: Int? = null

    @Size(max = 200)
    @NotNull
    @Column(name = "\"Name\"", nullable = false, length = 200)
    open var name: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"AlbumId\"")
    open var album: Album? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"MediaTypeId\"", nullable = false)
    open var mediaType: MediaType? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"GenreId\"")
    open var genre: Genre? = null

    @Size(max = 220)
    @Column(name = "\"Composer\"", length = 220)
    open var composer: String? = null

    @NotNull
    @Column(name = "\"Milliseconds\"", nullable = false)
    open var milliseconds: Int? = null

    @Column(name = "\"Bytes\"")
    open var bytes: Int? = null

    @NotNull
    @Column(name = "\"UnitPrice\"", nullable = false, precision = 10, scale = 2)
    open var unitPrice: BigDecimal? = null

    override fun toString(): String {
        return "Track(id=$id, name=$name)"
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this.javaClass != other.javaClass) return false
        other as Track
        if (id != other.id) return false
        if (name != other.name) return false
        return true
    }

}