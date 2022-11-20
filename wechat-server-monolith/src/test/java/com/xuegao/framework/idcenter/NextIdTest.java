package com.xuegao.framework.idcenter;

import com.xuegao.idcenter.XuegaoIdGeneratorLoader;
import org.junit.Test;

public class NextIdTest {

    @Test
    public void nextId() {
        System.out.println(XuegaoIdGeneratorLoader.getIdGenerator().nextId());
        System.out.println(XuegaoIdGeneratorLoader.getIdGenerator().nextId());
        System.out.println(XuegaoIdGeneratorLoader.getIdGenerator().nextId());

        // 11661233800413248
        // 11661233802707008
        // 11661233802707009

        // 11661235572441152
        // 11661235572768832
        // 11661235572834368

    }
}
