/**
 * 
 */
package com.atguigu.crowd.test;

import org.junit.Test;

import com.atguigu.crowd.util.CrowdUtil;

/**
 * @ClassName: StringTest
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年8月31日 下午11:30:52
 * @param:
 */
public class StringTest {
    @Test
    public void testMd5() {
        String source = "123123";
        String md5 = CrowdUtil.md5(source);
        System.out.println(md5);
    }
}
