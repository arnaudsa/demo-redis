package com.estudos.demoredis.repository

import com.estudos.demoredis.domain.User
import java.util.UUID
import org.springframework.data.repository.CrudRepository

interface UserRepository:CrudRepository<User,UUID> {
}