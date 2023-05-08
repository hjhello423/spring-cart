package cart.member.application;

import cart.member.controller.MembersResponse;
import cart.member.domain.MemberRepository;
import cart.member.domain.Members;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MembersResponse findAllMembers() {
        Members members = memberRepository.findAll();

        return MembersResponse.of(members);
    }

}
