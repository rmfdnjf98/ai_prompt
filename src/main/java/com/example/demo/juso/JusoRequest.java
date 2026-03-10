package com.example.demo.juso;

import lombok.Data;

public class JusoRequest {

    @Data
    public static class Address {
        private String roadFullAddr;
        private String roadAddrPart1;
        private String addrDetail;
        private String roadAddrPart2;
        private String engAddr;
        private String jibunAddr;
        private String zipNo;
        private String admCd;
        private String rnMgtSn;
        private String bdMgtSn;
        private String detBdNmList;
        private String bdNm;
        private String bdKdcd;
        private String siNm;
        private String sggNm;
        private String emdNm;
        private String liNm;
        private String rn;
        private String udrtYn;
        private String buldMnnm;
        private String buldSlno;
        private String mtYn;
        private String lnbrMnnm;
        private String lnbrSlno;
        private String emdNo;
    }
}
