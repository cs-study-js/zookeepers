package com.zookepers.zookeepers.controller;

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

import com.zookepers.zookeepers.service.board.BoardService;
import com.zookepers.zookeepers.service.comment.CommentService;
import com.zookepers.zookeepers.service.member.MemberService;
import com.zookepers.zookeepers.dto.BoardSearchDto;
import com.zookepers.zookeepers.dto.BoardWriteDto;
import com.zookepers.zookeepers.dto.CommentWriteDto;
import com.zookepers.zookeepers.entity.BoardEntity;
import com.zookepers.zookeepers.entity.CommentEntity;
import com.zookepers.zookeepers.entity.MemberEntity;
import com.zookepers.zookeepers.service.CodeService;

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
	public String board(@SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser, Model model, @PageableDefault(page=0, size=5, sort="boardNo", direction = Sort.Direction.DESC) Pageable pageable) {
		
		model.addAttribute("loginUser", loginUser);
		pageNumbers pageNumbers = new pageNumbers();
		Page<BoardEntity> boardList = boardService.boardList(pageable);

		pageNumbers.setNowPage(boardList.getPageable().getPageNumber() + 1);
		pageNumbers.setStartPage(Math.max(pageNumbers.nowPage - 4, 1));
		pageNumbers.setEndPage(Math.min(pageNumbers.nowPage + 5, boardList.getTotalPages()));

		model.addAttribute("list", boardList);
		model.addAttribute("pageNumbers", pageNumbers);

		return "board";
	}

	@GetMapping("/newBoard.do")
	public String nowBoard(@SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser, Model model, @PageableDefault(page=0, size=10, sort="boardNo", direction = Sort.Direction.DESC) Pageable pageable){
		
		model.addAttribute("loginUser", loginUser);
		pageNumbers pageNumbers = new pageNumbers();
		Page<BoardEntity> boardList = boardService.boardList(pageable);

		pageNumbers.setNowPage(boardList.getPageable().getPageNumber() + 1);
		pageNumbers.setStartPage(Math.max(pageNumbers.nowPage - 4, 1));
		pageNumbers.setEndPage(Math.min(pageNumbers.nowPage + 5, boardList.getTotalPages()));

		model.addAttribute("list", boardList);
		model.addAttribute("pageNumbers", pageNumbers);
		
		return "newBoard";
	}

	@PostMapping("/boardSearch.do")
	public String search(BoardSearchDto form){
		boardService.boardSearchTitle(form.getTitle());
		return "redirect:/board";
	}

	@GetMapping("/boardWrite.do")
	public String boardWrite(@SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser, HttpServletRequest request, Model model){
		model.addAttribute("loginUser", loginUser);

		HttpSession session = request.getSession();
		String memberNo = loginUser.getMemberNo();
		
		session.setAttribute("memNo", memberNo);

		return "boardWrite";
	}

	@PostMapping("/write.do")
	public String write(BoardWriteDto boardWriteDto, @SessionAttribute(name = "memNo", required = false)String memberNo){
		boardWriteDto.setMemberNo(memberNo);
		boardService.create(boardWriteDto);
		return "redirect:/board.do";
	}

	@GetMapping("/newBoardWrite.do")
	public String newBoardWrite(@SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser,@SessionAttribute(name ="memNo", required = false)String memberNo , HttpServletRequest request, Model model) {
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("memNo", memberNo);

		return "newBoardWrite";
	}
	@GetMapping("/boardDetail.do")
	public String boardDetail(Model model, String boardNo, @SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser, HttpServletRequest request) {
		model.addAttribute("loginUser", loginUser);
		
		HttpSession session = request.getSession();
		String memberNo = loginUser.getMemberNo();

		session.setAttribute("memNo", memberNo);

		BoardEntity boardDetail = boardService.findBoard(boardNo);
		model.addAttribute("board", boardDetail);

		model.addAttribute("writeUser", memberService.findMemberByMemberNo(boardDetail.getMemberNo()));

		return "boardDetail";
	}

	@GetMapping("/boardDelete.do")
	public String boardDelete(Model model, String boardNo, @SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser){

		boardService.boardDelete(boardNo);

		return "redirect:/board.do";
	}

	@GetMapping("/boardModify.do")
	public String board_modify(@PathVariable("boardNo") String boardNo){

		return "board/boardModify";
	}

	@PostMapping("/writeComment.do")
	public String board_comment(String boardNo, CommentWriteDto commentDto, BoardWriteDto boardWriteDto, @SessionAttribute(name = "memNo", required = false)String memberNo){
		
		commentDto.setMemberNo(memberNo);
		commentDto.setBoardNo(boardNo);
		
		commentService.write(commentDto);
		
		return "board/boardDetail.do?boardNo={boardNo}";
	}

	@GetMapping("/newBoardDetail.do")
	public String newBoardDetail(String boardNo, Model model, @SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser){
		model.addAttribute("loginUser", loginUser);
		BoardEntity boardDetail = boardService.findBoard(boardNo);
		model.addAttribute("board", boardDetail);
		List<CommentEntity> comments = commentService.commentList(boardNo);
		model.addAttribute("comment", comments);
		model.addAttribute("writeUser", memberService.findMemberByMemberNo(boardDetail.getMemberNo()));

		return "newBoardDetail";
	}
	

	@GetMapping("/mypage.do")
	public String mypage(@SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser, Model model) {
		model.addAttribute("loginUser", loginUser);

		if(loginUser != null){
			return "mypage";
		}

		else{
			return "login";
		}
	}

}