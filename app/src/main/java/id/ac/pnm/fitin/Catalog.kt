package id.ac.pnm.fitin
data class Catalog(
    val Image: Int,
    val Name: String,
    val Price: String,
    val Deskripsi: String,
    val Category: Category
)
enum class Category{
    Jaket, Knit, Dasi, Kemeja, Celana, Cardigan
}