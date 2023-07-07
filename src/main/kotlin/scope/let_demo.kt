package scope

import java.util.*

fun processNullableString(str: String?) =
    str?.let { s -> // null 가능 레퍼런스로 let을 실행한다
        when {
            s.isEmpty() -> "Empty"// it의 length가 0일 경우 Empty 반환
            s.isBlank() -> "Blank"// it의 length가 0이거나 공백으로만 차있을 경우 Blank 반환
            else -> s.replaceFirstChar {
                if (it.isLowerCase())
                    it.titlecase(Locale.getDefault())
                else it.toString()
            }
        }
    } ?: "Null" // null일 경우 Null 반환
// null 불가능 레퍼런스 이므로 엘비스 연산자를 사용하지 않고 empty,blank만 확인하여 맨앞이 소문자일 경우에 대문자로 변경해서 반환하고 대문자일 경우 그냥 toString으로 반환
fun processString(str: String) = when {
    str.isEmpty() -> "Empty"
    str.isBlank() -> "Blank"
    else -> str.replaceFirstChar {
        if (it.isLowerCase())
            it.titlecase(Locale.getDefault())
        else it.toString()
    }
}

