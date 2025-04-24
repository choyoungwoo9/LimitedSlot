package me.youngwoo.limitedslot.member.service

import me.youngwoo.limitedslot.member.domain.MemberDomain

interface IMemberWriter {
    fun save(member: MemberDomain): MemberDomain
}
