package com.example.java0617.controller;

import com.example.java0617.api.ApiResponse;
import com.example.java0617.domain.Member;
import com.example.java0617.dto.RequestCreateMemberDTO;
import com.example.java0617.dto.RequestUpdateMemberDTO;
import com.example.java0617.dto.ResponseMemberDTO;
import com.example.java0617.repository.MemberRepository;
import com.example.java0617.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/create")
    public ApiResponse createMember(@RequestBody RequestCreateMemberDTO requestCoupleDTO){
        long retId = memberService.saveMember(requestCoupleDTO);
        return ApiResponse.success("result",retId);
    }

    @GetMapping("/read/{id}")
    public ApiResponse readMember(@PathVariable Long id){
        ResponseMemberDTO responseMemberDTO = memberService.findMember(id);
        return ApiResponse.success("result",responseMemberDTO);
    }

    @PutMapping("/update/{id}")
    public ApiResponse updateMember(@PathVariable Long id, @RequestBody RequestUpdateMemberDTO requestUpdateMemberDTO){
        long retId = memberService.modifyMember(id, requestUpdateMemberDTO);
        return ApiResponse.success("result",retId);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteMember(@PathVariable Long id){
        long retId = memberService.removeMember(id);
        return ApiResponse.success("result", retId);
    }

    @GetMapping("/recommend/{id}")
    public ApiResponse recommendMember(@PathVariable Long id){
        List<ResponseMemberDTO> responseMemberDTOList = memberService.recommendMember(id);
        return ApiResponse.success("result",responseMemberDTOList);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        Member member = MemberRepository.findByEmail
    }
}
