package cart.domain.Member;

public class Member {

    private Long id;
    private String email;
    private String password;

    private Member() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static MemberBuilder builder() {
        return new MemberBuilder();
    }

    public static class MemberBuilder {
        private Long id;
        private String email;
        private String password;

        public MemberBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MemberBuilder email(String email) {
            this.email = email;
            return this;
        }

        public MemberBuilder password(String password) {
            this.password = password;
            return this;
        }

        public Member build() {
            Member member = new Member();
            member.id = this.id;
            member.email = this.email;
            member.password = this.password;
            return member;
        }
    }

}
