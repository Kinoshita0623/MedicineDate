package jp.panta.medicinedate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import jp.panta.medicinedate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        val viewModel = ViewModelProvider(this, MainViewModel.Factory())[MainViewModel::class.java]
        binding.viewModel = viewModel

        binding.startDayButton.setOnClickListener {
            showStartDatePickerDialog()
        }
        binding.endDate.setOnClickListener {
            showStartDatePickerDialog()

        }
    }

    private fun showStartDatePickerDialog(){
        StartDatePickerDialog().show(supportFragmentManager, "DatePicker")
    }
}
