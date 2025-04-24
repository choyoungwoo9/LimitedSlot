package me.youngwoo.limitedslot.member.repository

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import me.youngwoo.limitedslot.member.domain.MemberDomain

@Entity
@Table(name = "member")
class MemberEntity(
    @Id var id: String,
    @Column(nullable = false)
    var name: String,
    @Column(nullable = false)
    var password: String,
) {
    protected constructor() : this("", "", "")

    companion object {
        fun domainToEntity(member: MemberDomain): MemberEntity {
            return MemberEntity(
                id = member.id,
                name = member.name,
                password = member.password,
            )
        }

        fun entityToDomain(memberEntity: MemberEntity): MemberDomain {
            return MemberDomain(
                id = memberEntity.id,
                name = memberEntity.name,
                password = memberEntity.password,
            )
        }
    }
}
