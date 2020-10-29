package com.example.hello.kotlinCoroutines

import android.os.Bundle
import android.os.SystemClock
import android.transition.TransitionInflater.from
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.hello.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.internal.util.HalfSerializer.onNext
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.kotlin.toObservable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class RxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx2)
//
//        val buttonTiming = findViewById<Button>(R.id.button_rx)
//        buttonTiming.setOnClickListener {
//            var count = 0
//            GlobalScope.launch {
//                repeat(11) {
//                    if (count == 10) {
//                        setIsEnabled(buttonTiming,true)
//                    }else{
//                        setIsEnabled(buttonTiming,false)
//                    }
//                    setText(buttonTiming, "The number is $count")
//                    count++
//                    delay(1000)
//                }
//            }
//        }
//    }
//
//    private fun setText(text: TextView, value: String) {
//        runOnUiThread { text.text = value }
//    }
//
//    private fun setIsEnabled(text: TextView,isButtonEnable:Boolean){
//        runOnUiThread { text.isEnabled = isButtonEnable }
//    }

//        val buttonTiming = findViewById<Button>(R.id.button_rx)
//        buttonTiming.setOnClickListener {
//            var count = 0
//            GlobalScope.launch(Dispatchers.Main) {
//                repeat(11) {
//                    buttonTiming.isEnabled = count == 10
//                    buttonTiming.text = "The number is $count"
//                    count++
//                    delay(1000)
//                }
//            }
//        }


        val buttonTiming = findViewById<Button>(R.id.button_rx)
        buttonTiming.setOnClickListener {
            val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

            list.toObservable()
                .subscribeBy(
                    onNext = {
                        GlobalScope.launch(Dispatchers.Main) {
                            buttonTiming.text = "The number is $it"
                            delay(1000L)
                        }
                    },
                    onError = { it.printStackTrace() },
                    onComplete = { println("Done") }
                )
        }


//        val buttonTiming = findViewById<Button>(R.id.button_rx)
//        val letters = arrayOf("1", "2", "3", "4", "5", "6", "7")
//        val observable: Observable<String> = Observable.from(letters)
//        observable.subscribe(
//            { i: String ->
//                buttonTiming.text = "The number is $i"
//                SystemClock.sleep(1000)
//            },
//            { obj: Throwable -> obj.printStackTrace() },
//            {  println("Done")}
//        )


//        val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
//
//        list.toObservable() // extension function for Iterables
//            .filter { it.length >= 5 }
//            .subscribeBy(  // named arguments for lambda Subscribers
//                onNext = { println(it) },
//                onError =  { it.printStackTrace() },
//                onComplete = { println("Done!") }
//            )


    }
}

