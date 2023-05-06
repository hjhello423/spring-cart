package cart.application;

import cart.domain.Member;

import java.util.List;

public class Members {

    private List<Member> value;

    public Members(List<Member> members) {
        this.value = members;
    }

    public List<Member> getValue() {
        return value;
    }

}
