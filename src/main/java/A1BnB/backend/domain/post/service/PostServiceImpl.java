package A1BnB.backend.domain.post.service;

import static A1BnB.backend.domain.member.exception.constants.MemberExceptionMessages.MEMBER_NAME_NOT_FOUND;

import A1BnB.backend.domain.date.model.entity.Date;
import A1BnB.backend.domain.date.service.DateService;
import A1BnB.backend.domain.member.exception.MemberNotFoundException;
import A1BnB.backend.domain.member.service.MemberService;
import A1BnB.backend.domain.photo.dto.PhotoInfo;
import A1BnB.backend.domain.photo.model.entity.Photo;
import A1BnB.backend.domain.photo.service.PhotoService;
import A1BnB.backend.domain.post.dto.request.PostBookRequest;
import A1BnB.backend.domain.post.dto.response.PostDetailResponse;
import A1BnB.backend.domain.post.dto.request.PostSearchRequest;
import A1BnB.backend.domain.post.dto.PostSearchResult;
import A1BnB.backend.domain.post.dto.mapper.PostDetailResponseMapper;
import A1BnB.backend.domain.post.model.entity.Post;
import A1BnB.backend.domain.post.repository.PostRepository;
import A1BnB.backend.domain.member.model.entity.Member;
import A1BnB.backend.domain.post.dto.request.PostUploadRequest;
import A1BnB.backend.domain.post.dto.response.PostResponse;
import A1BnB.backend.domain.post.dto.mapper.PostResponseMapper;
import A1BnB.backend.domain.postBook.service.PostBookService;
import A1BnB.backend.domain.postLike.service.PostLikeService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final MemberService memberService;
    private final PhotoService photoService;
    private final PostLikeService postLikeService;
    private final PostBookService postBookService;
    private final DateService dateService;

    private final PostResponseMapper postResponseMapper;
    private final PostDetailResponseMapper postDetailResponseMapper;

    // 게시물 등록
    @Override
    @Transactional
    public void registerPost(String username, PostUploadRequest requestParam) {
        Member currentMember = memberService.findMember(username);
        List<Photo> photos = photoService.findPhotos(requestParam.photoIdList());
        List<Date> availableDates = dateService.getDates(requestParam.startDate(), requestParam.endDate());
        savePost(requestParam, currentMember, photos, availableDates);
    }

    // Post 엔티티 저장
    private void savePost(PostUploadRequest requestParam, Member currentMember, List<Photo> photos,
                          List<Date> availableDates) {
        Post post = Post.builder()
                .author(currentMember)
                .location(requestParam.location())
                .photos(photos)
                .pricePerNight(requestParam.pricePerNight())
                .maximumOccupancy(requestParam.maximumOccupancy())
                .caption(requestParam.caption())
                .availableDates(availableDates)
                .build();
        postRepository.save(post);
    }

    // 게시물 응답 DTO Page 반환
    @Override
    @Transactional(readOnly = true)
    public Page<PostResponse> getAllPosts(Pageable pageable) {
        Page<Post> postPage = postRepository.findAll(pageable);
        // 게시물 응답 DTO 반환
        return postPage.map(postResponseMapper::toPostResponse);
    }

    // 게시물 검색 응답 DTO Page 반환
    @Override
    @Transactional(readOnly = true)
    public Page<PostResponse> searchByCondition(PostSearchRequest requestParam, Pageable pageable) {
        // 게시물 검색
        List<LocalDateTime> searchDates = dateService.getLocalDateTimeDates(requestParam.checkInDate(), requestParam.checkOutDate());
        List<PostSearchResult> searchResults = postRepository.search(requestParam, searchDates);
        List<Long> postIds = makePostIds(searchResults);
        // 게시물 조회 및 DTO 반환
        Page<Post> postPage = postRepository.findAllByIds(postIds, pageable);
        return postPage.map(postResponseMapper::toPostResponse);
    }

    // 추론 결과 postId 리스트 반환
    private List<Long> makePostIds(List<PostSearchResult> searchResults){
        return searchResults.stream()
                .map(PostSearchResult::postId)
                .collect(Collectors.toList());
    }

    // 게시물 상세 DTO 반환
    @Override
    @Transactional(readOnly = true)
    public PostDetailResponse getPostDetail(String username, Long postId) {
        Post post = findPostByPostId(postId);
        List<PhotoInfo> photoInfoList = photoService.getPhotoInfoList(post.getPhotos());
        // 인증 여부 확인
        Member currentMember = findMember(username);
        return postDetailResponseMapper.toPostDetailResponse(currentMember, post, photoInfoList);
    }

    private Member findMember(String username){
        if (username!=null){
            return memberService.findMember(username);
        }
        return null;
    }

    @Override
    @Transactional
    public void likePost(String username, Long postId) {
        Post post = findPostByPostId(postId);
        Member currentMember = memberService.findMember(username);
        postLikeService.likePost(post, currentMember);
    }

    @Override
    @Transactional
    public void unlikePost(String username, Long postId) {
        Post post = findPostByPostId(postId);
        Member currentMember = memberService.findMember(username);
        postLikeService.unlikePost(post, currentMember);
    }

    @Override
    @Transactional
    public void bookPost(String username, Long postId, PostBookRequest requestParam) {
        Post post = findPostByPostId(postId);
        Member currentMember = memberService.findMember(username);
        postBookService.bookPost(post, currentMember, requestParam.checkInDate(), requestParam.checkOutDate());
    }

    @Override
    public void unbookPost(String username, Long postId) {
        Post post = findPostByPostId(postId);
        Member currentMember = memberService.findMember(username);
        postBookService.unbookPost(post, currentMember);
    }

    // 게시물 단일 조회
    public Post findPostByPostId(Long postId){
        return postRepository.findByPostId(postId)
                .orElseThrow(()->new MemberNotFoundException(MEMBER_NAME_NOT_FOUND.getMessage()));
    }

}