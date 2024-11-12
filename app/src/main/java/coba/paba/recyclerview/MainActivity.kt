package coba.paba.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var _nama: Array<String>
    private lateinit var _karakter: Array<String>
    private lateinit var _deskripsi: Array<String>
    private lateinit var _gambar: Array<String>

    private var arWayang = arrayListOf<Wayang>()
    private lateinit var _rvWayang: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _rvWayang = findViewById(R.id.rvWayang)

        SiapkanData()
        TambahData()
        TampilkanData()
    }

    private fun SiapkanData() {
        _nama = resources.getStringArray(R.array.namaWayang)
        _deskripsi = resources.getStringArray(R.array.deskripsiWayang)
        _karakter = resources.getStringArray(R.array.karakterUtamaWayang)
        _gambar = resources.getStringArray(R.array.gambarWayang)
    }

    private fun TambahData() {
        for (position in _nama.indices) {
            val data = Wayang(
                foto = _gambar[position],
                nama = _nama[position],
                karakter = _karakter[position],
                deskripsi = _deskripsi[position]
            )
            arWayang.add(data)
        }
    }

    fun TampilkanData() {
        _rvWayang.layoutManager = GridLayoutManager(this,2)
        _rvWayang.adapter = adapterRecView(arWayang)
    }
}
