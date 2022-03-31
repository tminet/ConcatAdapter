package tmidev.concatadapter.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import tmidev.concatadapter.domain.Tip
import tmidev.concatadapter.util.DismissTipClick

class TipsAdapter(
    private val dismissTipClick: DismissTipClick
) : ListAdapter<Tip, TipsViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TipsViewHolder.create(
            parent = parent,
            dismissTipClick = dismissTipClick
        )

    override fun onBindViewHolder(holder: TipsViewHolder, position: Int) =
        holder.bind(getItem(position))

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Tip>() {
            override fun areItemsTheSame(
                oldItem: Tip,
                newItem: Tip
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: Tip,
                newItem: Tip
            ) = oldItem == newItem
        }
    }
}