package com.n2014758085.main.Controller;

import com.n2014758085.main.Service.BasicService;
import com.n2014758085.main.Service.ProfileService;
import com.n2014758085.main.domain.Basic;
import com.n2014758085.main.domain.Profile;
import com.n2014758085.main.repository.BasicRepository;
import com.n2014758085.main.repository.ProfileRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class Integratedcontroller {

    private BasicService basicService;
    private ProfileService profileService;

    public Integratedcontroller(BasicService basicService, ProfileService profileService) {
        this.basicService = basicService;
        this.profileService = profileService;
    }

    /*
    // Pageable 적용시 (출력 예제 Pageable 없는거 같아 주석처리)
    @GetMapping("/")
    public String list(@PageableDefault Pageable pageable, Model model) {
        model.addAttribute("basicList", basicService.findBasicList(pageable));
        model.addAttribute("profileList", profileService.findProfileList(pageable));
        return "index";
    }*/

    // index
    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("basicList", basicService.findBasicList());
        model.addAttribute("profileList", profileService.findProfileList());
        return "index";
    }

    // 게시글 보기
    @GetMapping("/basic/{idx}")
    public String readBasic(@PathVariable Long idx, Model model) {
        model.addAttribute("basic", basicService.findBasicByIdx(idx));
        return "basic-item";
    }
    @GetMapping("/profile/{idx}")
    public String readProfile(@PathVariable Long idx, Model model) {
        model.addAttribute("profile", profileService.findProfileByIdx(idx));
        return "profile-item";
    }

    // 게시글 작성 폼
    @GetMapping("/basic/new")
    public String basicForm(Basic basic) {
        return "basic-new";
    }
    @GetMapping("/profile/new")
    public String profileForm(Profile profile) {
        return "profile-new";
    }

    // 게시글 추가
    @PostMapping("/basic/add")
    public String addBasic(Basic basic, Model model) {
        Basic savedBasic = basicService.saveBasic(basic);
        model.addAttribute("basic", basicService.findBasicByIdx(savedBasic.getIdx()));
        return "basic-item";
    }
    @PostMapping("/profile/add")
    public String addProfile(Profile profile, Model model) {
        profile.setCreatedAt(LocalDateTime.now());

        Profile savedProfile = profileService.saveProfile(profile);
        model.addAttribute("profile", profileService.findProfileByIdx(savedProfile.getIdx()));
        return "profile-item";
    }

    // 게시글 수정 폼
    @GetMapping("/basic/edit/{idx}")
    public String updateBasicForm(@PathVariable Long idx, Model model) {
        Basic basic = basicService.findBasicByIdx(idx);

        model.addAttribute("basic", basic);
        return "basic-update";
    }
    @GetMapping("/profile/edit/{idx}")
    public String updateProfileForm(@PathVariable Long idx, Model model) {
        Profile profile = profileService.findProfileByIdx(idx);

        model.addAttribute("profile", profile);
        return "profile-update";
    }

    // 게시글 수정
    @PostMapping("/basic/update/{idx}")
    public String updateBasic(@PathVariable Long idx, @Valid Basic basic, Model model) {
        model.addAttribute("basic", basicService.saveBasic(basic));

        model.addAttribute("basicList", basicService.findBasicList());
        model.addAttribute("profileList", profileService.findProfileList());
        return "index";
    }
    @PostMapping("/profile/update/{idx}")
    public String updateProfile(@PathVariable Long idx, @Valid Profile profile, Model model) {
        profile.setCreatedAt(LocalDateTime.now());
        profileService.saveProfile(profile);

        //model.addAttribute("profile", profileService.saveProfile(profile));

        model.addAttribute("basicList", basicService.findBasicList());
        model.addAttribute("profileList", profileService.findProfileList());
        return "index";
    }

    // 게시글 삭제
    @GetMapping("/basic/delete/{idx}")
    public String deleteBasic(@PathVariable Long idx, @Valid Basic basic, Model model) {
        basicService.deleteBasic(basic);

        model.addAttribute("basicList", basicService.findBasicList());
        model.addAttribute("profileList", profileService.findProfileList());
        return "index";
    }
    @GetMapping("/profile/delete/{idx}")
    public String deleteProfile(@PathVariable Long idx, @Valid Profile profile, Model model) {
        profileService.deleteProfile(profile);

        model.addAttribute("basicList", basicService.findBasicList());
        model.addAttribute("profileList", profileService.findProfileList());
        return "index";
    }
}
