package sample

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import sample.interfaces.DateView

class CommonPresenter(private val view: DateView) {

    private val repo = TestRepo.getRepo()

    fun refresh() {
        val state = CommonState(
            text = dateUtilities.platformDate.getCurrentDate()
        )
        view.showState(state)
    }

    fun startRequest() = GlobalScope.launch {
        val json = repo.getRecipe()
        withContext(Dispatchers.Main) {
            view.showRequest(CommonState(json))
        }
    }

    fun getContacts() = GlobalScope.launch {
        val contacts = repo.getContacts()
        withContext(Dispatchers.Main) {
            view.onApiResult(contacts)
        }
    }
}