package top.jowanxu.wanandroidclient.adapter

import android.content.Context
import android.text.Html
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import top.jowanxu.wanandroidclient.R
import top.jowanxu.wanandroidclient.bean.Datas

class SearchAdapter(val context: Context, datas: MutableList<Datas>) :
    BaseQuickAdapter<Datas, BaseViewHolder>(R.layout.home_list_item, datas) {
    override fun convert(helper: BaseViewHolder, item: Datas?) {
        item ?: return
        @Suppress("DEPRECATION")
        helper.setText(R.id.homeItemTitle, Html.fromHtml(item.title))
            .setText(R.id.homeItemAuthor, item.author)
            .setText(R.id.homeItemType, item.chapterName)
            .setText(
                R.id.homeItemDate,
                if (item.originId != 0) context.getString(
                    R.string.bookmark_time,
                    item.niceDate
                ) else item.niceDate
            )
            .addOnClickListener(R.id.homeItemType)
            .setTextColor(R.id.homeItemType, context.resources.getColor(R.color.colorPrimary))
            .linkify(R.id.homeItemType)
            .setImageResource(
                R.id.homeItemLike,
                if (item.originId != 0 || item.collect) R.drawable.ic_action_like else R.drawable.ic_action_no_like
            )
            .addOnClickListener(R.id.homeItemLike)
    }
}