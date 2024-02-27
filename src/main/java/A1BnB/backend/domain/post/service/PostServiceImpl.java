package A1BnB.backend.domain.post.service;

import A1BnB.backend.domain.member.service.MemberService;
import A1BnB.backend.domain.photo.model.entity.Photo;
import A1BnB.backend.domain.photo.service.PhotoService;
import A1BnB.backend.domain.post.dto.PostSearchRequest;
import A1BnB.backend.domain.post.dto.PostSearchResult;
import A1BnB.backend.domain.post.model.entity.Post;
import A1BnB.backend.domain.post.repository.PostRepository;
import A1BnB.backend.domain.member.model.entity.Member;
import A1BnB.backend.domain.post.dto.PostUploadRequest;
import A1BnB.backend.domain.post.dto.PostResponse;
import A1BnB.backend.domain.post.dto.mapper.PostResponseMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private final PostRepository postRepository;
    @Autowired
    private final MemberService memberService;
    @Autowired
    private final PostResponseMapper postResponseMapper;
    @Autowired
    private final PhotoService photoService;

    // 게시물 등록
    @Override
    @Transactional
    public void registerPost(String userName, PostUploadRequest uploadParam) {
        // 로그인 중인 회원 조회
        Member currentMember = memberService.findMember(userName);

        // photo 리스트 조회
        List<Photo> photos = photoService.getPhotos(uploadParam.photoIdList());

        // Post 엔티티 저장
        Post post = Post.builder()
                .author(currentMember)
                .location(uploadParam.location())
                .photos(photos)
                .checkIn(uploadParam.checkIn())
                .checkOut(uploadParam.checkOut())
                .pricePerNight(uploadParam.pricePerNight())
                .build();
        postRepository.save(post);
    }

    // 게시물 전체 조회
    @Override
    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        // 게시물 전체 조회
        List<Post> posts = postRepository.findAll();

        // 게시물 응답 DTO 반환
        return postResponseMapper.toPostResponses(posts);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostResponse> searchByCondition(PostSearchRequest searchCondition) {
        // 게시물 검색
        List<PostSearchResult> searchResults = postRepository.search(searchCondition);

        // 게시물 Id 리스트
        List<Long> postIdList = makePostIdList(searchResults);

        // 게시물 조회
        List<Post> posts = postRepository.findAllByIdIn(postIdList);
        return postResponseMapper.toPostResponses(posts);
    }

    private List<Long> makePostIdList(List<PostSearchResult> searchResults){
        return searchResults.stream()
                .map(PostSearchResult::postId)
                .collect(Collectors.toList());
    }

}