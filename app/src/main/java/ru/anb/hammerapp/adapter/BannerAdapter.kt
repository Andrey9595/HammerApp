package ru.anb.hammerapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.anb.hammerapp.databinding.BannerItemBinding
import ru.anb.hammerapp.model.BannerModel
import ru.anb.hammerapp.model.TagModel

class BannerAdapter() : RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    private var bannerList = emptyList<BannerModel>()

    class BannerViewHolder(val binding: BannerItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        return BannerViewHolder(
            BannerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val banner = bannerList[position]
        holder.binding.bannerText.text = banner.text
    }

    override fun getItemCount() = bannerList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<BannerModel>){
        bannerList = data
        notifyDataSetChanged()
    }
}