package cn.fxbin.apitest

import org.junit.Test

/**
 * JunitCase
 *
 * @author fxbin* @version v1.0* @since 2019/12/4 19:19
 */
class JunitCase {

    @Test
    void testFunction() {
        ResumeClient resumeClient= new ResumeClient()
        resumeClient.getResumeDetails2()
        println "--phone information is:    "  + resumeClient.getResumeDetails3()
        println "--phone information is:    "  + resumeClient.getResumeDetailHeader()
    }

}
