package me.youngwoo.limitedslot.member.repository

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity()
@Table(name = "member")
class MemberEntity(
    @Id var id: String,
    @Column(nullable = false)
    var name: String,
    @Column(nullable = false)
    var password: String,
) {
    protected constructor() : this("", "", "")
}
