package com.zookeepers.zookeepers.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.zookeepers.zookeepers.dto.board.BoardSearchRequestDto;
import com.zookeepers.zookeepers.dto.tradeBoard.TradeBoardDetailResponseDto;
import com.zookeepers.zookeepers.dto.tradeBoard.TradeBoardWriteRequestDto;
import com.zookeepers.zookeepers.dto.tradeBoard.TradeBoardCommentWriteRequestDto;
import com.zookeepers.zookeepers.entity.MemberEntity;
import com.zookeepers.zookeepers.entity.TradeBoardEntity;
import com.zookeepers.zookeepers.entity.TradeCommentEntity;
import com.zookeepers.zookeepers.service.CodeService;
import com.zookeepers.zookeepers.service.member.MemberService;
import com.zookeepers.zookeepers.service.tradeBoard.TradeBoardService;
import com.zookeepers.zookeepers.service.tradeComment.TradeCommentService;

@Controller
public class TradeBoardController {
    private final TradeBoardService tradeBoardService;

	private final MemberService memberService;

	private final TradeCommentService tradeCommentService;

	private final CodeService codeService;

	TradeBoardController(TradeBoardService tradeBoardService, MemberService memberService, TradeCommentService tradeCommentService, CodeService codeService){
		this.tradeBoardService = tradeBoardService;
		this.memberService = memberService;
		this.tradeCommentService = tradeCommentService;
		this.codeService = codeService;
	}
	
	@PostMapping("/tradeBoardSearch.do")
	public String tradeBoardSearchDo(BoardSearchRequestDto form){
		return "tradeBoard";
	}

	@GetMapping("/tradeBoard.do")
	public String tradeBoard(@SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser, Model model,@PageableDefault(page=0, size=10, sort="tradeBoardNo", direction = Sort.Direction.DESC) Pageable pageable){
		model.addAttribute("loginUser", loginUser);
		pageNumbers pageNumbers = new pageNumbers();											//페이징 넘버링 객체 생성
		Page<TradeBoardEntity> tradeBoardList = tradeBoardService.tradeBoardList(pageable);		//판매글 리스트 불러오기

		pageNumbers.setNowPage(tradeBoardList.getPageable().getPageNumber() + 1);				//페이징 넘버링 객체 값 할당 PageImpl 사용하여 Entity -> Dto로 변경 할 예정
		pageNumbers.setStartPage(Math.max(pageNumbers.nowPage - 4, 1));
		pageNumbers.setEndPage(Math.min(pageNumbers.nowPage + 5, tradeBoardList.getTotalPages()));

		model.addAttribute("list", tradeBoardList);								//판매글 리스트 view에 전송
		model.addAttribute("pageNumbers", pageNumbers);							//페이징 넘버링 view에 전송

		return "tradeBoard";
	}

	@PostMapping("/tradeCommentWrite.do")
	public String tradeBoardCommentWriteDo(String tradeBoardNo, TradeBoardCommentWriteRequestDto tradeCommentDto, @SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser){
		tradeCommentDto.setTradeBoardNo(tradeBoardNo);			//tradeBoardCommentDto 에 tradeBoardNo 저장
		tradeCommentDto.setMemberNo(loginUser.getMemberNo());					//tradeBoardCommentDto 에 memberNo 저장

		tradeCommentService.write(tradeCommentDto);				//tradeBoardCommentDto service로 전송

		return "tradeBoardDetail";
	}

	@GetMapping("/tradeBoardWrite.do")
	public String tradeBoardWrite(@SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser, HttpServletRequest request, Model model){
		model.addAttribute("loginUser", loginUser);

		return "tradeBoardWrite";
	}

	@PostMapping("/tradeBoardWrite.do")
	public String tradeBoard(TradeBoardWriteRequestDto tradeBoardWriteDto, @SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser, HttpServletRequest request, Model model){
		tradeBoardService.create(tradeBoardWriteDto, loginUser.getMemberNo());			//tradeBoard 작성 값 Service로 전송
	
		return "redirect:/tradeBoard.do";
	}

	@GetMapping("/tradeBoardDetail.do")
	public String tradeBoardDetail(Model model, String tradeBoardNo, @SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser, HttpServletRequest request){
		model.addAttribute("loginUser", loginUser);

		TradeBoardEntity tradeBoardEntity = tradeBoardService.findTradeBoard(tradeBoardNo);												//tradeBoardDetailResponseDto에 들어갈 tradeBoardEntity 
		MemberEntity memberEntity = memberService.findMemberByMemberNo(tradeBoardEntity.getMemberNo());									//tradeBoardDetailResponseDto에 들어갈 memberEntity
		String gradeCodeName = codeService.getCodeName(memberEntity.getMemberGrade()); 
		String categoryCodeName = codeService.getCodeName(tradeBoardEntity.getTradeBoardCategory());	

		TradeBoardDetailResponseDto tradeBoardDetailResponseDto = new TradeBoardDetailResponseDto(tradeBoardEntity, memberEntity, gradeCodeName, categoryCodeName);		//Service로 전송
		List<TradeCommentEntity> comment = tradeCommentService.tradeCommentList(tradeBoardNo);											//댓글 불러오기

		model.addAttribute("tradeBoard", tradeBoardDetailResponseDto);
		model.addAttribute("comment",comment);

		return "tradeBoardDetail";
	}

	@PostMapping("/tradeBoardCommentWrite.do")
	public String tradeBoardCommentWriteDo(String tradeBoardNo,TradeBoardCommentWriteRequestDto tradeCommentWriteRequestDto,@SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser,String a){
		
		tradeCommentWriteRequestDto.setMemberNo(loginUser.getMemberNo());
		tradeCommentWriteRequestDto.setTradeBoardNo(tradeBoardNo);

		tradeCommentService.write(tradeCommentWriteRequestDto);

		return "redirect:tradeBoardDetail.do?tradeBoardNo="+tradeBoardNo;
	}
}
