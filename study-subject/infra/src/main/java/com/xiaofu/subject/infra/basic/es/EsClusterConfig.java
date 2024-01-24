package com.xiaofu.subject.infra.basic.es;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiaofu
 * @date 2024/1/25 1:10
 * @des
 */
@Data
public class EsClusterConfig implements Serializable {

    /**
     * 集群名称
     */
    private String name;

    /**
     * 集群节点
     */
    private String nodes;

}
