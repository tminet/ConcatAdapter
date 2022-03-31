package tmidev.concatadapter.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import dagger.hilt.android.AndroidEntryPoint
import tmidev.concatadapter.R
import tmidev.concatadapter.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private lateinit var tipsAdapter: TipsAdapter
    private lateinit var programmingLanguagesAdapter: ProgrammingLanguagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = getString(R.string.appName)

        setupAdapters()
        setListeners()
    }

    private fun setupAdapters() {
        tipsAdapter = TipsAdapter { position ->
            dismissTip(position = position)
        }

        programmingLanguagesAdapter = ProgrammingLanguagesAdapter()

        binding.recyclerView.adapter = ConcatAdapter(tipsAdapter, programmingLanguagesAdapter)

        tipsAdapter.submitList(viewModel.getTipList())
        programmingLanguagesAdapter.submitList(viewModel.getProgrammingLanguageList())
    }

    private fun setListeners() = binding.run {
        fabAddTip.setOnClickListener {
            val newList = viewModel.addTip()
            tipsAdapter.submitList(newList)
            recyclerView.smoothScrollToPosition(newList.size - 1)
        }
    }

    private fun dismissTip(position: Int) {
        val newList = viewModel.removeTip(position = position)
        tipsAdapter.submitList(newList)
    }
}