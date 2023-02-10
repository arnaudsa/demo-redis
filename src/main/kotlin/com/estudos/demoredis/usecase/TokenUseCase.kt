package com.estudos.demoredis.usecase

import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service

@Service
class TokenUseCase(
    private val template: StringRedisTemplate
) {

    fun salvar(key: String, value: String) {
        template.opsForValue().set(key, value)
    }

    fun getById(key: String) =  template
        .opsForValue()
        .get(key)

}
