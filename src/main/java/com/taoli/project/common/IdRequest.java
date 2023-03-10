package com.taoli.project.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 删除请求
 *
 * @author taoli
 */
@Data
public class IdRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}