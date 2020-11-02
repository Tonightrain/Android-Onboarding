package com.example.hello.kotlinCoroutines

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.hello.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit
import java.util.function.Consumer
import java.util.function.Predicate


class RxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx2)

        //做法1 使用runONUiThread
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


        //做法2 使用Dispatchers.Main
//        val buttonTiming = findViewById<Button>(R.id.button_rx)
//        buttonTiming.setOnClickListener {
//            var count = 0
//            GlobalScope.launch(Dispatchers.Main) {
//                Log.d("RxActivity", "Thread:${Thread.currentThread().name}")
//                repeat(11) {
//                    buttonTiming.isEnabled = count == 10
//                    buttonTiming.text = "The number is $count"
//                    count++
//                    delay(1000)
//                }
//            }
//        }


        //做法三 使用Observable 数组流
//        val buttonTiming = findViewById<Button>(R.id.button_rx)
//
//        buttonTiming.setOnClickListener {
//            val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//            GlobalScope.launch {
//                list.toObservable()
//                    .subscribeBy(
//                        onNext = {
//                            runBlocking {
//                                runOnUiThread { buttonTiming.isEnabled = it == 10 }
//                                buttonTiming.text = "The number is $it"
//                                delay(1000L)
//
//                            }
//                        },
//                        onError = { it.printStackTrace() },
//                        onComplete = { println("Done") }
//                    )
//            }
//        }

        //做法四 使用Observable.interval 时间流 takeWhile initialDelay it observeOn subscribeOn
        val buttonTiming = findViewById<Button>(R.id.button_rx)
        buttonTiming.setOnClickListener {
            Observable.interval(0, 1000L, TimeUnit.MILLISECONDS)
                .timeInterval()
                .takeWhile {
                    it.value() < 11
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    buttonTiming.text = "The number is ${it.value()}"
                    buttonTiming.isEnabled = it.value() == 10L
                }
        }

//        val buttonTiming = findViewById<Button>(R.id.button_rx)
//        val letters = arrayOf("1", "2", "3", "4", "5", "6", "7")
//        val observable: Observable<String> = Observable.from(letters)
//        observable.subscribe(
//            { i: String ->
//                buttonTiming.text = "The number is $i"
//            },
//            { obj: Throwable -> obj.printStackTrace() },
//            {  println("Done")}
//        )
    }
}

