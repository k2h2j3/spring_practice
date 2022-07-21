package Club.WelcomeClub;

import Club.WelcomeClub.repository.MemberRepository;
import Club.WelcomeClub.repository.MemoryMemberRepository;
import Club.WelcomeClub.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
