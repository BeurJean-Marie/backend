package com.likelion14.PBL_Spring.member.domain.policy;

import com.likelion14.PBL_Spring.member.domain.role.Role;

public interface SubmissionPolicy {
    boolean canSubmit(Role role);
}