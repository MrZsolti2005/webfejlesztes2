package hu.inf.unideb.library.web;

import hu.inf.unideb.library.model.Member;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MemberController {

        @RequestMapping(
                path = "api/library/members/{libraryCardNumber}",
                method = RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON_VALUE
        )
        Member getOne(
                @PathVariable Integer libraryCardNumber
        );

        @GetMapping("api/library/members")
        List<Member> getAll();

        @PostMapping("api/library/members")
        Member createOne(
                @RequestBody Member member
        );

        @PutMapping("/api/library/members")
        Member updateOne(
                @RequestBody Member member
        );

        @DeleteMapping("/api/library/members/{libraryCardNumber}")
        void deleteOne(
                @PathVariable Integer libraryCardNumber
        );

}
