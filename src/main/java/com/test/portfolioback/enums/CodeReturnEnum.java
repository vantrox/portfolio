package com.test.portfolioback.enums;

/**
 *
 * @author Robson J Silva <vantrox@yahoo.com.br>
 */
public enum CodeReturnEnum {
    NO_CHANGE(100),
    SUCCESS(200),
    ERROR(300);
    
    private int code;

    private CodeReturnEnum(int code) {
        this.code = code;
    }
    
    public int getCode(){
        return this.code;
    }
    
    public static CodeReturnEnum get(int code){
        for(CodeReturnEnum codeReturnEnum : values()){
            if(codeReturnEnum.getCode() == code){
                return codeReturnEnum;
            }
        }
        throw new IllegalArgumentException("Code return is invalid: " + code);
    }
    
}
