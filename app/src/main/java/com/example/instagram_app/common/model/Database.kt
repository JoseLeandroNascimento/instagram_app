package com.example.instagram_app.common.model

import java.util.UUID

object Database {

    val usersAuth = hashSetOf<UserAuth>()

    var sessionAuth: UserAuth? = null

    init {
        usersAuth.add(
            UserAuth(
                uuid = UUID.randomUUID().toString(),
                name = "userA",
                email = "userA@gmail.com",
                password = "12345678"
            )
        )

        usersAuth.add(
            UserAuth(
                uuid = UUID.randomUUID().toString(),
                name = "userB",
                email = "userB@gmail.com",
                password = "87654321"
            )
        )
    }

}