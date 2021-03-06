package com.o2osys;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.o2osys.common.CommonUtils;
import com.o2osys.component.LocationKakaoComponent;
import com.o2osys.entity.kakao.Location;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LocationTestApplicationTests {

    private final Logger log = LoggerFactory.getLogger(LocationTestApplicationTests.class);

    // 다음지도 컴포넌트
    @Autowired
    private LocationKakaoComponent lc;

    @Autowired
    CommonUtils util;

    @Test
    public void contextLoads() throws Exception {

        // 카카오 api를 통한 좌표 조회
        String str = "광주 남구 주월동 535 남구 주월동 호반베르디움2차202동304";
        //        서울특별시 노원구 월계1동 389-1 삼능스페이스향 804호
        //서울 도봉구 창5동 : [상세주소] 창동 창동SR스타빌 708호
        //서울특별시 노원구 상계10동777번지 주공아파트709동 301호
        //대전광역시 서구 월평1동 성심타운726번지bo1호
        //광주 남구 주월동 535 남구 주월동 호반베르디움2차 202동304
        //서울 강남구 논현1동 마일스디오빌 논현동 58-2 1209호
        //서울 서초구 서초동 1342 ㅡ

        //인천 부평구 부개동 307-5 서울연립다동106호

        Location location = lc.getAddr(str);

        log.debug("#### location : "+ util.jsonStringFromObject(location));

    }

}
