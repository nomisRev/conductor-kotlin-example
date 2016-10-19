package be.vergauwen.simon.conductor

import android.os.Build
import android.support.design.widget.AppBarLayout
import android.view.View
import be.vergauwen.simon.common.di.anko.actionBarSize
import be.vergauwen.simon.common.di.anko.changeHandlerFrameLayout
import be.vergauwen.simon.common.di.anko.color
import be.vergauwen.simon.common.ui.layout.LayoutInjector
import org.jetbrains.anko.UI
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.matchParent

class MainLayout : LayoutInjector<MainActivity> {
    override fun injectLayout(detailView: MainActivity): View {
        return detailView.UI {
            coordinatorLayout {
                fitsSystemWindows = true

                appBarLayout {
                    toolbar {
                        popupTheme = R.style.AppTheme_PopupOverlay
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) elevation = 4f
                        setTitleTextColor(color(android.R.color.white))
                        detailView.setSupportActionBar(this)
                    }.lparams(width = matchParent, height = actionBarSize())
                }.lparams(width = matchParent)

                detailView.container = changeHandlerFrameLayout {
                }.lparams(width = matchParent, height = matchParent) {
                    behavior = AppBarLayout.ScrollingViewBehavior()
                }
            }
        }.view
    }
}