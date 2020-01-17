package com.xgtl.weather.Bean.bean;

import java.util.List;

public class History {

    /**
     * code : 1
     * data : [{"id":402,"title":"北宋设置榷场与西夏进行贸易","year":"1045"},{"id":403,"title":"英国天文学家哈雷逝世","year":"1742"},{"id":404,"title":"英国外交官阿美士德出生","year":"1773"},{"id":405,"title":"美国独立战争正式结束","year":"1784"},{"id":406,"title":"世界著名和平战士爱伦堡诞生","year":"1894"},{"id":407,"title":"秋瑾创办《中国女报》","year":"1907"},{"id":408,"title":"荷兰须德海水坝崩溃，造成洪水泛滥","year":"1916"},{"id":409,"title":"日本作家三岛由纪夫出生","year":"1925"},{"id":410,"title":"意大利机队完成了首次结队飞越大西洋的壮举","year":"1931"},{"id":411,"title":"新疆军阀盛世才清洗异已，杀300多人","year":"1938"},{"id":412,"title":"玛格丽特二世登基 丹麦历史上第二位女君主诞生","year":"1940"},{"id":413,"title":"美国女演员菲·唐娜薇出生","year":"1941"},{"id":414,"title":"卡萨布兰卡会议在摩洛哥举行","year":"1943"},{"id":415,"title":"苏军在列宁格勒和诺夫哥罗德转入进攻","year":"1944"},{"id":416,"title":"日本作家绿川英子逝世","year":"1947"},{"id":417,"title":"抽象艺术派画家勃纳尔逝世","year":"1947"},{"id":418,"title":"电影《一江春水向东流》创中国电影卖座最高纪录","year":"1948"},{"id":419,"title":"毛泽东发表时局声明","year":"1949"},{"id":420,"title":"铁托担任南斯拉夫联邦共和国总统和武装部队最高统帅","year":"1953"},{"id":421,"title":"知识分子已是工人阶级的一部分","year":"1956"},{"id":422,"title":"美国演员亨弗莱·鲍嘉逝世","year":"1957"},{"id":423,"title":"国际业余田径联合会接受郑凤荣跳高世界纪录","year":"1958"},{"id":424,"title":"人类第一次下潜到马里亚纳海沟的底部","year":"1960"},{"id":425,"title":"中共八届九中全会在北京举行","year":"1961"},{"id":426,"title":"美国导演斯蒂文·索德伯格出生","year":"1963"},{"id":427,"title":"法国禁止英国进入欧洲共同市场","year":"1963"},{"id":428,"title":"中共中央开展\u201c四清\u201d运动","year":"1965"},{"id":429,"title":"丹麦国王腓特烈九世逝世，玛格丽特二世继位","year":"1972"},{"id":430,"title":"数学家、逻辑学家哥德尔逝世","year":"1978"},{"id":431,"title":"《足球世界》杂志创刊","year":"1980"},{"id":432,"title":"匈牙利爆发特大足球彩票丑闻","year":"1983"},{"id":433,"title":"麦当劳创始人雷蒙德·克罗克逝世","year":"1983"},{"id":434,"title":"全国宣传部长会议召开","year":"1997"},{"id":435,"title":"美国探测器\u201c信使号\u201d掠过水星","year":"2000"},{"id":436,"title":"人类成功克隆猴","year":"2000"},{"id":437,"title":"北京奥申委宣布申奥形象大使","year":"2001"},{"id":438,"title":"惠更斯号进入土卫六大气层 成功登陆","year":"2005"},{"id":439,"title":"师昌绪和王振义获2010年国家最高科技奖","year":"2011"},{"id":440,"title":"原中央军委副主席刘华清逝世","year":"2011"}]
     * msg : 请求成功
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 402
         * title : 北宋设置榷场与西夏进行贸易
         * year : 1045
         */

        private int id;
        private String title;
        private String year;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }
    }
}
