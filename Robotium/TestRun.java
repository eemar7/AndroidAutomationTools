import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;


import com.robotium.solo.Solo;


@SuppressWarnings("unchecked")
public class TestRun extends ActivityInstrumentationTestCase2 {
        private static final String TARGET_PACKAGE_ID = "com.pinterest";
        private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.pinterest.activity.PinterestActivity";
        private static Class<?> launcherActivityClass;
        static {
                try {
                        launcherActivityClass = Class
                                        .forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
                } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                }
        }


        @SuppressWarnings("unchecked")
        public TestRun() throws ClassNotFoundException {
                super(launcherActivityClass);
        }


        private Solo solo;


        @Override
        protected void setUp() throws Exception {
                solo = new Solo(getInstrumentation(), getActivity());
        }


        public void testDemo() {
                solo.sleep(10000);
                Log.d("Appurify", "This is a bootstrap"); 
                solo.sleep(10000);
        }


        @Override
        public void tearDown() throws Exception {
                try {
                        solo.finalize();
                } catch (Throwable e) {
                        e.printStackTrace();
                }
                getActivity().finish();
                super.tearDown();
        }


}
