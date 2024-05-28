package kz.tutorial.nedid

import android.app.Application
import kz.tutorial.nedid.di.mapperModule
import kz.tutorial.nedid.di.networkModule
import kz.tutorial.nedid.di.repositoryModule
import kz.tutorial.nedid.di.useCaseModule
import kz.tutorial.nedid.di.viewModelModule
import org.koin.core.context.startKoin
import timber.log.Timber

class TutorialApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initDI()
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun initDI() {
        startKoin {
            modules(networkModule, viewModelModule, repositoryModule, useCaseModule, mapperModule)
        }
    }
}
