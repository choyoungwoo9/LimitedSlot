package me.youngwoo.limitedslot.member.service

import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberWriter: IMemberWriter,
    private val memberReader: IMemberReader,
)
