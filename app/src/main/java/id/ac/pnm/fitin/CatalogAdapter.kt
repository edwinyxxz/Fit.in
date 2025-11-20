package id.ac.pnm.fitin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CatalogAdapter(val data: List<Catalog>, val onClickOpenDetailProductActivity: (Catalog)-> Unit): RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CatalogViewHolder {
        val layout: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_catalog, parent, false)
        return CatalogViewHolder(layout)
    }
    override fun onBindViewHolder(
        holder: CatalogViewHolder,
        position: Int
    ) {
        val catalog: Catalog = data[position]
        holder.image.setImageResource(catalog.Image)
        holder.textViewPrice.text = catalog.Price
        holder.textViewName.text = catalog.Name
        holder.textViewDeskripsi.text = catalog.Deskripsi
        holder.textViewCategory.text = catalog.Category.toString()

        holder.row.setOnClickListener { onClickOpenDetailProductActivity(catalog) }
    }
    override fun getItemCount(): Int = data.size
    class CatalogViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val image = row.findViewById<ImageView>(R.id.image_product)
        val textViewPrice = row.findViewById<TextView>(R.id.textViewPrice)
        val textViewName = row.findViewById<TextView>(R.id.textViewName)
        val textViewDeskripsi = row.findViewById<TextView>(R.id.textViewDeskripsi)
        val textViewCategory = row.findViewById<TextView>(R.id.textViewCategory)
    }
}