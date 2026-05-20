package com.likelion14.PBL_Spring.member.controller;


import com.likelion14.PBL_Spring.member.domain.role.Lion;
import com.likelion14.PBL_Spring.member.domain.role.Role;
import com.likelion14.PBL_Spring.member.domain.role.Staff;
import com.likelion14.PBL_Spring.member.dto.*;
import com.likelion14.PBL_Spring.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/members")
@Tag(name = "Member", description = "멤버 관리 API")

public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Operation(summary = "Lion(아기사자) 등록")
    @PostMapping("/lions")
    public ResponseEntity<LionResponse> createLion(@RequestBody LionCreateRequest lionCreateRequest){
        Role lion = memberService.createLion(lionCreateRequest);
        if(lion == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(LionResponse.from((Lion) lion));
    }

    @Operation(summary = "Staff(운영진) 등록")
    @PostMapping("/staffs")
    public ResponseEntity<StaffResponse> createStaff(@RequestBody StaffCreateRequest staffCreateRequest) {
        Role staff = memberService.createStaff(staffCreateRequest);
        if(staff == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(StaffResponse.from((Staff) staff));
    }

    @Operation(summary = "전체 멤버 조회 또는 이름으로 검색")
    @GetMapping("/{name}")
    public ResponseEntity<?> getMember(@PathVariable String name){
        Role member = memberService.searchByName(name);
        if(member == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(member));
    }

    @Operation(summary = "이름으로 단일 멤버 조회")
    public Object toResponse(Role role) {
        if (role instanceof Lion lion) {
            return LionResponse.from(lion);
        } else if (role instanceof Staff staff) {
            return StaffResponse.from(staff);
        }
        return role;
    }

    @Operation(summary = "Lion 정보 수정")
    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> updateLion(@PathVariable String name,
                                                   @RequestBody LionUpdateRequest request){
        Role updated = memberService.updateLion(name, request);;
        if (updated == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(LionResponse.from((Lion) updated));
    }

    @Operation(summary = "Staff 정보 수정")
    @PutMapping("/staffs/{name}")
    public ResponseEntity<StaffResponse> updateStaff(@PathVariable String name,
                                                   @RequestBody StaffUpdateRequest request){
        Role updated = memberService.updateStaff(name, request);;
        if (updated == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(StaffResponse.from((Staff) updated));
    }

    @Operation(summary = "멤버 삭제")
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(@PathVariable String name) {
        boolean success = memberService.deleteMember(name);
        if (!success) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build(); // 204
    }

    // GET /members - 전체 조회 또는 이름으로 검색
    @GetMapping
    public ResponseEntity<List<Object>> getMembers(
            @RequestParam(required = false) String name) {

        List<Role> roles;

        if (name != null) {
            roles = memberService.searchAllByName(name);
        } else {
            roles = memberService.findAll();
        }

        List<Object> result = roles.stream()
                .map(role -> {
                    if (role instanceof Lion lion) return LionResponse.from(lion);
                    else if (role instanceof Staff staff) return StaffResponse.from(staff);
                    return role;
                })
                .toList();

        return ResponseEntity.ok(result);
    }
}
