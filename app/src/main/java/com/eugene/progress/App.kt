package com.eugene.progress

import android.app.Application
import com.eugene.progress.ui.main.MainContract
import com.eugene.progress.ui.main.MainInteractor
import com.eugene.progress.ui.main.MainPresenter
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(
            this,
            listOf(mainModule)
        )
    }

    private val mainModule = module {
        single<MainContract.Presenter> { MainPresenter(get()) }
        single<MainContract.Interactor> { MainInteractor() }
    }
}
