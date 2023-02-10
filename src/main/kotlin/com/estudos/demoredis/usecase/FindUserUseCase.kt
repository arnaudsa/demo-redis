package com.estudos.demoredis.usecase

import com.estudos.demoredis.repository.UserRepository
import java.util.UUID
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class FindUserUseCase(
    private val repository: UserRepository,
) {

    fun findById(id: UUID) = repository
        .findByIdOrNull(id)
        ?: DB["user-${id}"]
        ?: IllegalArgumentException("Usuário não encontrado")

}