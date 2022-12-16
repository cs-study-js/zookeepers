package com.zookepers.zookeepers.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zookepers.zookeepers.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import com.zookepers.zookeepers.Entity.Comment;
import com.zookepers.zookeepers.Entity.Member;
import com.zookepers.zookeepers.Entity.board;
import com.zookepers.zookeepers.service.BoardService;
import com.zookepers.zookeepers.service.CodeService;
import com.zookepers.zookeepers.service.CommentService;

@Controller
public class formcontrollerimpl implements formcontroller{
    private final MemberService memberService;
	
	private final BoardService boardService;
	
	private final CommentService commentService;

	private final CodeService codeService;

	public formcontrollerimpl(MemberService memberService,BoardService boardService, CommentService commentService, CodeService codeService) {
        this.memberService = memberService;
		this.boardService = boardService;
		this.commentService = commentService;
		this.codeService = codeService;
    }
    	
	@GetMapping("/")
	public String main(@SessionAttribute(name = "loginUser", required = false)Member loginUser, Model model) {

        model.addAttribute("loginUser", loginUser);

		return "index";
	}
	
	@GetMapping("/login.do")
	public String loginpage() {
		
		return "login";
	}
	
	@PostMapping("/member_login.do")
	public String login(LoginForm form, HttpServletRequest request, RedirectAttributes rttr){
		Member member = new Member();
		member.setMember_id(form.getMember_id());
		member.setMember_password(form.getMember_password());

		HttpSession session = request.getSession();
		Member login = memberService.login(member);
		
		String failString = "아이디 혹은 비밀번호가 잘못되었습니다.";

		
		if(login == null){
			System.out.println("로그인 실패야.");
			rttr.addFlashAttribute("loginFail", failString);
			return "redirect:login.do";
		}

		session.setAttribute("loginUser", login);
		
		
		System.out.println("in login page: "+ session.getAttribute("loginUser"));
		return "index";
	}

	@GetMapping("logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		System.out.println("in logout : "+session.getAttribute("loginUser"));

		session.invalidate();

		return "index";
	}

	@GetMapping("/join.do")
	public String join() {
		return "join";
	}
	


	@PostMapping("/member_join.do")
	public String create(JoinForm form){
		Member member = new Member();
		member.setMember_no(memberService.getMemberId());
		member.setMember_id(form.getMember_id());
		member.setMember_password(form.getMember_password());
		member.setMember_name(form.getMember_name());
		member.setMember_nickname(form.getMember_nickname());
		member.setMember_phonenum(form.getMember_phonenum());
		member.setMember_address(form.getDummy_address());
		member.setMember_detailaddress(form.getMember_detailaddress());
		member.setMember_joindate(LocalDateTime.now());
		memberService.join(member);
		return "index";
	}

	@GetMapping("/Board.do")
	public String board(@SessionAttribute(name = "loginUser", required = false)Member loginUser, Model model, @PageableDefault(page=0, size=5, sort="boardno", direction = Sort.Direction.DESC) Pageable pageable) {
		
		model.addAttribute("loginUser", loginUser);

		Page<board> board_list = boardService.board_list(pageable);

		int nowPage = board_list.getPageable().getPageNumber() + 1;
		int startPage = Math.max(nowPage - 4, 1);
		int endPage = Math.min(nowPage + 5, board_list.getTotalPages());

		model.addAttribute("list", board_list);

		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);


		return "Board";
	}

	@PostMapping("/Board_search.do")
	public String search(BoardSearchForm form){
		boardService.board_search_title(form.getTitle());
		return "Board";
	}

	@PostMapping("/TBoard_search.do")
	public String Tsearch(BoardSearchForm form){
		return "TBoard";
	}

	@GetMapping("/Board_write.do")
	public String board_write(@SessionAttribute(name = "loginUser", required = false)Member loginUser, HttpServletRequest request, Model model){
		model.addAttribute("loginUser", loginUser);
		System.out.println(" Member no :"+loginUser.getMember_no());

		HttpSession session = request.getSession();
		String MemberNo = loginUser.getMember_no();

		session.setAttribute("memNo", MemberNo);


		return "Board_write";
	}

	@PostMapping("/write.do")
	public String write(BoardForm form, HttpServletRequest request, @SessionAttribute(name = "memNo", required = false)String MemberNo){
		board b = new board();
		b.setBoard_no(boardService.getBoardId());
		b.setMember_no((String)MemberNo);
		b.setBoard_writer(memberService.findNickname(MemberNo));
		b.setBoard_title(form.getBoard_title());
		b.setBoard_detail(form.getBoard_detail());
		b.setBoard_category(form.getBoard_category());
		b.setBoard_date(LocalDateTime.now());

		boardService.create(b);
		return "Board";
	}

	@GetMapping("/Board_detail.do")
	public String board_detail(Model model, String boardNo, @SessionAttribute(name = "loginUser", required = false)Member loginUser) {
		model.addAttribute("loginUser", loginUser);
		
		System.out.println("in board detail : " + boardService.find_board(boardNo));
		board board_detail = boardService.find_board(boardNo);
		model.addAttribute("board", board_detail);

		model.addAttribute("writeUser", memberService.findMemberByMemberNo(board_detail.getMember_no()));
		
		return "Board_detail";
	}

	@GetMapping("/Board_delete.do")
	public String board_delete(Model model, String boardNo, @SessionAttribute(name = "loginUser", required = false)Member loginUser){

		System.out.println("in delete : " + boardNo);
		boardService.board_delete(boardNo);
		return "redirect:/Board.do";

	}

	@GetMapping("/Board_modify.do")
	public String board_modify(@PathVariable("boardNo") String boardNo){

		System.out.println("in modify : "+boardNo);
		return "Board_modify";
	}

	@PostMapping("/Board_comment.do")
	public String board_comment(CommentForm form){
		Comment comment = new Comment();
		comment.setCom_no(commentService.getCommentId());
		comment.setCom_detail(form.getCom_detail());
		comment.setCom_date(LocalDateTime.now());
		
		commentService.write(comment);
		
		return "Board_detail";
	}
	
	@GetMapping("/TBoard.do")
	public String tboard(@SessionAttribute(name = "loginUser", required = false)Member loginUser, Model model) {
		model.addAttribute("loginUser", loginUser);

		return "TBoard";
	}
	
	@GetMapping("/TBoard_detail.do")
	public String tboard_detail(@SessionAttribute(name = "loginUser", required = false)Member loginUser, Model model) {
		model.addAttribute("loginUser", loginUser);
		return "TBoard_detail";
	}
	
	@GetMapping("/Mypage.do")
	public String mypage(@SessionAttribute(name = "loginUser", required = false)Member loginUser, Model model) {
		model.addAttribute("loginUser", loginUser);
		return "mypage";
	}
}