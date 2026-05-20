package com.likelion14.PBL_Spring.member.domain.role;

import com.likelion14.PBL_Spring.member.domain.policy.StaffSubmissionPolicy;
import com.likelion14.PBL_Spring.member.domain.policy.SubmissionPolicy;

public class Staff extends Role {
    private String position;
    private final SubmissionPolicy submissionPolicy = new StaffSubmissionPolicy();

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.position = position;
    }

    public String getPosition() { return position; }

    @Override
    public String getRoleName() { return "운영진"; }

    @Override
    public boolean canSubmit() { return submissionPolicy.canSubmit(this); }

    @Override
    public String getDetail() { return "직책: " + position; }

    @Override
    public String toString() {
        return "이름: " + name + " | 전공: " + major + " | 기수: " + generation + " | 파트: " + part
                + "\n직책: " + position;
    }
}