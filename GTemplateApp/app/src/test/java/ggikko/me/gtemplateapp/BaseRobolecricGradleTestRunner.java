package ggikko.me.gtemplateapp;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricGradleTestRunner;

/**
 * Created by hyunwoopark on 2016. 4. 8..
 */
public class BaseRobolecricGradleTestRunner extends RobolectricGradleTestRunner {
    public BaseRobolecricGradleTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }
}
