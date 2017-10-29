package com.fastaccess.ui.modules.main.donation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.view.View;

import com.fastaccess.R;
import com.fastaccess.helper.AnimHelper;
import com.fastaccess.helper.PrefGetter;
import com.fastaccess.ui.base.BaseActivity;
import com.fastaccess.ui.base.mvp.presenter.BasePresenter;
import com.fastaccess.ui.modules.repos.RepoPagerActivity;

import net.grandcentrix.thirtyinch.TiPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Kosh on 24 Mar 2017, 9:16 PM
 */

public class DonationActivity extends BaseActivity {
    @BindView(R.id.cardsHolder) View cardsHolder;
    @BindView(R.id.appbar) AppBarLayout appBarLayout;

    @Override protected int layout() {
        return R.layout.support_development_layout;
    }

    @Override protected boolean isTransparent() {
        return false;
    }

    @Override protected boolean canBack() {
        return true;
    }

    @Override protected boolean isSecured() {
        return true;
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AnimHelper.animateVisibility(cardsHolder, true);
    }

    @OnClick(R.id.two) void onTwoClicked(View v) {
        PrefGetter.setProItems();
        PrefGetter.setEnterpriseItem();
        showMessage(getString(R.string.success), "\"Pro\" features unlocked, but don't forget to support development!");
    }

    @OnClick(R.id.five) void onFiveClicked(View v) {
        startActivity(RepoPagerActivity.createIntent(this, "FastHub", "k0shk0sh"));
    }

    @NonNull @Override public TiPresenter providePresenter() {
        return new BasePresenter();
    }
}
