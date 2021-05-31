package com.dkn.subsatubajp.utilis

object Extra {
    const val ID = "id"
    const val TYPE = "type"
}

enum class TYPE {
    MOVIE,
    TV_SHOW
}

fun String.loadVideo(): String {
    return "<body style=\"margin:0;padding:0;\"><iframe class=\"youtube-player\" type=\"text/html\" width=\"100%\" allowfullscreen=\"true\" allowscriptaccess=\"always\" height=\"100%\" scrolling=\"no\" src=\"https://www.youtube.com/embed/${this}\" frameborder=\"0\"></body>"
}