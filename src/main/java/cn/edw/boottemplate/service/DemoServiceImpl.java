package cn.edw.boottemplate.service;

import cn.edw.boottemplate.common.utils.RRException;
import org.springframework.stereotype.Service;

/**
 * @author taoxu.xu
 * @date 8/21/2021 7:45 PM
 */
@Service
public class DemoServiceImpl implements DemoService{
    @Override
    public String hi(String name) {
        if (name == null || name.isEmpty()||"edw".equals(name)){
            throw new RRException("name is invalid");
        }
        return "hi";
    }
}
