package tmidev.concatadapter.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import tmidev.concatadapter.domain.ProgrammingLanguage

class ProgrammingLanguagesAdapter :
    ListAdapter<ProgrammingLanguage, ProgrammingLanguagesViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProgrammingLanguagesViewHolder.create(parent = parent)

    override fun onBindViewHolder(holder: ProgrammingLanguagesViewHolder, position: Int) =
        holder.bind(getItem(position))

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<ProgrammingLanguage>() {
            override fun areItemsTheSame(
                oldItem: ProgrammingLanguage,
                newItem: ProgrammingLanguage
            ) = oldItem.name == newItem.name

            override fun areContentsTheSame(
                oldItem: ProgrammingLanguage,
                newItem: ProgrammingLanguage
            ) = oldItem == newItem
        }
    }
}