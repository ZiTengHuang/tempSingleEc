package com.example.ppt.temp_coer.net.api;

public class Constants {

        //    private static final String  "http://www.hrwl360.com/mobile/api/";
        public static final String SERVER=  "http://47.104.73.186/mobile/api/";

        /**
         * 登录接口
         */
        public static final String LOGIN ="login";
        /**
         * 登出接口
         */
        public static final String LOGINOUT =  "loginout";

        /**
         * 首页数据
         */
        public static final String WEBINDEX =  "webIndex";

        /**
         * 发送短信
         */
        public static final String SEBDNSGCIDE =  "sendMsgCode";
        /**
         * 注册
         */
        public static final String REG =  "reg";
        /**
         * 用户消息列表
         */
        public static final String USERMSGLIST =  "userMsgList";
        /**
         * 用户消息详情
         */
        public static final String USERMSGDATAIL =  "userMsgDetail";
        /**
         * 找回密码
         */
        public static final String FORGETPWD =  "forgetPwd";
        /**
         * 借款列表
         */
        public static final String BORROWLIST =  "borrowList";
        /**
         * 借款详情
         */
        public static final String BORROWDETAIL =  "borrowDetail";
        /**
         * 优惠券列表
         */
        public static final String COUPONLIST =  "couponList";
        /**
         * 优惠券图片
         */
        public static final String COUPONRULE =  "couponRule";
        /**
         * 修改登录密码
         */
        public static final String EWSETPWD =  "resetPwd";
        /**
         * 人际关系
         */
        public static final String POSTRELATION =  "postRelation";
        /**
         * 手机认证页面
         * 借款(确认接口调用)
         */
        public static final String AUTHCENTER =  "authCenter";
        /**
         * 手机认证提交
         */
        public static final String PHONEAUTH =  "phoneAuth";
        /**
         * 身份认证获取
         */
        public static final String POSTIDCARDPAGE =  "postIdCardPage";
        /**
         * 身份认证提交
         */
        public static final String POSTIDCARD =  "postIdCard";
        /**
         * 个人信息页面
         */
        public static final String INFOPOSTPAGE =  "infoPostPage";
        /**
         * 个人信息页面(人际关系)
         */
        public static final String RELATIONPAGE =  "relationPage";
        /**
         * 个人信息提交(现居住地)
         */
        public static final String POSTLIVE =  "postLive";
        /**
         * 个人信息页面(工作信息)
         */
        public static final String WORKPAGE =  "workPage";
        /**
         * 个人信息提交(工作信息)(工作信息)
         */
        public static final String POSTWORK =  "postWork";
        /**
         * 个人信息页面(收款信息)
         */
        public static final String BANKPAGE =  "bankPage";
        /**
         * 个人信息页面(收款信息)
         */
        public static final String POSTBANK =  "postBank";
        /**
         * 借款(申请界面)
         */
        public static final String BORROWPAGE =  "borrowPage";
        /**
         * 借款(确认接口调用)
         */
        public static final String BORROWACT =  "borrowAct";
        /**
         * 还款页面
         */
        public static final String PAYPAGE =  "payPage";
        /**
         * 还款
         */
        public static final String REPAYACT =  "repayAct";
        //人脸识别
        public static final String FACE_COMPARE =  "face_compare";

        //提交淘宝信息
        public static final String POSTTBINFO =  "postTbInfo";

        //提交淘宝信息页面
        public static final String POSTTBPAGE =  "postTbPage";

        //其他信息提交页面
        public static final String POSTOTHERPAGE =  "postOtherPage";

        //其他信息提交
        public static final String POSTOTHERINFO =  "postOtherInfo";

        //其他信息提交
        public static final String PATH =  "postOtherInfo";
        //版本更新
        public static final String VERSION =  "version";

        //提交线下还款
        public static final String POST_REPAY_LOG =  "post_repay_log";

        //提交用户问题
        public static final String POSTQUESION =  "postQuesion";

        //续约页面数据
        public static final String RENEWAL =  "renewal";

        //续约post
        public static final String ACTRENEWAL =  "actRenewal";

        //发起认证支付(发起成功后会发送短信验证码)
        public static final String REALPAYORDER =  "realPayOrder";

        //重新发送短信验证码（当提交认证支付后未收到验证码，可调用此接口重新发送）
        public static final String SENDVERCODE =  "sendVercode";
        //认证支付确认支付
        public static final String REALPAYCOFIRM =  "realPayConfirm";


}
