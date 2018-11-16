package com.cloud.jsproducermanage.entity;

import java.io.Serializable;

/**
 * (Financialtypelist)实体类
 *
 * @author makejava
 * @since 2018-11-10 08:53:04
 */
public class Financialtypelist implements Serializable {
    private static final long serialVersionUID = 519728601051840491L;
    //理财种类表ID
    private Integer financialtypelistId;
    //理财种类名称
    private String financialtypelistName;


    public Integer getFinancialtypelistId() {
        return financialtypelistId;
    }

    public void setFinancialtypelistId(Integer financialtypelistId) {
        this.financialtypelistId = financialtypelistId;
    }

    public String getFinancialtypelistName() {
        return financialtypelistName;
    }

    public void setFinancialtypelistName(String financialtypelistName) {
        this.financialtypelistName = financialtypelistName;
    }

}