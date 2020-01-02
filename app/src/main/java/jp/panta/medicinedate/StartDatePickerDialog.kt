package jp.panta.medicinedate

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import java.util.*

class StartDatePickerDialog : DialogFragment(),  DatePickerDialog.OnDateSetListener{

    private var mViewModel: MainViewModel? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val viewModel= ViewModelProvider(activity!!, MainViewModel.Factory())[MainViewModel::class.java]
        mViewModel = viewModel
        val calendar = Calendar.getInstance().apply{
            time = viewModel.startDate.value?: Date()
        }
        return DatePickerDialog(activity!!, this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
    }
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val startDate = Calendar.getInstance().apply{
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, month)
            set(Calendar.DAY_OF_MONTH, dayOfMonth)

        }.time

        mViewModel?.startDate?.value = startDate
    }
}