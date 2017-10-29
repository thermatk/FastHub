package com.fastaccess.ui.modules.main.premium

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import butterknife.BindView
import butterknife.OnClick
import com.fastaccess.R
import com.fastaccess.helper.*
import com.fastaccess.ui.base.BaseActivity
import com.fastaccess.ui.base.mvp.presenter.BasePresenter
import com.fastaccess.ui.modules.repos.RepoPagerActivity

/**
 * Created by kosh on 13/07/2017.
 */
class PremiumActivity : BaseActivity<PremiumMvp.View, BasePresenter<PremiumMvp.View>>(), PremiumMvp.View {
    @BindView(R.id.cardsHolder) lateinit var cardsHolder: View

    override fun layout(): Int = R.layout.support_development_layout

    override fun isTransparent(): Boolean = true

    override fun providePresenter(): BasePresenter<PremiumMvp.View> = BasePresenter<PremiumMvp.View>()

    override fun canBack(): Boolean = true

    override fun isSecured(): Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AnimHelper.animateVisibility(cardsHolder, true)
    }

    @OnClick(R.id.two) fun onBuyAll() {
        PrefGetter.setProItems()
        PrefGetter.setEnterpriseItem()
        showMessage(getString(R.string.success), "\"Pro\" features unlocked, but don't forget to support development!")
        successResult()
    }

    @OnClick(R.id.five) fun onShowUpstreamSupport() {
        startActivity(RepoPagerActivity.createIntent(this, "FastHub", "k0shk0sh"))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            successResult()
        }
    }

    private fun successResult() {
        hideProgress()
        setResult(Activity.RESULT_OK)
        finish()
    }

    override fun onSuccessfullyActivated() {
        hideProgress()
        showMessage(R.string.success, R.string.success)
        successResult()
    }

    override fun onNoMatch() {
        hideProgress()
        showErrorMessage(getString(R.string.not_match))
    }

    private fun isGoogleSupported(): Boolean {
        if (AppHelper.isGoogleAvailable(this)) {
            return true
        }
        showErrorMessage(getString(R.string.google_play_service_error))
        return false
    }

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, PremiumActivity::class.java))
        }
    }
}