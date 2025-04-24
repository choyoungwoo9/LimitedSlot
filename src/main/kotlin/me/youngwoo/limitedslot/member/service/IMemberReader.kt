package me.youngwoo.limitedslot.member.service

interface IMemberReader {
    fun isIdExist(id: String): Boolean
}
