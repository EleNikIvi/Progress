package com.eugene.progress

import android.app.Application
import com.eugene.progress.ui.main.MainContract
import com.eugene.progress.ui.main.MainInteractor
import com.eugene.progress.ui.main.MainPresenter
import com.eugene.progress.ui.main.day.MainDayContract
import com.eugene.progress.ui.main.day.MainDayInteractor
import com.eugene.progress.ui.main.day.MainDayPresenter
import com.eugene.progress.ui.main.month.MainMonthContract
import com.eugene.progress.ui.main.month.MainMonthInteractor
import com.eugene.progress.ui.main.month.MainMonthPresenter
import com.eugene.progress.ui.main.week.MainWeekContract
import com.eugene.progress.ui.main.week.MainWeekInteractor
import com.eugene.progress.ui.main.week.MainWeekPresenter
import com.eugene.progress.ui.main.year.MainYearContract
import com.eugene.progress.ui.main.year.MainYearInteractor
import com.eugene.progress.ui.main.year.MainYearPresenter
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(
            this,
            listOf(mainModule, mainDayModule, mainWeekModule, mainMonthModule, mainYearModule)
        )
    }


    private val mainModule = module {
        single<MainContract.Presenter> { MainPresenter(get()) }
        single<MainContract.Interactor> { MainInteractor() }
    }

    private val mainDayModule = module {
        single<MainDayContract.Presenter> { MainDayPresenter(get()) }
        single<MainDayContract.Interactor> { MainDayInteractor() }
    }

    private val mainWeekModule = module {
        single<MainWeekContract.Presenter> { MainWeekPresenter(get()) }
        single<MainWeekContract.Interactor> { MainWeekInteractor() }
    }

    private val mainMonthModule = module {
        single<MainMonthContract.Presenter> { MainMonthPresenter(get()) }
        single<MainMonthContract.Interactor> { MainMonthInteractor() }
    }

    private val mainYearModule = module {
        single<MainYearContract.Presenter> { MainYearPresenter(get()) }
        single<MainYearContract.Interactor> { MainYearInteractor() }
    }
}
