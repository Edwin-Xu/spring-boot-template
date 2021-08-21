package cn.edw.boottemplate.controller;

import cn.edw.boottemplate.common.utils.R;
import cn.edw.boottemplate.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author taoxu.xu
 * @date 8/21/2021 7:44 PM
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/hi/{name}")
    public R hi(@PathVariable("name") String name){
        final String hi = demoService.hi(name);
        return R.ok().setData(hi);
    }
}
