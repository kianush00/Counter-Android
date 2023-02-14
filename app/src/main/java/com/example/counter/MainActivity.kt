package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCount()

        binding.btnSum.setOnClickListener {
            count++
            setCount()
        }

        binding.btnSum.setOnLongClickListener {
            count = 0
            setCount()
            true
        }

        Log.i("LifeCycle", "onCreate")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LifeCycle", "onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.i("LifeCycle", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("LifeCycle", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("LifeCycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LifeCycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifeCycle", "onDestroy")
        Toast.makeText(this, "La aplicación ha finalizado.", Toast.LENGTH_SHORT).show()
    }

    private fun setCount() {
        binding.tvCount.text = count.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putInt(PARAM_COUNT, count)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        count = savedInstanceState.getInt(PARAM_COUNT)
        setCount()
        super.onRestoreInstanceState(savedInstanceState)
    }

    companion object {
        private const val PARAM_COUNT: String = "param_count"
    }
}