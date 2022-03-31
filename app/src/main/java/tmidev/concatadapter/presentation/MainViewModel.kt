package tmidev.concatadapter.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import tmidev.concatadapter.domain.ProgrammingLanguage
import tmidev.concatadapter.domain.Tip
import tmidev.concatadapter.util.Factory
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private var tipList = Factory.createTipList()
    private var programmingLanguageList = Factory.createProgrammingLanguageList()

    fun getTipList(): List<Tip> = tipList

    fun getProgrammingLanguageList(): List<ProgrammingLanguage> = programmingLanguageList

    fun addTip(): List<Tip> {
        val currentLastIndex = tipList.lastIndex
        val newLastIndex = if (currentLastIndex >= 0) tipList[currentLastIndex].id + 1 else 1
        tipList = tipList.toMutableList().apply {
            val newTip = Tip(
                id = newLastIndex,
                description = "This is a new test tip ($newLastIndex) added"
            )
            add(newTip)
        }
        return tipList
    }

    fun removeTip(position: Int): List<Tip> {
        tipList = tipList.toMutableList().apply {
            removeAt(position)
        }
        return tipList
    }
}