package sample.interfaces

import sample.CommonState

interface DateView {
    fun showState(state: CommonState)

    fun showRequest(message: CommonState)

    fun <T> onApiResult(result: T)
}