package tmidev.concatadapter.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tmidev.concatadapter.databinding.ItemProgrammingLanguageBinding
import tmidev.concatadapter.domain.ProgrammingLanguage

class ProgrammingLanguagesViewHolder(
    private val binding: ItemProgrammingLanguageBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(programmingLanguage: ProgrammingLanguage) = binding.run {
        textViewName.text = programmingLanguage.name
        textViewDescription.text = programmingLanguage.description
        imageViewLogo.setImageResource(programmingLanguage.logo)
    }

    companion object {
        fun create(parent: ViewGroup): ProgrammingLanguagesViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemBinding = ItemProgrammingLanguageBinding.inflate(inflater, parent, false)
            return ProgrammingLanguagesViewHolder(binding = itemBinding)
        }
    }
}