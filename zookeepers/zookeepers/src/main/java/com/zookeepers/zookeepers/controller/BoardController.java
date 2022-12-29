package com.zookeepers.zookeepers.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.zookeepers.zookeepers.dto.board.BoardDetailResponseDto;
import com.zookeepers.zookeepers.dto.board.BoardSearchRequestDto;
import com.zookeepers.zookeepers.dto.board.BoardWriteRequestDto;
import com.zookeepers.zookeepers.dto.comment.CommentWriteRequestDto;
import com.zookeepers.zookeepers.entity.BoardEntity;
import com.zookeepers.zookeepers.entity.CommentEntity;
import com.zookeepers.zookeepers.entity.MemberEntity;
import com.zookeepers.zookeepers.service.CodeService;
import com.zookeepers.zookeepers.service.board.BoardService;
import com.zookeepers.zookeepers.service.comment.CommentService;
import com.zookeepers.zookeepers.service.member.MemberService;

@RequestMapping("/board")
@Controller
public class BoardController {
    private final MemberService memberService;
	
	private final BoardService boardService;
	
	private final CommentService commentService;

	private final CodeService codeService;

	public BoardController(MemberService memberService,BoardService boardService, CommentService commentService, CodeService codeService) {
        this.memberService = memberService;
		this.boardService = boardService;
		this.commentService = commentService;
		this.codeService = codeService;
    }

	@GetMapping("/board.do")
	public String boardList(@SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser, Model model, @PageableDefault(page=0, size=10, sort="boardNo", direction = Sort.Direction.DESC)Pageable pageable){
		
		model.addAttribute("loginUser", loginUser);					// 로그인 세션
		pageNumbers pageNumbers = new pageNumbers(); 								// 페이징 넘버링 객체 생성
		Page<BoardEntity> boardEntityList = boardService.boardList(pageable);             // 게시판 리스트 불러오기

		pageNumbers.setNowPage(boardEntityList.getPageable().getPageNumber() + 1);		//페이징 넘버링 객체 값 할당 
		pageNumbers.setStartPage(Math.max(pageNumbers.nowPage - 4, 1));
		pageNumbers.setEndPage(Math.min(pageNumbers.nowPage + 5, boardEntityList.getTotalPages()));

		model.addAttribute("list", boardEntityList);
		model.addAttribute("pageNumbers", pageNumbers);
		
		return "board";
	}

	@PostMapping("/boardSearch.do")
	public String boardSearchDo(BoardSearchRequestDto form){
		boardService.boardSearchTitle(form.getTitle());

		return "redirect:/board";
	}

	@PostMapping("/write.do")
	public String writeDo(BoardWriteRequestDto boardWriteDto, @SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser){
		boardWriteDto.setMemberNo(loginUser.getMemberNo());  //Dto에 작성자 memberNo 저장
		boardService.create(boardWriteDto);  //service로 Dto 전송

		return "redirect:/board/board.do";
	}

	@GetMapping("/boardWrite.do")
	public String boardWrite(@SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser, HttpServletRequest request, Model model) {
		model.addAttribute("loginUser", loginUser);

		return "boardWrite";
	}

	@GetMapping("/boardDelete.do")
	public String boardDelete(Model model, String boardNo, @SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser){

		boardService.boardDelete(boardNo); // 게시물 삭제

		return "redirect:/board/board.do";
	}

	@GetMapping("/boardModify.do")
	public String boardModify(@PathVariable("boardNo") String boardNo){

		return "board/boardModify";
	}

	@PostMapping("/boardCommentWrite.do")
	public String boardCommentWriteDo(String boardNo, CommentWriteRequestDto commentWriteRequestDto, @SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser){
		
		commentWriteRequestDto.setMemberNo(loginUser.getMemberNo());  //  CommentDto에 memberNo 저장
		commentWriteRequestDto.setBoardNo(boardNo);    //  CommentDto에 boardNo 저장
		
		commentService.write(commentWriteRequestDto);
		
		return "redirect:boardDetail.do?boardNo="+boardNo;
	}

	@GetMapping("/boardDetail.do")
	public String boardDetail(String boardNo, Model model, @SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser){
		model.addAttribute("loginUser", loginUser);
		BoardEntity boardEntity = boardService.findBoard(boardNo);												//ResponseDto에 들어갈 BoardEntity
		MemberEntity writeUser = memberService.findMemberByMemberNo(boardEntity.getMemberNo());					//ResponseDto에 들어갈 MemberEntity
		String gradeCodeName = codeService.getCodeName(writeUser.getMemberGrade()); 							//gradeCode로 gradeName 조회
		String categoryCodeName = codeService.getCodeName(boardEntity.getBoardCategory());						//categoryCode로 categoryName 조회
		BoardDetailResponseDto boardDetailResponseDto = new BoardDetailResponseDto(boardEntity, gradeCodeName, categoryCodeName);
		List<CommentEntity> comment = commentService.commentList(boardNo);

		model.addAttribute("board", boardDetailResponseDto);
		model.addAttribute("comment", comment);

		return "boardDetail";
	}

	@GetMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();

		session.invalidate();

		return "redirect:/";
	}

}