package com.xiaofu.subject.infra.basic.es;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author xiaofu
 * @date 2024/1/25 1:10
 * @des
 */
@Data
public class EsIndexInfo implements Serializable {

    private String docId;

    private Map<String, Object> data;

}
