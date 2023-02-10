package com.estudos.demoredis.domain

import java.util.UUID
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive

@RedisHash("user")
data class User(
    @Id
    val id: UUID,
    val name: String,

    @TimeToLive
    val expiration: Long,
)
