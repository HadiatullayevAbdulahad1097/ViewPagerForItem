package developer.abdulahad.viewpagerforitem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import developer.abdulahad.viewpagerforitem.models.User
import developer.abdulahad.viewpagerforitem.databinding.ItemView2Binding
import developer.abdulahad.viewpagerforitem.databinding.ItemViewBinding

class MyViewPagerAdapter(val context: Context,val list : List<User>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        if (position%2==0) {
            val itemView = ItemViewBinding.inflate(LayoutInflater.from(container.context), container, false)

            Glide.with(context).load(list[position].imageLink).into(itemView.imageItem)
            itemView.txtItem.text = list[position].name

            container.addView(itemView.root)
            return itemView.root
        }else{
            val itemView2Binding = ItemView2Binding.inflate(LayoutInflater.from(container.context), container, false)

            Glide.with(context).load(list[position].imageLink).into(itemView2Binding.imageItem2)
            itemView2Binding.clickItem.text = list[position].name

            container.addView(itemView2Binding.root)
            return itemView2Binding.root
        }
    }

    override fun getCount(): Int = list.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
         val view = `object` as View 
         container.removeView(view)
    }
}