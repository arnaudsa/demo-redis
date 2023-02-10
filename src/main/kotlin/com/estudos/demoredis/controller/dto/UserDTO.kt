package com.estudos.demoredis.controller.dto

import com.estudos.demoredis.domain.User
import java.util.UUID

data class UserDTO(
    val name:String
){

    fun toModel() = User(
        id = UUID.randomUUID(),
        name = name,
        expiration = 400
    )

}
