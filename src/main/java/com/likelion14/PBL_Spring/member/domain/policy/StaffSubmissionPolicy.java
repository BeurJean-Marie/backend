package com.likelion14.PBL_Spring.member.domain.policy;

import com.likelion14.PBL_Spring.member.domain.role.Role;

public class StaffSubmissionPolicy implements SubmissionPolicy {
    @Override
    public boolean canSubmit(Role role) {
        return false;  // 운영진은 과제 제출 불가
    }
}