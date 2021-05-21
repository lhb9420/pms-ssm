package com.util.jsonClass;

public class EchartsCategoryData {
    private String product;
    private Integer 实到;
    private Integer 应到;
    private Integer 缺勤;

    public EchartsCategoryData(String product, Integer 实到, Integer 应到, Integer 缺勤) {
        this.product = product;
        this.实到 = 实到;
        this.应到 = 应到;
        this.缺勤 = 缺勤;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer get实到() {
        return 实到;
    }

    public void set实到(Integer 实到) {
        this.实到 = 实到;
    }

    public Integer get应到() {
        return 应到;
    }

    public void set应到(Integer 应到) {
        this.应到 = 应到;
    }

    public Integer get缺勤() {
        return 缺勤;
    }

    public void set缺勤(Integer 缺勤) {
        this.缺勤 = 缺勤;
    }
}
