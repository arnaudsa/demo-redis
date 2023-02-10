package com.estudos.demoredis.usecase

import com.estudos.demoredis.domain.User
import com.estudos.demoredis.repository.UserRepository
import org.springframework.stereotype.Service

val DB = LinkedHashMap<String,User>()

@Service
class CreateUserUseCase(
    private val repository: UserRepository,
) {


    fun salvar(user: User): User {
        DB[user.id.toString()] = user
        return repository.save(user)
    }

}