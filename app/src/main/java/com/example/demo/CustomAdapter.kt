package com.example.demo

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class CustomAdapter (var context :Context, var mangmonan :ArrayList<MonAn>) : BaseAdapter(),
    Parcelable {
    class ViewHolder(row : View){
        var texttenmonan : TextView
        var imgmonan : ImageView
        init{
            texttenmonan = row.findViewById(R.id.textmonan)
            imgmonan = row.findViewById(R.id.hinhanh)
        }
    }

    constructor(parcel: Parcel) : this(
        TODO("context"),
        TODO("mangmonan")
    )


    override fun getCount(): Int {
        return mangmonan.size
    }

    override fun getItem(position: Int): Any {
        return mangmonan.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewholder: ViewHolder
        if (convertView == null) {
            var layoutinflater: LayoutInflater = LayoutInflater.from(context)
            view = layoutinflater.inflate(R.layout.dong_monan, null)
            viewholder = ViewHolder(view)
            view.tag = viewholder
        } else {
            view = convertView
            viewholder = convertView.tag as ViewHolder
        }
        var monan: MonAn = getItem(position) as MonAn
        viewholder.texttenmonan.text = monan.ten
        viewholder.imgmonan.setImageResource(monan.hinhanh)
        return  view as View
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CustomAdapter> {
        override fun createFromParcel(parcel: Parcel): CustomAdapter {
            return CustomAdapter(parcel)
        }

        override fun newArray(size: Int): Array<CustomAdapter?> {
            return arrayOfNulls(size)
        }
    }
}