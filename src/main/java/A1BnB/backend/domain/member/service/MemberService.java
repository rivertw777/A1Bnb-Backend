package A1BnB.backend.domain.member.service;

import A1BnB.backend.domain.member.dto.request.MemberSignupRequest;
import A1BnB.backend.domain.member.dto.response.GuestReservationResponse;
import A1BnB.backend.domain.member.dto.response.SettleAmountResponse;
import A1BnB.backend.domain.member.model.entity.Member;
import A1BnB.backend.domain.post.dto.response.PostResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    void registerUser(MemberSignupRequest signupParam);
    Member findMember(String name);
    SettleAmountResponse findMySettlementAmount(String username);
    List<PostResponse> findMyPosts(String username);
    List<GuestReservationResponse> findHostReservations(String username);
    List<GuestReservationResponse> findGuestReservations(String username);
    List<PostResponse> findMyLikePosts(String username);
}