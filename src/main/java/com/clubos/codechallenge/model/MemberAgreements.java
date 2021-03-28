package com.clubos.codechallenge.model;

public class MemberAgreements{

    private Integer memberId;
    private Integer agreement;
    private String AgreementType;

    public Integer getMemberId() {
        return memberId;
    }

    public Integer getAgreement() {
        return agreement;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public void setAgreement(Integer agreement) {
        this.agreement = agreement;
    }

    public void setAgreementType(String agreementType) {
        AgreementType = agreementType;
    }

    public String getAgreementType() {
        return AgreementType;
    }
}
