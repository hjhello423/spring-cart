package cart.auth.authentication;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AuthInterceptorTest {

    @DisplayName("")
    @Test
    void decode() {
        // given
        String s = "basic YWRtaW46cGFzc3dvcmQ=";
        // when
        String[] basics = s.split("basic");

        // then
        System.out.println(basics[0]);
        System.out.println(basics[1]);
    }

    @Test
    void decode2() {
        // given
//        "basic dgvzdc11c2vyojexmte=";
//        String s = "dgvzdc11c2vyojexmte=";
        String s = "dGVzdDoxMTEx";
//        String s = "YWRtaW46cGFzc3dvcmQ==";
        String decoded = new String(Base64.decodeBase64(s));
        System.out.println(decoded);
    }
}
