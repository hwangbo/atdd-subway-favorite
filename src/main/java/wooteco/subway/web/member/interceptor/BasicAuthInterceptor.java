package wooteco.subway.web.member.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import wooteco.subway.domain.member.Member;
import wooteco.subway.service.member.MemberService;
import wooteco.subway.web.member.AuthorizationExtractor;
import wooteco.subway.web.member.InvalidAuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

@Component
public class BasicAuthInterceptor implements HandlerInterceptor {
    public static final String BASIC = "Basic";
    private AuthorizationExtractor authExtractor;
    private MemberService memberService;

    public BasicAuthInterceptor(AuthorizationExtractor authExtractor, MemberService memberService) {
        this.authExtractor = authExtractor;
        this.memberService = memberService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String sourceCode = authExtractor.extract(request, BASIC);
        byte[] decode = Base64.getDecoder().decode(sourceCode);
        String[] userInfo = new String(decode).split(":");
        String email = userInfo[0];
        String password = userInfo[1];

        Member member = memberService.findMemberByEmail(email);
        if (!member.checkPassword(password)) {
            throw new InvalidAuthenticationException("올바르지 않은 이메일과 비밀번호 입력");
        }

        request.setAttribute("loginMemberEmail", email);
        return true;
    }
}
