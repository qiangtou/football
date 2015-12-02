package com.qiangtou.web;

import com.qiangtou.vo.WxVerify;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2015/12/1.
 */
@Controller
public class IndexController {
    private static Logger logger=Logger.getLogger(IndexController.class);

    @RequestMapping("index.do")
    @ResponseBody
    public String index() {
        logger.info("ok");
        return "ok";
    }
    @RequestMapping("verify")
    @ResponseBody
    public String verify(@ModelAttribute WxVerify verify) {
        logger.info("ok"+verify);
        return verify.verify()?verify.getEchostr():"false";
    }
}
