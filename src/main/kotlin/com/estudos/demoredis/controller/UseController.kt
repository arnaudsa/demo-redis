package com.estudos.demoredis.controller

import com.estudos.demoredis.controller.dto.UserDTO
import com.estudos.demoredis.usecase.CreateUserUseCase
import com.estudos.demoredis.usecase.FindUserUseCase
import java.net.URI
import java.util.UUID
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UseController(
  private val createUserUseCase: CreateUserUseCase,
  private val findUserUseCase: FindUserUseCase,
) {

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: UUID): ResponseEntity<Any>? {
        return runCatching {
            ResponseEntity.ok(findUserUseCase.findById(id))
        }.onFailure {
            ResponseEntity.notFound()
        }
        .getOrNull()
    }

    @PostMapping
    fun salvar(@RequestBody user: UserDTO): ResponseEntity<Any>{
        return createUserUseCase.salvar(user.toModel())
            .let {
                ResponseEntity
                    .created(URI.create("/user/${it.id}"))
                    .body(it)
            }
    }

}