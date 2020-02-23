package com.restful.test.dto;

public enum CompanyType {
    SOLE_PROPRIETORSHIP("Sole Proprietorship"),
    LIMITED_LIABILITY_COMPANY("Limited Liability Company"),
    PARTNERSHIP("Partnership"),
    OTHERS("Others");

    private String name;

    CompanyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        switch (this) {
            case PARTNERSHIP:
                return 75;
            case SOLE_PROPRIETORSHIP:
                return 12;
            case LIMITED_LIABILITY_COMPANY:
                return 63;
            case OTHERS:
            default:
                return 0;
        }
    }

    public static CompanyType convertFrom(String name){
        if(PARTNERSHIP.getName().equals(name)){
            return PARTNERSHIP;
        }else if(SOLE_PROPRIETORSHIP.getName().equals(name)){
            return SOLE_PROPRIETORSHIP;
        }else if(LIMITED_LIABILITY_COMPANY.getName().equals(name)){
            return LIMITED_LIABILITY_COMPANY;
        }else if(OTHERS.getName().equals(name)){
            return OTHERS;
        }
        return null;
    }
}
