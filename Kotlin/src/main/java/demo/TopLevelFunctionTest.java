package demo;

import demo.singleton.HelperKt;
import demo.singleton.UtilA;
import demo.singleton.UtilB;
import demo.singleton.UtilC;

public class TopLevelFunctionTest {
    public static void main(String[] strings) {
        HelperKt.topLevelFunction();

        UtilA.INSTANCE.doObjectAction();

        UtilB.Companion.doCompanionAction();

        UtilC.doJvmStaticAction();
    }
}
