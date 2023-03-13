package uz.gita.mg.data.model

/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */
enum class LevelEnum(
    val harCount: Int,
    val verCount: Int
) {
    EASY(3, 4),
    MEDIUM(4, 6),
    HARD(6, 8)
}