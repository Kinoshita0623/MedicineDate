package jp.panta.medicinedate

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

object DateFormatHelper {

    @BindingAdapter("date")
    @JvmStatic
    fun TextView.showDate(date: Date?){
        date?: return

        this.text = SimpleDateFormat("yyyy/MM/dd(E)", Locale.JAPAN).format(date)
    }
}