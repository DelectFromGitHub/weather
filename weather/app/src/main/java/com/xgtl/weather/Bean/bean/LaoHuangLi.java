package com.xgtl.weather.Bean.bean;

public class LaoHuangLi {

    /**
     * reason : successed
     * result : {"id":"3583","yangli":"2020-01-13","yinli":"己亥(猪)年十二月十九","wuxing":"大溪水 满执位","chongsha":"冲鸡(己酉)煞西","baiji":"乙不栽植千株不长 卯不穿井水泉不香","jishen":"天德合 月德合 天巫 四相 天仓 民日 天德 五合 金堂 宝光 鸣犬对","yi":"嫁娶 订盟 纳采 祭祀 祈福 求嗣 会亲友 解除 出行 入学 纳财 开市 交易 立券 习艺 经络 安床 开仓 出货财 纳畜 安葬 启钻 修坟 入殓","xiongshen":"灾煞 天火 地曩","ji":"入宅 开光 开市 动土"}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * id : 3583
         * yangli : 2020-01-13
         * yinli : 己亥(猪)年十二月十九
         * wuxing : 大溪水 满执位
         * chongsha : 冲鸡(己酉)煞西
         * baiji : 乙不栽植千株不长 卯不穿井水泉不香
         * jishen : 天德合 月德合 天巫 四相 天仓 民日 天德 五合 金堂 宝光 鸣犬对
         * yi : 嫁娶 订盟 纳采 祭祀 祈福 求嗣 会亲友 解除 出行 入学 纳财 开市 交易 立券 习艺 经络 安床 开仓 出货财 纳畜 安葬 启钻 修坟 入殓
         * xiongshen : 灾煞 天火 地曩
         * ji : 入宅 开光 开市 动土
         */

        private String id;
        private String yangli;
        private String yinli;
        private String wuxing;
        private String chongsha;
        private String baiji;
        private String jishen;
        private String yi;
        private String xiongshen;
        private String ji;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getYangli() {
            return yangli;
        }

        public void setYangli(String yangli) {
            this.yangli = yangli;
        }

        public String getYinli() {
            return yinli;
        }

        public void setYinli(String yinli) {
            this.yinli = yinli;
        }

        public String getWuxing() {
            return wuxing;
        }

        public void setWuxing(String wuxing) {
            this.wuxing = wuxing;
        }

        public String getChongsha() {
            return chongsha;
        }

        public void setChongsha(String chongsha) {
            this.chongsha = chongsha;
        }

        public String getBaiji() {
            return baiji;
        }

        public void setBaiji(String baiji) {
            this.baiji = baiji;
        }

        public String getJishen() {
            return jishen;
        }

        public void setJishen(String jishen) {
            this.jishen = jishen;
        }

        public String getYi() {
            return yi;
        }

        public void setYi(String yi) {
            this.yi = yi;
        }

        public String getXiongshen() {
            return xiongshen;
        }

        public void setXiongshen(String xiongshen) {
            this.xiongshen = xiongshen;
        }

        public String getJi() {
            return ji;
        }

        public void setJi(String ji) {
            this.ji = ji;
        }
    }
}
