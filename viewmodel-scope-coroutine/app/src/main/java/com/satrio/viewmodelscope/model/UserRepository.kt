package com.satrio.viewmodelscope.model

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUsers() : List<User>{
           delay(5000)
           val users : List<User> = listOf(
               User(1,"Kukuh"),
               User(2,"Satrio"),
               User(3,"Wibowo"),
               User(4,".....")

           )
        return users

    }
}