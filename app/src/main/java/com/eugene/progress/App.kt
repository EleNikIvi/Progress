package com.eugene.progress

import android.app.Application
import com.eugene.progress.domain.service.TimeService
import com.eugene.progress.domain.service.TimeServiceContract
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
import com.eugene.progress.ui.settings.SettingsContract
import com.eugene.progress.ui.settings.SettingsInteractor
import com.eugene.progress.ui.settings.SettingsPresenter
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(
            this,
            listOf(
                domainModule,
                mainModule, mainDayModule, mainWeekModule, mainMonthModule, mainYearModule,
                settingsModule
            )
        )
    }

    private val domainModule = module {
        factory<TimeServiceContract> { TimeService() }
    }

    private val mainModule = module {
        factory<MainContract.Presenter> { MainPresenter(get()) }
        factory<MainContract.Interactor> { MainInteractor() }
    }

    private val mainDayModule = module {
        factory<MainDayContract.Presenter> { MainDayPresenter(get()) }
        factory<MainDayContract.Interactor> { MainDayInteractor(get()) }
    }

    private val mainWeekModule = module {
        factory<MainWeekContract.Presenter> { MainWeekPresenter(get()) }
        factory<MainWeekContract.Interactor> { MainWeekInteractor(get()) }
    }

    private val mainMonthModule = module {
        factory<MainMonthContract.Presenter> { MainMonthPresenter(get()) }
        factory<MainMonthContract.Interactor> { MainMonthInteractor(get()) }
    }

    private val mainYearModule = module {
        factory<MainYearContract.Presenter> { MainYearPresenter(get()) }
        factory<MainYearContract.Interactor> { MainYearInteractor(get()) }
    }

    private val settingsModule = module {
        factory<SettingsContract.Presenter> { SettingsPresenter(get()) }
        factory<SettingsContract.Interactor> { SettingsInteractor() }
    }
}
