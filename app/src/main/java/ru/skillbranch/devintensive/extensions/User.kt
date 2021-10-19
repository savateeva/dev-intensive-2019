package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

fun User.toUserView(): UserView {
    val initials = Utils.toInitials(firstName, lastName)
    val status = if (LastVisit === null) "No autorize" else if(isOnline) "onLine"
            else "Last visit ${LastVisit.humanizDiff()}"
    val nickName = User.translitiration(firstName)
    return UserView(id, "$firstName $lastName", avatar ?: "noAvatar", initial = initials)

}

private fun Date.humanizDiff(date:Date = Date()):String{
//TODO

    return ""
}