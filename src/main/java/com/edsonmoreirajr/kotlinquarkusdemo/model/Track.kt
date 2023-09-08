package com.edsonmoreirajr.kotlinquarkusdemo.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal

@Entity
@Table(name = "Track")
class Track(
    @Id
    @Column(name = "TrackId", nullable = false)
    val id: Int? = null,

    @Size(max = 200)
    @NotNull
    @Column(name = "Name", nullable = false, length = 200)
    val name: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AlbumId")
    val album: Album? = null,

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MediaTypeId", nullable = false)
    val mediaType: MediaType? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GenreId")
    val genre: Genre? = null,

    @Size(max = 220)
    @Column(name = "Composer", length = 220)
    val composer: String? = null,

    @NotNull
    @Column(name = "Milliseconds", nullable = false)
    val milliseconds: Int? = null,

    @Column(name = "Bytes")
    val bytes: Int? = null,

    @NotNull
    @Column(name = "UnitPrice", nullable = false, precision = 10, scale = 2)
    val unitPrice: BigDecimal? = null
) {
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