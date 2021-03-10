package com.example.dev_intenseve.Extensions

import com.example.dev_intenseve.Models.User
import com.example.dev_intenseve.Models.UserView


fun User.toUserView() : UserView{
    val nickName = ""
    val initials =""
    val status =if (lastVisit==null) "Еще ни разу не был"else if (isOnline) "online" else "Последний раз был ${}"
    return UserView(
        id,
        fullName = "$firstName $secondName",
        nickName = nickName,
        initials = initials,
        avatar = avatar,
        status = status
    )
}