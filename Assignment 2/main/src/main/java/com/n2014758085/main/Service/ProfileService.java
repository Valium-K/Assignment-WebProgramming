package com.n2014758085.main.Service;

import com.n2014758085.main.domain.Profile;
import com.n2014758085.main.repository.ProfileRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    /*
    // Pageable 적용 (출력 예제 Pageable 없는거 같아 주석처리함)
    public Page<Profile> findProfileList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());

        return profileRepository.findAll(pageable);
    }
    */

    // Pageable 미적용
    public List<Profile> findProfileList() {
        return profileRepository.findAll();
    }

    public Profile findProfileByIdx(Long idx) {
        return profileRepository.findById(idx).orElse(new Profile());
    }

    public Profile saveProfile(Profile p) {
        Profile profile = profileRepository.save(p);
        return profile;
    }

    public void deleteProfile(Profile profile) {
        profileRepository.delete(profile);
    }
}
