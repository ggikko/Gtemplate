package ggikko.me.gtemplateapp.ui;

import android.content.Context;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import ggikko.me.gtemplateapp.BaseRobolecricGradleTestRunner;
import ggikko.me.gtemplateapp.BuildConfig;
import ggikko.me.gtemplateapp.TestApplication;

@RunWith(BaseRobolecricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = TestApplication.class)
@Ignore
public class BaseTestSupport {
    protected Context getContext() {
        return RuntimeEnvironment.application;
    }

    protected TestApplication getApplication() {
        final Context context = getContext();
        return (TestApplication) context;
    }

    protected String getString(int resourceId) {
        return getContext().getString(resourceId);
    }

}
