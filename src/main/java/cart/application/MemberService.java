package cart.application;

import cart.controller.dto.MembersResponse;
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
