package tmidev.concatadapter.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tmidev.concatadapter.databinding.ItemTipBinding
import tmidev.concatadapter.domain.Tip
import tmidev.concatadapter.util.DismissTipClick

class TipsViewHolder(
    private val binding: ItemTipBinding,
    private val dismissTipClick: DismissTipClick
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(tip: Tip) = binding.run {
        textViewTipId.text = tip.id.toString()
        textViewTipDescription.text = tip.description

        textViewGotIt.setOnClickListener {
            dismissTipClick(bindingAdapterPosition)
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            dismissTipClick: DismissTipClick
        ): TipsViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemBinding = ItemTipBinding.inflate(inflater, parent, false)
            return TipsViewHolder(
                binding = itemBinding,
                dismissTipClick = dismissTipClick
            )
        }
    }
}