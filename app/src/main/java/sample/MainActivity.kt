package sample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.TickerMode
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import sample.databinding.ActivityMainBinding
import sample.interfaces.DateView
import sample.models.Contacts


class MainActivity : AppCompatActivity(), DateView {

    private val presenter = CommonPresenter(this)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Sample().checkMe()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //setContentView(R.layout.activity_main)
//        findViewById<TextView>(R.id.main_text).text = hello()
//        Timer().schedule(object : TimerTask() {
//            override fun run() {
//                presenter.refresh()
//            }
//
//        }, 1000, 1000)


        refreshTime()
        presenter.startRequest()
        binding.btnShowContacts.setOnClickListener { presenter.getContacts() }
    }

    private fun refreshTime() = GlobalScope.launch {
        @Suppress("EXPERIMENTAL_API_USAGE")
        val ticker =
            ticker(delayMillis = 1000, initialDelayMillis = 0, mode = TickerMode.FIXED_PERIOD)
        for (event in ticker) {
            withContext(Dispatchers.Main) {
                presenter.refresh()
            }
        }
    }

    override fun showState(state: CommonState) {
        binding.mainText.text = state.text
    }

    override fun showRequest(message: CommonState) {
        Toast.makeText(applicationContext, message.text, Toast.LENGTH_LONG).show()
    }

    override fun <T> onApiResult(result: T) {
        if(result is Contacts) {
            binding.textContacts.text = result.toString()
        }
    }
}