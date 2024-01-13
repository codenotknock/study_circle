package com.xiaofu.subject.domain.handler.subject;

import com.xiaofu.subject.common.enums.SubjectInfoTypeEnum;
import com.xiaofu.subject.domain.handler.SubjectTypeHandler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author xiaofu
 * @date 2024/1/13 18:31
 * @des  题目类型工厂
 */

@Component
public class SubjectTypeHandlerFactory implements InitializingBean {

    @Autowired
    private List<SubjectTypeHandler> subjectTypeHandlerList;

    private Map<SubjectInfoTypeEnum, SubjectTypeHandler> handlerMap = new HashMap<>();


    public SubjectTypeHandler getHandler(int subjectType) {
        SubjectInfoTypeEnum subjectInfoTypeEnum = SubjectInfoTypeEnum.getByCode(subjectType);
        if (Objects.nonNull(subjectInfoTypeEnum)) {
            return handlerMap.get(subjectInfoTypeEnum);
        }
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (SubjectTypeHandler subjectTypeHandler : subjectTypeHandlerList) {
            handlerMap.put(subjectTypeHandler.getHandlerType(), subjectTypeHandler);
        }
    }
}
