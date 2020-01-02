package jp.panta.medicinedate

import androidx.lifecycle.*
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.util.*

class MainViewModel : ViewModel(){

    @Suppress("UNCHECKED_CAST")
    class Factory : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass == MainViewModel::class.java){
                return MainViewModel() as T
            }
            throw IllegalArgumentException("use MainViewModel::class.java")
        }
    }


    val inputDaysLeft = MutableLiveData<String>()

    val startDate = MutableLiveData<Date>().apply{
        value = Date()
    }
    val lastDate = MediatorLiveData<Date>()

    init{
        lastDate.addSource(inputDaysLeft){
            try{
                val start = startDate.value?: Date()
                val leftDays = Integer.parseInt(it)
                lastDate.value = evaLastDate(start, leftDays)
            }catch(e: NumberFormatException){

            }
        }

        lastDate.addSource(startDate){
            try{
                val daysLeft = Integer.parseInt(inputDaysLeft.value?: "")
                lastDate.value = evaLastDate(it, daysLeft)
                            }catch(e: NumberFormatException){

            }
        }

    }
    private fun evaLastDate(start: Date, count: Int): Date{
        val calendar = Calendar.getInstance()
        calendar.time = start
        calendar.add(Calendar.DATE, count)
        return calendar.time
    }

}