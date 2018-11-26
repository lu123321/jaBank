package com.example.jsconsumermanagement.pojo;


import java.io.Serializable;
    /**
     * (CreditcardCard)实体类
     *
     * @author makejava
     * @since 2018-11-14 08:58:07
     */
    public class CreditcardCard implements Serializable {
        private static final long serialVersionUID = -73077462973476234L;
        //信用卡ID
        private Integer cardId;
        //信用卡号码
        private String cardNumber;
        //信用卡当前余额
        private Double cardBalance;
        //信用卡状态(正常，挂失)
        private String cardState;
        //主副卡标志（主卡）
        private String cardSign;
        //信用卡还款日
        private String cardDuedate;
        //账单日
        private String cardDate;
        //信用卡可用余额
        private Double cardUsablebalanc;
        //账户别名
        private String cardAlias;
        //办卡日期
        private String cardHandledate;
        //启用日期
        private String cardStartdate;
        //信用卡额度
        private Double cardLimit;
        //币种
        private String cardCurrency;
        //信誉度
        private Integer cardAa;
        //当前欠款
        private Double cardBb;
        //关联用户ID
        private Integer cardPeson;
        //关联生成订单信息id
        private Integer cardApplyid;


        public Integer getCardApplyid() {
            return cardApplyid;
        }

        public void setCardApplyid(Integer cardApplyid) {
            this.cardApplyid = cardApplyid;
        }

        public Integer getCardPeson() {
            return cardPeson;
        }

        public void setCardPeson(Integer cardPeson) {
            this.cardPeson = cardPeson;
        }

        public Integer getCardId() {
            return cardId;
        }

        public void setCardId(Integer cardId) {
            this.cardId = cardId;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public Double getCardBalance() {
            return cardBalance;
        }

        public void setCardBalance(Double cardBalance) {
            this.cardBalance = cardBalance;
        }

        public void setCardUsablebalanc(Double cardUsablebalanc) {
            this.cardUsablebalanc = cardUsablebalanc;
        }

        public String getCardState() {
            return cardState;
        }

        public void setCardState(String cardState) {
            this.cardState = cardState;
        }

        public String getCardSign() {
            return cardSign;
        }

        public void setCardSign(String cardSign) {
            this.cardSign = cardSign;
        }

        public String getCardDuedate() {
            return cardDuedate;
        }

        public void setCardDuedate(String cardDuedate) {
            this.cardDuedate = cardDuedate;
        }

        public String getCardDate() {
            return cardDate;
        }

        public void setCardDate(String cardDate) {
            this.cardDate = cardDate;
        }


        public Double getCardUsablebalanc() {
            return cardUsablebalanc;
        }

        public String getCardAlias() {
            return cardAlias;
        }

        public void setCardAlias(String cardAlias) {
            this.cardAlias = cardAlias;
        }

        public String getCardHandledate() {
            return cardHandledate;
        }

        public void setCardHandledate(String cardHandledate) {
            this.cardHandledate = cardHandledate;
        }

        public String getCardStartdate() {
            return cardStartdate;
        }

        public void setCardStartdate(String cardStartdate) {
            this.cardStartdate = cardStartdate;
        }

        public Double getCardLimit() {
            return cardLimit;
        }

        public void setCardLimit(Double cardLimit) {
            this.cardLimit = cardLimit;
        }

        public String getCardCurrency() {
            return cardCurrency;
        }

        public void setCardCurrency(String cardCurrency) {
            this.cardCurrency = cardCurrency;
        }

        public Integer getCardAa() {
            return cardAa;
        }

        public void setCardAa(Integer cardAa) {
            this.cardAa = cardAa;
        }

        public Double getCardBb() {
            return cardBb;
        }

        public void setCardBb(Double cardBb) {
            this.cardBb = cardBb;
        }
    }