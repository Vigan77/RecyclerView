package coba.paba.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


// Model data untuk Wayang
data class Wayang(
    var foto: String,
    var nama: String,
    var karakter: String,
    var deskripsi: String
)

// Adapter untuk RecyclerView
class adapterRecView(private val listWayang: ArrayList<Wayang>) : RecyclerView.Adapter<adapterRecView.ListViewHolder>() {

    // ViewHolder untuk menghubungkan view dari item_recycler.xml
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gambarWayang: ImageView = itemView.findViewById(R.id.gambarWayang)
        val namaWayang: TextView = itemView.findViewById(R.id.namaWayang)
        val karakterWayang: TextView = itemView.findViewById(R.id.karakterWayang)
        val deskripsiWayang: TextView = itemView.findViewById(R.id.deskripsiWayang)

    }

    // Membuat dan menghubungkan ViewHolder dengan layout item_recycler
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ListViewHolder(view)
    }

    // Menghubungkan data dengan view di ListViewHolder
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var wayang = listWayang[position]
        holder.namaWayang.setText(wayang.nama)
        holder.deskripsiWayang.setText(wayang.deskripsi)
        holder.karakterWayang.setText(wayang.karakter)

        Picasso.get()
            .load(wayang.foto) // URL atau sumber gambar dari objek wayang
            .into(holder.gambarWayang)
    }

    // Mendapatkan jumlah item dalam dataset
    override fun getItemCount(): Int {
        return listWayang.size
    }
}
