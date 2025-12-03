package id.ac.pnm.fitin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(val data: List<ItemCart>): RecyclerView.Adapter<CartAdapter.CartViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartViewHolder {
        val layout: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(layout)
    }

    override fun onBindViewHolder(
        holder: CartViewHolder,
        position: Int
    ) {
        val dataCart = data[position]
        holder.image.setImageResource(dataCart.Image)
        holder.textViewName.text = dataCart.Name
        holder.textViewPrice.text = "${dataCart.Price}"
        holder.textViewCategory.text = dataCart.Category
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CartViewHolder(val row: View) : RecyclerView.ViewHolder(row){
        val image = row.findViewById<ImageView>(R.id.imageViewProduct)
        val textViewPrice = row.findViewById<TextView>(R.id.textViewPrice)
        val textViewName = row.findViewById<TextView>(R.id.textViewName)
        val textViewCategory = row.findViewById<TextView>(R.id.textViewCategory)
    }
}